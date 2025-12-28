
import java.util.*;
import java.io.*;

public class Main {

	public static boolean[] map;
	public static boolean[] answer;
	public static ArrayList<Integer>[] edges;
	public static boolean[] v;
	public static int[] inDegree;
	public static int N,M;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        //N개의 도시와 M개의 도로.
        //각 도시에는 1~N까지의 넘버링
        //불에 타 파괴된 도시가 존재.
        //도시 하나에 폭탄을 떨구면 인접한 도시는 모두 파괴된다
        //폭탄이 떨어진 지점을 알아내라.
        
        //파괴된 도시의 개수와 그 도시의 번호가 주어짐.
        //어떠한 경우라도 지도와 같은 모양이 나오지 않으면 -1을 출력
        //가능하면 첫 줄에 폭탄이 떨어진 도시의 개수 T를 출력 후, 다음 줄에 도시 번호 T개를 공백으로 구분하여 출력하라
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        int city1,city2;
        
        map=new boolean[N+1];
        v=new boolean[N+1];
        inDegree=new int[N+1];
        answer=new boolean[N+1];
        edges=new ArrayList[N+1];
        
        for(int i=1;i<=N;i++) {
        	edges[i]=new ArrayList<>();
        
        }
        
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	city1=Integer.parseInt(st.nextToken());
        	city2=Integer.parseInt(st.nextToken());
        	
        	edges[city1].add(city2);
        	edges[city2].add(city1);
        	inDegree[city1]++;
        	inDegree[city2]++;
        	

        }
        
        int T=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        
        for(int i=0;i<T;i++){
        	map[Integer.parseInt(st.nextToken())]=true;//폭탄이 터진 곳이다.
        }
        ArrayDeque<Integer> q=new ArrayDeque<>();
        
        int cnt=0;
        int a=0;
        for(int i=1;i<=N;i++) {
        	cnt=0;
        	
        	//연결된 도시가 없으면 패스
        	if(inDegree[i]==0){
        		//근데 연결 안되었는데, 파괴되었을 수도
        		if(map[i]) {
        			answer[i]=true;
            		sb.append(i+" ");
        			a++;
        		}
        		continue;
        	}
        	
        	//인접 도시 중 파괴된 도시의 개수
        	for(int next:edges[i]){
        		if(map[next]) cnt++;
        	}
        	
        	//여기서 탐색된 곳들 제외하고는 터지면 안됨.
        	if(cnt==inDegree[i]&&map[i]){//인접 도시는 모두 파괴되었고, 자신도 파괴되었으면 이곳에 폭탄.
        		//System.out.println("터진게 확정인 도시: "+i);
        		answer[i]=true;
        		a++;
        		q.add(i);
        		sb.append(i+" ");
        	}
        	
        }
        
        boolean possible=true;
        
        int p;

        while(!q.isEmpty()){
        	p=q.poll();
        	for(int next:edges[p]) {//폭탄이 떨어진 곳 근처는 폭파.
        		answer[next]=true;
        	}
        }
        
//        System.out.println("폭탄이 터진 상황");
//        System.out.println(Arrays.toString(map));
//        
//        System.out.println("역산출 상황");
//        System.out.println(Arrays.toString(answer));
        
        for(int i=1;i<=N;i++){
        	if(map[i]!=answer[i]){
        		System.out.println(-1);
        		return;
        	}
        }
        
        System.out.println(a);
        System.out.println(sb);
        //파괴된 곳은 폭탄이 터진 곳이거나, 여파거나. 
        //2000개의 도시와 다 연결된 최대의 간선을 다 탐색한다? 백트래킹으로?
        //간선이 여러개 연결되어 있는데, 주변이 다 터진게 아니면, 폭탄이 터질 수 없음
        //반대로 간선이 여러개 연결되어 있는데, 주변이 타 터졌으면, 여기에 폭타이 떨어져도 되고, 안떨어져도 됨. 그러니 떨어진 것으로 확정을 지어버림.
        
        //그러면 도시의 상태는 셋중 하나. 폭탄이 떨어졌다고 확정하거나, 폭탄이 떨어지면 안되거나.         

        //System.out.println(sb);
        
        
    }
        
}



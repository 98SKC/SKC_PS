import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken()); //역의 수
        int K=Integer.parseInt(st.nextToken()); //하이퍼튜브가 연결하는 역의 개수
        int M=Integer.parseInt(st.nextToken()); //하이퍼튜브의 개수
        
        //k개의 역이 연결되어있다. 1번에서 N번까지의 최소방문 역의 개수
        
        //일반적인 다익스트라랑 다른가?
        //문제가 이상해 조건이 누락되어있음. 같은 튜브의 역들은 거쳐가지 않는 것으로 판정.
        
        //두가지의 자료구조
        //이 역에 정차하는 하이퍼튜브를 저장할 자료구조
        //하이퍼튜브가 지나가는 역을 저장할 자료구조
        //1. 지금 역을 지나는 하이퍼튜브로 전체 for문을 연다.
        //2. 지금 하이퍼튜브와 같다면 가중치들은 0.
        //3. 하이퍼튜브가 다르다면 가중치 1
        
        List<Integer>[] hyperTubes=new ArrayList[M+1];// 하이퍼튜브[i]가 거치는 역
        List<Integer>[] stations=new ArrayList[N+1];//역[i]에 정차하는 하이퍼튜브  
        
        String[] str;
        int[] dijk=new int[N+1];
        
        for(int i=1;i<=M;i++) {
        	hyperTubes[i]=new ArrayList<>();
        }
        for(int i=1;i<=N;i++) {
        	stations[i]=new ArrayList<>();
        	dijk[i]=Integer.MAX_VALUE;
        }
        
        int len;
        int a;
        for(int i=1;i<=M;i++) {
        	str=br.readLine().split(" ");
        	len=str.length;
        	for(int j=0;j<len;j++) {
        		a=Integer.parseInt(str[j]);
        		hyperTubes[i].add(a);//i 하이퍼튜브가 거치는 a역
        		stations[a].add(i);//a에 정차하는 하이퍼튜브
        		
        	}
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return Integer.compare(o1[1], o2[1]);
        	}
        });
        
        pq.add(new int[] {1,0,-1});
        int answer=-1;
        int[] station;
        int weight;
        dijk[1]=0;
        //하이퍼튜브가 정차하지 않는 역은 while을 돌지 않아도 될 것.
        //근데 그러면 break가 어디에 들어가냐는건데. 
        
        while(!pq.isEmpty()) {
        	station=pq.poll();
        	//System.out.println(station[0]);

        	//System.out.println("다익스트라 상태: "+Arrays.toString(dijk));
        	if(station[0]==N) {
        		answer=station[1];
        		break;
        	}
        	
        	for(int hyperTube:stations[station[0]]) {//탑승 가능한 하이퍼튜브,
        		if(hyperTube==station[2]) continue;
        		
            	for(int next:hyperTubes[hyperTube]) {//hyperTube를 타고 갈수있는 다음 역
            		if(dijk[next]>station[1]+1) {
            			dijk[next]=station[1]+1;
            			pq.add(new int[] {next,dijk[next],hyperTube});
            		}
            	}
            	
        	}

        }
        if(answer!=-1)System.out.println(answer+1);
        else System.out.println(-1);
    }

}

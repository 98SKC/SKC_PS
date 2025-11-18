

import java.util.*;
import java.io.*;

public class Main {

	public static ArrayList<Integer>[] roads;
	public static boolean[] v;
	public static int[][] dp;
	public static int N;
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        N=Integer.parseInt(br.readLine());
        
        dp=new int[N+1][2];//i에 경찰서를 세웠을 때 1, 세우지 않았을 때 0.
        roads=new ArrayList[N+1];
        v=new boolean[N+1];
    	
        for(int i=1;i<=N;i++) {
        	roads[i]=new ArrayList<>();
        }

        StringTokenizer st;
        int a,b;
        
        for(int i=1;i<N;i++) {
        	
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	roads[a].add(b);
        	roads[b].add(a);

        	
        }
                
        //N개의 도시가 양방향 도로로 이어져 있다.
        //N-1개의 도로를 이용해 모든 도시들 사이에 단 하나의 경로만이 존재한다.
        //경찰서를 일부 도시에 건설한다.
        //도시에 경찰서를 세우면 해당 도시와 그 도시에 연결된 양방향 도로들로 연결된 도시들을 감시할 수 있다.
        
        
        //그리디는 안될 것 같은게
        //10이 가장 많은 도시 두개가 있다 하자. 둘이 연결된 간선 하나, 각각이 가진 9개씩 집합
        //(여기 4 4 10 10 4) 중앙에 10만 보면 10개 10개 같은데,
        //(    a b c  d  e) b를 c를 선택하면 a+c+e를 세워야 하고
        //					d를 선택하면 d b를 세우면 끝임.
        //위상 정렬도 또한 위상정렬대로면 a,e를 택해야 하는데 b,d가 답이지, a,e,c는 답이 아님.
        //위상정렬x, 간선 많은순 그리디 x.
        //그렇다고 노드 하나하나 1 선택했을 경우, 2 선택했을 경우를 dp로?
        //우선 트리 구조. 
        
        //이전이 선택되지 않으면, 다음은 무조건 선택
        //이전이 선택되었다면, 다음은 선택을 안해도 상관x
        //이전이 선택되지 않으면, 다음은 무조건 선택해야 하는게 맞나?
        //그림상 꼭 그런건 아닌데, 같게 된다고 볼 수 있음
        //a-b-c-d 에서 o x x o가 그 예시인데, 이런경우를 다 보면 부모랑 자식을 트레이드해도 상관이 없는 구조로
        //되어있음 고로 o x o x 와 같게 됨
       search(1);
        
        
       System.out.println(Math.min(dp[1][0],dp[1][1])); //루트를 선택 했을 때, 안했을 때

    }
    
    public static void search(int city){
    	
    	v[city]=true;
    	
    	dp[city][1]=1; //이 도시만을 선택할 경우 증가.
    	//마지막 노드에 도착하면 dp[마지막][1]=1, dp[마지막][0]=0 인 상태가 될 것. 
    	//그럼 바로 위의 노드(부모)로 이동해서 
    	//dp[부모][1]+=Math.min(dp[자식][1], dp[자식][0]);
    	//dp[부모][0]+=dp[자식][1];
    	//의 형식으로 부모의 자식들 모두에 대해 부모가 선택된 경우, 선택되지 않은 경우에 대해 합산할 것.
    	//이렇게 말단부터 차례대로 올라가면서 합해간다.
    	
    	for(int next:roads[city]){
    		if(v[next]) continue;
    		
    		search(next);
    		
    		//city를 선택하면-> 자식은 선택해도, 안해도 상관 없음. 둘 중 작은 쪽
    		dp[city][1]+=Math.min(dp[next][1], dp[next][0]);
    		
    		//city를 선택 안하면 자식은 선택 해야만 한다.
    		dp[city][0]+=dp[next][1];
    			    		
    	}
    	
    }
        
}



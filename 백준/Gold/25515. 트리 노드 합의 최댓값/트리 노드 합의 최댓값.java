
import java.util.*;
import java.io.*;

public class Main {

	public static ArrayList<Integer>[] edges;
	public static long[] dp;
	public static int[] node;
	public static boolean[] v;
	public static int N;
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        //N개의 노드와 N-1개의 간선으로 이루어진 트리가 있다.
        //번호는 0번부터 N-1까지, 루트는 항상 0번.
        //각 노드에는 하나의 정수가 적혀있고
        //루트부터 시작하여 이웃한 노드를 방문하면서 노드에 적힌 정수의 합을 최대로 하려 한다.
        //노드를 방문하면 그 수는 무조건 더한다. 
        //같은 노드를 여러번 방문할 수도 있고, 어러번 방문해도 최초 한번만 정수를 더한다.
        
        
        //노드에 음수인 정수들이 있어서, 다 더하는게 정답이 아닌 상태.
        
        N=Integer.parseInt(br.readLine());
        edges=new ArrayList[N];
        v=new boolean[N];
        node=new int[N];
        
        for(int i=0;i<N;i++) {
        	edges[i]=new ArrayList<>();
        }
        
        int a,b;
        
        StringTokenizer st;
        for(int i=0;i<N-1;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	edges[a].add(b);
        	edges[b].add(a);


        }
        
        st=new StringTokenizer(br.readLine());

        //노드 개수는 10만개.
        for(int i=0;i<N;i++) {
        	node[i]=Integer.parseInt(st.nextToken());
        }
        
        //dp, bfs
        
        dp=new long[N];// dp[i][j]일 때, i에서j로 넘어왔을 때 최댓값.
        
        
        bfs(0);
        
        System.out.println(dp[0]);
    }
    
    //10000000000
    //트리니까 순환이 없다.
    //루트 기준으로 1자식으로 갔을 때 얻을 수 있는 최대
    //부모를 기준으로 어디 자식까지 갔을 때 가 최대냐.
    public static void bfs(int pos){
    
    	v[pos]=true;
    	dp[pos]=node[pos];
    	
    	for(int next:edges[pos]){
    		if(v[next]) continue;
    		
    		bfs(next);
    		
    		if(dp[next]>0) dp[pos]+=dp[next];
    		
    	}

    }
        
}



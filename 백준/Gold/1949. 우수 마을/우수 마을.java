
import java.util.*;
import java.io.*;

public class Main{
	public static ArrayList<Integer>[] edges;

    public static int[] people;
    public static int N;
    public static int[][] dp;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        people=new int[N+1];
        edges=new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	people[i]=Integer.parseInt(st.nextToken());
        	edges[i]=new ArrayList<>();
        }
        int a,b;
        
        for(int i=1;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	edges[a].add(b);
        	edges[b].add(a);

        }
        dp=new int[N+1][2];
        
        dfs(1, 0);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
	
	
	public static void dfs(int n, int parent) {
		for (int node : edges[n]) {
			if (node != parent) {//트리 구조라 사이클이 없으니 부모만 거치지 않으면 중복 아님
				dfs(node, n);
				dp[n][0] += Math.max(dp[node][0], dp[node][1]);//n노드가 부모가 아니면 자식은 우수일 수 있고, 아닐 수 있음.
				//마을이 1-2-3-4-5 모양일 때, 우수아님-우수아님-우수아님  이런식으로 뻗어가는 것은 어떻게 제외하는가?
				//주변 노드가 모두 우수마을이 아니면 자신의 인구수가 더해지는게( for문 밖)이 최적의 수가 될 것이기에 제외된다.
				dp[n][1] += dp[node][0];//n노드가 우수마을이면, 자식은 무조건 아님.
			}
		}
		//만약에 모든 자식이 다 [0]에서 최대가 된다고 하면 dp[n][0]은 사실 dp[node][0]의 합으로 dp[n][1]과 같은 상태. 여기서 자기 자신도 더하니 
		//최적해가 되는 것
		dp[n][1] += people[n];
	}
}


import java.util.*;
import java.io.*;

public class Main {

	public static int[][] dp;
	public static boolean[] v;
	public static ArrayList<Integer>[] edge;
    public static int N;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        v=new boolean[N+1];
        StringTokenizer st;
        dp=new int[N+1][2];// i가 루트일 때, i가 얼리어답터 유무에 따른 최소의 얼리어답터 개수
        edge=new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	edge[i]=new ArrayList<Integer>();
        }
        int a,b;
        for(int i=0;i<N-1;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	edge[a].add(b);
        	edge[b].add(a);
        	
        }
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
	
	public static void dfs(int node) {//node가 루트일 때
		//System.out.println(node+"루프 체크용 출력");
		v[node] = true;
		dp[node][0] = 1;//일단 자신이 얼리어답터인경우 최소 자기 자신 하나
		
		for(int nextNode : edge[node]) {// 인접이 다 v가 되면 재귀는 끝 
			if(v[nextNode]) continue;
			dfs(nextNode);// 다음 노드에 대해서 다음 노드가 루트일 때(이미 지난 노드는 제외하고) 0,1에 따른 최소수
			dp[node][1] += dp[nextNode][0]; //node가 루트가 아니면, 근접 친구는 얼리어답터. 그러므로 다음 노드의 얼리어답터 dp의 합
			dp[node][0] += Math.min(dp[nextNode][0], dp[nextNode][1]);// 자신이 얼리어답터면, 친구가 얼리어답터일 수 있고 아닐 수 있다
			
		}
	}
}

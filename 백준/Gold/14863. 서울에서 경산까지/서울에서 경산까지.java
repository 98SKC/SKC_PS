
import java.util.*;
import java.io.*;

public class Main {

	public static int N,K;
	public static int[][] time, cost;
	public static int[][] dp;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        
        int walk,walkCost,bike,bikeCost;
        
        time=new int[N+1][2];//[i][0] i를 걸어서 갈 때 시간,   [i][1] i를 자전거 탈 때 시간.
        cost=new int[N+1][2];//[i][0] i를 걸어서 갈 때 모금액,  [i][1] i를 자전거 탈 때 모금액.
        dp=new int[N+1][K+1]; //i까지 j시간으로 올 때 최대 금액.
        
        for(int i=0;i<=N;i++) {
            Arrays.fill(dp[i],-1);
        }
        
        dp[0][0]=0;
        
        for(int i=1;i<=N;i++) {
        	
        	st=new StringTokenizer(br.readLine());
        	
        	walk=Integer.parseInt(st.nextToken());
        	walkCost=Integer.parseInt(st.nextToken());
        	bike=Integer.parseInt(st.nextToken());
        	bikeCost=Integer.parseInt(st.nextToken());
        	
        	time[i][0]=walk;
        	cost[i][0]=walkCost;
        	
        	time[i][1]=bike;
        	cost[i][1]=bikeCost;
        	
        }
        
        
        
        //서울에서 경산까지 여러 도시를 거쳐 이동
        //도시의 개수와 순서는 정해져 있으며, 모든 소기를 단 한번씩 방문하며 경산에서 끝난다.
        //도시의 개수는 N. 서울에서 두번째 도시까지 가는 구간을 1, 두번째에서 세번째를 2....로 부른다.
        //마지막 도착지 경산까지 도착구간은 N이라 할 때, 즉, 구간의 전체 개수는 N개이다.
        //구간 사이 이동은 도보 혹은 자전거 어느 한쪽을 이용.
        //각 구간에는 도보 시간, 도보에서 얻게 되는 모금액, 자전거 시간, 자전거 사용시 모금액이 정해져 있다.
        
        //K분 안에 경산까지 이동하여 얻을 수 있는 최대의 모금액을 구하라.
        //dp 혹은 재귀가 떠오르는데, 재귀로 하기에는 도시가 100
        
        //순서가 있고, 다 방문을 하는데.... 배낭?
        //넣을 떄 뭘로 넣냐 인가
        
        for (int i = 1; i <= N; i++) {
            for (int t = 0; t <= K; t++) {
            	
                // 걷기
                if (t >= time[i][0] && dp[i-1][t - time[i][0]] != -1) {
                    dp[i][t] = Math.max(dp[i][t], dp[i-1][t - time[i][0]] + cost[i][0]);
                }
                
                // 자전거
                if (t >= time[i][1] && dp[i-1][t - time[i][1]] != -1) {
                    dp[i][t] = Math.max(dp[i][t], dp[i-1][t - time[i][1]] + cost[i][1]);
                }
            }
        }

        int ans = 0;
        for (int t = 0; t <= K; t++) {
            ans = Math.max(ans, dp[N][t]);
        }
        System.out.println(ans);
        
        
    }

        
}



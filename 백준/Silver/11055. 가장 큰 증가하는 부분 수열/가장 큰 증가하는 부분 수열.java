import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int N=Integer.parseInt(br.readLine());
		
		
		int[] dp = new int[N+1];
		int[] cost = new int[N+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = cost[1]; // dp[1]은 항상 cost[1]로 초기화. 최소 자신의 값
		int max=dp[1];
		for(int i=2;i<=N;i++) { 
			dp[i] = cost[i]; //자신의 값을 dp에 저장해 둔다.
			for(int j=1;j<i;j++) { // 첫 번째 부터 i이전 까지 비교를 위한 반복
				if(cost[i]>cost[j]) { // 기준값이 더 큰 경우
					// dp[j]에는 j기준의 가장 큰 증가하는 부분 수열의 합이 있다. 
					dp[i] = Math.max(dp[j]+cost[i],dp[i]); // 증가 수열이므로 dp값 갱신
				}
			}
			if(dp[i]>max) max = dp[i];
			
		}
		
		
		
		System.out.println(max);
	}
	
	

}
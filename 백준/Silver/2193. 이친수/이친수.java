import java.io.*;
import java.util.*;

public class Main {

	
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		long[][] dp =new long[N+1][2];
		
		dp[1][0]=0;//n이 0로 끝날 경우의 최대값 
		dp[1][1]=1;//n이 1로 끝날 때 의 최대값
		
		for(int i=2;i<=N;i++) {
			dp[i][0]=dp[i-1][0]+dp[i-1][1];// 0으 이전이 무엇이든 붙을 수 있음
			dp[i][1]=dp[i-1][0];// 1로 끝나려면 이전이 무조건 0으로 끝나야함.
		}
		System.out.println(dp[N][0]+dp[N][1]);
		
	}
	
	
}
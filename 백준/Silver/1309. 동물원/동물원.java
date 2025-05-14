import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[][] map=new int[N+1][2];
		int[][] dp=new int[N+1][3];
		dp[1][0]=1;// 아예 안두기
		dp[1][1]=1;// 좌측 한마리
		dp[1][2]=1;// 우측 한마리
		int mod=9901;
		for(int i=2;i<=N;i++){//N행까지 있을 때 배치 수
			
			dp[i][0]= (dp[i-1][0]%mod+dp[i-1][1]%mod+dp[i-1][2]%mod)%mod;
			dp[i][1]=(dp[i-1][0]%mod+dp[i-1][2]%mod)%mod;
			dp[i][2]=(dp[i-1][0]%mod+dp[i-1][1]%mod)%mod;
			
		}
		System.out.println((dp[N][0]%mod+dp[N][1]%mod+dp[N][2]%mod)%mod);
	}
	
	

}
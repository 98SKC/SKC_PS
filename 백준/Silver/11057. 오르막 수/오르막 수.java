import java.io.*;
import java.util.*;

public class Main {

	
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		long[][] dp=new long[N+1][10];
		for(int i=0;i<10;i++) {
			dp[1][i]=1;
		}
		
		for(int i=2;i<=N;i++) {// i길이의
			for(int j=0;j<=9;j++) {// j로 끝나는 오름수의 최대 수는
				for(int k=0;k<=j;k++) {//i-1 길이의 끝자리가 j이하인 오름수들의 합
					dp[i][j]=((dp[i][j]%10007+dp[i-1][k]%10007)%10007);
				}
			}
		}
		long answer=0;
		
		for(int i=0;i<10;i++) {
			answer=(answer%10007+dp[N][i]%10007)%10007;
		}
		
		System.out.println(answer);
	}
	
	
}
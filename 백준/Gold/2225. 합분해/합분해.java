import java.io.*;
import java.util.*;

public class Main {

	public static final int mod=1000000000;
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int[][] dp=new int[N+1][K+1];// i를 j개의 수로 만들 수 있는 경우의 수 개수.
		for(int i=0;i<N+1;i++) {
			dp[i][1]=1;// 1개의 상수로 i를 만들 수 있는 경우의 수는 오직 i 하나만 사용하는 경우
		}
		
		for(int i=2;i<=K;i++) {
			for(int j=0;j<N+1;j++) {
				for(int k=0;k<N+1;k++) {
					//System.out.println((j-k)+" "+i+" "+j+" "+k+" ");
					if(j-k>=0) dp[j][i]=(dp[j][i]%mod+dp[j-k][i-1]%mod)%mod;
				}
			}
		}
		System.out.println(dp[N][K]);
	}
	
	
}
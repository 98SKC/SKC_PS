import java.io.*;
import java.util.*;

public class Main {

	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int N;//동전의 가지 수
		int M;
		int[] coins;
		int[] dp;
		StringBuilder sb=new StringBuilder();
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			coins=new int[N];
			for(int i=0;i<N;i++) {
				coins[i]=Integer.parseInt(st.nextToken());
			}
			M=Integer.parseInt(br.readLine());
			dp=new int[M+1];
			dp[0]=1;
			
			for(int i=0;i<N;i++) {
				for(int j=coins[i];j<=M;j++) {
					if(dp[j-coins[i]]!=0) {
						dp[j]+=dp[j-coins[i]];
					}
				}
			}
			
			//System.out.println(Arrays.toString(dp));
			sb.append(dp[M]+"\n");
			
		}
		System.out.println(sb);
		
	}
	
	
}
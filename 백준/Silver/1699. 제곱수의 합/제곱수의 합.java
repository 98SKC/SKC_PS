import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		//N을 표현할 수 있는 최소항의 제곱수의 개수
		
		int[] dp=new int[N+1];
		dp[1]=1;//1

		int min;
		
		
		for(int i=2;i<=N;i++) {
			min=Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++) {
				min=Math.min(min, 1+dp[i-j*j]);
			}
			dp[i]=min;
		}
		
		//System.out.println(Arrays.toString(dp));
		
		System.out.println(dp[N]);
	}
	
	

}
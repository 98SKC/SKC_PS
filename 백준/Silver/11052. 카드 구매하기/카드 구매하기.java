import java.io.*;
import java.util.*;

public class Main {

	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		int[] dp=new int[N+1];
		int[] price=new int[N+1];
		int sub=0;
		
		for(int i=1;i<=N;i++) {
			sub=Integer.parseInt(st.nextToken());
			price[i]=sub;
			dp[i]=price[i];
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i-j>0) dp[i]=Math.max(dp[i], dp[i-j]+price[j]);
			}
		}
		System.out.println(dp[N]);
		
	}
	
	
}
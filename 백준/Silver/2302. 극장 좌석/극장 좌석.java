import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int N=Integer.parseInt(br.readLine());
		int VIP=Integer.parseInt(br.readLine());
		
		int[] vip=new int[VIP];
		
		for(int i=0;i<VIP;i++) {
			vip[i]=Integer.parseInt(br.readLine());
		}
		
		int[] dp=new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        if (N > 1) {
            dp[2] = 2;
        }
		
		for(int i=3;i<=N;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		int pos=1;
		int len, answer=1;
		for(int i=0;i<VIP;i++) {
			len=vip[i]-pos;
			answer*=dp[len];
			pos=vip[i]+1;
			
		}
		if(N!=pos) {
			len=N-pos+1;
			answer*=dp[len];

		}
		
		System.out.println(answer);
	}
	
	

}
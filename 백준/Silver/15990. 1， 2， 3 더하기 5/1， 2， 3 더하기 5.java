
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        
        int N;
        int mod=1000000009;
        long[][] dp=new long[100001][4];
        dp[1][1]=1;
        dp[2][2]=1;
        dp[3][1]=1;
        dp[3][2]=1;
        dp[3][3]=1;
        
        
        int max=3;
        StringBuilder sb=new StringBuilder();
        for(int t=0;t<T;t++) {
        	N=Integer.parseInt(br.readLine());
        	
        	if(max>=N) {
        		sb.append((dp[N][3]+dp[N][1]+dp[N][2])%mod+"\n");
        		continue;
        	} 
        	

        	for(int i=max;i<=N;i++) {
        		
        		if(i-1>0) dp[i][1]=(dp[i-1][2])%mod+(dp[i-1][3])%mod;// 1크기전에 2로 끝난경우와 3으로 끝난 경우
        		if(i-2>0) dp[i][2]=(dp[i-2][1])%mod+(dp[i-2][3])%mod;// 2크기전에 1로 끝난경우와 3으로 끝난 경우
        		if(i-3>0) dp[i][3]=(dp[i-3][1])%mod+(dp[i-3][2])%mod;// 3크기전에 1로 끝난경우와 2으로 끝난 경우
        		
        		//System.out.println(i+"가 1,2,3 을 끝으로 만들어질 수 있는 수: "+dp[i][1]+" "+dp[i][2]+" "+dp[i][3]+" ");
        	}
        	
        	max=N;
        	
        	sb.append((dp[N][3]+dp[N][1]+dp[N][2])%mod+"\n");
        }
        
        System.out.println(sb);
        
    }
}

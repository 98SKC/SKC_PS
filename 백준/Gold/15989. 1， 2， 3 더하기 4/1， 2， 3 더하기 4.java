import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        int N;
        int[] arr;
        int end=4;
        
        int[][] dp=new int[10001][4];
        dp[1][1]=1;
        dp[2][1]=1;  
        dp[2][2]=1;
        dp[3][1]=1;// 1 1 1.
        dp[3][2]=1;// 1 2
        dp[3][3]=1;// 3

        for(int t=1; t<=T ;t++) {
        	N=Integer.parseInt(br.readLine());
        	
        	if(N<4&&dp[N][1]!=0) {
        		sb.append(dp[N][1]+dp[N][2]+dp[N][3]);
        		sb.append("\n");
        		continue;
        	}
        	
        	for(int i=end;i<=N;i++ ) {
        		dp[i][1]=dp[i-1][1];
        		dp[i][2]=dp[i-2][1]+dp[i-2][2];
        		dp[i][3]=dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
        	}
        	sb.append(dp[N][1]+dp[N][2]+dp[N][3]);
    		sb.append("\n");
        	end=N+1;
        	
        }
        
        
        System.out.println(sb);
        
        
    }
}
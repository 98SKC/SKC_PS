import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        int[][] map=new int[N][M];
        int[][] dp=new int[N][M];
        String str;
        int max=0;
        for(int i=0;i<N;i++) {
        	str=br.readLine();
        	for(int j=0;j<M;j++) {
        		map[i][j]=str.charAt(j)-'0';
        		if(map[i][j]==1) {
        			dp[i][j]=1;
        			max=1;
        		}
        		
        	}
        }
        
        if(max==0) {
        	System.out.println(0);
        	return;
        }
        
        int sub;
        
        for(int i=1;i<N;i++) {
        	for(int j=1;j<M;j++) {
        		if(map[i][j]==1) {
        			if(dp[i-1][j]>0&&dp[i][j-1]>0&&dp[i-1][j-1]>0) {
            			sub=Math.min(dp[i-1][j], dp[i][j-1]);
            			dp[i][j]=Math.min(sub,dp[i-1][j-1])+1;
            			max=Math.max(max, dp[i][j]);
        			}
        		}
        	}
        }
//        for(int i=0;i<N;i++) {
//        	System.out.println(Arrays.toString(dp[i]));
//        }
        
        System.out.println(max*max);
        
    }
}
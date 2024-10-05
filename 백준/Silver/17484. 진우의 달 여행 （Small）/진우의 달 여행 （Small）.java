import java.util.*;
import java.io.*;

public class Main {


	public static int[] dj=new int[] {-1,0,1};
	
	
	
    public static void main(String[] args) throws Exception {
        
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	int N=Integer.parseInt(st.nextToken());
    	int M=Integer.parseInt(st.nextToken());
    	int[][] arr=new int[N][M];
    	int[][][] dp=new int[N][M][3];
    	for(int i=0;i<N;i++) {
    		st=new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			arr[i][j]=Integer.parseInt(st.nextToken());
    		}
    	}
    	for(int i=0;i<M;i++) {
    		dp[0][i][0]=arr[0][i];
    		dp[0][i][1]=arr[0][i];
    		dp[0][i][2]=arr[0][i];
    	}
    	
    	for(int i=1;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			if(j==0) {
    				dp[i][j][0]=arr[i][j]+Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]);// 좌하으로 오는 경우
    				dp[i][j][1]=arr[i][j]+dp[i-1][j][0];// 좌하으로 오는 경우
    				
    			}else if(j>0&&j<M-1) {
    				dp[i][j][0]=arr[i][j]+Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]);
    				dp[i][j][1]=arr[i][j]+Math.min(dp[i-1][j][0], dp[i-1][j][2]);
    				dp[i][j][2]=arr[i][j]+Math.min(dp[i-1][j-1][1], dp[i-1][j-1][0]);
    				
    			}else {
    				dp[i][j][1]=arr[i][j]+dp[i - 1][j][2];// 좌상으로 오는 경우
    				dp[i][j][2]=arr[i][j]+Math.min(dp[i-1][j-1][1], dp[i-1][j-1][0]);// 좌상으로 오는 경우
    			}

    		}
    	}
    	
    	int answer=Integer.MAX_VALUE;
    	
    	for(int i=0;i<M;i++) {
    		for(int j=0;j<3;j++) {
    			if(dp[N-1][i][j]!=0) {
    				answer=Math.min(answer, dp[N-1][i][j]);
    			}
    		}
    	}
    	
    	System.out.println(answer);
    	
    }
}
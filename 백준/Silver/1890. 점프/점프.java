
import java.util.*;
import java.io.*;

public class Main {

	public static int[] di=new int[] {0,1};
	public static int[] dj=new int[] {1,0};
		
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] arr=new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		arr[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        long[][] dp=new long[N][N];

        
        int ni,nj;
        dp[0][0]=1;
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		if(arr[i][j]==0||dp[i][j]==0) continue;
        		
        		for(int a=0;a<2;a++) {
        			ni=i+di[a]*arr[i][j];
        			nj=j+dj[a]*arr[i][j];
        			if(ni>=0&&ni<N&&nj>=0&&nj<N) {
        				dp[ni][nj]+=dp[i][j];
        			}
        			
        		}
        	}
        }
//        for(int[] n:dp) {
//        	System.out.println(Arrays.toString(n));
//        }

        System.out.println(dp[N-1][N-1]);
        
        
    }
}

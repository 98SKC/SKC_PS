import java.util.*;
import java.io.*;

public class Main {

	static int N,M;
	static int[][] map;
    static int[][] dp;
    static int[] di=new int[] {0,1,0,-1};
    static int[] dj=new int[] {1,0,-1,0};
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int pos,pi,pj,ni,nj;
        map=new int[N][M];
        dp=new int[N][M];
        

		
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
                dp[i][j]=-1;
            }
        }
      
     

        System.out.println(dfs(0,0));
//        for(int[] a:dp) {
//       	 System.out.println(Arrays.toString(a));
//        }
    }
	
	
	static int dfs(int pi,int pj) {
		
		if (pi == N-1 && pj == M-1) {
			return 1;
		}
		
		if (dp[pi][pj] != -1) {
			return dp[pi][pj];
		}
		
		dp[pi][pj] = 0; 
		
		int ni,nj;
	   	
	   	for(int a=0;a<4;a++) {

	   		ni=pi+di[a];
	   		nj=pj+dj[a];

	   		if(ni>=0&&ni<N&&nj>=0&&nj<M) {
	   			if(map[pi][pj]>map[ni][nj]) {
	   				dp[pi][pj]+=dfs(ni,nj);
	   			}
	   		}
	   	}
			return dp[pi][pj];
	}
}
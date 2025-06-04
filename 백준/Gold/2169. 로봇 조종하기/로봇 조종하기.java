
import java.util.*;
import java.io.*;

public class Main {

	public static int[] di=new int[] {0,0,1};
	public static int[] dj=new int[] {1,-1,0};
	public static int N,M;
	public static int[][] map;
	public static boolean[][] v;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        int[][][] dp=new int[N][M][3];// 0,1,2 가 차례로, 위에서 왔을 때, 좌우 에서 왔을 때 최대, 
        v=new boolean[N][M];
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		for(int a=0;a<3;a++) {
        			dp[i][j][a]=Integer.MIN_VALUE;
        		}
        	}
        }
        //첫 줄은 왼쪽에서만 올 수 있음.
        dp[0][0][1]=map[0][0];
        dp[0][0][0] = map[0][0];
        for(int j=1;j<M;j++) {
        	dp[0][j][1]=map[0][j]+dp[0][j-1][1];
        }
        
        for(int i=1;i<N;i++) {
        	//위에서 오는 경우
        	for(int j=0;j<M;j++) {
        		dp[i][j][0]=Math.max(Math.max(dp[i-1][j][0], dp[i-1][j][1]),dp[i-1][j][2])+map[i][j];
        	}
        	
        	//왼쪽에서 오는 경우. 왼쪽 원소의 왼쪽에서 온 경우와 위에서 온 경우 중 큰 값
        	for(int j=1;j<M;j++) {//맨 왼쪽은 왼쪽에서 올 수 없음.
        		dp[i][j][1]=Math.max(dp[i][j-1][0], dp[i][j-1][1])+map[i][j];   
        	}
        	
        	//오른쪽에서 오는 경우
        	for(int j=M-2;j>=0;j--) {//맨 오른쪽은 오른쪽에서 올 수 없음
        		dp[i][j][2]=Math.max(dp[i][j+1][0], dp[i][j+1][2])+map[i][j];   
        	}
        }
        
        
        System.out.println(Math.max(dp[N-1][M-1][0], dp[N-1][M-1][1]));// 좌에서 위에서만 확인
        
        
        
    }
}

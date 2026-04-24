
import java.util.*;
import java.io.*;

public class Main {

	public static int[][] point;
    public static int N;
    public static double[][] dist;
    public static double[][] dp;
    //public static double[][] answer;
    public static int full;
    public static double answer=Double.MAX_VALUE;
    static final double INF = 1e18;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        N=Integer.parseInt(br.readLine());
        point=new int[N][2];
        dist=new double[N][N];
        
        //System.out.println("getsize"+getSize());
        dp=new double[N][getSize()];
        
        full=(int)Math.pow(2,N)-1;
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1.0);
        }
        
        StringTokenizer st;
        for(int i=0;i<N;i++) {
        	
        	st=new StringTokenizer(br.readLine());
        	point[i][0]=Integer.parseInt(st.nextToken());
        	point[i][1]=Integer.parseInt(st.nextToken());
        	
        }
        
        for(int i=0;i<N;i++) {
        	for(int j=i+1;j<N;j++) {
         	
            	double d=calDist(i,j);
            	dist[i][j]=d;
            	dist[j][i]=d;
            	
            }
        }
        

        System.out.println(dfs(0,1));
        
        
    }
	
	public static double calDist(int p1, int p2){
		
		double d1=point[p1][0]-point[p2][0];
		double d2=point[p1][1]-point[p2][1];
		return Math.sqrt(Math.pow(d1, 2)+Math.pow(d2, 2));
		
	}
	
	public static int getSize() {
		return(int)Math.pow(2, N);
	}
        
//	public static void dfs(int state, int p,double d){
//		//다시 0으로 가고 리턴.
//		
//		if(state==full) {
//			if(answer>(dist[0][p]+d)){
//				answer=(dist[0][p]+d);
//			}
//			return;
//		}
//		
//		//1010101   00001000
//		
//		for(int i=0;i<N;i++){
//			
//			int s=state;
//			int next=(int)Math.pow(2, i);
//			
//			if((s&next)==next) continue; //이미 방문한 점이면 스킵.
//			
//			s=state|next;
//			
//			
//			if(dp[i][s]!=-1&&dp[i][s]<=d+dist[p][i]) continue;
//			
//			dp[i][s]=d+dist[p][i];
//			
//			dfs(s,i,d+dist[p][i]);
//			
//		}
//
//	}
	
	
    static double dfs(int p, int state) {
        if (state == full) {
            return dist[p][0];
        }

        if (dp[p][state] != -1.0) {
            return dp[p][state];
        }

        dp[p][state] = INF;

        for (int next = 0; next < N; next++) {
            int bit = 1 << next;

            if ((state & bit) != 0) continue;

            int nextState = state | bit;

            dp[p][state] = Math.min(
                dp[p][state],
                dist[p][next] + dfs(next, nextState)
            );
        }

        return dp[p][state];
    }
}



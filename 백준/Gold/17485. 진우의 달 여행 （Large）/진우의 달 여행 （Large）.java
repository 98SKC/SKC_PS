
import java.util.*;
import java.io.*;

public class Main{

	public static int[][][] dp;
	public static int[][] space;
	public static int[] dj=new int[] {-1,0,1};
	public static int N,M;
	public static int answer=Integer.MAX_VALUE;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        space=new int[N][M];
        dp=new int[N][M][3];
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		space[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		for(int a=0;a<3;a++) {
        			dp[i][j][a]=Integer.MAX_VALUE;
        		}
        	}
        }
        
        
        for(int j=0;j<M;j++) {
        	dp[0][j][0]=space[0][j];
        	dp[0][j][1]=space[0][j];
        	dp[0][j][2]=space[0][j];
        }
        

        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		if(o1[2]==o2[2]) { //코스트가 같으면 더 멀리 간 루트
        			return o2[1]-o1[1];
        		}
        		return o1[2]-o2[2];
        		
        	}
        	
        	
        });

        for(int j=0;j<M;j++) {
        	dp[0][j][0]=space[0][j];
        	dp[0][j][1]=space[0][j];
        	dp[0][j][2]=space[0][j];
        	pq.add(new int[] {0,j,space[0][j],-1}); // (0,j) 좌표까지 코스트, 직전 방향(초기 어디든 가능 =>-1)
        }
        
        int[] p;
        
        int ni, nj, cost, dir;
        
        while(!pq.isEmpty()) {
        	p=pq.poll();
        	
        	cost=p[2];
        	
        	if(p[0]==N-1) {
        		answer=Math.min(answer, cost);
        		break;
        	}
        	
        	ni=p[0]+1;
        	dir=p[3];
        	
        	for(int a=0;a<3;a++) {
        		if(dir==a) continue;
        		nj=dj[a]+p[1];
        		if(nj>=0&&nj<M){
        			if(dp[ni][nj][a]>cost+space[ni][nj]) {
        				dp[ni][nj][a]=cost+space[ni][nj];
        				pq.add(new int[] {ni,nj,dp[ni][nj][a], a});
        			}
        		}
        	}
        	
        	
        }
        
        System.out.println(answer);
        
    }

}

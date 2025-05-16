
import java.util.*;
import java.io.*;

public class Main {

	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {-1,0,1,0};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        //N*N크기의 대나무 숲. 판다가 대나무를 먹는다
        //상 하 좌 우로 이동하면서 먹는다.
        //대나무를 먹고 이동할 때 이전 지역보다 대나무가 많아야 한다.
        // 어디에 풀고, 어디로 이동시켜야 판타가 최대한 많은 칸을 방문할 수 있는가
        int[][] map=new int[N][N];
        int[][] dp=new int[N][N];
        StringTokenizer st;
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1,int[] o2) {//대나무가 작은 곳부터 시작
        		return o1[3]-o2[3];
        	}
        }); 
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
            	map[i][j]=Integer.parseInt(st.nextToken());
            	dp[i][j]=1;
            	pq.add(new int[] {i,j,1,map[i][j]});
            }
        }
        
        int max=0;// 이동같이 최대가 되도록 이동시켜야하네
        int[] sub;
        int ni,nj;
        
        //시간 단축을 위해, 작은 칸부터 시작하고자 했는데,
        while(!pq.isEmpty()){
        	
        	sub=pq.poll();
        	
        	if(dp[sub[0]][sub[1]]>sub[2]) {
        		continue;
        	}
        	
        	max=Math.max(max, sub[2]);
        	for(int a=0;a<4;a++) {
        		ni=sub[0]+di[a];
        		nj=sub[1]+dj[a];
        		if(		ni>=0&&ni<N&&nj>=0&&nj<N&&// 격자 내부이고
        				map[sub[0]][sub[1]]<map[ni][nj]&&//지금 위치보다 대나무가 많으며
        				dp[ni][nj]<sub[2]+1) {// dp에 저장된 이동거리보다 이번 이동커리가 길어야 한다.
        				dp[ni][nj]=sub[2]+1;
        				pq.add(new int[] {ni,nj,dp[ni][nj],map[ni][nj]});
        		}
        	}
        	
        }
        
        System.out.println(max);

        
    }
}

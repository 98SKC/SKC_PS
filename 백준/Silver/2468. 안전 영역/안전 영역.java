import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	static int[] row=new int[] {-1,0,1,0};//좌 하 우 상
	static int[] col=new int[] {0,1,0,-1};
	//static int[] visit;//0 안전, 1 방문, 2 잠김-int[i]%3 != 0 이면 탐색 가능 이런 느낌?
	static boolean[][] visit;
	static int maxH=0;
	static int minH=0;
	static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		int answer=1;
		StringTokenizer st;
		
		
		//지도 만들기.
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				maxH=Math.max(maxH, map[i][j]);
				minH=Math.min(minH, map[i][j]);
				
			}
		}
		for(int i=minH+1;i<maxH;i++) {//최소 보다 높아야 잠기는 곳이 생기고, 최대보다 낮아야 다 안잠김.
			int sum=0;// 
			visit=new boolean[N][N];
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(map[j][k]>i&&!visit[j][k]) {// 그 지반이 높아야 탐색.
						helper(j,k,i);
						sum++;
					}
				}
			}
			answer=Math.max(answer, sum);
		}
		System.out.println(answer);
		
	}
	
	static void helper(int j,int k,int h) {//j가 세로,
		visit[j][k]=true;
		int di=j;
		int dj=k;
		for(int i=0;i<4;i++) {
			int ni=di+row[i];
			int nj=dj+col[i];
			if(ni>=0&&ni<N&&nj>=0&&nj<N&&map[ni][nj]>h&&!visit[ni][nj]) {// 배열 안쪽이고, 지금 잠긴 높이보다 높아야함.
				helper(ni,nj,h);
			}
		}
	}

}
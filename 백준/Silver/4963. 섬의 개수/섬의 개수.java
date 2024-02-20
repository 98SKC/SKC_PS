import java.io.*;
import java.util.*;

public class Main {
	
	
	static int[][] map;
	static boolean[][] v;
	static int[] di= {0,1,0,-1,1,-1,1,-1};
	static int[] dj= {1,0,-1,0,1,-1,-1,1};					
	static int N,M,count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			if(N==0&&M==0) break;
			count=0;
			
			map=new int[N][M];
			v=new boolean[N][M];
			
			//맵을 생성
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==1&&!v[i][j]) {
						v[i][j]=true;
						findIsland(i,j);
						count++;
					}
				}
			}
	
			sb.append(count).append("\n");			
		}
		System.out.println(sb);
	}
	static void findIsland(int i,int j) {
		
		int ni;
		int nj;
		
		for(int a=0;a<8;a++) {
			ni=i+di[a];
			nj=j+dj[a];
			if(ni>=0&&ni<N&&nj>=0&&nj<M&&map[ni][nj]==1&&!v[ni][nj]) {//이동 지역이 map 안쪽일 때
				v[ni][nj]=true;
				findIsland(ni, nj);
			}
		}
	}
	// 섬 찾아서 count로 표시
	
}
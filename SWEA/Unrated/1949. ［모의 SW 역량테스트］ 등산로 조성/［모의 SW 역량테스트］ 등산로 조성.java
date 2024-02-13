import java.io.*;
import java.util.*;

public class Solution {

	static int N, K;
	static int[][] map;
	static boolean[][] v;
	static int maxHight = 0;
	static int answer=0;
	static int[] di= {-1,0,1,0};// 상 좌 하 우
	static int[] dj= {0,-1,0,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		Queue<Integer> q=new ArrayDeque<>();
		for (int tc = 1; tc <= T; tc++) {
			answer=0;
			maxHight=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			
			//지도 생성
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHight=Math.max(maxHight, map[i][j]);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==maxHight) {
						v=new boolean[N][N];
						v[i][j]=true;//제일 높은곳이긴 한데, 혹시 깎아서 올 수 있다고 생각 할 수 있으니 방문 처리
						dfs(i,j,1,K);
						
					}
				
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);
	}
	static void dfs(int i,int j,int s, int k) {// 위치i.j와 등산로 길이 s 받는다.
		if(!checkRoad(i,j,k)) {// 갈 수 있는 곳이 없으면 지금 위치를 최대거리와 비교
			answer=Math.max(answer, s);
			return;
		}
		
		for(int a=0;a<4;a++) {
			int ni=i+di[a];
			int nj=j+dj[a];
			if(ni>=0&&ni<N&&nj>=0&&nj<N&&!v[ni][nj]) {//지도 안쪽이면서, false이다. -> 갈 수 있다.
				if(map[i][j]>map[ni][nj]) {//지금 위치보다 낮다.
					v[ni][nj]=true;
					dfs(ni,nj,s+1,k);
					v[ni][nj]=false;
				}
				else if(map[i][j]>map[ni][nj]-k) {
					int sub=map[ni][nj];
					v[ni][nj]=true;
					map[ni][nj]=map[i][j]-1;//k다 깎을 필요도 없이 지금 높이보다 1만 낮으면 됨
					dfs(ni,nj,s+1,0);
					map[ni][nj]=sub;//되돌리기
					v[ni][nj]=false;
				}
			}
		}
		
	}

	static boolean checkRoad(int i,int j, int k) {// 깎을 수 있는 깎을 수 있는 깊이(0이면 기회를 소모했음)
		
		int ni;
		int nj;
		for(int a=0;a<4;a++) {
			ni=i+di[a];
			nj=j+dj[a];
			if(ni>=0&&ni<N&&nj>=0&&nj<N&&!v[i+di[a]][j+dj[a]]) {// false이다. -> 갈 수 있다.
				if(map[i][j]>map[ni][nj]||map[i][j]>map[ni][nj]-k) {//지금 위치보다 낮거나, 깎으면 갈 수 있다.
					return true;
				}
			}
		}
		return false;
	}

}
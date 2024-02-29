import java.io.*;
import java.util.*;

public class Solution {
	static int[] di= {-1,1,0,0};//상 하 우 좌
	static int[] dj= {0,0,1,-1};
	static int N,M,R,C,L,ni,nj;
	static int[][] map;
	static boolean[][] v;
	static boolean[] check;
	static Queue<Integer> q=new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			q.clear();
			st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());// 터널의 세로크기
			M=Integer.parseInt(st.nextToken());// 터널의 가로 크기
			R=Integer.parseInt(st.nextToken());// 맨홀 뚜껑의 세로위치
			C=Integer.parseInt(st.nextToken());//맨홀 뚜껑의 가로 위치
			L=Integer.parseInt(st.nextToken());// 탈출 후 지연된 시간.
			
			map=new int[N][M];
			v=new boolean[N][M];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int time=1;
			int size=0;
			int sub=0;
			
			q.add(R*M+C);
			v[R][C]=true;
			while(!q.isEmpty()&&time<L) {// 더 이동 가능한 파이프가 없거나 시간이 끝나면 끝
				size=q.size();
				for(int a=0;a<size;a++) {
					sub=q.poll();
					range(sub/M,sub%M);
				}
				time++;
			}
			int count=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(v[i][j]) count++;
				}
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
	
	static void oper(int i,int j,int dir,int a,int b,int c,int d){
		ni=i+di[dir];
		nj=j+dj[dir];// 위쪽
		if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]) {
			if(map[ni][nj]==a ||map[ni][nj]==b||map[ni][nj]==c||map[ni][nj]==d) {
				v[ni][nj]=true;
				q.add(ni*M+nj);
			}
		} 
		
	}
	static void up(int i,int j) {
		oper(i,j,0,1,2,5,6);
	}

	static void down(int i,int j) {
		oper(i,j,1,1,2,4,7);
	}
	static void right(int i,int j) {
		oper(i,j,2,1,3,6,7);
	}
	
	static void left(int i,int j) {
		oper(i,j,3,1,3,4,5);
	}

	
	
	static void range(int i,int j) {

		int dir=map[i][j];

		switch(dir) {
			case 1:
				up(i,j);
				down(i,j);//right left 아래까지 같이
			case 3:
				//가로
				right(i,j);
				left(i,j);
				break;
			case 2:
				up(i,j);
				down(i,j);
				break;	
			case 4:
				// 상, 우 연결
				up(i,j);
				right(i,j);
				break;
			case 5:
				// 하, 우 연결
				down(i,j);
				right(i,j);
				break;
			case 6:// 하 좌 연결
				down(i,j);
				left(i,j);
				break;
			case 7:// 상 좌 연결
				up(i,j);
				left(i,j);
				break;
			
		}
	}

}
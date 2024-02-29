import java.io.*;
import java.util.*;

public class Solution {
	static int[] di= {-1,1,0,0};//상 하 우 좌
	static int[] dj= {0,0,1,-1};
	static int N,M,R,C,L,ni,nj,count;
	static int[][] map;
	static boolean[][] v;
	static Queue<Integer> q=new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			q.clear();
			count=0;
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
			count++;
			while(!q.isEmpty()&&time<L) {// 더 이동 가능한 파이프가 없거나 시간이 끝나면 끝
				size=q.size();
				for(int a=0;a<size;a++) {
					sub=q.poll();
					range(sub/M,sub%M);
				}
				time++;
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
				count++;
				q.add(ni*M+nj);
			}
		} 
	}
	static void select(int i,int j,int dir) {
		switch(dir) {
		case 0: case 1://위
			oper(i,j,dir,1,2+dir/2,5-dir,6+dir);
			break;
		case 2: case 3://오른쪽
			oper(i,j,dir,1,2+dir/2,10-dir*2,10-dir*2+1);
			break;
		}
	}
	
	static void range(int i,int j) {
		int dir=map[i][j];
		switch(dir) {
			case 1:
				select(i,j,0);
				select(i,j,1);//right left 아래까지 같이
			case 3:
				//가로
				select(i,j,2);
				select(i,j,3);
				break;
			case 2:
				select(i,j,0);
				select(i,j,1);
				break;	
			case 4:
				select(i,j,0);
				select(i,j,2);
				break;
			case 5:
				select(i,j,1);
				select(i,j,2);
				break;
			case 6:
				select(i,j,1);
				select(i,j,3);
				break;
			case 7:
				select(i,j,0);
				select(i,j,3);
				break;
		}
	}
}
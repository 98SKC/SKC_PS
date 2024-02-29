import java.io.*;
import java.util.*;

public class Solution {

	//방향 입력받을때 -1씩 하는 것 잊지 않기
	static int[] di= {-1,1,0,0};//상 하 우 좌
	static int[] dj= {0,0,1,-1};
	static int N,M,R,C,L;
	static int[][] map;
	static boolean[][] v;
	static boolean[] check;
	static Queue<Integer> q=new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/sample_input (10).txt"));
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
			
			q.add(R*M+C);//아직 하는중
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
//			for(boolean[] a:v) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println("----------------------------------------");
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
	// 추가해야 하는거. 파이프가 안 이어져있을 수 있음. 그리고 우상 우하 이런거 틀림. 
	static void range(int i,int j) {
		
		int dir=map[i][j];
		int ni;
		int nj;
		
	//	System.out.printf("i는 %d,j는%d dir은 %d \n",i,j,dir);
		switch(dir) {
			case 1:
				//System.out.println("십자");
				
				ni=i+di[0];
				nj=j+dj[0];// 위쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==2||map[ni][nj]==5||map[ni][nj]==6) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}
				
				ni=i+di[1];
				nj=j+dj[1];// 아래쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==2||map[ni][nj]==4||map[ni][nj]==7) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}
				
				ni=i+di[2];
				nj=j+dj[2];// 오른쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==3||map[ni][nj]==7||map[ni][nj]==6) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}
				
				ni=i+di[3];
				nj=j+dj[3];// 왼쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==3||map[ni][nj]==5||map[ni][nj]==4) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}	

				break;
			case 2:
			//	System.out.println("세로");

				ni=i+di[0];
				nj=j+dj[0];// 위쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==2||map[ni][nj]==5||map[ni][nj]==6) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}
				
				ni=i+di[1];
				nj=j+dj[1];// 아래쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==2||map[ni][nj]==4||map[ni][nj]==7) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}
				break;
			case 3:
				//가로
				ni=i+di[2];
				nj=j+dj[2];// 오른쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==3||map[ni][nj]==7||map[ni][nj]==6) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}
				
				ni=i+di[3];
				nj=j+dj[3];// 왼쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==3||map[ni][nj]==5||map[ni][nj]==4) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}	
				break;
			case 4:
				// 상, 우 연결
				ni=i+di[0];
				nj=j+dj[0];// 위쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==2||map[ni][nj]==5||map[ni][nj]==6) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}
				
				
				ni=i+di[2];
				nj=j+dj[2];// 오른쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==3||map[ni][nj]==7||map[ni][nj]==6) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}
				break;
			case 5:
				// 하, 우 연결
				ni=i+di[1];
				nj=j+dj[1];// 아래쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==2||map[ni][nj]==4||map[ni][nj]==7) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}
				
				
				ni=i+di[2];
				nj=j+dj[2];// 오른쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==3||map[ni][nj]==7||map[ni][nj]==6) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}
				break;
			case 6:// 하 좌 연결

				ni=i+di[1];
				nj=j+dj[1];// 아래쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==2||map[ni][nj]==4||map[ni][nj]==7) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}
				
				
				ni=i+di[3];
				nj=j+dj[3];// 왼쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==3||map[ni][nj]==5||map[ni][nj]==4) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}
				
				break;
			case 7:// 상 좌 연결
				ni=i+di[0];
				nj=j+dj[0];// 위쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==2||map[ni][nj]==5||map[ni][nj]==6) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}
				
				ni=i+di[3];
				nj=j+dj[3];// 왼쪽
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]){// 방문한 적이 없고, 맵 안쪽이다.
					if(map[ni][nj]==1 ||map[ni][nj]==3||map[ni][nj]==5||map[ni][nj]==4) {//바로 위의 if에 있어도 되는데 가로로 너무 길어서 확인 힘듦...
						v[ni][nj]=true;
						q.add(ni*M+nj);
					}
				}
				
	
				break;
			
		}
		
		
	}

}
import java.util.*;
import java.io.*;


public class Main {

	static int N,min=0;
	static int[][] map;
	static int[] di= {-1,0,0,1};
	static int[] dj= {0,-1,1,0};//상 좌 우 하
	static boolean[][] v;
	static int size=2,count=2;
	static int subI,subJ,dis=0;;
	static int[] subIJ=new int[3];//0 은 i좌표, 1은 j좌표, 2는 이동해온 거리
	
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		Queue<int[]> q=new ArrayDeque<>();
		int ni=0, nj=0;
		boolean check;
	
		
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		v=new boolean[N][N];

		//물고기와 상어 정보 저장.
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					q.add(new int[] {i,j,0}); //0 i좌표, 1 j좌표, 2 이동거리
					map[i][j]=0;// 상어 위치도 0으로 변경
					v[i][j]=true;//처음 위치는 방문 처리
				}
			}
		}

		while(!q.isEmpty()) {// 이동할 수가 없을 때 까지.
			subIJ=q.poll();
			subI=subIJ[0];
			subJ=subIJ[1];
			dis=subIJ[2];
			if(map[subI][subJ]>0&&map[subI][subJ]<size) {// 최단 거리의 물고기를 먹은 경우.
				check=true;
				while(!q.isEmpty()&&check) {
					// 같은 거리의 좌표들끼리 우선순위를 비교해봄.
					check=helper(q.poll());// 지금 발견한 좌표와 같은 거리의 놈들만 체크.
//					System.out.println(subIJ.toString());
//					System.out.println("----------------");
				}
				
				q.clear();//다른 이동 경우 초기화.
				min+=dis;// 총 이동거리 갱신
				dis=0;// 이동거리 초기화.
				map[subI][subJ]=0;// 물고기를 먹음.
				v=new boolean[N][N];//방문 상황 초기화
				v[subI][subJ]=true;// 지금 위치는 다시 방문처리. 
				count-=1;// 먹어야 하는 양 갱신
				if(count==0) {// 다 먹었으면 
					size+=1;//크기는 커지고
					count=size;// 카운트도 초기화
				}
	//			System.out.printf("%d %d 위치의 물고기를 먹었습니다.이동거리는 %d입니다. 지금 크기는 %d 더 먹어야 하는 물고기는 %d 입니다. 지금까지 먹은 물고기는 %d 입니다. \n",subI,subJ,min,size,count,ccount++);
			}

			// 이동을 위치를 확인.
			for(int a=0;a<4;a++) {
				
				ni=subI+di[a];
				nj=subJ+dj[a];
//				System.out.printf("이동 위치 확인 ni는 %d, nj는 %d \n ",ni,nj);
//				System.out.printf("%b %b %b %b %b \n",ni>=0,ni<N,nj>=0,nj<N,!v[nj][ni]);
				if(ni>=0&&ni<N&&nj>=0&&nj<N&&!v[ni][nj]) {// 우선 맵 안쪽의 범위인지, 방문을 한적 있는지 확인
					if(map[ni][nj]<=size) {// 이동이 가능한 좌표면, 거기에 자신보다 큰 물고기가 있는지 확인.
						q.add(new int[] {ni,nj,dis+1});// 이동 가능하면 q에 이동좌표와 이동 거리 저장.
						v[ni][nj]=true;
					}
				}
			}
		}

		System.out.println(min);
	}
	static boolean helper(int[] b) {
		if(dis!=b[2]) {
			return false;
		}
		
		int bi=b[0];
		int bj=b[1];
		if(map[bi][bj]>0&&map[bi][bj]<size) {
			int ai=subI;
			int aj=subJ;
			if(ai>bi) {// 다른 놈이 더 위에
//				System.out.println("subIJ바뀌는지 확인");
				subIJ=b;
				subI=b[0];
				subJ=b[1];
//				System.out.println(b.toString());
			}else if(ai==bi&&aj>bj) {// 높이가 같을 때 다른게 더 왼쪽에
//				System.out.println("subIJ바뀌는지 확인");
				subIJ=b;
				subI=b[0];
				subJ=b[1];
//				System.out.println(b.toString());

			}
		}
		return true;

	}
	

}
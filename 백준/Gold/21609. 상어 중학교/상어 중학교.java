import java.util.*;
import java.io.*;

//1. 총 4개의 상태. 없음, 검정 블록, 무지개 블록, 색상블록
//2. 반시계로 회전 후 중력 작용. 검정 블록은 공간고정
//3. 블록 그룹에 대한 기준 블록이 있다. 무지개 블록이 아닌 블록 중 좌측 상단이 기준
//4. 크기가 가장 큰 블록 그룹은 삭제된다. 크기가 같다면 무지개 블록이 가장 많은 그룹이.
//무지개 블록 수도 같다면 기준 블록이 가장 아래쪽. 높이도 같다면 가장 우측.



public class Main {
	static int[][] map;
	static int N,M;
	static int rainbow=0;
	static int[] di= {0,1,0,-1};
	static int[] dj= {1,0,-1,0};
	static Queue<Integer> del=new ArrayDeque<>();// 삭제할 좌표들의 q
	static Queue<Integer> q;// 블록 그룹을 구할 q
	static Stack<Integer> alwaysFalse=new Stack<>();
	static int max=0;
	static int answer=0;
	static boolean[][] v;
	static boolean check;
	//-2 공백, -1 검은블록, 0 무지개, 1
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][N];
		v=new boolean[N][N];
		int cnt=0;
		int sub;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		check=true;
		while(check) {
			v=new boolean[N][N];
			check=false;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]>0) {
						bfs(i,j,map[i][j]);
					}
				}
			}
			
			//블록 삭제하기
			if(del.size()>1) {
				check=true;
				int sub2;
				//삭제부
				//System.out.println("추가되는 점수: "+Math.pow(del.size(),2));
				answer+=Math.pow(del.size(),2);
				while(!del.isEmpty()) {
					sub2=del.poll();
					map[sub2/N][sub2%N]=-2;
				}
				//System.out.println("삭제된 배열");
//				for(int[] a:map) {
//					System.out.println(Arrays.toString(a));
//				}
				
				gravity();			
				//System.out.println("1차 중력 작용 배열");
//				for(int[] a:map) {
//					System.out.println(Arrays.toString(a));
//				}
				
				//맵 돌리기
				turn();
				//System.out.println("돌린 배열");
//				for(int[] a:map) {
//					System.out.println(Arrays.toString(a));
//				}
				gravity();			
				//System.out.println("2차 중력 작용 배열");
//				for(int[] a:map) {
//					System.out.println(Arrays.toString(a));
//				}
			}
		}
		
		System.out.println(answer);
	}
	
	static void turn() {
		
		Queue<Integer> q=new ArrayDeque<>();
		for(int i=0;i<N;i++) {
			for(int j=N-1;j>=0;j--) {
				q.add(map[i][j]);
			}
		}
		
		for(int j=0;j<N;j++) {
			for(int i=0;i<N;i++) {
				map[i][j]=q.poll();
			}
		}
	}
	
	static void gravity() {
		int bot;
		for(int j=0;j<N;j++) {
			bot=N-1;
			for(int i=N-1;i>=0;i--) {
				if(map[i][j]==-1) {// 검은 블록이 있으면 그 위에 쌓임.
					bot=i-1;
				}else if(map[i][j]!=-2){//-1도 아니면서 다른 블록
					if(bot!=i) {// 지금 위치가 바닥이 아니면 바닥과 교환후 바닥 올리기
						map[bot][j]=map[i][j];
						map[i][j]=-2;	
					}
					bot--;
				}//-2이면 그냥 탐색 위치만 올림.				
			}
		}
	}
	
	static void bfs(int i,int j,int block) {
		q=new ArrayDeque<>();
		Queue<Integer> sub3=new ArrayDeque<>();
		q.add(i*N+j);
		int sub;
		int ci,cj,ni, nj;
		
		
		while(!q.isEmpty()) {
			
			sub=q.poll();
			ci=sub/N;
			cj=sub%N;
			
			for(int a=0;a<4;a++) {
				ni=ci+di[a];
				nj=cj+dj[a];
				if(ni>=0&&ni<N&&nj>=0&&nj<N&&(map[ni][nj]==block||map[ni][nj]==0)&&!v[ni][nj]){//맵범위 내이고, 블록색이 같거나 무지개이고, 방문안함
					if(map[ni][nj]==0) {//무지개 불록이면
						alwaysFalse.add(ni*N+nj);
					}
					q.add(ni*N+nj);
					v[ni][nj]=true;
					sub3.add(ni*N+nj);
				}
			}
			
		}
		
		//위의 while에서 블록 그룹을 q에 넣어둠.
//		System.out.println("삭제 예정인 블록 크리:"+del.size());
//		System.out.println("찾은 그룹 크기: "+sub3.size());

		if(del.size()<sub3.size()) {//새로 구한 그룹의 크기가 더 크면
			del=sub3;
			rainbow=alwaysFalse.size();// 무지개 블록 개수 변경
		}else if(del.size()==sub3.size()&&rainbow<=alwaysFalse.size()) {//만약 크기가 같으면 
				del=sub3;
				rainbow=alwaysFalse.size();		
		}//그룹이 작은건 고려 안함
		
		//무지개 블록은 방문 초기화.
		while(!alwaysFalse.isEmpty()) {
			sub=alwaysFalse.pop();
			v[sub/N][sub%N]=false;
		}
		
	}
	//여기까지 bfs 메서드
	
	

}
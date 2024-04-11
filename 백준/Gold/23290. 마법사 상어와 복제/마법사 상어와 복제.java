import java.util.*;

import java.io.*;

public class Main {

	static int[][] map=new int[4][4];
	static int[] di=new int[] { 0,-1,-1,-1,0,1,1, 1}; 
	static int[] dj=new int[] {-1,-1, 0, 1,1,1,0,-1};
	
	static int[] si=new int[] {-1,0,1,0}; //상 좌 하 우
	static int[] sj=new int[] {0,-1,0,1};
	
	static List<int[]> copyFish;
	static int sharkMax;
	static int[] sharkDir=new int[3];
	static boolean[][] v;
	static List<Integer>[][] fish=new List[4][4];//fish.get(i)
	
	static Position shark;
	static int M,S;
	static class Position implements Comparable<Position>{
		int i;
		int j;
		
		Position(int i,int j){
			this.i=i;
			this.j=j;
		}
		
		@Override
		public int compareTo(Position o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M=Integer.parseInt(st.nextToken());//물고기 정보의 줄 개수
		S=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				fish[i][j]=new ArrayList<>();
			}
		}
		
		int subI;
		int subJ;
		int subDir;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			subI=Integer.parseInt(st.nextToken())-1;
			subJ=Integer.parseInt(st.nextToken())-1;
			subDir=Integer.parseInt(st.nextToken())-1;
			//Position pos=new Position(subI, subJ, subDir);
			fish[subI][subJ].add(subDir);
			
		}
		st=new StringTokenizer(br.readLine());
		shark=new Position(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);


		for(int i=1;i<=S;i++) {

			copy();
			
			moving();

			sharkMax=-1;
			v=new boolean[4][4];
			
			dfs(0,0, shark.i,shark.j, new int[] {0,0,0});
			
			eat();

			disappear();
			
			copyApply();

		}
		
		int sum=0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				sum+=fish[i][j].size();
			}
		}
		System.out.println(sum);
	}
	static void copy() {//1번 항목의 복사
		copyFish=new ArrayList<>();
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				for(int dir:fish[i][j]) {
					copyFish.add(new int[] {i*4+j,dir});
				}
			}
		}
		
	}
	
	static void copyApply() {//1번 항목의 복사 실행
		
		int subI;
		int subJ;
		for(int[] a: copyFish) {
			subI=a[0]/4;
			subJ=a[0]%4;
			fish[subI][subJ].add(a[1]);
		}
	}
	
	static void moving() {
		Queue<int[]> q=new ArrayDeque<>();
		int[] sub;
		int ni;
		int nj;
		int subDir;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				for(int dir:fish[i][j]) {
					boolean check=false;
					subDir=dir;
					ni=i;
					nj=j;

					for(int a=0;a<8;a++) {
						
						if(subDir<0) subDir=7;
						
						ni=i+di[subDir];
						nj=j+dj[subDir];
						
						
						if(ni>=0&&ni<4&&nj>=0&&nj<4&&map[ni][nj]==0) {
							if(ni==shark.i&&nj==shark.j) {
								subDir-=1;
								continue;
								
							} 
							check=true;
							break;
						}

						
						subDir-=1;
					}
					if(check) {
						q.add(new int[] {ni*4+nj,subDir});
					}else {
						q.add(new int[] {i*4+j,dir});
					}

				}
				fish[i][j].clear();
			}
		}
		
		while(!q.isEmpty()) {
			sub=q.poll();

			ni=sub[0]/4;
			nj=sub[0]%4;

			fish[ni][nj].add(sub[1]);
		}

		
		
	}

	static void dfs(int cnt,int max,int i,int j,int[] dir) {// 사전순으로 상어의 이동 위치 탐색  //상좌하우   1234  1111~4444
		
		if(cnt==3) {
			if(sharkMax<max) {
				sharkMax=max;
				for(int d=0;d<3;d++) {
					sharkDir[d]=dir[d];
				}

			}
			return;
		}
		if(cnt!=0)v[i][j]=true;
		
		int ni,nj;
			
		for(int a=0;a<4;a++) {
			ni=i+si[a];
			nj=j+sj[a];
			if(ni>=0&&ni<4&&nj>=0&&nj<4) {
				dir[cnt]=a;
				if(v[ni][nj]) {
					dfs(cnt+1,max,ni,nj,dir);
				}else {
					dfs(cnt+1,max+fish[ni][nj].size(),ni,nj,dir);
				}
				
			}
		}
		v[i][j]=false;
	}
	
	static void eat() {

		int ni=shark.i;
		int nj=shark.j;
		for(int i=0;i<3;i++) {
			ni=ni+si[sharkDir[i]];
			nj=nj+sj[sharkDir[i]];

			if(!fish[ni][nj].isEmpty()) {
				map[ni][nj]=3;// 냄새 갱신 생각해서 1추가한 3 저장.
				fish[ni][nj].clear();
			}
	
		}
		shark.i=ni;
		shark.j=nj;
	}
	
	static void disappear() {// 냄새 상태 갱신
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(map[i][j]!=0) {
					map[i][j]--;
				}
			}
		}
	}
	
}
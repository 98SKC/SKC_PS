import java.io.*;
import java.util.*;

public class Main {
	
	static int N,start, cnt=0, min=Integer.MAX_VALUE;
	static int[] di= {0,1,0,-1};
	static int[] dj= {1,0,-1,0};
	static int[][] map;
	static boolean[][] v;
	static Queue<Integer> q=new ArrayDeque<>();
	//static List<Integer> list=new ArrayList<>();
	static HashSet<Integer> set=new HashSet<>();
	
	//가장 먼저 떠오르는건 BFS. -> 문제점: 모든 외각을 판단하고, 외각에서 다 bfs를 해야함.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		int si=0;
		int sj=0;
		int ni=0;
		int nj=0;
		map=new int[N][N];
		//지도만들기
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
	
		//섬 구분하기
		v=new boolean[N][N];	
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!v[i][j]&&map[i][j]!=0) {
					cnt++;
					seperateIsland(i,j);
				}
			}
		}
	//	System.out.println("섬의 개수: "+cnt);
	//	System.out.println("외각 개수: "+set.size());
		//다리 지을 곳 찾는 dfs
		for(int a:set) {// 외각의 좌표만을 선택
			q.clear();
			v=new boolean[N][N];// 시작 외각마다 방문 상황 초기화.
			v[a/N][a%N]=true;
			cnt=0;// 시작 외각마다 다리 길이 초기화
			q.add(a);// 처음 위치 큐에 저장.
			int startLand=0;
			for(int b=0;b<4;b++) {

				ni=a/N+di[b];
				nj=a%N+dj[b];
				if(ni<0||ni>=N||nj<0||nj>=N) continue;
				if(map[ni][nj]!=0) {
					startLand=map[ni][nj];
					break;
				}
			}
			//System.out.println("외각 번호: "+a);
			while(!q.isEmpty()) {		

				cnt+=1;
				//System.out.println("cnt증가:"+cnt); 
				if(cnt>min) break;
				int len=q.size();
				int sub=0;
				
				
				for(int c=0;c<len;c++) {

					sub=q.poll();
					//v[sub/N][sub%N]=true;
					for(int b=0;b<4;b++) {
						ni=sub/N+di[b];
						nj=sub%N+dj[b];
						if(ni<0 || nj <0 || ni >= N || nj >= N || v[ni][nj]) continue;
						if(map[ni][nj]!=startLand&&map[ni][nj]!=0) {//다리 연결됨을 확인-> 4방향에 시작의 땅과 다른 땅이 존재.
							//System.out.printf("시작위치: %d,%d  도착위치: %d,%d 거리: %d \n",a/N,a%N,ni,nj,cnt);
							min=cnt;
							break;
						}else if(map[ni][nj]!=startLand&&map[ni][nj]==0) {// 다음 탐색 조건 : 바다고, 시작한 땅이 아님.
							v[ni][nj]=true;
							q.offer(ni*N+nj);
							
						}
					}
				}
			}
		}
		System.out.println(min);
	}
	static void seperateIsland(int i, int j) {
		v[i][j]=true;
		map[i][j]=cnt;
		int ni;
		int nj;
		boolean land=false;
		for(int a=0;a<4;a++) {
			ni=i+di[a];
			nj=j+dj[a];
			if(ni<0||ni>=N||nj<0||nj>=N||v[ni][nj]) continue;
			if(map[ni][nj]==0) {
				set.add(ni*N+nj);
			}else {
				seperateIsland(ni, nj);
			}
		}
	}
  
}
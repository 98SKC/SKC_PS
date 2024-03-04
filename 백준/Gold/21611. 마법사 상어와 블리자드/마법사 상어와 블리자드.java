import java.util.*;

import java.io.*;

public class Main {

	static int ccnt=0;
	static int N, M;
	static int startI;
	static int startJ;
	static int[][] map;
	static int[] di= {0,-1,1,0,0};//상 하 좌 우
	static int[] dj= {0,0,0,-1,1};
	static Queue<Integer> q;
	static Queue<int[]> arrQ;
	static int one=0, two=0, three=0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		startI = N / 2;
		startJ = N / 2 - 1;
		// 상어 위치는 N/2 , N/2

		// 맵생성
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int a,b;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			blizzard(a,b);
			do{
				pullMarble();
			}while(chainBoom());
			grouping();
			insertMarble();
		}
		System.out.println(one+2*two+3*three);

	}

	static void search() {// 중심으로부터 돌아가면서 탐색하는 메서드
		int ni=N/2;
		int nj=N/2;
		int number=1;
		int dir=3;// 좌 하 우 상     3 2 4 1
		while(ni>=0&&ni<N&&nj>=0&&nj<N){
			for(int a=0;a<number;a++) {
				ni=ni+di[dir];
				nj=nj+dj[dir];
			}
			if(dir==3) {// 좌에서 하로
				dir=2;
			}else if(dir==2) {//하에서 우로
				dir=4;
				number++;
			}else if(dir==4) {//우에서 상으로
				dir=1;
			}else {// 상에서 좌로
				dir=3;
				number++;
			}
		}
	}
	
	static void blizzard(int d,int s) {// 상어의 구슬 깨기
		int ni=N/2;
		int nj=N/2;		
		for(int i=0;i<s;i++) {
			ni=ni+di[d];
			nj=nj+dj[d];
			map[ni][nj]=0;
		}

	}
	
	static boolean chainBoom() {// 연속적인 구슬을 찾아 폭발시키는 메서드/ 막타가 안쳐짐.

		int ni=N/2;
		int nj=N/2;
		int number=1;
		int before;
		boolean answer=false;
		Queue<Integer> subQ=new ArrayDeque<Integer>();
		int dir=3;// 좌 하 우 상     3 2 4 1
		while(ni>=0&&ni<N&&nj>=0&&nj<N){
			for(int a=0;a<number;a++) {

				subQ.add(ni*N+nj);
				before=map[ni][nj];
				ni=ni+di[dir];
				nj=nj+dj[dir];
				if(ni<0||ni>=N||nj<0||nj>=N) break;
				if(before!=map[ni][nj]) {//구슬이 달라지면 이전까지 연속된 구슬이 4개 이상인지 확인
					if(subQ.size()>=4) {//다른것도 하나 들어가 있으니 5개가 들어가 있어야 연쇄. 단 마지막 좌표는 남김 
						
						answer=true;// 연쇄가 있으면 true
						if(before==1) {
							one+=subQ.size();
						}else if(before==2) {
							two+=subQ.size();
						}else {
							three+=subQ.size();
						}
						while(!subQ.isEmpty()) {
							int sub=subQ.poll();
							map[sub/N][sub%N]=0;
						}
					}else {// 4개가 안쌓임.
						while(!subQ.isEmpty()) {
							subQ.poll();// 하나만 남기고 제거.
						}
					}
				}
			}
			if(dir==3) {// 좌에서 하로
				dir=2;
			}else if(dir==2) {//하에서 우로

				dir=4;
				number++;
			}else if(dir==4) {//우에서 상으로

				dir=1;
			}else {// 상에서 좌로

				dir=3;
				number++;
			}
		}

		return answer;
	}
	
	static void pullMarble() {// 폭발, 혹은 구슬 깨기 이후 구슬을 당기는 메서드

		q=new ArrayDeque<Integer>();
		int ni=N/2;
		int nj=N/2;
		int number=1;
		int before=0;
		int dir=3;// 좌 하 우 상     3 2 4 1
		
	
		while(ni>=0&&ni<N&&nj>=0&&nj<N){
			for(int a=0;a<number;a++) {
				before=map[ni][nj];
				ni=ni+di[dir];
				nj=nj+dj[dir];

				if(ni<0||ni>=N||nj<0||nj>=N) break;

				if(map[ni][nj]!=0) {
					q.add(map[ni][nj]);
				} 
			}
			if(dir==3) {// 좌에서 하로
				dir=2;
			}else if(dir==2) {//하에서 우로
				dir=4;
				number++;
			}else if(dir==4) {//우에서 상으로
				dir=1;
			}else {// 상에서 좌로
				dir=3;
				number++;
			}

		}
		ni=N/2;
		nj=N/2;
		number=1;
		dir=3;
		int sub;
		while(ni>=0&&ni<N&&nj>=0&&nj<N){		
			for(int a=0;a<number;a++) {
				if(!q.isEmpty()) {
					sub=q.poll();
				}else {
					sub=0;
				}
				ni=ni+di[dir];
				nj=nj+dj[dir];
				if(ni<0||ni>=N||nj<0||nj>=N) break;
				map[ni][nj]=sub;
			}
			if(dir==3) {// 좌에서 하로
				dir=2;
			}else if(dir==2) {//하에서 우로
				dir=4;
				number++;
			}else if(dir==4) {//우에서 상으로
				dir=1;
			}else {// 상에서 좌로
				dir=3;
				number++;
			}
		}
	

	}
	
	static void grouping() {// 구슬을 그룹화하는 메서드

		
		arrQ=new ArrayDeque<int[]>();
		int ni=N/2;
		int nj=N/2;
		int number=1;
		int before=0;
		int size=0;//상어 위치부터 시작하는 건 제외하기 위함.
		int dir=3;// 좌 하 우 상     3 2 4 1
		while(ni>=0&&ni<N&&nj>=0&&nj<N){
			for(int a=0;a<number;a++) {
				before=map[ni][nj];
				ni=ni+di[dir];
				nj=nj+dj[dir];
				if(ni<0||ni>=N||nj<0||nj>=N) break;
				if(before!=map[ni][nj]) {
				
					if(size!=0)arrQ.add(new int[] {size,before});
					size=1;
				}else {
			
					size++;	
					
				}
				
				
			}
			if(dir==3) {// 좌에서 하로
				dir=2;
			}else if(dir==2) {//하에서 우로
				dir=4;
				number++;
			}else if(dir==4) {//우에서 상으로
				dir=1;
			}else {// 상에서 좌로
				dir=3;
				number++;
			}
		}
		if (size != 0) {
			if(before!=0) arrQ.add(new int[] {size, before});
		   
		}
	}
	
	static void insertMarble() {//  그룹별로 구슬 추가
		Queue<Integer> insert=new ArrayDeque<Integer>();
		int size;
		int number;
		int[] arr;
		
		while(!arrQ.isEmpty()) {
			arr=arrQ.poll();
			insert.add(arr[0]); // 그룹의 크기
			insert.add(arr[1]); // 그룹을 구성하는 구슬의 번호
			
		}
		
		int ni=N/2;
		int nj=N/2;
		number=1;
		int sub;
		int dir=3;// 좌 하 우 상     3 2 4 1
		while(ni>=0&&ni<N&&nj>=0&&nj<N){	
			for(int a=0;a<number;a++) {
			    ni=ni+di[dir];
			    nj=nj+dj[dir];
			    if(ni<0||ni>=N||nj<0||nj>=N) break;
			    if(!insert.isEmpty()) sub=insert.poll();
			    else sub=0;
			    map[ni][nj]=sub;
			}
			if(dir==3) {// 좌에서 하로
				dir=2;
			}else if(dir==2) {//하에서 우로
				dir=4;
				number++;
			}else if(dir==4) {//우에서 상으로
				dir=1;
			}else {// 상에서 좌로
				dir=3;
				number++;
			}
		}

	}

}
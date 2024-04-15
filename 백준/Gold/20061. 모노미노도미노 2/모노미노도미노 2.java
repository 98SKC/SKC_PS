import java.util.*;
import java.io.*;



public class Main {

	
	
	static int answer=0;
	static boolean[][] green=new boolean[6][4];
	static boolean[][] blue=new boolean[6][4];

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int type;
		int subX;
		int subY;
		for(int t=0;t<N;t++) {
			st=new StringTokenizer(br.readLine());
			type=Integer.parseInt(st.nextToken());//1- 한칸짜리, 2-가로, 3-세로
			subX=Integer.parseInt(st.nextToken());
			subY=Integer.parseInt(st.nextToken());
			
			switch(type) {
				case 1:
					point(true,subX,subY);
					point(false,subY,subX);
					break;
				case 2:
					rowBlock(true,subX,subY);// 초록 기준 x,y에서 가로 블록이 내려오면
					colBlock(false,subY,subX);// 파랑 기준 y,x에서 세로 블록이 내려옴
					break;
				case 3:
					colBlock(true,subX,subY);// 초록 기준 x,y에서 세로 블록이 내려오면
					rowBlock(false,subY,subX);// 파랑 기준 y,x에서 가로 블록이 내려옴
					break;
			}
			answer+=searchFull(true);
			int del=searchOut(true);
			if(del!=0) {
				delete(true,del);
			}
			
			answer+=searchFull(false);
			del=searchOut(false);
			if(del!=0) {
				delete(false,del);
			}
			
			
		}

		
		System.out.println(answer);
		int sum=0;
		for(int i=0;i<6;i++) {
			for(int j=0;j<4;j++) {
				if(green[i][j]) sum++;
				if(blue[i][j]) sum++;
			}
		}
		System.out.println(sum);

	}
	
	static boolean[][] select(boolean s){
		if(s) {
			return green;
		}else {
			return blue;
		}
	}
	static void rowBlock(boolean s, int x,int y) {// 가로 형태의 블록
		boolean[][] map=select(s);

		//처음 현 i 인덱스
		int np;
		//이동할 i인덱스
		int mp=1;
		//고정 j 인덱스
		int hp1=y;
		int hp2=y+1;
		
		while(mp<6&&!map[mp][hp1]&&!map[mp][hp2]) {
			mp++;
		}
		map[mp-1][hp1]=true;
		map[mp-1][hp2]=true;
		
		
	}
	
	static void colBlock(boolean s, int x, int y) {// 세로 형태의 블록
		boolean[][] map=select(s);
		//처음 현 i 인덱스
		int np;
		//이동할 i인덱스
		int mp=1;
		//고정 j 인덱스
		int hp=y;
		
		while(mp<6&&!map[mp][hp]) {
			mp++;
		}
		map[mp-1][hp]=true;
		map[mp-2][hp]=true;
		
	}
	
	static void point(boolean s, int x,int y) {//한칸짜리 블록
		boolean[][] map=select(s);

		//이동할 i인덱스
		int mp=1;
		//고정 j 인덱스
		int hp=y;
		
		while(mp<6&&!map[mp][hp]) {
			mp++;
		}
		map[mp-1][hp]=true;
	}
	
	static int searchFull(boolean s) {// 한 줄 완성 시 삭제까지 처리
		List<Integer> list=new ArrayList<Integer>();
		int answer=0;
		boolean[][] map=select(s);
		for(int i=2;i<6;i++) {
			for(int j=0;j<4;j++) {
				if(!map[i][j]) {
					break;
				}
				
				if(j==3) {
					//System.out.println(i+"행 꽉참");
					list.add(i);
				} 
			}
		}
		answer=list.size();
		if(answer!=0) {
			for(int i:list) {
				for(int j=0;j<4;j++) {
					map[i][j]=false;
				}
			}
			pullBlock(s,list);
		}
		
		return answer;
		
	}
	
	static int searchOut(boolean s) {
		boolean[][] map=select(s);
		int answer=0;
		for(int i=0;i<2;i++) {
			for(int j=0;j<4;j++) {
				if(map[i][j]) {
					answer++;
					break;
				}
			}
		}
		return answer;
	}
	
	static void pullBlock(boolean s,List<Integer> list) {
		boolean[][] map=select(s);
		HashSet<Integer> set=new HashSet<Integer>();
		for(int a:list) {

			set.add(a);
		}
		int cnt;
		Queue<Boolean> q=new ArrayDeque<>();
		boolean check;
		for(int j=0;j<4;j++) {
			cnt=5;
			for(int i=5;i>=0;i--) {
				if(!set.contains(i)) {
					q.add(map[i][j]);
					map[i][j]=false;
				}
				
			}

			while(!q.isEmpty()) {
	
				map[cnt][j]=q.poll();
				cnt--;
			}
		}

		
	}
	
	//연한 블록에 있을 때 삭제하는 메서드
	static void delete(boolean s, int d) {
		boolean[][] map=select(s);
		List<Integer> list=new ArrayList<Integer>();
		for(int i=5;i>5-d;i--) {

			list.add(i);
		}

		for(int i=6-d;i<6;i++) {
			for(int j=0;j<4;j++) {
				map[i][j]=false;
			}
		}

		pullBlock(s,list);
	}
	
	
}
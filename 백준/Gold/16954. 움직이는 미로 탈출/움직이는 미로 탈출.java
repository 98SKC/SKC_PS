import java.io.*;
import java.util.*;

public class Main {

	public static int[] di=new int[] {0,0,1,0,-1,1,1,-1,-1};
	public static int[] dj=new int[] {0,1,0,-1,0,-1,1,-1,1};
	
	
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> wall=new ArrayDeque<>();
		//PriorityQueue<Integer> wall = new PriorityQueue<>(Comparator.reverseOrder());

		String sub;
		int[][] map=new int[8][8];
		
		
		for(int i=0;i<8;i++) {
			sub=br.readLine();
			for(int j=0;j<8;j++) {
				if(sub.charAt(j)=='#') {
					
					map[i][j]=1;// mpa이 true인 곳에 벽이 있다.
					wall.add(i*8+j);
				}
			}
		}

		boolean check=false;
		ArrayDeque<Integer> q=new ArrayDeque<>();
		boolean[][] p;
		int ni,nj;
		int pi,pj;
		int pos;
		q.add(7*8);// 사람의 초기 위치
		
		while(!q.isEmpty()) {
			p=new boolean[8][8];
			int len=q.size();
			// 사람이 이동 가능한 경우를 배열에 저장.
			for(int i=0;i<len;i++){
				pos=q.poll();
				pi=pos/8;
				pj=pos%8;
				if(pi==0&&pj==7) {// 목적지에 도착
					check=true;
					break;
				}
				for(int a=0;a<9;a++) {// 이동 가능한 8방향과 가만히 있는 경우까지
					ni=pi+di[a];
					nj=pj+dj[a];
					if(ni>=0&&ni<8&&nj>=0&&nj<8&&0==map[ni][nj]&&!p[ni][nj]){
						
						p[ni][nj]=true;
					}
					
				}
			}
			if(check) break;
			
			// 벽의 이동
			int len2=wall.size();
			//System.out.println("벽 개수: "+len2);
			for(int i=0;i<len2;i++) {
				int w=wall.poll();
				int wi=w/8;
				int wj=w%8;
				//System.out.print("이동 전 벽 위치: "+wi+" "+wj);
				map[wi][wj]--;
				if(wi+1<8) {
					wall.add((wi+1)*8+wj);
					map[wi+1][wj]++;
					if(p[wi+1][wj]) {
						p[wi+1][wj]=false;
					}
				}
			}
			
//			System.out.println("벽");
//			for(int i=0;i<8;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println("사람");
//			for(int i=0;i<8;i++) {
//				System.out.println(Arrays.toString(p[i]));
//			}
//			System.out.println();
			//최종적으로 다음 턴 이동 가능한 경우의 수 큐에 삽입
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					if(p[i][j]) q.add(i*8+j);
				}
			}
			
		}
		
		if(check) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	
	
}
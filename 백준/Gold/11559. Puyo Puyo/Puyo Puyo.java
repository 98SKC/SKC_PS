import java.io.*;
import java.util.*;


public class Main {

	static int count=0;
	static int[] di= {0,1,0,-1};
	static int[] dj= {1,0,-1,0};
	static char[][] map=new char[12][6];
	static boolean[] v;
	static Queue<Integer> pos=new ArrayDeque<>(); // 삭제를 위한 큐
	static Queue<Character> q=new ArrayDeque<>();// 재정렬을 위한 큐
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		boolean check;
		int sub;
		for(int i=0;i<12;i++) {
			str=br.readLine();
			for(int j=0;j<6;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		do{
			check=false;
			v=new boolean[72];
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++) {
					if(map[i][j]!='.'&&!v[i*6+j]) {
						chain(i,j,map[i][j]);
						//System.out.println("체인 끝났음==============="); 
						if(pos.size()>=4) {
							check=true;
							while(!pos.isEmpty()) {
								sub=pos.poll();
								//System.out.printf("%d %d 삭제. 색은 %c \n",sub/6,sub%6,map[sub/6][sub%6]);
								map[sub/6][sub%6]='.';
							}
						}
						pos.clear();
					}
				}
			}
			simul();// 뿌요를 삭제하고, 아래로 내린다.
//			System.out.println("여기서");
			if(check) count++;
//			System.out.println("올라야하는데?");
			
//			for(char[] a:map) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println("----------------------------");
		}while(check);
		
		System.out.println(count);
		
		
		
		
	}
	
	static void chain(int i,int j,char color) {//상하좌우로 찾아감.

		int ni;
		int nj;
		
		for(int a=0;a<4;a++) {
			ni=i+di[a];
			nj=j+dj[a];
			if(ni>=0&&ni<12&&nj>=0&&nj<6&&!v[ni*6+nj]&&map[ni][nj]==color) {
				v[ni*6+nj]=true;
				pos.add(ni*6+nj);
//				System.out.printf("%d %d 위치 색은 %c \n",ni,nj,map[ni][nj]);
				chain(ni,nj,color);
			}
		}
	}
	
	
	static void simul() {// 왼쪽부터. 아래쪽의 빈공간이 있으면 위아래를 교환하려했는데 큐가 나을지도

		
		
		for(int j=0;j<6;j++) {
			for(int k=11;k>=0;k--) {
				if(map[k][j]!='.') {
					q.add(map[k][j]);
					map[k][j]='.';
				} 
			}
			int k=11;
			while(!q.isEmpty()) {
				map[k][j]=q.poll();
				k--;
			}
		}
		
	}

}
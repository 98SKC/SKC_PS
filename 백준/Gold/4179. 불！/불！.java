import java.io.*;
import java.util.*;

public class Main{

	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int R=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		
		char[][] map=new char[R][C];
		boolean[][] v1=new boolean[R][C];
		boolean[][] v2=new boolean[R][C];
		
		String str;
		ArrayDeque<int[]> p=new ArrayDeque<>();
		ArrayDeque<int[]> f=new ArrayDeque<>(); 
		for(int r=0;r<R;r++) {
			str=br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c]=str.charAt(c);
				if(map[r][c]=='J') {
					p.add(new int[] {r,c});
					v1[r][c]=true;
				}else if(map[r][c]=='F') {
					f.add(new int[] {r,c});
					v2[r][c]=true;
				}
			}
		}
		int[] pos;
		int size;
		int[] di=new int[] {0,1,0,-1};
		int[] dj=new int[] {1,0,-1,0};
		int ni,nj;
		boolean find=false;
		int turn=0;
		while(!p.isEmpty()) {
			turn++;
			size=p.size();
			//사람먼저 옮기기
			for(int s=0;s<size;s++) {
				pos=p.poll();
				if(v2[pos[0]][pos[1]]) continue;// 불난 곳이면 탈출
				
				
				for(int a=0;a<4;a++) {
					ni=pos[0]+di[a];
					nj=pos[1]+dj[a];
					if(ni>=0&&ni<R&&nj>=0&&nj<C){//격자 내부면
						if(!v1[ni][nj]&&!v2[ni][nj]&&map[ni][nj]!='#') {//사람도 방문 안했고, 불도 안남
							p.add(new int[] {ni,nj});
							v1[ni][nj]=true;
						}
					}else{//탈출
						find=true;
						break;
					}
				}
				
				
				
			}
			if(find) break;
			size=f.size();
			for(int s=0;s<size;s++) {
				pos=f.poll();
				for(int a=0;a<4;a++) {
					ni=pos[0]+di[a];
					nj=pos[1]+dj[a];
					if(ni>=0&&ni<R&&nj>=0&&nj<C&&!v2[ni][nj]&&map[ni][nj]!='#'){//격자 내부면
						f.add(new int[] {ni,nj});
						v2[ni][nj]=true;
					}
				}
			}

		}
//		System.out.println("사람");
//		for(boolean[] n:v1) {
//			System.out.println(Arrays.toString(n));
//		}
//		System.out.println("불");
//		for(boolean[] n:v2) {
//			System.out.println(Arrays.toString(n));
//		}
		
		if(find) {
			System.out.println(turn);			
		}else {
			System.out.println("IMPOSSIBLE");
		}
		
		
		
		
	}
	
	

}
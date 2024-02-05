import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	static int[] row=new int[] {-1,0,1,0};//좌 하 우 상
	static int[] col=new int[] {0,1,0,-1};
	static boolean[][] visit;
	static int N;
	static int sum;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		ArrayList<Integer> arr=new ArrayList<>();
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		int count=0;
		//StringTokenizer st;
	
		
		//지도 만들기.
		for(int i=0;i<N;i++) {
			//st=new StringTokenizer(br.readLine());
			String str=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j)-'0';
				
			}
	
		}
		

		
		visit=new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1&&!visit[i][j]) {// 집이 있고, 방문 안함.
					count++;
					sum=0;
					helper(i,j);
					arr.add(sum);		
				}
			}
		}
		Collections.sort(arr);
		sb.append(count).append("\n");
		for(int i=0;i<arr.size();i++) {
			sb.append(arr.get(i)).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void helper(int i,int j) {
		visit[i][j]=true;

		sum+=1;
		int di=i;
		int dj=j;
		for(int k=0;k<4;k++) {
			int ni=di+row[k];
			int nj=dj+col[k];
			if(ni>=0&&ni<N&&nj>=0&&nj<N&&!visit[ni][nj]&&map[ni][nj]==1) {// 배열 안쪽이고, 지금 잠긴 높이보다 높아야함.
			//	System.out.print("탐색위치: "+ni+","+nj);
				//System.out.println("map["+ni+"]["+nj+"]: "+map[ni][nj]);
				helper(ni,nj);
			}
		}
		return;
	}

}
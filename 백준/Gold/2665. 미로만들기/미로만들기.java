import java.io.*;
import java.util.*;

public class Main{

	
	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0};
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		String str;
		int[][] map=new int[N][N];
		int[][] dijk=new int[N][N];
	
		int max=N*N+1;
		for(int i=0;i<N;i++) {
			str=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j)-'0';
				map[i][j]=map[i][j]*(-1)+1;
				dijk[i][j]=max;
			}
		}
		PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1,int[] o2) {
				return o1[2]-o2[2];
			}
		});
		pq.add(new int[] {0,0,map[0][0]});//시작부터 검정방이면 1번서야지
		dijk[0][0]=map[0][0];
		int[] sub;
		int ni,nj;
		while(!pq.isEmpty()){
			sub=pq.poll();
			
			
			for(int a=0;a<4;a++) {
				ni=sub[0]+di[a];
				nj=sub[1]+dj[a];
				if(ni>=0&&ni<N&&nj>=0&&nj<N&&dijk[ni][nj]>sub[2]+map[ni][nj]) {
					dijk[ni][nj]=sub[2]+map[ni][nj];
					pq.add(new int[] {ni,nj,dijk[ni][nj]});
				}
			}
		}
//		for(int[] m:dijk) {
//			System.out.println(Arrays.toString(m));
//		}
		if(dijk[N-1][N-1]==max) dijk[N-1][N-1]=0;
		System.out.println(dijk[N-1][N-1]);
	}
	
	
}

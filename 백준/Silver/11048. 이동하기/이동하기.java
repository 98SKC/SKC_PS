import java.io.*;
import java.util.*;
// 누적합 확실.
public class Main {
	
	static int[] bi= {0,-1,-1}; 
	static int[] bj= {-1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int ni;
		int nj;
		int max;
		int map[][]=new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				max=0;
				for(int a=0;a<3;a++) {
				if(i+bi[a]>=0&&i+bi[a]<N&&j+bj[a]>=0&&j+bj[a]<M) {
					//System.out.printf("원위치%d %d   %d가 i, %d가 j, 이곳의 sum은 %d  \n",i,j,i+bi[a],j+bj[a],map[i+bi[a]][j+bj[a]]);
					max=Math.max(map[i+bi[a]][j+bj[a]], max);
					//System.out.println(max);
				}
				
			}
				map[i][j]=map[i][j]+max;
		}
	}
		System.out.println(map[N-1][M-1]);
	}
}
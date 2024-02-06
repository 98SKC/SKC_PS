import java.io.*;
import java.util.*;


public class Main {

	static int[][] arr;
	static int N,M,C;
	static int[] di=new int[] {1,0,-1,0};
	static int[] dj=new int[] {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb=new StringBuilder();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int h=N/2;
		for(int count=0;count<C;count++) {
			for(int i=0;i<h;i++) {
				rotationArr(i);
			}
		}
		
		for(int[] a:arr) {
			for(int b:a) {
				sb.append(b).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
		
		
	}
	static void rotationArr(int i) {

		int sub;
		
		int ni=i;
		int nj=i;
		int subI;
		int subJ;
		for(int k=0;k<4;k++) {		
			while(ni+di[k]>=i&&ni+di[k]<N-i&&nj+dj[k]>=i&&nj+dj[k]<M-i){
				//이동할 칸의 정보를 sub에 저장
				//sub, 현위치, 원점. 
				sub=arr[ni+di[k]][nj+dj[k]];
				arr[ni+di[k]][nj+dj[k]]=arr[i][i];
				arr[i][i]=sub;
				ni+=di[k];
				nj+=dj[k];				
			}
			
		}
	}

	

}
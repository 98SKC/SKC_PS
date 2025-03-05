import java.io.*;
import java.util.*;

public class Main {

	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		int[] arr=new int[N];
		int[][] nge=new int[N][2];
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		nge[N-1][0]=-1;
		nge[N-1][1]=Integer.MAX_VALUE;
		int point;
		for(int i=N-2;i>=0;i--) {
			//a b c  배열에서 a가 b보다 작으면 오큰수는 b, a가 b의 오큰수보다 작으면 a의 오큰수는 b의 오큰수
			point=i+1;
			while(point<N){

				if(arr[i]<arr[point]){
					nge[i][0]=arr[point];
					nge[i][1]=point;

					break;
				}else if (arr[i]<nge[point][0]){
					nge[i][0]=nge[point][0];
					nge[i][1]=nge[point][1];

					break;
				}
				
				point=nge[point][1];
			}

			
			if(point>=N) {
				nge[i][0]=-1;
				nge[i][1]=Integer.MAX_VALUE;
			}  
		}
		
		for(int i=0;i<N;i++) {
			//a b c  배열에서 a가 b보다 작으면 오큰수는 b, a가 b의 오큰수보다 작으면 a의 오큰수는 b의 오큰수
			sb.append(nge[i][0]+" ");
		}
		System.out.println(sb);
	}
	
	
}
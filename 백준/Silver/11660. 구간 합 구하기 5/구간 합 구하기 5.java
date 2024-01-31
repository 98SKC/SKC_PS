import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int answer;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());// 테스트케이스 느낌.
		int[][] arr = new int[N+1][N+1];
		int[][] sumArr=new int[N+1][N+1];
		StringBuilder sb = new StringBuilder();
		int sum;
	
		for(int i=1;i<=N;i++) {// 배열 입력
			st = new StringTokenizer(br.readLine());
			sum=0;
			for(int j=1;j<=N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				sumArr[i][j]=sumArr[i][j-1]+arr[i][j];
			}
		}
//		for(int[] a:sumArr) {
//			System.out.println(Arrays.toString(a));
//		}
		for(int i=0;i<M;i++) {
			answer=0;
			st = new StringTokenizer(br.readLine());
			int y1=Integer.parseInt(st.nextToken());//1
			int x1=Integer.parseInt(st.nextToken());//2
			int y2=Integer.parseInt(st.nextToken());//1
			int x2=Integer.parseInt(st.nextToken());//2
			
			for(int j=y1;j<=y2;j++) {
				answer+=sumArr[j][x2]-sumArr[j][x1-1];
//				System.out.print("sumArr["+j+"]["+x2+"]:"+sumArr[j][x2]);
//				System.out.println("sumArr["+j+"]["+(x1-1)+"]:"+sumArr[j][x1-1]);
//				System.out.println("===========================================");
			}
			sb.append(answer).append("\n");
		
		}
		
		
		
		System.out.println(sb);
	}

}
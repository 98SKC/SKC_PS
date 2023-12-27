
import java.util.*;
import java.io.*;
import java.math.MathContext;


class Solution{
	public static int[][] room;
	public static void main(String args[]) throws Exception{

	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String sub;
		int T=Integer.parseInt(br.readLine());


		for(int test_case = 1; test_case <= T; test_case++){
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt (st.nextToken());// 맵의 크기
			int M=Integer.parseInt (st.nextToken());// 스프레이 범위
			room=new int[N][N];
			
			for(int i=0;i<N;i++) {
				StringTokenizer st2=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					room[i][j]=Integer.parseInt(st2.nextToken());
				}
			}// 파리 위치 생성
			
			System.out.println("#"+test_case+" "+search(N,M));
			

			}
	}
	public static int search(int N, int M) {
	    int max = 0;

	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            int plus = room[i][j]; // 중심 칸
	            int cross = room[i][j]; // 중심 칸

	            for (int k = 1; k < M; k++) {
	                // "+ 모양" 계산
	                if (i - k >= 0) plus += room[i - k][j];
	                if (i + k < N) plus += room[i + k][j];
	                if (j - k >= 0) plus += room[i][j - k];
	                if (j + k < N) plus += room[i][j + k];

	                // "x 모양" 계산
	                if (i - k >= 0 && j - k >= 0) cross += room[i - k][j - k];
	                if (i - k >= 0 && j + k < N) cross += room[i - k][j + k];
	                if (i + k < N && j - k >= 0) cross += room[i + k][j - k];
	                if (i + k < N && j + k < N) cross += room[i + k][j + k];
	            }

	            max = Math.max(max, Math.max(plus, cross));
	        }
	    }
	    return max;
	}

}
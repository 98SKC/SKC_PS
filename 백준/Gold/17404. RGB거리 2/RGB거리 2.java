
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
 
		int N = Integer.parseInt(br.readLine());
 
		int[][] cost = new int[N][3];
		int[][][] answer= new int[N][3][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
 
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
 
		}
		// 빨 파 초
		// 빨 파 빨
		// 1부터 N-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더한다.  
		// 처음을 빨강으로 고정, 
		int INF = 100000000;
		answer[0][0][0]=cost[0][0];// 시작이 빨강인경우
		answer[0][0][1]=cost[0][1];// 시작이 초록인경우
		answer[0][0][2]=cost[0][2];// 시작이 파랑인경우

		int min=INF;
		
		for(int j=0;j<3;j++){//시작을 j로 고정시켰을 때
		    for (int c = 0; c < 3; c++) {
		        if (c == j)
		            answer[0][c][j] = cost[0][c];
		        else
		            answer[0][c][j] = INF;
		    }
			for (int i = 1; i < N; i++) {
				answer[i][0][j]=cost[i][0]+Math.min(answer[i - 1][1][j], answer[i - 1][2][j]);// 지금 위치가 빨강일 때 누적합이 작은 쪽.
				answer[i][1][j]=cost[i][1]+Math.min(answer[i - 1][0][j], answer[i - 1][2][j]);//지금 위치가 초록일때
				answer[i][2][j]=cost[i][2]+Math.min(answer[i - 1][0][j], answer[i - 1][1][j]);//지금위치가 파랑일때	
			}
			
			if(j==0) {
				min=Math.min(Math.min(answer[N - 1][1][j], answer[N - 1][2][j]), min);//마지막이 0인 경우는 제외
			} else if(j==1) {
				min=Math.min(Math.min(answer[N - 1][0][j], answer[N - 1][2][j]), min);
			}else {
				min=Math.min(Math.min(answer[N - 1][0][j], answer[N - 1][1][j]), min);
			}
			
		}

		
		// cost[N - 1][0]가 빨강이면서 cost[0][0]
		System.out.println(min);
        
    }
}

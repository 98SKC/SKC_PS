import java.io.*;
import java.util.*;
 
public class Main {
 
	public static void main(String[] args) throws Exception {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
 
		int N = Integer.parseInt(br.readLine());
 
		int[][] cost = new int[N][3];
 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
 
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
 
		}
 
		// 1부터 N-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더한다.  
		for (int i = 1; i < N; i++) {
			cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);// 지금 위치가 빨강일 때 누적합이 작은 쪽.
			cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);//지금 위치가 초록일때
			cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]);//지금위치가 파랑일때
		}
 
		System.out.println(Math.min(Math.min(cost[N - 1][0], cost[N - 1][1]), cost[N - 1][2]));
	}
 
}
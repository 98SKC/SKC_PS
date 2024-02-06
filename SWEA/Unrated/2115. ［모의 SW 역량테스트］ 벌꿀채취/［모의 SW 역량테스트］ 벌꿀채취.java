
import java.io.*;
import java.util.*;

public class Solution{

	static int N, M, C;
	static int[][] map;
	static boolean[][] visited;
	static int maxNum = 0;
	static int[] sum;//부분집합의 최대값을 저장할 누적합 배열

	public static void main(String[] args) throws Exception {
	//	System.setIn(new FileInputStream("res/sample_input (2).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			sum=new int[N*N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + tc + " " + combination());
		}
	}

	private static void getMaxHoney(int i, int j, int cnt, int sum, int benefit) {
		// 채취한 꿀이 최대 채취 양을 넘었으면 그냥 return
		if (sum > C)
			return;

		// 벌통 M개 선택했으면
		if (cnt == M) {
			// 최대 이익 갱신
			if (maxNum < benefit)
				maxNum = benefit;
			return;
		}

		// 선택
		getMaxHoney(i, j + 1, cnt + 1, sum + map[i][j], benefit + map[i][j] * map[i][j]);
		// 비선택
		getMaxHoney(i, j + 1, cnt + 1, sum, benefit);

	}
	private static void makeSum() {
		for(int i=0;i<N;i++) {
			for(int j = 0; j <= N - M; j++) {
				getMaxHoney(i, j, 0, 0, 0);
				sum[i*N+j]=maxNum;
				maxNum =0;
			}
		}
	}
	private static int combination() {
		makeSum();
		int result = 0;
		int max1 = 0;
		int max2 = 0;
		for (int i = 0; i < N; i++) { // 첫 행부터 살펴본다.
			for (int j = 0; j <= N - M; j++) { // 첫 열부터 벌통 선택할 수 있는 열(N-M)까지

				max1 = sum[i*N+j];
				max2 = 0; // 일꾼1의 선택이 바뀌었으므로, 일꾼2의 이익도 0으로 초기화
				
				// 일꾼2는 일꾼1이 선택한 벌통 다음 열에서 벌통을 다시 선택한다.
				for (int j2 = j + M; j2 <= N - M; j2++) {
					// 현재 좌표 (i, j2), 선택한 벌통 수, 꿀의 양, 이익
					max2 = Math.max(max2,sum[i*N+j2]); // 이익 최댓값으로 갱신
				}

				// 일꾼2는 다른 행에서 벌통을 선택하는게 더 클 수도 있다.
				// 일꾼1의 다음 행부터 살펴본다.
				for (int i2 = i + 1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N - M; j2++) { // 첫 열부터 벌통 선택할 수 있는 열(N-M)까지
						max2 =Math.max(max2,sum[i2*N+j2]); // 최댓값 갱신
					}
				}
				// 일꾼1이 벌통을 새로 선택했을 때마다 전체 이익 최댓값으로 갱신
				result = Math.max(result, max1 + max2);
			}
		}
		return result;
	}
}
import java.io.*;
import java.util.*;

public class Solution {

	static int N, M, C;
	static int[][] map;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + tc + " " + combination());
		}
	}

	private static int combination() {
		int result = 0;
		int max1 = 0;
		int max2 = 0;
		for (int i = 0; i < N; i++) { // 첫 행
			for (int j = 0; j <= N - M; j++) { // 첫 줄부터 (N-M)까지
				// 일꾼1 선택 시작
				// 일꾼1이 다시 선택하므로 이익 초기화
				max = 0;
				getHoneyMax(i, j, 0, 0, 0);// x좌표, y좌표, 벌통의 개수, 채취한 꿀의 양, 얻은 이익
				max1 = max; // j열에서 벌통을 선택했을 때, 일꾼1의 최대 이익

				// 일꾼2 선택 시작
				max = 0; // 일꾼2가 벌통을 선택, 이익 0으로 초기화
				max2 = 0; // 일꾼1의 선택이 바뀌었으므로, 일꾼2의 이익도 0으로 초기화
				// 일꾼2는 일꾼1이 선택한 벌통 다음 열에서 벌통을 다시 선택.
				for (int j2 = j + M; j2 <= N - M; j2++) {
					getHoneyMax(i, j2, 0, 0, 0);// 현재 좌표 (i, j2), 선택한 벌통 수, 꿀의 양, 이익
					max2 = Math.max(max2, max); // 이익 최댓값으로 갱신
				}

				// 일꾼1의 다음 행부터 부분.
				for (int i2 = i + 1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N - M; j2++) { // 첫 줄부터 (N-M)까지
						getHoneyMax(i2, j2, 0, 0, 0);
						max2 = Math.max(max2, max); // 이익 최댓값으로 갱신
					}
				}
				// 일꾼1이 벌통을 새로 선택했을 때마다 전체 이익 최댓값으로 갱신
				result = Math.max(result, max1 + max2);
			}
		}
		return result;
	}

	//부분집합의 최대 이익
	private static void getHoneyMax(int i, int j, int count, int sum, int maxPrice) {
		// 채취한 꿀이 최대 채취 양을 넘었으면 그냥 return
		if (sum > C)
			return;

		// 벌통 M개 선택했으면 
		if (count == M) {
			// 최대 이익 갱신
			if (max < maxPrice)
				max = maxPrice;
			return;
		}
		// 선택
		getHoneyMax(i, j + 1, count + 1, sum + map[i][j], maxPrice + map[i][j] * map[i][j]);
		// 비선택
		getHoneyMax(i, j + 1, count + 1, sum, maxPrice);

	}
}
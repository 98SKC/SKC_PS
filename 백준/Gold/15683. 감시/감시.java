import java.util.*;
import java.io.*;

public class Main {
	public static int N, M; // N과 M은 각각 행과 열의 크기.
	public static int[][] map; // 각 칸의 상태를 나타내는 2차원 배열 (CCTV, 벽, 빈 공간).
	public static int[][] sub; // 각 상태를 복사할 2차원 배열.
	public static int[] output; // 각 CCTV의 방향을 저장할 배열.

	public static ArrayList<CCTV> cctv; // CCTV 목록을 저장할 ArrayList.
	public static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌 시계방향 순서 
	public static int[] dy = {0, 1, 0, -1};

	public static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new ArrayList<>(); 

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 

				// CCTV가 있는 경우 CCTV 목록에 추가.
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv.add(new CCTV(map[i][j], i, j));
				}
			}
		}

		output = new int[cctv.size()]; // 각 CCTV의 방향을 저장할 배열.
		permutation(0, cctv.size()); // 모든 가능한 CCTV 방향의 조합을 찾는다.

		System.out.println(answer); 
	}

	// 가능한 모든 CCTV 방향 조합을 찾는 메서드.
	public static void permutation(int depth, int r) {
		if (depth == r) {
			sub = new int[N][M]; // 현재 지도 상태를 복사.
			for (int i = 0; i < map.length; i++) {
				System.arraycopy(map[i], 0, sub[i], 0, map[i].length);
			}

			// 각 CCTV에 대해 설정된 방향으로 감시.
			for (int i = 0; i < cctv.size(); i++) {
				direction(cctv.get(i), output[i]);
			}

			// 사각 지대의 크기를 계산.
			getBlindSpot();

			return;
		}

		// 모든 방향에 대해 반복하며 다음 CCTV의 방향을 설정.
		for (int i = 0; i < 4; i++) {
			output[depth] = i;
			permutation(depth + 1, r);
		}
	}

	// 각 CCTV의 방향에 따라 감시 영역을 설정하는 메서드.
	public static void direction(CCTV cctv, int d) {
		int cctvNum = cctv.num;

		if(cctvNum == 1) {
			if(d == 0) watch(cctv, 0); // 상 
			else if(d == 1) watch(cctv, 1); // 우 
			else if(d == 2) watch(cctv, 2); // 하  
			else if(d == 3) watch(cctv, 3); // 좌 
		} else if(cctvNum == 2) {
			if(d == 0 || d == 2) {
				watch(cctv, 0); watch(cctv, 2); // 상하 
			} else {
				watch(cctv, 1); watch(cctv, 3); // 좌우 
			}
		} else if(cctvNum == 3) {
			if(d == 0) {
				watch(cctv, 0); // 상우 
				watch(cctv, 1);
			} else if(d == 1) { 
				watch(cctv, 1); // 우하 
				watch(cctv, 2);
			} else if(d == 2) { 
				watch(cctv, 2); // 하좌 
				watch(cctv, 3);
			} else if(d == 3) { 
				watch(cctv, 0); // 좌상 
				watch(cctv, 3);
			}
		} else if(cctvNum == 4) {
			if(d == 0) {
				watch(cctv, 0); // 좌상우 
				watch(cctv, 1);
				watch(cctv, 3);
			} else if(d == 1) {
				watch(cctv, 0); // 상우하 
				watch(cctv, 1);
				watch(cctv, 2);
			} else if(d == 2) {
				watch(cctv, 1); // 좌하우 
				watch(cctv, 2);
				watch(cctv, 3);
			} else if(d == 3) {
				watch(cctv, 0); // 상좌하 
				watch(cctv, 2);
				watch(cctv, 3);
			}
		} else if(cctvNum == 5) { // 상우하좌
			watch(cctv, 0);
			watch(cctv, 1);
			watch(cctv, 2);
			watch(cctv, 3);
		}
	}

	// CCTV가 특정 방향으로 감시할 때 사용하는 메서드.
	public static void watch(CCTV cctv, int d) {
		Queue<CCTV> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M]; // 방문 확인을 위한 배열

		queue.add(cctv);
		visited[cctv.x][cctv.y] = true;

		while (!queue.isEmpty()) {
			int nx = queue.peek().x + dx[d];
			int ny = queue.poll().y + dy[d];

			// 지도 범위를 벗어나거나 벽(6)을 만날 경우 중지
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || sub[nx][ny] == 6) {
				break;
			}

			// 빈 공간(0)이면 감시 영역으로 설정(-1)
			if (sub[nx][ny] == 0) {
				sub[nx][ny] = -1;
				queue.add(new CCTV(cctv.num, nx, ny));
			} else {
				// 다른 CCTV가 있거나 이미 감시된 공간일 경우, 그냥 통과
				queue.add(new CCTV(cctv.num, nx, ny));
			}
		}
	}

	// 사각 지대의 크기를 계산하는 메서드
	public static void getBlindSpot() {
		int cnt = 0; // 사각 지대 카운트
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (sub[i][j] == 0) { // 감시되지 않은 빈 공간을 찾음
					cnt++;
				}
			}
		}
		answer = Math.min(answer, cnt); // 최소 사각 지대 크기를 업데이트
	}
}

//CCTV 클래스 정의
class CCTV {
	int num; // CCTV 번호
	int x, y; // CCTV의 위치 (x, y)

	CCTV(int num, int x, int y) {
		this.num = num; // CCTV 번호
		this.x = x; // x 좌표
		this.y = y; // y 좌표
	}
}
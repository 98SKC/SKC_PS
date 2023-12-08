
import java.io.*;
import java.util.*;


public class Main {
	
	// 공기청정기 위치 좌표.
	private static class machine {
		int row; 	// 행
		int col;	// 열

		public machine(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	private static class Dust {
		int row;		// 행
		int col;		// 열
		int dust;	// 먼지

		public Dust(int row, int col, int dust) {
			this.row = row;
			this.col = col;
			this.dust = dust;
		}
	}
	
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static int R, C, T;		// 집의 행,열, 시간
	private static int[][] room;	// 방의 맵.
	private static machine upAirCleaners;
	private static machine downAirCleaners;
	private static Queue<Dust> dusts = new LinkedList<>();	// 먼지 좌표 저장 큐
	private static int[] moveRow = {1, 0, -1, 0};		// 좌표계산에 사용할 배열
	private static int[] moveCol = {0, 1, 0, -1};		// 좌표계산에 사용할 배열

	public static void main(String[] args) throws IOException {
		int check=0;
		String[] info = reader.readLine().split(" ");
		R = Integer.parseInt(info[0]);
		C = Integer.parseInt(info[1]);
		T = Integer.parseInt(info[2]);
		room = new int[R][C];

		for (int i = 0; i < R; i++) {
			String[] rowInfo = reader.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(rowInfo[j]);
				// 공기청정기 좌표 저장
				if (room[i][j] == -1) {
					if(check!=1) {

						downAirCleaners=new machine(i,j);
						check=1;
					}else {

						upAirCleaners=new machine(i,j);
					}
					
				}
			}
		}

		
		int time=0;

		while (time < T) {
			// 집안의 먼지들 큐에 저장
			offerDust();
			// 먼지들 확산
			diffuseDust();
			// 공기청정기 반시계방향 동작
			operateAirCleaner("up");
			// 공기청정기 시계방향 동작
			operateAirCleaner("down");
			
			time++;
		}

		// 0초가 되면 집안의 남아있는 먼지량 모두 더해서 출력
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result += room[i][j] == -1 ? 0 : room[i][j];
			}
		}
		System.out.println(result);
	}

	/**
	 * 먼지 큐에 추가
	 */
	//초기에 나는 먼지의 확산이 처음의 먼지량에 따라 달라져서 before after로 객체를 만들었는데, 큐에 다 넣어서 처음의 양을 유지하는 듯 하다.
	// 이 방법이면  map에 큐의 먼지량의 확산값을 확산한 곳에 넣고, 빠진 만큼 빼면 됨.
	private static void offerDust() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] > 0) {
					dusts.offer(new Dust(i, j, room[i][j]));
				}
			}
		}
	}

	/**
	 * 먼지 확산
	 */
	private static void diffuseDust() {
		// 큐가 빌 때까지 반복
		while (!dusts.isEmpty()) {
			// 큐에 있는 먼지 꺼내기
			Dust dust = dusts.poll();
			// 먼지가 확산된 양을 저장할 변수
			int sum = 0;
			// 상하좌우 좌표 계산
			for (int i = 0; i < 4; i++) {// 이게 먼지 추가할 좌표.
				int nr = dust.row + moveRow[i];
				int nc = dust.col + moveCol[i];
				// 집을 벗어나거나 공기청정기가 다음 좌표면 확산 안함
				if (nr >= R || nr < 0 || nc >= C || nc < 0 || room[nr][nc] == -1) {
					continue;
				}
				// 계산된 좌표로 먼지 확산 5분의 1만큼
				room[nr][nc] += dust.dust / 5;
				// 확산된 먼지 양만큼 합산
				sum += dust.dust / 5;
				
			}
			// 한개의 먼지가 확산이 끝나면 확산된 양만큼 감소
			room[dust.row][dust.col] -= sum;
		}
	}

	private static void operateAirCleaner(String wind) {
		//위로 순환은 반시계, 아래로 순환이면 시계
		machine airCleaner;
		if(wind.equals("up")) {
			airCleaner = upAirCleaners;
		}else {
			airCleaner = downAirCleaners;
		}
		// 공기청정기가 동작하는 첫 좌표 계산을 위한 삼항연산자
		int mr = wind.equals("up") ? 1 : -1;
		// 현재 좌표
		int cr = airCleaner.row + mr;
		int cc = airCleaner.col;
		// 처음 좌표 먼지 없애기
		room[cr][cc] = 0;
		// 공기청정기 기준으로 2개의 방향으로 먼지를 흡입하므로 범위 지정
		int rowMaxRange = wind.equals("up") ? R : airCleaner.row + 1;
		int rowMinRange = wind.equals("up") ? airCleaner.row : 0;

		// 바람이 순회하는 방향의 역으로 좌표계산하면서 먼지흡입
		for (int i = 0; i < 4; i++) {
			while (true) {
				// 다음 좌표 계산
				int nr = cr + (moveRow[i] * mr);
				int nc = cc + moveCol[i];
				// 주어진 범위르 벗어나면 먼지 흡입 방향 변경
				if (nr >= rowMaxRange || nr < rowMinRange || nc >= C || nc < 0) {
					break;
				}
				// 순회하다가 다시 공기청정기로 되돌아오면 먼지가 이동했으므로 0값으로 변경
				room[cr][cc] = room[nr][nc] == -1 ? 0 : room[nr][nc];
				// 이동한 좌표의 값을 현재 좌표값으로 변경
				cr = nr;
				cc = nc;
			}
		}
	}


}

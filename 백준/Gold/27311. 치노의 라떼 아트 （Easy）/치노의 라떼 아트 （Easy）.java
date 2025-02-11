import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			char[][] map = new char[R][C];

			int totalCream = 0, bigSquare = 0, SmallSquare = 0;
			int minX = R, minY = C, maxX = -1, maxY = -1;

			for (int i = 0; i < R; i++) {
				String row = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = row.charAt(j);
					if (map[i][j] == '#') {
						totalCream++;
						//#의 위치로 N 사각형의 크기를 구한다.
						minX = Math.min(minX, i);
						minY = Math.min(minY, j);
						maxX = Math.max(maxX, i);
						maxY = Math.max(maxY, j);
					}
				}
			}
			//크림이 없으면 꽝
			if (totalCream == 0) {
				sb.append("0\n");
				continue;
			}
			
			//M 사각형 크기
			bigSquare = maxX - minX + 1;
			if (maxY - minY + 1 != bigSquare) {//가로 세로가 다르면 정사각형이 아니므로 패스
				sb.append("0\n");
				continue;
			}

			int emptyCount = 0;
			int emptyMinX = R, emptyMinY = C, emptyMaxX = -1, emptyMaxY = -1;
			for (int i = minX; i <= maxX; i++) {// 빈공간은 큰 사각형 내부에서만 찾는다.
				for (int j = minY; j <= maxY; j++) {
					if (map[i][j] == '.') {
						emptyCount++;
						emptyMinX = Math.min(emptyMinX, i);
						emptyMinY = Math.min(emptyMinY, j);
						emptyMaxX = Math.max(emptyMaxX, i);
						emptyMaxY = Math.max(emptyMaxY, j);
					}
				}
			}
			//빈공간이 없어도 꽝
			if (emptyCount == 0) {
				sb.append("0\n");
				continue;
			}

			if (!((emptyMinX == minX && emptyMinY == minY) || (emptyMinX == minX && emptyMaxY == maxY) || 
					(emptyMaxX == maxX && emptyMinY == minY) || (emptyMaxX == maxX && emptyMaxY == maxY))) {
				sb.append("0\n");
				continue;
			}

			SmallSquare = emptyMaxX - emptyMinX + 1;
			if (emptyMaxY - emptyMinY + 1 != SmallSquare) {
				sb.append("0\n");
				continue;
			}
			//크림이 퍼져있는가 아닌가는 크림 개수와 넓이로 판별
			if (totalCream != bigSquare * bigSquare - SmallSquare * SmallSquare) {
				sb.append("0\n");
				continue;
			}

			sb.append("1\n");
		}

		System.out.print(sb);
	}
}
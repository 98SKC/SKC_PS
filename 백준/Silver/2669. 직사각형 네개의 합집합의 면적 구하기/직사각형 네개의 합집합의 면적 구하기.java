import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		
        boolean[][] matrix = new boolean[100][100];
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());

			for (int j = sx; j < ex; j++) {
				for (int k = sy; k < ey; k++) {
					matrix[j][k] = true;
				}
			}
		}

		int result = 0;
        
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (matrix[i][j]) {
					result++;
				}
			}
		}

		System.out.println(result);
	}
}
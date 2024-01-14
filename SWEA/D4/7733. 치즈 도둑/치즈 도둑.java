import java.util.*;
import java.io.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    static int[] row = new int[]{-1, 1, 0, 0};
    static int[] col = new int[]{0, 0, 1, -1};
    static int N;
    static int[][] cheese;
    static boolean[][] visit;
    static int parts;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int maxPart, answer;
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            cheese = new int[N][N];
            visit = new boolean[N][N];
            maxPart = 0;
            answer = 1;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int sub = Integer.parseInt(st.nextToken());
                    maxPart = Math.max(maxPart, sub);
                    cheese[i][j] = sub;
                }
            }
            for (int day = 1; day <= maxPart; day++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (cheese[j][k] == day) {
                            cheese[j][k] = 0;
                        }
                    }
                }
                parts = 0;
                for (boolean[] row : visit) {
                    Arrays.fill(row, false);
                }
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (!visit[j][k] && cheese[j][k] != 0) {
                            searchHelper(j, k);
                            parts++;
                        }
                    }
                }
                answer = Math.max(parts, answer);
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    public static void searchHelper(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + row[i];
            int ny = y + col[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] && cheese[nx][ny] != 0) {
                searchHelper(nx, ny);
            }
        }
    }
}

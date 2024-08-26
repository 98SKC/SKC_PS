import java.io.*;

public class Main {

    static int N, M;
    static char[][] ground;
    static boolean[][] isVisited;
    static int ans;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = br.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);

            ground = new char[N + 1][M + 1];
            isVisited = new boolean[N + 1][M + 1];

            for (int i = 1; i <= N; i++) {
                char[] line = br.readLine().toCharArray();
                for (int j = 1; j <= M; j++) {
                    ground[i][j] = line[j - 1];
                }
            }

            for (int x = 1; x <= N; x++) {
                for (int y = 1; y <= M; y++) {
                    if (!isVisited[x][y])
                        dfs(x, y);
                }
            }

            System.out.println(ans);
        }
    }

    private static void dfs(int x, int y) {
        isVisited[x][y] = true;

        if (ground[x][y] == '-') {
            if (y == M) {
                ans++;
                return;
            }

            int nextY = y + 1;

            if (!isVisited[x][nextY] && ground[x][nextY] == '-')
                dfs(x, nextY);
            else {
                ans++;
                return;
            }
        }

        if (ground[x][y] == '|') {
            if (x == N) {
                ans++;
                return;
            }

            int nextX = x + 1;

            if (ground[nextX][y] == '|' && !isVisited[nextX][y])
                dfs(nextX, y);
            else {
                ans++;
                return;
            }
        }
    }
}
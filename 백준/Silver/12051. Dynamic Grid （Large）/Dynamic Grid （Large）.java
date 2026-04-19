import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void bfs(int sr, int sc) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        v[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (v[nr][nc]) continue;
                if (map[nr][nc] != '1') continue;

                v[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }

    static int countRegions() {
        v = new boolean[R][C];
        int cnt = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '1' && !v[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new char[R][C];
            for (int i = 0; i < R; i++) {
                String s = br.readLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            int N = Integer.parseInt(br.readLine());
            sb.append("Case #").append(tc).append(":\n");

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);

                if (op == 'M') {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    char z = st.nextToken().charAt(0);
                    map[x][y] = z;
                } else {
                    sb.append(countRegions()).append('\n');
                }
            }
        }

        System.out.print(sb);
    }
}
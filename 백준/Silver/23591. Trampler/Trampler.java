import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            String moves = br.readLine();
            int M = moves.length();

            int[] dr = new int[M + 1];
            int[] dc = new int[M + 1];

            for (int i = 0; i < M; i++) {
                dr[i + 1] = dr[i];
                dc[i + 1] = dc[i];

                char ch = moves.charAt(i);
                if (ch == 'U') dr[i + 1]--;
                else if (ch == 'D') dr[i + 1]++;
                else if (ch == 'L') dc[i + 1]--;
                else dc[i + 1]++;
            }

            int[][] map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            long[][] ans = new long[H][W];

            for (int r = 0; r < H; r++) {
                for (int c = 0; c < W; c++) {
                    long sum = 0;
                    boolean ok = true;

                    for (int k = 0; k <= M; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];

                        if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
                            ok = false;
                            break;
                        }

                        sum += map[nr][nc];
                    }

                    ans[r][c] = ok ? sum : 0;
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (j > 0) sb.append(' ');
                    sb.append(ans[i][j]);
                }
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }
}
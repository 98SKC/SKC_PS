
import java.io.*;
import java.util.*;

public class Main {

    public static int R, C;
    public static char[][] map;
    // 우, 아래, 좌, 위
    public static int[] di = {0, 1, 0, -1};
    public static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

        outer:
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (map[i][j] != '.') continue;

                boolean[] need = new boolean[4];
                boolean[] mz   = new boolean[4];
                int cnt = 0;

                for (int d = 0; d < 4; d++) {
                    int ni = i + di[d], nj = j + dj[d];
                    if (ni < 1 || ni > R || nj < 1 || nj > C) continue;
                    char nb = map[ni][nj];
                    int back = (d + 2) % 4;

                    if (nb == 'M' || nb == 'Z') {
                        mz[d] = true; 
                    } else if (opens(nb, back)) {
                        need[d] = true;
                        cnt++;
                    }
                }

                if (cnt == 0) continue;

     
                if (cnt == 1 || cnt == 3) {
                    for (int d = 0; d < 4; d++) {
                        if (mz[d]) { need[d] = true; cnt++; break; }
                    }
                }

                char piece = decide(need);
                if (piece == '?') continue;

                System.out.println(i + " " + j + " " + piece);
                break outer;
            }
        }
    }

    public static boolean opens(char c, int dir) {
        if (c == '+') return true;
        if (c == '-') return dir == 0 || dir == 2;
        if (c == '|') return dir == 1 || dir == 3;
        if (c == '1') return dir == 0 || dir == 1; // 우, 아래
        if (c == '2') return dir == 0 || dir == 3; // 우, 위
        if (c == '3') return dir == 2 || dir == 3; // 좌, 위
        if (c == '4') return dir == 1 || dir == 2; // 아래, 좌

        return false;
    }

    public static char decide(boolean[] need) {
        boolean r = need[0], d = need[1], l = need[2], u = need[3];

        if (r && d && l && u) return '+';
        if (r && l && !d && !u) return '-';
        if (!r && d && !l && u) return '|';
        if (r && d && !l && !u) return '1'; // 우, 아래
        if (r && !d && !l && u) return '2'; // 우, 위
        if (!r && !d && l && u) return '3'; // 좌, 위
        if (!r && d && l && !u) return '4'; // 좌, 아래
        return '?';
    }
}

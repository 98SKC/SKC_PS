import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[][] map;
    public static int[] di = new int[]{0, 1, 0, -1};
    public static int[] dj = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        String str;
        char c;
        int goal = 1;

        ArrayDeque<int[]> q = new ArrayDeque<>();

        // visited[i][j][score(0~3)][dir(0~4)]  (4는 "이전 방향 없음")
        boolean[][][][] visited = new boolean[N][M][4][5];

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                c = str.charAt(j);

                if (c == '#') {           // 벽
                    map[i][j] = 9;
                } else {                  // 길
                    map[i][j] = 0;
                }

                if (c == 'S') {           // 시작점
                    q.add(new int[]{i, j, 0, 4, 0}); // i, j, cost, prevDir(4), score(0)
                    visited[i][j][0][4] = true;
                }

                if (c == 'C') {           // 목적지 2개 (1,2로 라벨링)
                    map[i][j] = goal++;
                }
            }
        }

        int answer = -1;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int pi = p[0];
            int pj = p[1];
            int cost = p[2];
            int dir = p[3];
            int score = p[4];

            // 이미 두 C를 다 방문한 상태로 큐에 들어올 수도 있으니 체크
            if (score == 3) {
                answer = cost;
                break;
            }

            for (int a = 0; a < 4; a++) {
                if (a == dir) continue; // 같은 방향 연속 이동 금지

                int ni = pi + di[a];
                int nj = pj + dj[a];

                if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
                if (map[ni][nj] == 9) continue; // 벽

                int newScore = score;

                // C에 도착하면 방문 처리 (map값이 1 또는 2)
                if (map[ni][nj] == 1) newScore |= 1;
                else if (map[ni][nj] == 2) newScore |= 2;

                if (visited[ni][nj][newScore][a]) continue;
                visited[ni][nj][newScore][a] = true;

                q.add(new int[]{ni, nj, cost + 1, a, newScore});
            }
        }

        System.out.println(answer);
    }
}

//import java.io.*;
//import java.util.*;
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
//
//    }
//
//}
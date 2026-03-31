import java.io.*;
import java.util.*;

public class Main {

    // potal[i][j][d] : (i,j)에서 d방향으로 가장 가까운 포탈까지 거리
    public static int[][][] potal;
    public static char[][] map;
    // v[i][j][mode] : (i,j)에 mode(0=일반, 1=변신) 상태로 도착하는 최소 턴
    public static int[][][] v;

    public static int[] di = new int[]{0, 1, 0, -1};
    public static int[] dj = new int[]{1, 0, -1, 0};

    public static int N, T, R, C;

    public static final int INF = 1_000_000_000;
    public static final int INF_PORTAL = 501;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        potal = new int[N + 1][N + 1][4];
        map = new char[N + 1][N + 1];
        v = new int[N + 1][N + 1][2];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = str.charAt(j - 1);
                for (int d = 0; d < 4; d++) {
                    potal[i][j][d] = INF_PORTAL;
                }
                v[i][j][0] = INF;
                v[i][j][1] = INF;
            }
        }

        // 행 기준 전처리
        for (int i = 1; i <= N; i++) {
            int last = -1;

            // 왼쪽 포탈 찾기 (dir=2)
            for (int j = 1; j <= N; j++) {
                if (last != -1) {
                    potal[i][j][2] = j - last;
                }
                if (map[i][j] == '#') {
                    last = j;
                }
            }

            last = -1;
            // 오른쪽 포탈 찾기 (dir=0)
            for (int j = N; j >= 1; j--) {
                if (last != -1) {
                    potal[i][j][0] = last - j;
                }
                if (map[i][j] == '#') {
                    last = j;
                }
            }
        }

        // 열 기준 전처리
        for (int j = 1; j <= N; j++) {
            int last = -1;

            // 위쪽 포탈 찾기 (dir=3)
            for (int i = 1; i <= N; i++) {
                if (last != -1) {
                    potal[i][j][3] = i - last;
                }
                if (map[i][j] == '#') {
                    last = i;
                }
            }

            last = -1;
            // 아래쪽 포탈 찾기 (dir=1)
            for (int i = N; i >= 1; i--) {
                if (last != -1) {
                    potal[i][j][1] = last - i;
                }
                if (map[i][j] == '#') {
                    last = i;
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[3], o2[3]));

        // 시작점: 일반 모드
        v[1][1][0] = 0;
        pq.add(new int[]{1, 1, 0, 0}); // i, j, trans, turn

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int pi = p[0];
            int pj = p[1];
            int trans = p[2];
            int turn = p[3];

            // 오래된 상태 버리기
            if (v[pi][pj][trans] != turn) continue;

            for (int a = 0; a < 4; a++) {
                // 1칸 이동
                // 변신 -> 일반 복귀는 0턴이므로,
                // 변신 상태에서도 결과적으로 1턴에 일반 상태로 1칸 이동한 것과 동일하게 처리 가능
                int ni = pi + di[a];
                int nj = pj + dj[a];
                if (ni > 0 && ni <= N && nj > 0 && nj <= N) {
                    if (v[ni][nj][0] > turn + 1) {
                        v[ni][nj][0] = turn + 1;
                        pq.add(new int[]{ni, nj, 0, turn + 1});
                    }
                }

                // 포탈 이동
                if (potal[pi][pj][a] != INF_PORTAL) {
                    int subNi = pi + di[a] * potal[pi][pj][a];
                    int subNj = pj + dj[a] * potal[pi][pj][a];
                    int cost = turn + (trans == 1 ? 1 : T + 1);

                    if (v[subNi][subNj][1] > cost) {
                        v[subNi][subNj][1] = cost;
                        pq.add(new int[]{subNi, subNj, 1, cost});
                    }
                }
            }
        }

        System.out.println(Math.min(v[R][C][0], v[R][C][1]));
    }
}
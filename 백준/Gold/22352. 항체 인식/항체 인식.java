import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] before, after;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        before = new int[N][M];
        after = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) before[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) after[i][j] = Integer.parseInt(st.nextToken());
        }

        // 1) 처음으로 다른 칸 찾기
        int sx = -1, sy = -1;
        outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (before[i][j] != after[i][j]) {
                    sx = i; sy = j;
                    break outer;
                }
            }
        }

        // 이미 동일하면 그대로 YES
        if (sx == -1) {
            System.out.println("YES");
            return;
        }

        // 2) before에서 (sx,sy)와 같은 값으로 연결된 컴포넌트를 after[sx][sy]로 칠하기
        int from = before[sx][sy];
        int to = after[sx][sy];

        boolean[][] vis = new boolean[N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        vis[sx][sy] = true;
        before[sx][sy] = to;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + di[k];
                int ny = y + dj[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (vis[nx][ny]) continue;
                if (before[nx][ny] != from) continue;

                vis[nx][ny] = true;
                before[nx][ny] = to;
                q.add(new int[]{nx, ny});
            }
        }

        // 3) 전체가 after와 같으면 YES, 아니면 NO
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (before[i][j] != after[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
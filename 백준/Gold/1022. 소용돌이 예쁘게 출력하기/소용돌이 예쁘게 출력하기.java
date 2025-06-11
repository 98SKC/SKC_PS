
import java.util.*;
import java.io.*;

public class Main {

    public static final int[] di = {0, -1, 0, 1};
    public static final int[] dj = {1, 0, -1, 0};

    // region 전용 map
    public static int[][] map;
    public static int[] answer = new int[4];
    public static int baseR, baseC;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 절대 좌표로 변환 (5000 오프셋 유지)
        answer[0] = Integer.parseInt(st.nextToken()) + 5000; // r1
        answer[1] = Integer.parseInt(st.nextToken()) + 5000; // c1
        answer[2] = Integer.parseInt(st.nextToken()) + 5000; // r2
        answer[3] = Integer.parseInt(st.nextToken()) + 5000; // c2

        // region 크기 계산
        baseR = answer[0];
        baseC = answer[1];
        int R = answer[2] - answer[0] + 1;
        int C = answer[3] - answer[1] + 1;
        map = new int[R][C];

        // 소용돌이 생성 (전 범위 순회하나, map에 저장은 region only)
        makeMap();

        // 네 모서리 값으로 포맷 너비 계산
        int max = 0;
        max = Math.max(max, map[0][0]);
        max = Math.max(max, map[0][C - 1]);
        max = Math.max(max, map[R - 1][0]);
        max = Math.max(max, map[R - 1][C - 1]);
        int width = String.valueOf(max).length();

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(String.format("%" + width + "d", map[i][j]));
                if (j < C - 1) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    // 절대 좌표 범위 1..10001 x 1..10001
    public static void makeMap() {
        int cnt = 0, level = 1, dir = 0;
        int ni = 5000, nj = 5000;
        // 시작점
        store(ni, nj, 1);
        // 다음 위치부터
        ni = 5000;
        nj = 5001;
        for (int val = 2; val <= 100020001; val++) {
            store(ni, nj, val);
            cnt++;
            if (cnt == level) {
                cnt = 0;
                dir = (dir + 1) % 4;
                if (dir == 2 || dir == 0) level++;
            }
            ni += di[dir];
            nj += dj[dir];
        }
    }

    // region 안이면 저장
    private static void store(int absR, int absC, int val) {
        int r = absR - baseR;
        int c = absC - baseC;
        if (r >= 0 && r < map.length && c >= 0 && c < map[0].length) {
            map[r][c] = val;
        }
    }
}

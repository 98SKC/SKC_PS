import java.io.*;
import java.util.*;

public class Main {

    public static int[] di = new int[] { 0, 1, 0, -1 };
    public static int[] dj = new int[] { 1, 0, -1, 0 };
    public static int[][] map;
    public static int max = 0;
    public static int N, M, H;
    public static int[] start;
    public static HashSet<Integer> milk = new HashSet<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        start = new int[2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    // 시작점 찾기
                    start[0] = i;
                    start[1] = j;
                } else if (map[i][j] == 2) {
                    milk.add(i * N + j);
                }
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int sub;

        // milk의 복사본을 사용하여 반복
        find(start[0],start[1], M, 0);

        System.out.println(max);
    }

    public static void find(int pi, int pj, int hp, int count) {
        int ni, nj;

        if (Math.abs(pi - start[0]) + Math.abs(pj - start[1]) <= hp) {
            max = Math.max(max, count);// 집을 갈 수 있다.
        }

        // milk의 복사본을 사용하여 반복
        for (Integer next : new HashSet<>(milk)) {
            ni = next / N;
            nj = next % N;
            

            if (Math.abs(pi - ni) + Math.abs(pj - nj) <= hp) {

                milk.remove(ni * N + nj);
                find(ni, nj, hp - (Math.abs(pi - ni) + Math.abs(pj - nj)) + H, count + 1);
                milk.add(ni * N + nj);
            }
        }
    }
}
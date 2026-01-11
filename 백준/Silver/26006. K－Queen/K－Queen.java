

import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int R, C;
    static int[] di = {0,-1,-1,-1,0,1,1,1};
    static int[] dj = {-1,-1,0,1,1,1,0,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 킹 주변 8칸
        int[] kr = new int[8];
        int[] kc = new int[8];
        boolean[] blocked = new boolean[8];// 체스판을 다 boolean 배열로 만들면 메모리초과.
        //그러니 수치상에서 행,렬,대각선만 보기위함.

        for (int d = 0; d < 8; d++) {
            kr[d] = R + di[d];
            kc[d] = C + dj[d];
            if (kr[d] <= 0 || kr[d] > N || kc[d] <= 0 || kc[d] > N) {
                blocked[d] = true; // 체스판 밖이면 이동 불가
            }
        }

        boolean kingChecked = false;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int qr = Integer.parseInt(st.nextToken());
            int qc = Integer.parseInt(st.nextToken());

            // 킹 공격 여부
            if (qr == R || qc == C || Math.abs(qr - R) == Math.abs(qc - C)) {
                kingChecked = true;
            }

            // 킹 주변 8칸 공격 여부
            for (int d = 0; d < 8; d++) {
                if (blocked[d]) continue;

                if (qr == kr[d] || qc == kc[d]
                    || Math.abs(qr - kr[d]) == Math.abs(qc - kc[d])) {
                    blocked[d] = true;
                }
            }
        }

        boolean escape = false;
        for (int d = 0; d < 8; d++) {
            if (!blocked[d]) {
                escape = true;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (kingChecked) {
            if (escape) sb.append("CHECK");
            else sb.append("CHECKMATE");
        } else {
            if (escape) sb.append("NONE");
            else sb.append("STALEMATE");
        }

        System.out.println(sb);
    }
}

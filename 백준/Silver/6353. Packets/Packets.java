import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] a = new int[7]; // a[1] ~ a[6]
            int sum = 0;

            for (int i = 1; i <= 6; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                sum += a[i];
            }

            if (sum == 0) break;

            int box = 0;

            // 6x6은 하나당 박스 하나
            box += a[6];

            // 5x5는 하나당 박스 하나, 남는 공간에 1x1 11개 가능
            box += a[5];
            a[1] = Math.max(0, a[1] - a[5] * 11);

            // 4x4는 하나당 박스 하나, 남는 공간에 2x2 5개 가능
            box += a[4];

            int need2 = a[4] * 5;
            if (a[2] >= need2) {
                a[2] -= need2;
            } else {
                int lack2 = need2 - a[2];
                a[1] = Math.max(0, a[1] - lack2 * 4);
                a[2] = 0;
            }

            // 3x3은 한 박스에 4개까지 가능
            box += (a[3] + 3) / 4;

            int remain3 = a[3] % 4;

            if (remain3 == 1) {
                // 3x3 1개 남으면 2x2 5개 + 1x1 7개 가능
                int use2 = Math.min(a[2], 5);
                a[2] -= use2;

                int usedArea = 9 + use2 * 4;
                a[1] = Math.max(0, a[1] - (36 - usedArea));

            } else if (remain3 == 2) {
                // 3x3 2개 남으면 2x2 3개 + 1x1 6개 가능
                int use2 = Math.min(a[2], 3);
                a[2] -= use2;

                int usedArea = 18 + use2 * 4;
                a[1] = Math.max(0, a[1] - (36 - usedArea));

            } else if (remain3 == 3) {
                // 3x3 3개 남으면 2x2 1개 + 1x1 5개 가능
                int use2 = Math.min(a[2], 1);
                a[2] -= use2;

                int usedArea = 27 + use2 * 4;
                a[1] = Math.max(0, a[1] - (36 - usedArea));
            }

            // 남은 2x2는 한 박스에 9개까지 가능
            if (a[2] > 0) {
                box += (a[2] + 8) / 9;

                int remain2 = a[2] % 9;
                if (remain2 > 0) {
                    int emptyArea = 36 - remain2 * 4;
                    a[1] = Math.max(0, a[1] - emptyArea);
                }
            }

            // 남은 1x1은 한 박스에 36개까지 가능
            if (a[1] > 0) {
                box += (a[1] + 35) / 36;
            }

            sb.append(box).append('\n');
        }

        System.out.print(sb);
    }
}
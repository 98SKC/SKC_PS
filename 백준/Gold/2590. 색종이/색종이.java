

import java.util.*;
import java.io.*;

public class Main {

    public static int[] paper = new int[7];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 6; i++) {
            paper[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;

        // 6x6
        if (paper[6] > 0) {
            ans += paper[6];
        }

        // 5x5
        while (paper[5] > 0) {
            int area = 36 - 25; // 남는 칸 수(1x1로 채움)
            paper[5]--;
            paper[1] = Math.max(paper[1] - area, 0);
            ans++;
        }

        // 4x4
        while (paper[4] > 0) {
            int area = 36 - 16; // 남는 면적
            int used2 = Math.min(paper[2], 5); // 최대 2x2 다섯 장
            area -= used2 * 4;

            paper[4]--;
            paper[2] = Math.max(paper[2] - 5, 0);
            paper[1] = Math.max(paper[1] - area, 0);
            ans++;
        }

        // 3x3
        while (paper[3] > 0) {
            int used3 = Math.min(paper[3], 4);
            int area = 36 - 9 * used3;

            if (paper[3] >= 4) {
                paper[3] -= 4;
                area = 0;
            } else if (paper[3] == 3) {
                int used2 = Math.min(1, paper[2]);
                area -= used2 * 4;
                paper[3] -= 3;
                paper[2] = Math.max(paper[2] - 1, 0);
            } else if (paper[3] == 2) {
                int used2 = Math.min(3, paper[2]);
                area -= used2 * 4;
                paper[3] -= 2;
                paper[2] = Math.max(paper[2] - 3, 0);
            } else { // paper[3] == 1
                int used2 = Math.min(5, paper[2]);
                area -= used2 * 4;
                paper[3] -= 1;
                paper[2] = Math.max(paper[2] - 5, 0);
            }

            paper[1] = Math.max(paper[1] - area, 0);
            ans++;
        }

        // 2x2
        while (paper[2] > 0) {
            int used2 = Math.min(paper[2], 9);
            int area = 36 - 4 * used2;
            paper[2] = Math.max(paper[2] - 9, 0);
            paper[1] = Math.max(paper[1] - area, 0);
            ans++;
        }

        // 1x1
        while (paper[1] > 0) {
            paper[1] = Math.max(paper[1] - 36, 0);
            ans++;
        }

        System.out.println(ans);
    }
}
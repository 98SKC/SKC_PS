// 백준 일곱난쟁이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarfs = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            sum += dwarfs[i];
        }

        // 오름차순 출력을 위해 미리 정렬
        Arrays.sort(dwarfs);

        int fake1 = 0, fake2 = 0;

        // 9명 중 2명을 선택해 총합에서 뺐을 때 100이 되는지 확인
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - dwarfs[i] - dwarfs[j] == 100) {
                    fake1 = i;
                    fake2 = j;
                    break;
                }
            }
            if (fake1 != 0 || fake2 != 0) break;
        }

        // 가짜 난쟁이를 제외하고 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (i == fake1 || i == fake2) continue;
            sb.append(dwarfs[i]).append("\n");
        }
        System.out.print(sb);
    }
}

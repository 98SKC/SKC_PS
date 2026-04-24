import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[N + 1];

        // dp[i] = 돌이 i개 남았을 때, 현재 턴인 사람이 이길 수 있으면 true

        for (int i = 1; i <= N; i++) {
            // 마지막 돌을 가져가면 지므로
            // i개를 전부 가져가는 선택은 지는 선택이다.

            if (i - 1 > 0 && !dp[i - 1]) {
                dp[i] = true;
            }

            if (i - 3 > 0 && !dp[i - 3]) {
                dp[i] = true;
            }

            if (i - 4 > 0 && !dp[i - 4]) {
                dp[i] = true;
            }
        }

        System.out.println(dp[N] ? "SK" : "CY");
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static long[][][][] dp;
    static int N, R, G, B;
    static long[][] comb; // 조합 값을 저장하기 위한 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());


        dp = new long[N + 1][R + 1][G + 1][B + 1];
        comb = new long[N + 1][N + 1];

        // 조합 테이블 계산
        calculateCombinations(N);

        for (int n = 0; n <= N; n++) {
            for (int r = 0; r <= R; r++) {
                for (int g = 0; g <= G; g++) {
                    for (int b = 0; b <= B; b++) {
                    	
                        if (n == 0) {
                            dp[n][r][g][b] = 1;
                            continue;
                        }

                        // 한 가지 색으로만 이루어져 있을 경우
                        if (r - n >= 0) dp[n][r][g][b] += dp[n - 1][r - n][g][b];
                        if (g - n >= 0) dp[n][r][g][b] += dp[n - 1][r][g - n][b];
                        if (b - n >= 0) dp[n][r][g][b] += dp[n - 1][r][g][b - n];

                        // 두 가지 색으로 이루어져 있을 경우
                        if (n % 2 == 0) {
                            int divNum = n / 2;
                            if (r - divNum >= 0 && g - divNum >= 0) 
                                dp[n][r][g][b] += comb[n][divNum] * dp[n - 1][r - divNum][g - divNum][b];
                            if (g - divNum >= 0 && b - divNum >= 0) 
                                dp[n][r][g][b] += comb[n][divNum] * dp[n - 1][r][g - divNum][b - divNum];
                            if (r - divNum >= 0 && b - divNum >= 0) 
                                dp[n][r][g][b] += comb[n][divNum] * dp[n - 1][r - divNum][g][b - divNum];
                        }

                        // 세 가지 색으로 이루어져 있을 경우
                        if (n % 3 == 0) {
                            int divNum = n / 3;
                            if (r - divNum >= 0 && g - divNum >= 0 && b - divNum >= 0)
                                dp[n][r][g][b] += comb[n][divNum] * comb[n - divNum][divNum] * dp[n - 1][r - divNum][g - divNum][b - divNum];
                        }
                    }
                }
            }
        }

        System.out.println(dp[N][R][G][B]);
    }

    public static void calculateCombinations(int max) {
        for (int i = 0; i <= max; i++) {
            comb[i][0] = comb[i][i] = 1; // nC0 = 1, nCn = 1
            for (int j = 1; j < i; j++) {
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!dp[i][j] || arr[i][j] == -1) continue;

                int move = arr[i][j];

                if (i + move < n) dp[i + move][j] = true;
                if (j + move < n) dp[i][j + move] = true;
            }
        }

        if (dp[n - 1][n - 1]) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지원자 수
        int K = Integer.parseInt(st.nextToken()); // 뽑을 인원 수
        int x = Integer.parseInt(st.nextToken()); // a + b 값 (모든 사람에게 동일)

        int[] arr = new int[N]; // 지원자의 힘(a) 값만 저장
        dp = new boolean[K + 1][K * x + 1]; // dp[i][j] -> i명을 선택했을 때 j값을 만들 수 있는가?

        // 지원자의 힘(a) 값을 입력받음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken()); // 힘(a) 값 저장
        }

        // 각 지원자의 a 값을 DP에 반영 (정답 코드 방식 적용)
        for (int p : arr) {
            knapsack(p, K, x);
        }

        // 최댓값 찾기
        int maxValue = 0;
        for (int s = 0; s <= x * K; s++) {
            if (dp[K][s]) { // K명을 선택했을 때 가능한 S 값
                maxValue = Math.max(maxValue, s * (K * x - s)); // S * (Kx - S) 최댓값 갱신
            }
        }

        System.out.println(maxValue);
    }

    static void knapsack(int p, int k, int x) {
        for (int i = k - 1; i >= 1; i--) { // i명 선택한 경우
            for (int j = x * k; j >= p; j--) { // j값을 역순으로 업데이트
                dp[i + 1][j] = dp[i + 1][j] || dp[i][j - p]; // j-p가 가능한 경우 업데이트
            }
        }
        dp[1][p] = true; // 한 명만 선택할 때, 해당 값 가능
    }
}
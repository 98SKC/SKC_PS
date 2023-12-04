import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            dp[i] = 5001; // N의 최댓값보다 큰 수로 초기화
        }

        if(N>=3) dp[3]=1;
        if(N>=5) dp[5]=1;



        for(int i = 6; i <= N; i++) { // 6kg부터 Nkg까지 확인
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1; // 3kg 또는 5kg 설탕을 추가로 사용하는 경우 중 최소값
        }

        System.out.println(dp[N] > N ? -1 : dp[N]); // 만약 dp[N]이 (5002)인 경우 -1 출력, 아니면 dp[N] 출력
    }
}

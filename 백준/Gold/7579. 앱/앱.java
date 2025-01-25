import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // N개의 앱
        int M = Integer.parseInt(st.nextToken()); // 필요한 메모리 크기
        
        st = new StringTokenizer(br.readLine());
        int[] weight = new int[N]; // 각 앱이 사용하는 메모리
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] price = new int[N]; // 각 앱의 비활성화 비용
        int totalPrice = 0; // 총 비용의 최대값 계산
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
            totalPrice += price[i];
        }

        // dp 배열: 비용에 따른 최대 확보 가능한 메모리
        int[] dp = new int[totalPrice + 1];
        Arrays.fill(dp, 0); // 초기화: 비용이 0일 때 확보 메모리는 0

        // 냅색 알고리즘 적용
        for (int i = 0; i < N; i++) { // 각 앱에 대해
            for (int j = totalPrice; j >= price[i]; j--) { // 비용을 역순으로 계산. i앱을 선택함으로써 얻을 수 있는 최대 메모리 양
                dp[j] = Math.max(dp[j], dp[j - price[i]] + weight[i]);// 선택 안한 것 vs 선택 한 것
            }
        }

        // 최소 비용 찾기
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= totalPrice; i++) {
            if (dp[i] >= M) { // 필요한 메모리 이상 확보 가능한 경우
                result = Math.min(result, i);
                break;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
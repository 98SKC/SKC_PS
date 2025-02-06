import java.util.*;
import java.io.*;

public class Main {

    static class Coin implements Comparable<Coin> {
        int price, number;

        public Coin(int price, int number) {
            this.price = price;
            this.number = number;
        }

        @Override
        public int compareTo(Coin o) {
            return Integer.compare(o.price, this.price); // price 기준 내림차순 정렬
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 3; t++) {
            int N = Integer.parseInt(br.readLine());
            boolean answer = false;
            int total = 0;

            Coin[] coins = new Coin[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int price = Integer.parseInt(st.nextToken());
                int number = Integer.parseInt(st.nextToken());
                coins[i] = new Coin(price, number);
                total += price * number;
            }

            if (total % 2 == 1) { // 총합이 홀수면 둘로 나눌 수 없음
                sb.append(0).append("\n");
                continue;
            }

            int mid = total / 2;
            boolean[] dp = new boolean[mid + 1]; // 1차원 DP 배열
            dp[0] = true; // 0원을 만들 수 있음

            // 동전 내림차순 정렬
            Arrays.sort(coins);

            for (int i = 0; i < N; i++) {
                int price = coins[i].price;
                int number = coins[i].number;

                if (price > mid) break; // 동전의 가치가 mid보다 크면 필요 없음
                for(int j=mid;j>=price;j--) {
                	if(dp[j-price]) {
                		for (int k = 0; k <=number; k++) { // 동전 개수만큼 반복
                            int sub=j+k*price;
                			if(sub<=mid) dp[sub]=true;
                        }
                	}
                }
                
            }
            //System.out.println(Arrays.toString(dp));
            // 최종 정답 출력
            sb.append(dp[mid] ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }
}
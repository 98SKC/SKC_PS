import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int[] card = new int[N + 1]; // card[i] = i개 카드팩 가격
        for(int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N + 1];
        
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 카드 0개를 사는 데 드는 비용은 0원

        
        for(int i = 1; i <= N; i++) { // 목표 카드 개수
            for(int j = 1; j <= i; j++) { // j개 들어있는 카드팩 사용
                if (dp[i - j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j] + card[j]);
                }
            }
        }

        System.out.println(dp[N]);
    }
}

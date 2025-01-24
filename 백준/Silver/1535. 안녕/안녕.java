import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        int[] value=new int[N+1];
        int[] weight=new int[N+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        for(int i=1;i<=N;i++) {
        	weight[i]=Integer.parseInt(st.nextToken());
        }
        
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
        	value[i]=Integer.parseInt(st.nextToken());
        }
        // 방법1. 2차원 dp
//        int[][] dp=new int[N+1][101];
//        
//        
//        // 채력= 무게 ,  기쁨- 가치
//        for (int i = 1; i <= N; i++) { // 각 물건에 대해
//            for (int j = 100; j >= 1; j--) { // 배낭 용량 (체력)
//                if (j >= weight[i]) { // 물건을 넣을 수 있다면
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
//                } else { // 물건을 넣을 수 없다면
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//
//        // 최대 기쁨 계산
//        int maxHappiness = 0;
//        for (int j = 1; j <= 100; j++) {
//            maxHappiness = Math.max(maxHappiness, dp[N][j]);
//        }
//        System.out.println(maxHappiness);
        
        //방법2. 1차웡 dp
        int[] dp = new int[101]; // 최대 체력 100까지만 유효

        for (int i = 1; i <= N; i++) { // 각 물건에 대해
            for (int j = 100; j >= weight[i]; j--) { // 큰 무게부터 계산
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
            }
        }

        // 최대 기쁨 계산
        int maxHappiness = 0;
        for (int j = 1; j < 100; j++) {
            maxHappiness = Math.max(maxHappiness, dp[j]);
        }
        System.out.println(maxHappiness);
    }
}
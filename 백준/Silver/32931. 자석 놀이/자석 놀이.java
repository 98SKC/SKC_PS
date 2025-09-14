

import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //2*N의 격자.
        //각 칸에 카드가 있다.
        //좌측상단에는 자석이 있고, 이를 상하좌우로 한칸씩 이동하며 우측하단으로 이동
        //카드는 자석에 달라붙으며 도착 후 카드의 합의 최대값을 구하라.

        int N = Integer.parseInt(br.readLine().trim());
 
        long[][] arr = new long[2][N+1];
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= N; j++) {
            arr[0][j] = Long.parseLong(st.nextToken());
        }
 
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= N; j++) {
            arr[1][j] = Long.parseLong(st.nextToken());
        }
 
        long[][] dp = new long[2][N+1];
 
        dp[0][1] = Math.max(arr[0][1], arr[0][1] + arr[1][1]);
        dp[1][1] = arr[0][1] + arr[1][1];
 
        for (int j = 2; j <= N; j++) {
            long topVal = arr[0][j];
            long botVal = arr[1][j];
 
            long cand1 = dp[0][j-1] + topVal;
            long cand2 = dp[0][j-1] + topVal + botVal;
            long cand3 = dp[1][j-1] + topVal + botVal;
            dp[0][j] = Math.max(Math.max(cand1, cand2), cand3);
 
            cand1 = dp[1][j-1] + botVal;
            cand2 = dp[1][j-1] + topVal + botVal;
            cand3 = dp[0][j-1] + topVal + botVal;
            dp[1][j] = Math.max(Math.max(cand1, cand2), cand3);
        }
 
        long answer = dp[1][N];
        System.out.println(answer);
   
    }
        
}



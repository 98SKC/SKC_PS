
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int T=Integer.parseInt(st.nextToken());
        int W=Integer.parseInt(st.nextToken());
        
        int[] plumTree=new int[T]; //t초에 자두가 떨어질 나무
        int[][][] dp=new int[T][W+1][3]; //t초에 w번 움직여서 1,2 나무에 있을 때 먹는 자두의 최대
        
        for(int i=0;i<T;i++) {
        	plumTree[i]=Integer.parseInt(br.readLine());
        }
        // 매 초마다, 두 개의 나무 중 하나에서 열매가 떨어진다.
        // 그 순간 그 나무에 위치해야한다.
        // 이동에는 시간이 소요되지 않으나 최대 W번만 움직이고자 한다.
        // 최대로 먹을 수 있는 자두의 수를 구하라.
        // 처음에는 1번 나무에 있다.
        

        for (int w = 0; w <= W; w++) {
            if (w % 2 == 0) {
                // 짝수번 이동 → 1번 나무에 있음
                dp[0][w][1] = (plumTree[0] == 1 ? 1 : 0);
                dp[0][w][2] = 0;
            } else {
                // 홀수번 이동 → 2번 나무에 있음
                dp[0][w][1] = 0;
                dp[0][w][2] = (plumTree[0] == 2 ? 1 : 0);
            }
        }

  
        for (int t = 1; t < T; t++) {
            for (int w = 0; w <= W; w++) {
                //움직이지 않고 그대로 있을 때
                dp[t][w][1] = dp[t-1][w][1] + (plumTree[t] == 1 ? 1 : 0);
                dp[t][w][2] = dp[t-1][w][2] + (plumTree[t] == 2 ? 1 : 0);

                //w>0일 때, 바로 직전에 다른 나무에 있다가 이동해 오는 경우
                if (w > 0) {
                    dp[t][w][1] = Math.max(
                        dp[t][w][1],
                        dp[t-1][w-1][2] + (plumTree[t] == 1 ? 1 : 0)
                    );
                    dp[t][w][2] = Math.max(
                        dp[t][w][2],
                        dp[t-1][w-1][1] + (plumTree[t] == 2 ? 1 : 0)
                    );
                }
            }
        }

        int ans = 0;
        for (int w = 0; w <= W; w++) {
            ans = Math.max(ans, Math.max(dp[T-1][w][1], dp[T-1][w][2]));
        }
        System.out.println(ans);
    }
}


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];


        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        	
        }
        
        int[][] dp = new int[N][2];
        
        dp[0][0] = arr[0];// 제거 안 한 상태
        dp[0][1] = 0;     // 제거 한 상태 

        int answer = arr[0];

        for (int i = 1; i < N; i++) {
            // 제거 안 한 상태: 이전에 이어붙이거나 !새로 시작!
            dp[i][0] = Math.max(dp[i-1][0], 0)+arr[i];

            // 제거 한 상태:
            // 1) 이전에도 제거한 상태에서 이어붙이기
            // 2) 이번에 arr[i]를 제거하기 
            dp[i][1] = Math.max(dp[i-1][1] + arr[i], dp[i-1][0]);

            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(answer);
        
    }
}

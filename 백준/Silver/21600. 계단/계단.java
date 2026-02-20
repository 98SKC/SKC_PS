import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        int ans = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.min(arr[i], dp[i - 1] + 1);
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
//import java.io.*;
//import java.util.*;
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
//
//    }
//
//}
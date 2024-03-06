import java.io.*;
import java.util.*;

 
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];// dp를 이용하여 푼다.
        
        int max;
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];
        //dp[i]는 이전까지의 합과 자신을 더한값 vs 자신 혼자의 값. dp[i]에는 i자리까지의 최대값이 들어간다.
        //dp[i+1]의 최대값은 dp[i]+arr[i](바로 전까지의 최대값+자기자신)vs 자기자신
        //dp[i]자체가 i까지 연속된 숫자중 최댓값이기 때문에 연속되는지 굳이 확인하지 않아도 되고, dp[i]는 i자리 '까지'의 최대값이기 때문에 뒤의 숫자를 생각하지 않아도 된다.
        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);  
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        
    }
}
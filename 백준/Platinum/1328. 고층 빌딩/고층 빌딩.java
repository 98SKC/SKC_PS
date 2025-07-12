
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 빌딩의 개수
        int L=Integer.parseInt(st.nextToken()); // 왼쪽에서 봤을 때
        int R=Integer.parseInt(st.nextToken()); // 오른쪽에서 봤을 때
        
        //첫째 줄에 가능한 빌딩 순서의 경우의 수를 1000000007
        int MOD=1000000007;
        //   3 2 2
        
        //   1 3 2
        //   2 3 1
        // 빌딩 크기가 모두 다르기에, 1~N의 높이가 하나씩 있다고 가정할 수 있다.
        // 왼쪽에서 5
        long[][][] dp= new long[N+1][N+1][N+1]; // n번째 빌딩을 새울 때, 왼쪽에서 보이는 수가 l, 오른쪽에서 보이는 수가 r
        dp[1][1][1]=1;// 1개의 빌딩을 새우는 경우
        
        if(N==1) {
        	System.out.println(1);
        	return;
        }
        dp[2][2][1]=1;
        dp[2][1][2]=1;
        
        // dp[n][l][r] = dp[n-1][l-1][r] + dp[n-1][l][r-1] + dp[n-1][l][r]*(n-2)
        // dp[n-1][l-1][r]: n-1개의 빌딩의 l-1, r상황에서 맨 왼쪽에 최소보다 작은 기둥을 둠
        // dp[n-1][l][r-1]: n-1개의 빌딩의 l, r-1상황에서 맨 오른쪽에 최소보다 작은 기둥을 둠		
        // dp[n-1][l][r]*(n-2): n-1개의 빌딩의 l, r 상황에서 최소보다 작은 기둥을 사이사이에 두면 보이지 않음
        
		dp[2][2][1] = dp[2][1][2] = 1;

		for (int n = 3; n <= N; n++) {
			for (int l = 1; l <= L; l++) {
				for (int r = 1; r <= R; r++) {
					dp[n][l][r] += dp[n - 1][l - 1][r] % MOD;
					dp[n][l][r] += dp[n - 1][l][r - 1] % MOD;
					dp[n][l][r] += (dp[n - 1][l][r] * (n - 2)) % MOD;
					dp[n][l][r] %= MOD;
				}
			}
		}
        
        System.out.println(dp[N][L][R]);
        
        
    }
}

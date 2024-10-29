import java.util.*;
import java.io.*;

public class Main {
	
	static final long MOD = 1_000_000_000L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        long[][] dp=new long[N+1][10];
        
        
    
        for(int i=0; i<=9; i++) {
            dp[1][i] = 1L;
        }

        // 123456 이 있으면 6부터 1번자리~~ 6번자리 로 커진다. 
        
        for(int i=2; i<=N; i++) {
            // i 자리수가 0으로 시작하는 수의 개수 ->이전 숫자가 1인 경우
            dp[i][0] = dp[i-1][1];
            
            // i 자리수가 9으로 시작하는 수의 개수 ->이전 숫자가 8인 경우
            dp[i][9] = dp[i-1][8];
            for(int j=1; j<=8; j++) {
                // 나머지 수들은 이전 숫자의 j-1로 시작하는 수의 개수와 j+1로 시작하는 수의 개수를 더한 값.
                dp[i][j] =(dp[i-1][j-1] + dp[i-1][j+1])%MOD;
            }
        }

        long result = 0;
        // n의 자리수에서 n의 자리가 0인경우는 없다. 제외.
        for(int i=1; i<=9; i++) {
            result = (result + dp[N][i]) % MOD; 
        }

        System.out.println(result);
      
        		
    }
}
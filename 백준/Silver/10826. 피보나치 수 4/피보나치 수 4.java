import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	public static BigInteger[] dp=new BigInteger[10001];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[10001];
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-2].add(dp[i-1]);
        }
        System.out.print(dp[n]);
    }
}

import java.io.*;
import java.util.*;

public class Main{
   
	public static long[] fibo;
	public static final int pisano = 15 * 100000; // 피사노 주기: 피보나치 수를 K로 나눈 나머지는 항상 주기를 가지게 된다고 한다.

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //max: 9,223,372,036,854,775,807
        //long 범위: 1,000,000,000,000,000,000
        long N = Long.parseLong(br.readLine());

        N %= pisano;
        fibo = new long[(int) N + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        
        
        for (int i = 2; i <= N; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000;
        }
        
        System.out.println(fibo[(int) N]);
    }
}
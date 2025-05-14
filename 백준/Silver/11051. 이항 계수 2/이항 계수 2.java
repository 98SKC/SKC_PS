import java.io.*;
import java.util.*;

public class Main {

    //  역원 공부: 페르마의 소정리 사용
    // (a^-1) mod p = a^(p-2) mod p (단, p는 소수)
    public static int modInverse(int x, int mod) {
        return modPow(x, mod - 2, mod);
    }

    //거듭제곱
    public static int modPow(int base, int exp, int mod) {
        int result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (int)((result * 1L * base) % mod);
            }
            base = (int)((base * 1L * base) % mod);
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int mod = 10007;

        //prefix[i] = i! % mod (팩토리얼 누적곱. 누적합 같은 느낌으로 구현)
        int[] prefix = new int[N + 1];
        prefix[0] = 1;
        for (int i = 1; i <= N; i++) {
            prefix[i] = (int)((prefix[i - 1] * 1L * i) % mod);
        }

        //이항계수 공식: nCk = n! / (k! * (n-k)!) mod p
        // = n! * (k!)^-1 * ((n-k)!)^-1 mod p
        int numerator = prefix[N]; // n!
        int denominator = (int)((prefix[K] * 1L * prefix[N - K]) % mod); // k! * (n-k)!

        //분모의 역원을 곱해서 나눗셈 처리
        int answer = (int)((numerator * 1L * modInverse(denominator, mod)) % mod);
        System.out.println(answer);
    }
}

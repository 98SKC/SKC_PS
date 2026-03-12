import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final long MOD = 1_000_000_009L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        long ans = (2L * modPow(3, n - 2)) % MOD;
        System.out.println(ans);
    }

    static long modPow(long base, int exp) {
        long result = 1L;
        long cur = base % MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * cur) % MOD;
            }
            cur = (cur * cur) % MOD;
            exp >>= 1;
        }

        return result;
    }
}
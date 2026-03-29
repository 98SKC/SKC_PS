import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (!isPrime(n)) {
            System.out.println("COMPOSITE");
            return;
        }

        int sum = digitSum(n);

        if (isPrime(sum)) {
            System.out.println("ADDITIVE PRIME");
        } else {
            System.out.println("PRIME, BUT NOT ADDITIVE");
        }
    }
        // 소수 판별
    public static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 자리수 합
    public static int digitSum(long n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    
}
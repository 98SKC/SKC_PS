import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static final double PI = Math.PI;
    static final long MOD = 1000000000000000000L;
    static Map<Double, Long> dp = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(pibonacci(N));
    }
    
        public static long pibonacci(double num) {
        if (0 <= num && num <= PI) {
            return 1;
        }

        if (dp.containsKey(num)) {
            return dp.get(num);
        }

        long value = (pibonacci(num - 1) + pibonacci(num - PI)) % MOD;
        dp.put(num, value);
        return value;
    }
}
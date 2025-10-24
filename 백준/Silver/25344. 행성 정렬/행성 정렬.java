import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim()); // 3 <= N <= 100000
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        long ans = 1L;
        for (int i = 0; i < N - 2; i++) {
            long t = Long.parseLong(st.nextToken());
            ans = lcm(ans, t);
            
        }

        System.out.println(ans);
    }
    
    private static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    
    private static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0; // 여기선 0 안 나옴(모든 T_i >= 1)
        long g = gcd(a, b);
        return (a / g) * b; // (a/g)*b 로 중간값 최소화
    }
}

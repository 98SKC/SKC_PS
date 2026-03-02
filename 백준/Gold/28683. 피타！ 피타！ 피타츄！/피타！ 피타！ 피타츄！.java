import java.io.*;
import java.util.*;

public class Main {
    
    static class Pair {
        
        long a, b;
        
        Pair(long a, long b) { this.a = a; this.b = b; }
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return a == p.a && b == p.b;
        }
        @Override public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    
    static long isqrt(long x) {
        long r = (long) Math.sqrt((double) x);
        while ((r + 1) > 0 && (r + 1) * (r + 1) <= x) r++;
        while (r * r > x) r--;
        return r;
    }

    static boolean isSquare(long x) {
        if (x < 0) return false;
        long r = isqrt(x);
        return r * r == x;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        
        if (isSquare(n)) {
            System.out.println(-1);
            return;
        }

        HashSet<Pair> ans = new HashSet<>();

        
        long limit = isqrt(n);
        for (long x = 1; x <= limit; x++) {
            long rem = n - x * x;
            if (rem <= 0) continue;
            if (isSquare(rem)) {
                long y = isqrt(rem);
                long a = Math.min(x, y);
                long b = Math.max(x, y);
                ans.add(new Pair(a, b));
            }
        }

        
        for (long d1 = 1; d1 * d1 <= n; d1++) {
            if (n % d1 != 0) continue;
            long d2 = n / d1;          
            if ( (d1 & 1) != (d2 & 1) ) continue;

            long b = (d2 - d1) / 2;    
            long c = (d2 + d1) / 2;    
            if (b > 0) {
                
                ans.add(new Pair(b, c));
            }
        }

        System.out.println(ans.size());
    }
}
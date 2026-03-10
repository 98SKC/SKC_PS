
import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if (a == b) {
            System.out.println("INF");
            return;
        }

        long small = Math.min(a, b);
        long diff = Math.abs(a - b);

        long p = small * small;
        long q = diff;

        long g = gcd(p, q);
        p /= g;
        q /= g;

        System.out.println(p + " " + q);
    }
    
    static long gcd(long x, long y) {
        
    	while (y != 0) {
            long t = x % y;
            x = y;
            y = t;
        }
    	
        return x;
    }
    
}
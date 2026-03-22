import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();

        HashSet<Long> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int x = fs.nextInt();
            int y = fs.nextInt();

            int g = gcd(Math.abs(x), Math.abs(y));
            x /= g;
            y /= g;

            long key = (((long) x) << 32) | (y & 0xffffffffL);
            set.add(key);
        }

        System.out.println(set.size());
    }
        static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

}
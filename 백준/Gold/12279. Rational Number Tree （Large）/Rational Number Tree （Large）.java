import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    static final BigInteger ONE = BigInteger.ONE;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(fs.next());

        for (int tc = 1; tc <= T; tc++) {
            int type = Integer.parseInt(fs.next());

            if (type == 1) {
                BigInteger n = new BigInteger(fs.next());

                BigInteger p = ONE;
                BigInteger q = ONE;

             
                for (int i = n.bitLength() - 2; i >= 0; i--) {
                    if (n.testBit(i)) {
                        // 오른쪽 자식: (p+q)/q
                        p = p.add(q);
                    } else {
                        // 왼쪽 자식: p/(p+q)
                        q = q.add(p);
                    }
                }

                sb.append("Case #").append(tc).append(": ")
                  .append(p).append(' ').append(q).append('\n');

            } else {
                BigInteger p = new BigInteger(fs.next());
                BigInteger q = new BigInteger(fs.next());

                ArrayList<Integer> bits = new ArrayList<>();

     
                while (!(p.equals(ONE) && q.equals(ONE))) {
                    if (p.compareTo(q) < 0) {
                        // 왼쪽 자식이었음
                        bits.add(0);
                        q = q.subtract(p);
                    } else {
                        // 오른쪽 자식이었음
                        bits.add(1);
                        p = p.subtract(q);
                    }
                }

       
                BigInteger n = ONE;
                for (int i = bits.size() - 1; i >= 0; i--) {
                    n = n.shiftLeft(1);
                    if (bits.get(i) == 1) {
                        n = n.add(ONE);
                    }
                }

                sb.append("Case #").append(tc).append(": ")
                  .append(n).append('\n');
            }
        }

        System.out.print(sb);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;

            do {
                c = read();
            } while (c <= ' ' && c != -1);

            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }

            return sb.toString();
        }
    }
}
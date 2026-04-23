import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static long p, q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());

        long answer = countUpTo(b) - countUpTo(a - 1);
        System.out.println(answer);
    }

    static long countUpTo(long n) {
        if (n <= 0) {
            return 0L;
        }

        ArrayList<Long> pPows = buildPowers(p, n);
        ArrayList<Long> qPows = buildPowers(q, n);

        long result = 0L;

        for (int i = 0; i < pPows.size(); i++) {
            for (int j = 0; j < qPows.size(); j++) {
                if (i <= j) {
                    continue;
                }

                long mul1 = safeMul(pPows.get(i), qPows.get(j), n);
                if (mul1 > n) {
                    continue;
                }

                long mul2;
                if (i + 1 < pPows.size()) {
                    mul2 = safeMul(pPows.get(i + 1), qPows.get(j), n);
                } else {
                    mul2 = n + 1;
                }

                long mul3;
                if (j + 1 < qPows.size()) {
                    mul3 = safeMul(pPows.get(i), qPows.get(j + 1), n);
                } else {
                    mul3 = n + 1;
                }

                long mul4;
                if (i + 1 < pPows.size() && j + 1 < qPows.size()) {
                    mul4 = safeMul(pPows.get(i + 1), qPows.get(j + 1), n);
                } else {
                    mul4 = n + 1;
                }

                result += n / mul1;

                if (mul2 <= n) {
                    result -= n / mul2;
                }

                if (mul3 <= n) {
                    result -= n / mul3;
                }

                if (mul4 <= n) {
                    result += n / mul4;
                }
            }
        }

        return result;
    }

    static ArrayList<Long> buildPowers(long base, long limit) {
        ArrayList<Long> list = new ArrayList<>();
        list.add(1L);

        while (true) {
            long last = list.get(list.size() - 1);
            if (last > limit / base) {
                break;
            }
            list.add(last * base);
        }

        return list;
    }

    static long safeMul(long x, long y, long limit) {
        if (x > limit / y) {
            return limit + 1;
        }
        return x * y;
    }
}
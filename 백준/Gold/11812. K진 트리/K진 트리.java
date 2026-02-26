import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long N;
    static int K, Q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (K == 1) {
                sb.append(Math.abs(a - b)).append('\n');
            } else {
                sb.append(LCA(a, b)).append('\n');
            }
        }

        System.out.print(sb.toString());
    }

    //공통조상을 찾는 메서드
    public static long LCA(long a, long b) {
        long mv = 0;

        long da = getDepth(a);
        long db = getDepth(b);

        if (da < db) {
            long sub = a; a = b; b = sub;
            long t = da; da = db; db = t;
        }

        while (da != db) {
            a = getParent(a);
            da--;
            mv++;
        }

        while (a != b) {
            a = getParent(a);
            b = getParent(b);
            mv += 2;
        }

        return mv;
    }

    static long getParent(long idx) {
        return (idx - 2) / K + 1;
    }

    static long getDepth(long idx) {
        long d = 0;
        while (idx > 1) {
            idx = getParent(idx);
            d++;
        }
        return d;
    }
}
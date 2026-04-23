import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] w = new long[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            w[i] = Math.min(a, b);
        }

        long L = Long.parseLong(br.readLine());

        Arrays.sort(w);

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + w[i];
        }

        int answer = 0;

        for (int k = 1; k <= n; k++) {
            if (k == 1) {
                answer = 1;
                continue;
            }

            long needTwice = 2L * prefix[k] - w[k - 1] - w[k - 2];
            long shelfTwice = 2L * L;

            if (needTwice < shelfTwice) {
                answer = k;
            }
        }

        System.out.println(answer);
    }
}
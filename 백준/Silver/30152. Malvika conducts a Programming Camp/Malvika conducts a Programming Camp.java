import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            long ans;
            if (n == 1) ans = 0;
            else if (n == 2) ans = m;
            else ans = n + 2 * m - 3;

            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}

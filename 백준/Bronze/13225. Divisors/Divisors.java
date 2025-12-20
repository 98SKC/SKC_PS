import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int c = Integer.parseInt(br.readLine());

        while (c-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    cnt++;
                    if (i * i != n) cnt++;
                }
            }

            sb.append(n).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}

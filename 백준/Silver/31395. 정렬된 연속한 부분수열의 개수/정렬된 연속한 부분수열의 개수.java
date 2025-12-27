
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long prev = Long.parseLong(st.nextToken());
        long cnt = 1;
        long sum = 0;

        for (int i = 2; i <= N; i++) {
            long cur = Long.parseLong(st.nextToken());

            if (prev < cur) {
                cnt++;
            } else {
                sum += cnt * (cnt + 1) / 2;
                cnt = 1;
            }

            prev = cur;
        }

        sum += cnt * (cnt + 1) / 2;

        System.out.println(sum);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (x % 3 == 0 && x % 5 != 0) {
                sb.append('F');
            } else {
                // x % 5 == 0 이거나, x % 15 == 0 인 경우 포함
                sb.append('B');
            }
        }

        System.out.println(sb.toString());
    }
}
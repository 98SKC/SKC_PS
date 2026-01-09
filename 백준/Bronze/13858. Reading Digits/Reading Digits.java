import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int pos = Integer.parseInt(st.nextToken());

        String cur = br.readLine();
        StringBuilder prev;
        for (int step = 0; step < k; step++) {
            //문자열 계속 이어붙이게 sb로 한번...?
            prev = new StringBuilder();

            for (int i = 0; i < cur.length(); i += 2) {
                int count = cur.charAt(i) - '0';
                char digit = cur.charAt(i + 1);

                for (int c = 0; c < count; c++) {
                    prev.append(digit);
                }
            }

            cur = prev.toString();
        }

        System.out.println(cur.charAt(pos));
    }
}

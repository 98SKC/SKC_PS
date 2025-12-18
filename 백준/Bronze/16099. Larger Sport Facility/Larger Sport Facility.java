import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());

            if (a > b) sb.append("TelecomParisTech\n");
            else if (a < b) sb.append("Eurecom\n");
            else sb.append("Tie\n");
        }

        System.out.print(sb);
    }
}

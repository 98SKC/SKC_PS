import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());

        for (int t = 0; t < test_case; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long K = Long.parseLong(st.nextToken()); // 서쪽 사이트 수
            long N = Long.parseLong(st.nextToken()); // 동쪽 사이트 수
            long answer = 1;

            for (int i = 0; i < K; i++) {
                answer *= (N - i);
                answer /= (i + 1);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}



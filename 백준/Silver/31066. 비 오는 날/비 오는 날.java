import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
           
            int n = Integer.parseInt(st.nextToken()); // 학생 수
            int m = Integer.parseInt(st.nextToken()); // 우산 수
            int k = Integer.parseInt(st.nextToken()); // 우산당 최대 인원

            
            if (n != 1 && m == 1 && k == 1) {
                sb.append(-1).append('\n');
                continue;
            }

            int cnt = 0;

            while (true) {
                cnt++;
                n -= m * k;   

                if (n <= 0) break;

                cnt++;       
                n++;
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }
}

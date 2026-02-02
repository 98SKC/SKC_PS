import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseNum = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int k1 = Integer.parseInt(st.nextToken());
            int k2 = Integer.parseInt(st.nextToken());

            if (N == 0 && k1 == 0 && k2 == 0) break;

            int[] price = new int[N];
            Integer[] idx = new Integer[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
                idx[i] = i + 1; // day
            }

            // price 오름차순, 같으면 day 오름차순
            Arrays.sort(idx, (a, b) -> {
                if (price[a - 1] != price[b - 1]) {
                    return price[a - 1] - price[b - 1];
                }
                return a - b;
            });

            bw.write("Case " + caseNum++);
            bw.newLine();

            // 최저가 k1개 → day 오름차순
            int[] low = new int[k1];
            for (int i = 0; i < k1; i++) {
                low[i] = idx[i];
            }
            Arrays.sort(low);
            for (int i = 0; i < k1; i++) {
                if (i > 0) bw.write(" ");
                bw.write(Integer.toString(low[i]));
            }
            bw.newLine();

            // 최고가 k2개 → day 내림차순
            int[] high = new int[k2];
            for (int i = 0; i < k2; i++) {
                high[i] = idx[N - k2 + i];
            }
            Arrays.sort(high);
            for (int i = k2 - 1; i >= 0; i--) {
                bw.write(Integer.toString(high[i]));
                if (i > 0) bw.write(" ");
            }
            bw.newLine();

            bw.flush();
        }

        bw.close();
    }
}


//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
//
//    }
//
//}

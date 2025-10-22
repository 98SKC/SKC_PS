

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static double[] needPancake = {0.5, 0.5, 0.25, 0.0625, 0.5625};
    static int[] needTopping = {1, 30, 25, 10};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < t; i++) {
            // 빈 줄이 있으면 건너뜀
            String line = br.readLine();
            while (line != null && line.trim().isEmpty()) line = br.readLine();

            double canMake1 = Double.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(line);

            for (int j = 0; j < 5; j++) {
                int n = Integer.parseInt(st.nextToken());
                double possible = n / needPancake[j];
                if (possible < canMake1) canMake1 = possible;
            }

            // 두 번째 줄도 빈 줄 방지
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) line = br.readLine();

            st = new StringTokenizer(line);
            int canMake2 = 0;
            for (int j = 0; j < 4; j++) {
                int n = Integer.parseInt(st.nextToken());
                canMake2 += n / needTopping[j];
            }

            System.out.println((int) Math.min(canMake1, canMake2));
        }

        br.close();
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        double[][] arr = new double[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken()); // 입력을 double로 받음
            arr[i][1] = Double.parseDouble(st.nextToken());
        }

        double left = 0;
        double right = 0;

        for (int i = 0; i < N - 1; i++) {
            left += arr[i][0] * arr[i + 1][1];
        }
        left += arr[N - 1][0] * arr[0][1];

        for (int i = 1; i < N; i++) {
            right += arr[i][0] * arr[i - 1][1];
        }
        right += arr[0][0] * arr[N - 1][1];

        double answer = Math.abs(left - right) / 2.0;

        
        System.out.printf("%.1f\n", answer);
    }
}
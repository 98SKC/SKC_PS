import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long t = Long.parseLong(st.nextToken());
            arr[i] = t - i;   
        }

        Arrays.sort(arr);

        long median = arr[n / 2];
        long answer = 0;

        for (int i = 0; i < n; i++) {
            answer += Math.abs(arr[i] - median);
        }

        System.out.println(answer);
    }
}
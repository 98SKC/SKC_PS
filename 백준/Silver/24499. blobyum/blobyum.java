import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = K - 1;

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += A[i];
        }

        int maxi = sum;

        while (true) {
            sum -= A[left];
            left = (left + 1) % N;
            right = (right + 1) % N;
            sum += A[right];

            if (left == 0) break;

            maxi = Math.max(maxi, sum);
        }

        System.out.println(maxi);
    }
}

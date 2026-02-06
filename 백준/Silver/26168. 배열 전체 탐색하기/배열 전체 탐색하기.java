import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static long[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();

        int o;
        long k;          // 🔹 변경
        long right;      // 🔹 변경
        int sub;

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            o = Integer.parseInt(st.nextToken());
            k = Long.parseLong(st.nextToken());   // 🔹 변경

            if (o == 1) {
                sub = binaryLower(k);
            } else if (o == 2) {
                sub = binaryUpper(k);
            } else {
                right = Long.parseLong(st.nextToken()); // 🔹 변경
                sub = searchBetween(k, right);
            }
            sb.append(sub).append('\n');
        }

        System.out.println(sb);
    }

    // K 이상 개수
    public static int binaryLower(long K) {   // 🔹 변경
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] < K) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return N - right;
    }

    // K 초과 개수
    public static int binaryUpper(long K) {   // 🔹 변경
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] <= K) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return N - right;
    }

    // i ≤ x ≤ j 개수
    public static int searchBetween(long i, long j) {  // 🔹 변경
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] < i) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int l = right;

        left = 0;
        right = N;

        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] <= j) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int r = right;

        return r - l;
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

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            int[] arr2 = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) arr2[i] = Integer.parseInt(st.nextToken());

            int maxSum = searchMax(arr, arr2, N, M);
            System.out.println("#" + testCase + " " + maxSum);
        }
    }

    private static int searchMax(int[] arr, int[] arr2, int N, int M) {
        int max = 0;
        if (N > M) {
            max = helper(arr, arr2, N, M);
        } else {
            max = helper(arr2, arr, M, N);
        }
        return max;
    }

    private static int helper(int[] longer, int[] shorter, int longLength, int shorterLength) {
        int max = 0;
        for (int i = 0; i <= longLength - shorterLength; i++) {
            int sub = 0;
            for (int j = 0; j < shorterLength; j++) {
                sub += longer[i + j] * shorter[j];
            }
            max = Math.max(max, sub);
        }
        return max;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    // 전역 변수로 K번째 저장되는 수와 현재 저장 횟수를 추적
    static int valueK = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, N - 1, K);
        System.out.println(valueK > 0 ? valueK : -1); // K번째 값이 설정되었으면 출력, 아니면 -1 출력
    }

    public static void merge_sort(int[] arr, int p, int r, int K) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(arr, p, q, K);
            merge_sort(arr, q + 1, r, K);
            merge(arr, p, q, r, K);
        }
    }

    public static void merge(int[] arr, int p, int q, int r, int K) {
        int[] tmp = new int[r - p + 1];
        int i = p, j = q + 1, k = 0;

        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k] = arr[i++];
                countK(tmp[k++], K);
            } else {
                tmp[k] = arr[j++];
                countK(tmp[k++], K);
            }
        }

        while (i <= q) {
            tmp[k] = arr[i++];
            countK(tmp[k++], K);
        }

        while (j <= r) {
            tmp[k] = arr[j++];
            countK(tmp[k++], K);
        }

        System.arraycopy(tmp, 0, arr, p, tmp.length);
    }

    // K번째 저장 시 값을 업데이트하는 함수
    private static void countK(int value, int K) {
        count++;
        if (count == K) {
            valueK = value;
        }
    }
}

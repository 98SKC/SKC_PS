import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;
    static int K;
    static boolean finished = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        mergeSort(a, 0, n - 1);

        if (cnt == K) {
            StringBuilder sb = new StringBuilder();
            for (int x : a) sb.append(x).append(' ');
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    static void mergeSort(int[] a, int left, int right) {
        if (left >= right || finished) return;

        int mid = (left + right) / 2;

        mergeSort(a, left, mid);
        if (finished) return;

        mergeSort(a, mid + 1, right);
        if (finished) return;

        merge(a, left, mid, right);
    }

    static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, t = 0;

        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) tmp[t++] = a[i++];
            else tmp[t++] = a[j++];
        }
        while (i <= mid) tmp[t++] = a[i++];
        while (j <= right) tmp[t++] = a[j++];

        i = left;
        t = 0;
        while (i <= right) {
            a[i++] = tmp[t++];
            cnt++;
            if (cnt == K) {
                finished = true;
                return;
            }
        }
    }
}

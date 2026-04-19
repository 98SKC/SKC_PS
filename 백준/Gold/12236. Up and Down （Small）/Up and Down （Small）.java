import java.io.*;
import java.util.*;

public class Main {
    public static int count(int[] a, int[] target) {
        int n = a.length;
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) pos.put(target[i], i);

        int inv = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pos.get(a[i]) > pos.get(a[j])) inv++;
            }
        }
        return inv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = -1;
            int maxIdx = -1;
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
                if (A[i] > max) {
                    max = A[i];
                    maxIdx = i;
                }
            }

            int[] others = new int[N - 1];
            int p = 0;
            for (int i = 0; i < N; i++) {
                if (i != maxIdx) others[p++] = A[i];
            }

            int ans = Integer.MAX_VALUE;

            for (int mask = 0; mask < (1 << (N - 1)); mask++) {
                ArrayList<Integer> left = new ArrayList<>();
                ArrayList<Integer> right = new ArrayList<>();

                for (int i = 0; i < N - 1; i++) {
                    if ((mask & (1 << i)) != 0) left.add(others[i]);
                    else right.add(others[i]);
                }

                Collections.sort(left);
                Collections.sort(right);
                Collections.reverse(right);

                int[] target = new int[N];
                int idx = 0;
                for (int x : left) target[idx++] = x;
                target[idx++] = max;
                for (int x : right) target[idx++] = x;

                ans = Math.min(ans, count(A, target));
            }

            sb.append("Case #").append(tc).append(": ").append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
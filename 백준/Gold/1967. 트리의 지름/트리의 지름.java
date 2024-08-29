import java.io.*;
import java.util.*;

public class Main {
    static int max = 0;
    static List<int[]>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        StringTokenizer st;

        int root, child, price;

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            root = Integer.parseInt(st.nextToken());
            child = Integer.parseInt(st.nextToken());
            price = Integer.parseInt(st.nextToken());
            list[root].add(new int[]{child, price});
        }

        helper(1);
        System.out.println(max);
    }

    public static int helper(int a) {
        ArrayList<Integer> sub = new ArrayList<>();
        for (int[] childInfo : list[a]) {
            int b = childInfo[0];
            int edgeCost = childInfo[1];
            sub.add(edgeCost + helper(b));
        }
        sub.sort(Comparator.reverseOrder());
        if (sub.size() == 0) {
            return 0;
        }
        if (sub.size() == 1) {
            max = Math.max(max, sub.get(0));
        } else {
            max = Math.max(max, sub.get(0) + sub.get(1));
        }

        return sub.get(0);
    }
}
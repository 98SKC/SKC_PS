import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) set.add(Integer.parseInt(st.nextToken()));

        int f = -1;
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (!set.contains(i)) {
                if (f == -1) f = i;
            } else {
                if (f != -1) {
                    list.add(new int[]{f, i - 1});
                    f = -1;
                }
            }
        }
        if (f != -1) list.add(new int[]{f, N});


        //빠진 구간이 없다.
        if (list.isEmpty()) {
            System.out.println(0);
            return;
        }

        int len = list.size();
        int[] dp = new int[len];
        int INF = 1_000_000_000;
        Arrays.fill(dp, INF);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                int start = list.get(j)[0];
                int end = list.get(i)[1];
                int cost = getCal(start, end);

                int prev = (j == 0) ? 0 : dp[j - 1];
                dp[i] = Math.min(dp[i], prev + cost);
            }
        }

        System.out.println(dp[len - 1]);
    }

    static int getCal(int start, int end) {
        return (end - start + 1) * 2 + 5;
    }
}


//import java.io.*;
//import java.util.*;
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
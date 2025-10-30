
import java.io.*;
import java.util.*;

public class Main {
    static class Meeting {
        int s, e, p;
        Meeting(int s, int e, int p) { this.s = s; this.e = e; this.p = p; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Meeting[] a = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            a[i] = new Meeting(s, e, p);
        }

  
        Arrays.sort(a, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                if (m1.e != m2.e) return Integer.compare(m1.e, m2.e);
                return Integer.compare(m1.s, m2.s);
            }
        });


        int[] ends = new int[N];
        for (int i = 0; i < N; i++) ends[i] = a[i].e;


        long[] dp = new long[N + 1]; 
        for (int i = 1; i <= N; i++) {
            Meeting cur = a[i - 1];

    
            int j = upperBound(ends, cur.s) - 1;

            long take = cur.p + (j >= 0 ? dp[j + 1] : 0); 
            long skip = dp[i - 1];

            dp[i] = Math.max(skip, take);
        }

        System.out.println(dp[N]);
    }


    static int upperBound(int[] arr, int key) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo; 
    }
}

import java.io.*;
import java.util.*;

public class Main {
    
    static class Meeting {
        int s, e, p; // start, end, people
        Meeting(int s, int e, int p){ this.s=s; this.e=e; this.p=p; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Meeting[] arr = new Meeting[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i] = new Meeting(s, e, p);
        }

        // 제한 조건에 보면 임의의 K 회의는 k-1, k+1 회의와 무조건 겹치며, 그 외에는 겹치지 않는다고함.
        // 즉 k선택하면 k+1 선택불가의 식으로 진행 가능
        //Arrays.sort(arr, Comparator.comparingInt(m -> m.s));

 
        int[] a = new int[N + 1];
        for (int i = 1; i <= N; i++) a[i] = arr[i-1].p;

        if (N == 1) { System.out.println(a[1]); return; }

   
        int prev2 = a[1];
        int prev1 = Math.max(a[1], a[2]);

        for (int i = 3; i <= N; i++) {
            int cur = Math.max(prev1, prev2 + a[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        System.out.println(prev1);
    }
}

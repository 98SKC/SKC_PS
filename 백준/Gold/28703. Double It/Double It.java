import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long max = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());
            max = Math.max(max, num);
            pq.add(num);
        }

        long tmp = max;
        long ans = tmp - pq.peek();

        while (pq.peek() < max) {
            long min = pq.poll();
            ans = Math.min(ans, tmp - min);

            long doubled = min * 2;
            tmp = Math.max(tmp, doubled);

            pq.add(doubled);
        }

        ans = Math.min(ans, tmp - pq.peek());
        System.out.println(ans);
    }
}
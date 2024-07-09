import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<int[]>[] list = new List[N + 1];
        boolean[] v = new boolean[N + 1];
        int[] dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        int a, b, c;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); // 시작지
        b = Integer.parseInt(st.nextToken()); // 도착지

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{a, 0});
        dist[a] = 0;

        while (!pq.isEmpty()) {
            int[] pos = pq.poll();
            if (v[pos[0]]) continue;
            v[pos[0]] = true;

            for (int[] d : list[pos[0]]) {
                if (dist[d[0]] > dist[pos[0]] + d[1]) {
                    dist[d[0]] = dist[pos[0]] + d[1];
                    pq.add(new int[]{d[0], dist[d[0]]});
                }
            }
        }

        System.out.println(dist[b]);
    }
}

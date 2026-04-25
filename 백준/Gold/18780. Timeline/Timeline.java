import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to;
        long w;

        Edge(int to, long w) {
            this.to = to;
            this.w = w;
        }
    }

    static int N, C;
    static long M;
    static long[] earliest;
    static int[] indegree;
    static List<List<Edge>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        earliest = new long[N + 1];
        indegree = new int[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            earliest[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            graph.get(a).add(new Edge(b, x));
            indegree[b]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Edge e : graph.get(cur)) {
                earliest[e.to] = Math.max(earliest[e.to], earliest[cur] + e.w);

                indegree[e.to]--;

                if (indegree[e.to] == 0) {
                    q.offer(e.to);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(earliest[i]).append('\n');
        }

        System.out.print(sb);
    }
}
import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] dijk = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dijk[i] = Integer.MAX_VALUE;
        }

        dijk[destination] = 0;

        ArrayList<Integer>[] edges = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int[] r : roads) {
            edges[r[0]].add(r[1]);
            edges[r[1]].add(r[0]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        pq.add(new int[]{destination, 0});

        while (!pq.isEmpty()) {
            int[] p = pq.poll();

            int now = p[0];
            int dist = p[1];

            if (dijk[now] < dist) continue;

            for (Integer next : edges[now]) {
                if (dijk[next] > dist + 1) {
                    dijk[next] = dist + 1;
                    pq.add(new int[]{next, dijk[next]});
                }
            }
        }

        int len = sources.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            int distance = dijk[sources[i]];
            answer[i] = distance == Integer.MAX_VALUE ? -1 : distance;
        }

        return answer;
    }
}
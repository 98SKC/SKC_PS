import java.io.*;
import java.util.*;

public class Main {

    static public class Node {
        int number;
        int cost;

        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] list = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        // 배열 초기화
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE; // 무한대 초기화
        }
        dist[1] = 0; // 시작점 거리 0

        int start, end, cost;
        for (int i = 0; i < M; i++) { // 간선 추가
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, cost));
            list[end].add(new Node(start, cost)); // 양방향 그래프라면 추가 필요
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node p = pq.poll();
            int now = p.number;
            int currentCost = p.cost;

            if (visited[now]) continue;
            visited[now] = true;

            for (Node next : list[now]) {
                if (dist[next.number] > currentCost + next.cost) {
                    dist[next.number] = currentCost + next.cost;
                    pq.offer(new Node(next.number, dist[next.number]));
                }
            }
        }
        System.out.println(dist[N]);
    }
}
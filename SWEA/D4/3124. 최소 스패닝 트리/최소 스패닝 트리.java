import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static Edge[] edges;
    static int[] parent; // 부모 노드를 저장할 배열

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static void make() {
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) parent[i] = i;
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]); // 경로 압축
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        parent[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            edges = new Edge[M];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(from, to, weight);
            }

            Arrays.sort(edges); // 간선을 가중치에 따라 오름차순으로 정렬

            make(); // 모든 정점을 각각의 집합으로 만듦

            long result = 0; // 가중치의 합은 int 범위를 넘을 수 있으므로 long 사용
            int count = 0; // 연결된 간선의 수
            for (Edge edge : edges) {
                if (union(edge.from, edge.to)) {
                    result += edge.weight;
                    if (++count == N - 1) break; // MST가 완성되면 반복 종료
                }
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}
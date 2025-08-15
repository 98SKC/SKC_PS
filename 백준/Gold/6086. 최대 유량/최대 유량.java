import java.io.*;
import java.util.*;

public class Main {
    
    static final int V = 52; // A-Z(26) + a-z(26)
    static int[][] cap = new int[V][V];
    static int[][] flow = new int[V][V];
    static ArrayList<Integer>[] adj = new ArrayList[V];



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char ca = st.nextToken().charAt(0);
            char cb = st.nextToken().charAt(0);
            int c = Integer.parseInt(st.nextToken());

            int a = idx(ca), b = idx(cb);

            // 양방향 파이프 
            cap[a][b] += c;
            cap[b][a] += c;
            
            if (!adj[a].contains(b)) adj[a].add(b);
            if (!adj[b].contains(a)) adj[b].add(a);
        }

        int s = idx('A');
        int t = idx('Z');
        System.out.println(maxflow(s, t));
    }
    
    // 헷갈리니 문자를 숫자로 바꾼다.
    // Z다음 a아님. 연속된거 아니니 기억.
    
    static int idx(char ch) {
        if ('A' <= ch && ch <= 'Z') return ch - 'A';
        return ch - 'a' + 26;
    }
    
    //최대유량 구하는 메서드. 당장 이해가 어려워서 일단 따라 작성하면서 다시 이해
    static int maxflow(int s, int t) {
        int result = 0;
        while (true) {
            int[] parent = new int[V];
            
            //배열 채우는 메서드 익숙해지자.
            Arrays.fill(parent, -1);

            Queue<Integer> q = new ArrayDeque<>();
            q.add(s);
            parent[s] = s;

            // BFS로 증가 경로 탐색
            while (!q.isEmpty() && parent[t] == -1) {
                int u = q.poll();
                for (int v : adj[u]) {
                    if (parent[v] == -1 && cap[u][v] - flow[u][v] > 0) {
                        parent[v] = u;
                        q.add(v);
                        if (v == t) break;
                    }
                }
            }

            if (parent[t] == -1) break; // 더 이상 이쪽으로는 증가 경로 없음. 퇴각하라

            // 병목 용량 계산
            int add = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                add = Math.min(add, cap[u][v] - flow[u][v]);
            }

            // 유량 흘리기 + 역간선 갱신
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                flow[u][v] += add;
                flow[v][u] -= add;
            }

            result += add;
        }
        return result;
    }
}

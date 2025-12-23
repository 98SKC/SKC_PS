import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<Integer>[] graph;
    public static int[] order;
    public static boolean[] visited;
    public static int idx = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        order = new int[n + 1];
        visited = new boolean[n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            graph[i].sort(Collections.reverseOrder());
        }

        visited[r] = true;
        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append('\n');
        }

        System.out.print(sb);
    }
    
    public static void dfs(int cur) {
        order[cur] = ++idx;

        for (int next : graph[cur]) {
            if (visited[next]) continue;
            visited[next] = true;
            dfs(next);
        }
    }
}

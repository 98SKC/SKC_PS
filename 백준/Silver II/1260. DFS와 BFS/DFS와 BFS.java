import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;
    static boolean[] visit;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken()); // 시작점

        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];
       // visit2 = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        dfs(V);
        sb.append("\n");
        visit = new boolean[N + 1];
        bfs(V);
        System.out.println(sb.toString().trim());
    }

    static void dfs(int v) {
        visit[v] = true;
        sb.append(v).append(" ");

        Collections.sort(list[v]); // 인접 리스트 정렬
        for (int point : list[v]) {
            if (!visit[point]) {
                dfs(point);
            }
        }
    }

    static void bfs(int v) {
        q.add(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");

            Collections.sort(list[current]); // 인접 리스트 정렬
            for (int point : list[current]) {
                if (!visit[point]) {
                	//넣을때 기준으로 방문
                    visit[point] = true;
                    q.add(point);
                }
            }
        }
    }
}
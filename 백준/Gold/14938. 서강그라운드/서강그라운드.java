import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken()); 

        int[] item = new int[N + 1]; 
        int[][] road = new int[N + 1][N + 1]; 

        for (int i = 1; i <= N; i++) {
            Arrays.fill(road[i], Integer.MAX_VALUE); 
        }

        List<Integer>[] list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            item[i] = Integer.parseInt(st.nextToken()); 
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            road[a][b] = c;
            road[b][a] = c;

            list[a].add(b);
            list[b].add(a);
        }

        int max = 0;

       
        for (int start = 1; start <= N; start++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 다익스트라를 위한 우선순위 큐
            int[] dist = new int[N + 1];
            boolean[] visited = new boolean[N + 1];

            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;
            pq.add(new int[] { start, 0 });

            int totalItems = 0;

            while (!pq.isEmpty()) {
                int[] node = pq.poll();
                int current = node[0];
                int currentDist = node[1];

                if (visited[current]) continue;

                visited[current] = true;
                totalItems += item[current]; 

               
                for (int next : list[current]) {
                    int newDist = currentDist + road[current][next];
                    if (newDist <= M && newDist < dist[next]) { // 수색 범위 내에서만
                        dist[next] = newDist;
                        pq.add(new int[] { next, newDist });
                    }
                }
            }

            max = Math.max(max, totalItems); 
        }

        System.out.println(max);
    }
}
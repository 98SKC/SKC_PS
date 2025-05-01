
import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static ArrayList<Integer>[] edge;
    static boolean[] isCycle; //순환인가?
    static int[] dist; //거리

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        
        // 인접 리스트 초기화
        edge = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge[a].add(b);
            edge[b].add(a);
        }

        // 사이클 표시 배열 초기화
        isCycle = new boolean[N + 1];

        // 사이클(순환선) 탐지:
        // 모든 노드 i에서 시작하여, i로 다시 돌아오는 경로가 있는지 DFS.
        // 확인되면 isCycle에 남아있는 경로 상의 노드들이 순환선이 된다.
        for (int i = 1; i <= N; i++) {
            if (checkCycle_dfs(i, i, i)) {
                break;  // 사이클 하나 찾으면 종료
            }
        }

        // 순환선까지 거리 계산을 위한 배열
        dist = new int[N + 1];

        // 각 노드에 대해, 사이클에 속하면 거리 0, 아니면 BFS
        for (int i = 1; i <= N; i++) {
            if (isCycle[i]) {
                dist[i] = 0;
            } else {
                dist[i] = calcDistance(i);
            }
        }


        StringBuilder sb=new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i]+" ");
        }
        System.out.println(sb);
        
    }


    static boolean checkCycle_dfs(int start, int prev, int now) {
        // 현재 노드를 '탐색 경로 상에 포함됨'으로 마킹
        isCycle[now] = true;

        
        // 인접 노드 순회
        for (int next : edge[now]) {
            // 아직 경로에 포함되지 않았다면 재귀 DFS
            if (!isCycle[next]) {
                if (checkCycle_dfs(start, now, next)) {
                    return true;  // 하위에서 사이클 발견되면 즉시 반환
                }
            }
            // 이미 포함된 노드이면서, 이전이랑 다르고, 시작이라면 사이클 확인
            else if (next == start && prev != next) {// 반대로 이미 포함된 노드인데 이전과 같으면 그냥 바로 전에 있던 곳
                return true;
            }
        }

        
        // 경로에서 제외 이 위치까지는 사이클이 아님
        isCycle[now] = false;
        return false;
    }


    static int calcDistance(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            // 한 거리씩 순회
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                // 순환선에 속한 노드면 지금까지의 depth 반환
                if (isCycle[cur]) {// 순환에 속하면
                    return depth;
                }
                // 아니면 인접 노드로 확장
                for (int nx : edge[cur]) {
                    if (!visited[nx]) {
                        visited[nx] = true;
                        q.offer(nx);
                    }
                }
            }
            depth++;
        }
        
        return 0;
    }
}

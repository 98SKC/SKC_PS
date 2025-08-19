import java.io.*;
import java.util.*;

//0-1bfs 연습. Deque를 사용. 가중치가 0이면 front, 가중치가 1이면 back
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 역 수
        int K = Integer.parseInt(st.nextToken()); // 한 튜브가 연결하는 역 개수
        int M = Integer.parseInt(st.nextToken()); // 튜브 수

        // N==1 예외
        if (N == 1) {
            System.out.println(1);
            return;
        }

        // 하이퍼튜브[i]가 거치는 역들
        List<Integer>[] hyperTubes = new ArrayList[M + 1];
        // 역[i]에 정차하는 하이퍼튜브들
        List<Integer>[] stations = new ArrayList[N + 1];

        for (int i = 1; i <= M; i++) hyperTubes[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) stations[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int a = Integer.parseInt(st.nextToken());
                hyperTubes[i].add(a); // i번 튜브가 지나는 a역
                stations[a].add(i);   // a역에 정차하는 i번 튜브
            }
        }

        final int INF = 1_000_000_000;
        int[] distS = new int[N + 1]; // 역까지의 비용(= 역 방문 증가 횟수)
        int[] distT = new int[M + 1]; // 튜브까지의 비용
        Arrays.fill(distS, INF);
        Arrays.fill(distT, INF);

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        // 상태: {type, id}  type: 0=station, 1=tube
        distS[1] = 0;
        dq.addFirst(new int[]{0, 1}); // 역 1에서 시작

        
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int type = cur[0], id = cur[1];

            if (type == 0) { // 지금이 역에있다.
                if (id == N) break; // 0-1 BFS 특성상 도착지에 최초 도달
                // 역 -> 튜브 (비용 0)
                for (int t : stations[id]) {
                    if (distT[t] > distS[id]) {
                        distT[t] = distS[id];
                        dq.addFirst(new int[]{1, t}); // 0비용은 앞으로
                    }
                }
            } else { // 지금이 튜브
                // 튜브 -> 역 (비용 1)
                for (int nxt : hyperTubes[id]) {
                    if (distS[nxt] > distT[id] + 1) {
                        distS[nxt] = distT[id] + 1;
                        dq.addLast(new int[]{0, nxt}); // 1비용은 뒤로
                    }
                }
            }
        }

        if (distS[N] == INF) System.out.println(-1);
        else System.out.println(distS[N] + 1); // 방문 역 수 = (역 방문 증가 횟수) + 1
    }
}


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //한 나라에 N개의 섬이 존재
        //섬은 1번부터 N번까지 
        //1번 섬에는 구명보트만, 다른 섬에는 양들 혹은 늑대들이 살고있다.
        //양들은 구명보트를 타고 늑대가 없는 나라로 이주하기로 함.
        //각 섬에서 1번 섬으로 가는 경로는 유일하며, i번 섬에는 pi 섬으로 가는 다리가 있다.
        //양들은 1번 섬으로 가는 경로로 이동하며, 늑대들은 이동하지 않고 섬으로 들어온 양을 잡아먹는다.
        //늑대 한마리는 최대 한마리의 양을 잡는다.
        //얼마나 많은 양이 1번섬에 도달 가능한가.

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int a, p;
        char t;
        int[] indegree = new int[N+1]; // i로 들어오는 진입 차수 (자식 수)
        int[] edge      = new int[N+1]; // i에서 갈 수 있는 섬 (부모 정보)
        long[] sheep    = new long[N+1]; // 이 지역에 양이 사는 수 (양이면 +, 늑대면 0으로 두고)
        long[] weight   = new long[N+1]; // 가중치 (양이면 0, 늑대면 -늑대수)

        // 입력 파싱: weight는 늑대 수만큼 음수, sheep은 양 수만큼 양수로 초기화
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            t = st.nextToken().charAt(0);    // W면 늑대, S면 양
            a = Integer.parseInt(st.nextToken()); // a마리
            p = Integer.parseInt(st.nextToken()); // i번 섬에서 p번 섬으로 가는 다리

            edge[i] = p;
            indegree[p]++;

            if (t == 'W') {
                weight[i] = -a;
                // sheep[i]는 0으로 남겨둠
            } else {
                // 양 섬이면 weight는 0, sheep에만 기록
                sheep[i] = a;
            }
        }

        // 위상 정렬용 큐: 리프 노드(i>=2 중 자식 수가 0인 섬)부터 시작
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 2; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // 리프부터 부모 방향으로 양을 전파
        while (!q.isEmpty()) {
            int cur = q.poll();

            // 이 섬에서 남은 양 수 계산
            long curSheep = sheep[cur];
            if (weight[cur] < 0) {
                // 늑대가 있던 섬이면 양 잡아먹힘
                curSheep = Math.max(0, curSheep + weight[cur]);
            }
            sheep[cur] = curSheep;

            // 부모 섬으로 전파
            int parent = edge[cur];
            sheep[parent] += curSheep;

            // 부모의 남은 자식 수 감소시키고, 0이 되면 큐에 추가
            if (--indegree[parent] == 0 && parent != 1) {
                q.add(parent);
            }
        }

        // 1번 섬에 모인 양의 수 출력
        System.out.println(sheep[1]);
    }
}

import java.io.*;
import java.util.*;


//주석으로 최대한 생각한거 풀어놓고 git에 넣어서 공부
public class Main {

    public static int[][] parent;          // parent[k][v] = v의 2^k번째 조상
    public static int[] depth;             // 깊이(루트=0)
    public static int[][] minEdge;         // minEdge[k][v] = v -> parent[k][v] 구간 최소 간선
    public static int[][] maxEdge;         // maxEdge[k][v] = v -> parent[k][v] 구간 최대 간선

    public static List<int[]>[] roads;
    public static boolean[] v;
    public static int N,K, LOG;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // LOG 계산: 2^LOG >= N 이 되도록

        LOG = 0;
        while ((1 << LOG) <= N) LOG++;


        parent=new int[LOG][N+1];
        depth =new int[N+1];
        v=new boolean[N+1];

        roads = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) roads[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            roads[A].add(new int[]{B, C});
            roads[B].add(new int[]{A, C});
        }

        K=Integer.parseInt(br.readLine());


        // 루트(1)에서 parent[0], depth 채우기


        v[1] = true;
        minEdge = new int[LOG][N + 1];
        maxEdge = new int[LOG][N + 1];
        parent[0][1] = 0;      // 루트의 부모는 0(없음)
        depth[1] = 0;

        initTree(1);

        // parent[k] 채우기 (Sparse Table)
        for (int k = 1; k < LOG; k++) {
            // parent[k][v]는 v의 '2^k번째 조상(위로 2^k칸 올라간 노드)'을 저장한다.
            // k=0이면 2^0 = 1칸 위 조상(=직계 부모)이고,
            // k=1이면 2칸 위, k=2이면 4칸 위 ... 이런 식으로 커진다.

            for (int node = 1; node <= N; node++) {
                // node에 대해 parent[k][node]를 채우는 과정.

                // mid = node에서 2^(k-1)칸 위로 올라간 조상 (중간만큼 올라감)
                // 즉 mid = parent[k-1][node]
                // 예: k=3이면 (k-1)=2 이므로 mid는 node에서 4칸 위 조상
                int mid = parent[k - 1][node];

                // 핵심 원리:
                // node의 2^k번째 조상은
                // "node의 2^(k-1)번째 조상(mid)의 2^(k-1)번째 조상"과 같다.
                //
                // 수식:
                // parent[k][node] = parent[k-1][ parent[k-1][node] ]
                //
                // 예: 8칸 위(2^3) 조상을 구하려면
                // 4칸 위(2^2)로 한 번 올라가서 mid에 도착하고,
                // 거기서 다시 4칸 위(2^2)로 올라가면 총 8칸 위 조상이 된다.

                // mid == 0 이면:
                // node에서 2^(k-1)칸 위로 가는 도중 루트 위(없음)에 도달했다는 뜻.
                // 그러면 2^k칸 위 조상도 당연히 없으므로 0으로 둔다.
                // 조상이 없으면(0이면) 더 위도 없음
                if (mid == 0) {
                    parent[k][node] = 0;

                    // 올라갈 구간 자체가 성립 안 하므로, 누적에 영향 없게 세팅
                    // (질의에서 이 칸을 쓰는 경우는 사실상 없지만 안전장치)
                    minEdge[k][node] = minEdge[k - 1][node];
                    maxEdge[k][node] = maxEdge[k - 1][node];
                } else {

                    // parent 점화식: 2^k = 2^(k-1) + 2^(k-1)
                    parent[k][node] = parent[k - 1][mid];

                    // "구간 정보" 점화식도 동일하게 '반 + 반'을 합친다.
                    // node -> mid 구간의 min/max는 minEdge[k-1][node], maxEdge[k-1][node]
                    // mid  -> parent[k-1][mid] 구간의 min/max는 minEdge[k-1][mid],  maxEdge[k-1][mid]
                    // 둘을 이어붙인 node -> parent[k][node] 구간의 min/max는:

                    minEdge[k][node] = Math.min(minEdge[k - 1][node], minEdge[k - 1][mid]);
                    maxEdge[k][node] = Math.max(maxEdge[k - 1][node], maxEdge[k - 1][mid]);
                }
                // mid가 0이 아니면:
                // mid에서 2^(k-1)칸 위로 더 올라간 결과를 parent[k][node]에 저장.
            }
        }


        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // lca를 찾는 과정에서 min/max도 같이 누적해서 결과를 만든다
            int[] ans = lca(A, B); // ans[0]=min, ans[1]=max
            sb.append(ans[0]).append(' ').append(ans[1]).append('\n');
        }

        System.out.println(sb);

    }

    // 트리를 돌면서 parent[0][child], depth[child]만 채움

    public static void initTree(int node) {
        for (int[] next : roads[node]) {
            int to = next[0];
            int w  = next[1];

            if (!v[to]) {
                v[to] = true;

                parent[0][to] = node;         // 1칸 위 조상
                depth[to] = depth[node] + 1;  // 깊이

                // to에서 부모(node)로 1칸 올라갈 때 지나가는 간선은 (to-node) 하나뿐
                minEdge[0][to] = w;
                maxEdge[0][to] = w;

                initTree(to);
            }
        }
    }

    //a와 b의 최소 공통 조상을 찾아 반환함
    static int[] lca(int a, int b) {
        int ansMin = Integer.MAX_VALUE;
        int ansMax = 0;

        if (depth[a] < depth[b]) { int t = a; a = b; b = t; }

        // 1) 깊이 맞추기
        int diff = depth[a] - depth[b];
        for (int k = LOG - 1; k >= 0; k--) {
            if ((diff & (1 << k)) != 0) {
                // a를 2^k칸 위로 올리는 "그 구간"의 min/max를 답에 반영
                ansMin = Math.min(ansMin, minEdge[k][a]);
                ansMax = Math.max(ansMax, maxEdge[k][a]);
                a = parent[k][a];
            }
        }

        // 2) 같아지면 끝 (LCA = a)
        // 이미 a를 끌어올리는 동안의 간선들은 누적됨
        if (a == b) return new int[]{ansMin, ansMax};

        // 3) 같이 올리기
        for (int k = LOG - 1; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                // a 쪽 점프 구간 반영
                ansMin = Math.min(ansMin, minEdge[k][a]);
                ansMax = Math.max(ansMax, maxEdge[k][a]);
                a = parent[k][a];

                // b 쪽 점프 구간 반영
                ansMin = Math.min(ansMin, minEdge[k][b]);
                ansMax = Math.max(ansMax, maxEdge[k][b]);
                b = parent[k][b];
            }
        }

        // 4) 마지막 1칸 (a->부모, b->부모)이 LCA로 올라가는 간선 2개
        ansMin = Math.min(ansMin, minEdge[0][a]);
        ansMax = Math.max(ansMax, maxEdge[0][a]);
        ansMin = Math.min(ansMin, minEdge[0][b]);
        ansMax = Math.max(ansMax, maxEdge[0][b]);

        return new int[]{ansMin, ansMax};
    }


}


//import java.io.*;
//import java.util.*;
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
//
//    }
//
//}
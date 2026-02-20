import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //N개의 도시가 동쪽에서 서쪽으로 순서대로 위치
        // 제일 동쪽에 있는 도시는 1번
        // 제일 서쪽에 있는 도시는 N번
        // M개 이하의 도시를 여행
        // 여행경로는 1번으로 시작해서 N으로 끝난다.
        // 1과 N을 포함해서 M개이다.
        // 서쪽에서 동쪽으로 이동 불가. 즉 번호가 증가하는 쪽으로만 이동 가능
        //각 돗에서 다른 도시로 이동하는 코스트가 있음. 코스트의 합이 최대가 되도록

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[]>[] edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            //int 밖에 있는것보다 여기서만 쓴다고 넣어두는걸로 명시하는게 더 좋다는 소리를 들었었는디
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (s > e) continue;          // 서 -> 동 이동 불가 (번호 감소)
            edges[s].add(new int[]{e, c});
        }

        // dp[city][cnt] = cnt개의 도시를 방문해서 city에 도착했을 때 최대 점수

        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) Arrays.fill(dp[i], -1);

        dp[1][1] = 0; // 1번 도시를 방문한 상태(방문 도시 수 1)

        // 방문 도시 수를 1 -> M-1로 늘려가며 여행
        for (int cnt = 1; cnt < M; cnt++) {
            for (int u = 1; u <= N; u++) {
                if (dp[u][cnt] == -1) continue; //이를 통해 1번을 시작으로 도착하는 곳들만 체크

                for (int[] edge : edges[u]) {
                    int v = edge[0];
                    int cost = edge[1];

                    dp[v][cnt + 1] = Math.max(dp[v][cnt + 1], dp[u][cnt] + cost);
                }
            }
        }

        int ans = 0;
        //아 M개 도시방문이 아니라 M개 이하의 도시 방문이였네
        for (int cnt = 2; cnt <= M; cnt++) {   // 1->N이려면 최소 2개 도시 방문
            ans = Math.max(ans, dp[N][cnt]);
        }

        System.out.println(ans);
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
import java.util.*;
import java.io.*;

public class Main {
    static int T, N, K;
    static int goal;
    static List<Integer>[] list;
    static int[] building;
    static int[] inLine;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 건물의 개수
            K = Integer.parseInt(st.nextToken()); // 건물 순서 규칙의 총 개수
            list = new ArrayList[N + 1];
            building = new int[N + 1];
            inLine = new int[N + 1];
            answer = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
                building[i] = Integer.parseInt(st.nextToken()); // i건물의 건설시간
                answer[i] = building[i];
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list[start].add(end);
                inLine[end]++;
            }

            goal = Integer.parseInt(br.readLine()); // 이 건물을 지어야 함.

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (inLine[i] == 0) {
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int build = q.poll(); // build를 짓는다.

                for (int a : list[build]) { // build를 지으면 a를 지을 수 있다.
                    if (--inLine[a] == 0) { // a건물을 짓는데 필요한 건물 하나가 없어짐, 바로 큐에 추가
                        q.add(a);
                    }
                    answer[a] = Math.max(answer[a], answer[build] + building[a]); // 건물 a를 짓는데 필요한 최소 시간 갱신
                }
            }
            sb.append(answer[goal]).append("\n");
        }

        System.out.println(sb);
    }
}
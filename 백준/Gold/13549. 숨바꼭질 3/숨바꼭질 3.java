import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1]; // 오름차순
            }
        });
        
        boolean[] visited = new boolean[100001]; // 방문한 위치를 기록하는 배열
        q.add(new int[]{N, 0});
        
        while (!q.isEmpty()) {
            int[] sub = q.poll();
            int position = sub[0];
            int time = sub[1];
            
            if (position == K) {
                System.out.println(time);
                return;
            }

            if (position < 0 || position > 100000 || visited[position]) {
                continue;
            }

            visited[position] = true;

            // 2배 이동을 먼저 처리 (0초 소요)
            if (position * 2 <= 100000 && !visited[position * 2]) {
                q.add(new int[]{position * 2, time});
            }
            // +1 이동 (1초 소요)
            if (position + 1 <= 100000 && !visited[position + 1]) {
                q.add(new int[]{position + 1, time + 1});
            }
            // -1 이동 (1초 소요)
            if (position - 1 >= 0 && !visited[position - 1]) {
                q.add(new int[]{position - 1, time + 1});
            }
        }
    }
}

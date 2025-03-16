import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        String str;

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] di = new int[] {0, 1, 0, -1};
        int[] dj = new int[] {1, 0, -1, 0};
        int[] sub;
        int ni, nj;
        int len = 0; // 현재 BFS에서 측정한 거리 (최대값 비교 용)
        int max = 0; // 모든 BFS 중의 최대 거리
        
        // 모든 육지를 시작점으로 BFS 실행. 그 가장 먼 두 점을 찾는 로직은 사이클이 없어야함
        for (int i= 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'L') {
                    // 각 시작점마다 방문 배열 초기화
                    boolean[][] v = new boolean[N][M];
                    q.clear();
                    q.add(new int[] {i, j, 0});
                    v[i][j] = true;
                    // 초기 BFS 진행
                    while(!q.isEmpty()){
                        sub = q.poll();
                        // sub[2]는 시작점으로부터의 거리
                        if(len < sub[2]) {
                            len = sub[2];
                        }
                        
                        for (int a = 0; a < 4; a++) {
                            ni = sub[0] + di[a];
                            nj = sub[1] + dj[a];
                            if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == 'L' && !v[ni][nj]) {
                                v[ni][nj] = true;
                                q.add(new int[] {ni, nj, sub[2] + 1});
                            }
                        }
                    }
                    // 각 시작점 BFS 후 최대 거리 비교
                    if(max < len) {
                        max = len;
                    }
                    // len 초기화 후 다음 시작점 탐색
                    len = 0;
                }
            }
        }
        System.out.println(max);
    }
}

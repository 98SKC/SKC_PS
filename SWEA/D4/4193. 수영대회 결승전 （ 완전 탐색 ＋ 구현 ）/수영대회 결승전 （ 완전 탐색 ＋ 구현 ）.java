import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    // 방향 설정: 상, 좌, 하, 우
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); 

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 맵 크기
            int[][] arr = new int[N][N]; // 맵 배열
            boolean[][] visit = new boolean[N][N]; // 방문 여부 확인 배열

            // 맵 정보 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 시작점과 도착점 입력
            st = new StringTokenizer(br.readLine());
            int start_y = Integer.parseInt(st.nextToken());
            int start_x = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int end_y = Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start_y, start_x, 0}); // 시작점 큐에 추가

            int time = N * N; // 최대 시간 설정
            while (!queue.isEmpty()) {
                int[] sub = queue.poll();
                int y = sub[0];
                int x = sub[1];
                int t = sub[2];
                visit[y][x] = true; // 방문 처리

                // 목적지 도달 시 시간 갱신 및 반복 종료
                if (y == end_y && x == end_x) {
                    time = t;
                    break;
                }

                // 상하좌우 이동
                for (int d = 0; d < 4; d++) {
                    int py = y + dy[d];
                    int px = x + dx[d];

                    // 범위 확인 및 방문 여부 검사
                    if (py < 0 || py >= N || px < 0 || px >= N) continue;
                    if (!visit[py][px]) {
                        // 장애물 확인 및 소용돌이 처리
                        if (arr[py][px] == 1) continue;
                        else if (arr[py][px] == 2) {
                            // 소용돌이가 활성화되는 경우 다시 현재 위치에서 대기
                            if ((t) % 3 == 0 || (t) % 3 == 1) {
                                visit[y][x] = true;
                                queue.add(new int[]{y, x, t + 1});
                            } else if ((t) % 3 == 2) {
                                visit[py][px] = true;
                                queue.add(new int[]{py, px, t + 1});
                            }
                        } else {
                            visit[py][px] = true;
                            queue.add(new int[]{py, px, t + 1});
                        }
                    }
                }
            }

            int answer = time == N * N ? -1 : time; // 도달 불가 시 -1, 아니면 시간 출력
            System.out.println("#" + test_case + " " + answer);
        }
    }
}

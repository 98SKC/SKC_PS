
import java.util.*;
import java.io.*;

public class Main{

    public static int[] di = new int[] {0, 1, 0, -1};
    public static int[] dj = new int[] {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dir = 0;
        
        int[][] map = new int[N][N];
        String str;
        int cnt = 0;
        int[] start = new int[2];
        // dir은 0: 가로, 1: 세로
        int[][][] v = new int[N][N][2]; // [i][j][dir]에 도달하는 최소 턴
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(v[i][j], Integer.MAX_VALUE);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[3] - o2[3];
            }
        });
        int[][] goal = new int[3][2];
        int find = 0;
        // 입력에서 'B'와 'E' 좌표 저장 ('B'의 중앙 좌표가 초기 상태)
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'B') {
                    if (find==0) {
                        // 첫 번째 'B' 좌표 기록 (가로면 같은 행, 세로면 다른 행)
                        start[0] = i;
                        start[1] = j;
                        find++;
                    } else if(find==1){
                        // 두 번째 'B'를 만났을 때, 첫 번째와 행이 같으면 가로, 아니면 세로
                        if (start[0] == i) {
                            dir = 0; // 가로
                        } else {
                            dir = 1; // 세로
                        }
                        // 두 번째 'B'가 중앙임. 초기 상태 추가
                        pq.add(new int[] {i, j, dir, 0});
                        v[i][j][dir] = 0;
                        find++;
                    }
                } else if (map[i][j] == 'E') {
                    goal[cnt][0] = i;
                    goal[cnt][1] = j;
                    cnt++;
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        int ni, nj;
        int[] sub;
        while (!pq.isEmpty()) {
            sub = pq.poll();
            
            // 목표 도착 여부 확인 (중심 좌표와 방향이 맞아야 함)
            // 'E'의 중앙은 goal[1]이고, 두 좌표가 같은 행이면 가로, 아니면 세로
            if (sub[0] == goal[1][0] && sub[1] == goal[1][1]) {
                int goalDir = (goal[0][0] == goal[1][0]) ? 0 : 1;
                if (sub[2] == goalDir) {
                    answer = Math.min(answer, sub[3]);
                    break;
                }
            }
            
            if (sub[2] == 0) { // 가로일 때 (중심이 좌우 1칸 필요)
                for (int a = 0; a < 4; a++) {
                    ni = sub[0] + di[a];
                    nj = sub[1] + dj[a];
                    // 가로 통나무는 이동 후 (ni, nj-1), (ni, nj), (ni, nj+1)을 차지하므로
                    // 중앙이 0보다 크고 N-1보다 작은지 체크
                    if (ni >= 0 && ni < N && nj > 0 && nj < (N - 1) && v[ni][nj][sub[2]] > sub[3] + 1) {
                        if (map[ni][nj - 1] != '1' && map[ni][nj] != '1' && map[ni][nj + 1] != '1') {
                            v[ni][nj][sub[2]] = sub[3] + 1;
                            pq.add(new int[] {ni, nj, sub[2], sub[3] + 1});
                        }
                    }
                }
            } else if (sub[2] == 1) { // 세로일 때 (중심이 상하 1칸 필요)
                for (int a = 0; a < 4; a++) {
                    ni = sub[0] + di[a];
                    nj = sub[1] + dj[a];
                    if (ni > 0 && ni < (N - 1) && nj >= 0 && nj < N && v[ni][nj][sub[2]] > sub[3] + 1) {
                        if (map[ni - 1][nj] != '1' && map[ni][nj] != '1' && map[ni + 1][nj] != '1') {
                            v[ni][nj][sub[2]] = sub[3] + 1;
                            pq.add(new int[] {ni, nj, sub[2], sub[3] + 1});
                        }
                    }
                }
            }
            
            // 회전: 중심을 둘러싼 3x3 영역에 장애물이 없어야 함
            boolean rotate = true;
            for (int x = sub[0] - 1; x <= sub[0] + 1; x++) {
                for (int y = sub[1] - 1; y <= sub[1] + 1; y++) {
                    if (x < 0 || x >= N || y < 0 || y >= N || map[x][y] == '1') {
                        rotate = false;
                        break;
                    }
                }
                if (!rotate) break;
            }
            
            int newDir = (sub[2] == 0) ? 1 : 0;
            if (rotate && v[sub[0]][sub[1]][newDir] > sub[3] + 1) {
                v[sub[0]][sub[1]][newDir] = sub[3] + 1;
                pq.add(new int[] {sub[0], sub[1], newDir, sub[3] + 1});
            }
            
        }
        
        System.out.println((answer == Integer.MAX_VALUE) ? 0 : answer);
    }
}

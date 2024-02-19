import java.util.*;
import java.io.*;

public class Main {
    // N: 격자의 크기, M: 상어의 수, K: 냄새가 사라지기까지의 시간
    static int N, M, K;
    static int[][][] sharkPriority; // 각 상어의 이동 우선순위
    static int[][] smellTime; // 각 칸에 남은 냄새의 시간
    static int[][] sharkNumber; // 각 칸에 뿌려진 냄새의 상어 번호
    static int[][] shark; // 각 상어의 위치와 방향 정보 [i][0]i상어의 행, [i][1]i상어의 열 [i][2] i상어의 방향.
    static int[] di = {0, -1, 1, 0, 0}; // 상, 하, 좌, 우 이동에 대한 행 변화량
    static int[] dj = {0, 0, 0, -1, 1}; // 상, 하, 좌, 우 이동에 대한 열 변화량

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int time = 0; // 시간 초기화
        int count;
        // 입력 받기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
   
        smellTime = new int[N + 1][N + 1];
        sharkNumber = new int[N + 1][N + 1];
        sharkPriority = new int[M + 1][5][4];
        shark = new int[M + 1][3];

        // 맵 생성
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n > 0) { // 상어가 있는 경우
                    shark[n][0] = i;
                    shark[n][1] = j;
                    smellTime[i][j] = K;// 냄새는 K시간 지속.
                    sharkNumber[i][j] = n;
                }
            }
        }

        // 상어의 초기 방향 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            shark[i][2] = Integer.parseInt(st.nextToken());
        }

        // 각 상어의 이동 우선순위 입력 받기
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    sharkPriority[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // 시뮬레이션 시작
        while (true) {
           
            
            // 상어 수 세기
            count = 0;
            for (int m = 1; m <= M; m++) {
                if (shark[m] != null) count++;
            }

            if (count == 1) { // 1번 상어만 남은 경우
                break;
            }

            if (time >= 1000) { // 1000초가 넘으면 -1 출력
                time = -1;
                break;
            }

            // 임시 배열로 상어 이동 처리- 
            int[][] tmp = new int[N + 1][N + 1];// 배열을 계속 초기화 해 주어야함.
            for (int m = 1; m <= M; m++) {
                if (shark[m] != null) { // 상어가 존재하는 경우 이동
                    moving(tmp, m);
                }
            }

            // 기존의 냄새 유효기간 갱신
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (smellTime[i][j] > 0) smellTime[i][j]--;
                    if (smellTime[i][j] == 0) sharkNumber[i][j] = 0;// 냄새가 없어 졌으니, 냄새 정보 배열에서 삭제.
                }
            }

            // 이동 후 상어 위치의 냄새 정보 갱신
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (tmp[i][j] > 0) {
                        smellTime[i][j] = K;// 지금 상어 위치에 K초 냄새 유지
                        sharkNumber[i][j] = tmp[i][j];// tmp[i][j]에 상어 번호 정보를 냄새 배열에 저장.
                    }
                }
            }
            time++; // 시간 증가
        }

        System.out.println(time); // 결과 출력
    }

    // 상어 이동 처리 함수
    public static void moving(int[][] tmp, int m) {
        int ni=0, nj=0, d=0;
        boolean check = true; // 냄새가 없는 칸을 찾았는지 여부

        // 냄새가 없는 칸 먼저 탐색
        for (int i = 0; i < 4; i++) {
            d = sharkPriority[m][shark[m][2]][i];//[m] m상어가 [shark[m][2]] shark[m][2]방향일때 우선순위 중 i번째.
            ni = shark[m][0] + di[d];
            nj = shark[m][1] + dj[d];

            // 경계 내부이고, 냄새가 없는 칸이면 이동
            if ((1 <= ni && ni <= N) && (1 <= nj && nj <= N) && sharkNumber[ni][nj] == 0) {
                check = false;
                break;
            }
        }

        // 냄새가 없는 칸이 없으면 자신의 냄새 칸을 찾아서 이동.
        if (check) {
            for (int i = 0; i < 4; i++) {
                d = sharkPriority[m][shark[m][2]][i];//[m] m상어가 [shark[m][2]] shark[m][2]방향일때 우선순위 중 i번째.
                ni = shark[m][0] + di[d];
                nj = shark[m][1] + dj[d];

                // 격자 안쪽이고 자신의 냄새가 있는 칸을 찾아서 이동
                if ((1 <= ni && ni <= N) && (1 <= nj && nj <= N) && sharkNumber[ni][nj] == m) {
                    break;
                }
            }
        }

        // 임시 배열에 상어 위치 갱신
        if (tmp[ni][nj] == 0) { // 다른 상어가 없는 경우
            tmp[ni][nj] = m; 
            shark[m][0] = ni;// 상어 위치정보 갱신.
            shark[m][1] = nj;
            shark[m][2] = d;// 상어 방향 번호 갱신
        } else { // 다른 상어가 있는 경우, 번호가 큰 상어는 제거
            shark[m] = null;// m을 작은 것 부터 채워넣고 있기 때문에 상어가 겹치면 m이 큰 번호.
        }
    }
}
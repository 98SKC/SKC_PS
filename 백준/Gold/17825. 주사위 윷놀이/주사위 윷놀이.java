import java.io.*;
import java.util.*;

public class Main {

    public static int[] dice   = new int[10];
    public static int[] round   = new int[] {
        0, 2, 4, 6, 8, 10,12,14,16,18,
        20,22,24,26,28,30,32,34,36,38,
        40
    };
    public static int[] cross1  = new int[] {0,13,16,19};
    public static int[] cross2  = new int[] {0,22,24};
    public static int[] cross3  = new int[] {0,28,27,26};
    public static int[] cross4  = new int[] {0,25,30,35};
    
    // horse[i][0] = 인덱스, horse[i][1] = map 번호 (0=round,1~3=cross1~3,4=cross4)
    public static int[][] horse = new int[4][2];
    // map[0]=round, map[1]=cross1, …, map[4]=cross4
    public static int[][] map   = new int[5][];
    
    public static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        // map 배열 초기화
        map[0] = round;
        map[1] = cross1;
        map[2] = cross2;
        map[3] = cross3;
        map[4] = cross4;

        // DFS 시작
        dfs(0, 0);
        System.out.println(max);
    }

    
    //https://evecomcom.tistory.com/27 사이트를 참고. 기존에는 map에 끝을 의미로 0을 넣었는데, map이 달라 같은 위치 판별이 안되어 끝 점을 e로 넣는 아이디어.
    public static void dfs(int turn, int sum) {
        if (turn == 10) {
            // 주사위 10번 굴리면 최대 점수 갱신
            max = Math.max(max, sum);
            return;
        }

        c: for (int i = 0; i < 4; i++) {
            // 이미 끝 지점('e')이면 더 이상 이동 불가
            if (horse[i][0] == 'e') continue;

            // 이동 전 원상태 저장
            int origIdx = horse[i][0];
            int origMap = horse[i][1];

            // 분기: round 맵(0)에서 10,20,30 지점일 경우 교차로로 진입
            if (origMap == 0 && origIdx % 5 == 0 && origIdx < 20) {
                horse[i][1] = origIdx / 5;   // 10→1, 20→2, 30→3
                horse[i][0] = 0;             // 해당 교차로 맵의 시작 인덱스
            }

            // 주사위만큼 이동
            horse[i][0] += dice[turn];

            // 범위 벗어나면
            if (horse[i][1] == 0 && horse[i][0] >= map[0].length) {
                // round 맵을 벗어나면 바로 끝
                horse[i][0] = 'e';
            } 
            if (horse[i][1] > 0 && horse[i][1] < 4
                       && horse[i][0] >= map[horse[i][1]].length) {
                // cross1~3 맵 벗어나면 cross4로 합류
                horse[i][0] = horse[i][0] - map[horse[i][1]].length + 1;
                horse[i][1] = 4;
            } 
            if (horse[i][1] == 4 && horse[i][0] >= map[4].length) {
                // cross4도 끝나면 round 맵 0으로 복귀 후 끝 처리
                horse[i][0] = horse[i][0] - map[4].length;
                horse[i][1] = 0;
                if (horse[i][0] > 0) horse[i][0] = 'e';
                else               horse[i][0] = 20;
            }

            // 충돌 검사: 끝('e')이 아닐 때만 같은 맵·같은 인덱스 허용 안 함
            if (horse[i][0] != 'e') {
                for (int k = 0; k < 4; k++) {
                    if (k == i) continue;
                    if (horse[k][1] == horse[i][1]
                     && horse[k][0] == horse[i][0]) {
                        // 충돌 시 원상 복구 후 다음 말로
                        horse[i][0] = origIdx;
                        horse[i][1] = origMap;
                        continue c;
                    }
                }
            }

            // 이동 후 점수 합산 및 재귀
            if (horse[i][0] == 'e') {
                dfs(turn + 1, sum);
            } else {
                dfs(turn + 1, sum + map[horse[i][1]][horse[i][0]]);
            }

            // 백트래킹: 원상 복구
            horse[i][0] = origIdx;
            horse[i][1] = origMap;
        }
    }
}

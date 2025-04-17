import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        int[] di = {1, -1, 0, 0}; // 하, 상, 우, 좌
        int[] dj = {0, 0, 1, -1};

        int robotCount = routes.length;
        int R = 101, C = 101; // 좌표 범위가 1~100

        // 포인트 번호(1~n) → 좌표
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.put(i + 1, new int[]{points[i][0], points[i][1]});
        }
        int[][] m=new int[R][C]; // 위치별 로봇 수 체크용
        // 큐에는 {r, c, 목표 인덱스, 로봇 번호}
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < robotCount; i++) {
            int startPointNum = routes[i][0];
            int[] start = map.get(startPointNum);
            q.add(new int[]{start[0], start[1], 1, i});
            m[start[0]][start[1]]++;
        }
               int turn=0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (m[i][j] > 1) {
                        answer++;
                    }
                }
            }

 
        while (!q.isEmpty()) {
            turn++;
            m = new int[R][C];
            int len = q.size();

            for (int t = 0; t < len; t++) {
                int[] sub = q.poll();
                int robotIdx = sub[3];
                int targetIdx = sub[2];

                // 현재 목표 포인트 번호
                int targetPointNum = routes[robotIdx][targetIdx];
                int[] target = map.get(targetPointNum);
                int gi = target[0];
                int gj = target[1];

                // 현재 위치 == 목표 좌표
                if (sub[0] == gi && sub[1] == gj) {
                    if (targetIdx == routes[robotIdx].length - 1) {
                        continue; // 운송 완료
                    } else {
                        // 다음 목표 인덱스 설정
                        sub[2]++;
                        targetPointNum = routes[robotIdx][sub[2]];
                        target = map.get(targetPointNum);
                        gi = target[0];
                        gj = target[1];
                    }
                }

                int dis = Math.abs(sub[0] - gi) + Math.abs(sub[1] - gj);
                boolean moved = false;

                for (int a = 0; a < 4; a++) {
                    int ni = sub[0] + di[a];
                    int nj = sub[1] + dj[a];
                    if (ni >= 1 && ni <= R && nj >= 1 && nj <= C) {
                        int nextDis = Math.abs(ni - gi) + Math.abs(nj - gj);
                        if (nextDis < dis) {
                            
                            
                            
                            q.add(new int[]{ni, nj, sub[2], sub[3]});
                            m[ni][nj]++;
                            break;
                        }
                    }
                }
            }

            
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (m[i][j] > 1) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}

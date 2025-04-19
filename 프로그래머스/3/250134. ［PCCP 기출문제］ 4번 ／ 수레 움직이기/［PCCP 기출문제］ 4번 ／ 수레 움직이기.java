class Solution {
    public int answer = Integer.MAX_VALUE;
    public int N, M;
    public int[] di = new int[]{0, 1, 0, -1}; // 방향 벡터 (우, 하, 좌, 상)
    public int[] dj = new int[]{1, 0, -1, 0};
    public int[][] map;
    public boolean[][] red, blue;

    public int solution(int[][] maze) {
        map = maze;
        N = maze.length;
        M = maze[0].length;
        red = new boolean[N][M]; // 빨간 수레의 방문 여부
        blue = new boolean[N][M]; // 파란 수레의 방문 여부

        int startRI = -1;
        int startRJ = -1;
        int startBI = -1;
        int startBJ = -1;

        // 시작 위치 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    startRI = i;
                    startRJ = j;
                } else if (map[i][j] == 2) {
                    startBI = i;
                    startBJ = j;
                }
            }
        }
        red[startRI][startRJ]   = true;
        blue[startBI][startBJ]  = true;
        // DFS 호출 (초기 위치와 턴 수 0부터 시작)
        dfs(startRI, startRJ, startBI, startBJ, 0);
        if (answer == Integer.MAX_VALUE) answer = 0; // 도달 불가능한 경우

        // n*m 퍼즐판. 빨강(Red)과 파랑(Blue) 수레가 하나씩.
        // 시작 위치에서 도착 칸까지 이동
        // 모든 수레를 도착 칸으로 이동시키면 퍼즐 풀림
        // 상하좌우 이동. 벽 혹은 격자판 밖 이동 불가
        // 이미 방문한 위치는 이동 불가
        // 도착하면 더 이상 움직이지 않음
        // 두 수레가 같은 칸에 있을 수 없음
        // 서로 위치 교환도 불가(서로 바꿔치는 동작도 금지)

        return answer;
    }

    public void dfs(int redI, int redJ, int blueI, int blueJ, int turn) {
        // System.out.println(redI + " " + redJ + " " + blueI + " " + blueJ + " " + turn);
        if(turn>answer) return;
        // 양쪽 모두 목적지에 도달했으면 최소 턴 갱신
        if (map[redI][redJ] == 3 && map[blueI][blueJ] == 4) {
            answer = Math.min(answer, turn);
           // System.out.println("도착. 최소 턴: " + answer);
            return;
        }

        int ri, rj;
        int bi, bj;

        // red 수레 이동 시도
        for (int a = 0; a < 4; a++) {
            if (map[redI][redJ] != 3) { // 도착하지 않았으면 이동
                ri = redI + di[a];
                rj = redJ + dj[a];
            } else { // 도착했으면 멈춤
                ri = redI;
                rj = redJ;
            }

            // red가 이동 가능한지 체크
            if (ri >= 0 && ri < N && rj >= 0 && rj < M//격자 안이고
                    && map[ri][rj] != 5//벽이 아니며
                    && (!red[ri][rj] || map[ri][rj] == 3)) {// 방문안했거나, 해당 위치가 도착지면
                red[ri][rj] = true;

                // blue 수레 이동 시도
                for (int b = 0; b < 4; b++) {
                    if (map[blueI][blueJ] != 4) { // 도착하지 않았으면 이동
                        bi = blueI + di[b];
                        bj = blueJ + dj[b];
                    } else { // 도착했으면 멈춤
                        bi = blueI;
                        bj = blueJ;
                    }

                    // blue가 이동 가능한지 체크
                    if (bi >= 0 && bi < N && bj >= 0 && bj < M//격자 안이고
                            && map[bi][bj] != 5//벽이 아니며
                            && (!blue[bi][bj] || map[bi][bj] == 4)) {// 방문 안했거나, 도착지이면

                        // 자리 교환 금지, 같은 칸 금지 조건
                        if (!(ri == blueI && rj == blueJ && bi == redI && bj == redJ)
                                && !(ri == bi && rj == bj)) {
                            blue[bi][bj] = true;
                            dfs(ri, rj, bi, bj, turn + 1); // 다음 턴으로 이동
                            blue[bi][bj] = false;
                        }
                    }
                    if(map[blueI][blueJ] == 4) break;//파란 수레가 도착해있다면 다른 방향은 x
                }

                red[ri][rj] = false;
            }

            // red가 도착했으면 더 이상 다른 방향 탐색하지 않음
            if (map[redI][redJ] == 3) break;
        }
    }
}

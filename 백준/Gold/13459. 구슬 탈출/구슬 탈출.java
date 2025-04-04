
import java.util.*;
import java.io.*;

public class Main{
    
    // 상태 정보를 저장하는 클래스 (빨간 구슬, 파란 구슬 위치와 기울인 횟수)
    static class State {
        int rx, ry, bx, by, count;
        public State(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }
        
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        char[][] map = new char[N][M];
        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;
        
  
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                // .은 빈칸, #은 벽, O는 구멍, R은 빨간 구슬, B는 파란 구슬
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    map[i][j] = '.';
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                    map[i][j] = '.';
                }
            }
        }
        
        
        ArrayDeque<State> q = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[N][M][N][M];//방문배열. 근데 의미가 있나? 완전 왔다갔다는 고를 수 있겠다.
        q.add(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;
        
        // 이동 방향: 왼쪽, 오른쪽, 위, 아래
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.count >= 10)
                continue;
            
            for (int i = 0; i < 4; i++) {
                int[] redResult = moveBall(map, cur.rx, cur.ry, dx[i], dy[i]);
                int[] blueResult = moveBall(map, cur.bx, cur.by, dx[i], dy[i]);
                
                // 파란 구슬이 구멍에 빠지면 해당 방향은 무시
                if (map[blueResult[0]][blueResult[1]] == 'O')
                    continue;
                // 빨간 구슬만 구멍에 빠지면 성공!
                if (map[redResult[0]][redResult[1]] == 'O') {
                    System.out.println(1);
                    return;
                }
                
                // 파란게 먼저일지 빨간게 먼저일지 애매하니까 다 이동시킨 상태에서
                // 두 구슬이 같은 칸에 있으면, 더 많이 이동한 구슬을 한 칸 뒤로 이동시킴
                if (redResult[0] == blueResult[0] && redResult[1] == blueResult[1]) {
                    if (redResult[2] > blueResult[2]) {
                        redResult[0] -= dx[i];
                        redResult[1] -= dy[i];
                    } else {
                        blueResult[0] -= dx[i];
                        blueResult[1] -= dy[i];
                    }
                }
                
                if (!visited[redResult[0]][redResult[1]][blueResult[0]][blueResult[1]]) {
                    visited[redResult[0]][redResult[1]][blueResult[0]][blueResult[1]] = true;
                    q.add(new State(redResult[0], redResult[1], blueResult[0], blueResult[1], cur.count + 1));
                }
            }
        }
        
        System.out.println(0);
    }
    
    // 주어진 방향(dx, dy)으로 구슬을 벽에 부딪히거나 구멍에 빠질 때까지 이동시킴.
    static int[] moveBall(char[][] map, int x, int y, int dx, int dy) {
        int moves = 0;
        while (map[x + dx][y + dy] != '#' && map[x][y] != 'O') {
            x += dx;
            y += dy;
            moves++;
            if (map[x][y] == 'O')
                break;
        }
        return new int[]{x, y, moves};
    }
}

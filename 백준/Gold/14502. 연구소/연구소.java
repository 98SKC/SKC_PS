import java.io.*;
import java.util.*;

// 바이러스 위치를 표현하는 클래스를 생성.
class virus {
    int y;
    int x;

    public virus(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int n, m; // 지도의 크기를 나타내는 변수들
    static int[][] map; // 지도 정보를 저장하는 2D 배열
    static boolean[][] visit; // 방문 여부를 저장하는 2D 배열
    static int answer = Integer.MIN_VALUE;
    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, 1, -1}; // 상하좌우 이동을 위한 배열

    public static void main(String[] args) throws Exception {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visit = new boolean[n][m];
        
        // 입력을 받아 지도 정보 초기화
        for (int i = 0; i < n; i++) {
        	st=new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0); // DFS를 통한 벽 설치 시뮬레이션 시작. 벽 설치는 DFS

        System.out.println(answer); // 최종 결과 출력
    }

    // 벽을 설치하는 모든 경우의 수를 탐색하는 DFS 메서드
    public static void dfs(int depth) {// 파라미터는 설치된 벽의 개수.
        if (depth == 3) { // 벽 3개가 설치되면 BFS로 바이러스 확산 시뮬레이션 수행. 바이러스는 BFS
            bfs();
            return;
        }
 
        // 지도 전체를 탐색하며 벽을 설치할 수 있는 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1; // 벽 설치
                    dfs(depth + 1); // 다음 벽 설치
                    map[i][j] = 0; // 백트래킹으로 설치된 벽을 제거.
                }
            }
        }
    }
 
 // BFS를 이용해 바이러스가 확산되는 과정을 시뮬레이션하는 메서드
    public static void bfs() {
    	int safe=0;
        int[][] virus_map = new int[n][m]; // 바이러스가 퍼진 후의 상태를 저장할 새로운 지도
        Queue<virus> queue = new ArrayDeque<>(); // 바이러스의 위치를 관리하기 위한 큐

        // 현재 지도의 상태를 복사하여 벽이 세워진 새로운 지도를 생성
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virus_map[i][j] = map[i][j];
            }
        }

        // 바이러스의 초기 위치를 큐에 추가. 이 위치들부터 확산 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus_map[i][j] == 2) {
                    queue.add(new virus(i, j)); // 바이러스 위치를 큐에 추가
                }
            }
        }

        // 큐가 빌 때까지 바이러스 확산 시뮬레이션 수행
        while (!queue.isEmpty()) {
            virus poll = queue.poll(); // 큐에서 바이러스 위치를 하나 꺼냄
            for (int i = 0; i < 4; i++) { // 상하좌우 네 방향으로 확산 가능 여부 검사
                int ny = poll.y + y[i];
                int nx = poll.x + x[i];
                if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
                    if (virus_map[ny][nx] == 0) {
                        virus_map[ny][nx] = 2; // 빈 공간을 바이러스가 차지
                        queue.add(new virus(ny, nx)); // 새로운 바이러스 위치를 큐에 추가, 이 위치에서도 확산 계속
                    }
                }
            }
        }
        
        //안전 영역을 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus_map[i][j] == 0) {
                	safe++; // 안전 영역 카운트
                }
            }
        }
        answer = Math.max(answer, safe); // 최대 안전 영역 크기 업데이트
    }

   
}
import java.util.*;
import java.io.*;

// 지뢰찾기 게임의 메인 로직을 포함하는 클래스
public class Solution {

    // 지도, 방문 여부, 지도의 크기, 이동 방향(8방향), 정답(클릭 횟수)을 저장하는 변수 선언
    static char[][] map;
    static boolean[][] visit;
    static int N;
    static int[] di = {-1,-1,0,1,1,1,0,-1}; // 상, 상우, 우, 우하, 하, 하좌, 좌, 좌상 방향
    static int[] dj = {0,1,1,1,0,-1,-1,-1};
    static int answer;

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); 
        
        for(int tc = 1; tc <= T; tc++) {
            answer = 0; // 클릭 횟수 초기화
            N = Integer.parseInt(br.readLine()); // 지도의 크기
            map = new char[N][N]; // 지도 배열 초기화
            visit = new boolean[N][N]; // 방문 여부 배열 초기화
            
            // 지도 정보 입력 받기
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String line = st.nextToken();
                for(int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j); // '.'은 빈 칸, '*'는 지뢰
                }
            }
            
            // 모든 칸을 순회하면서 주변에 지뢰가 없는 칸을 시작점으로 BFS 수행
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {// 눌러서 확 펴지는 범위를 여기서 다 체크하고 감
                    if(bomb(i, j) == 0 && map[i][j] != '*' && !visit[i][j]) {
                        answer += 1; // 클릭 횟수 증가
                        bfs(i, j); // 주변을 탐색하여 안전지대 영역 확장
                    }
                }
            }
            
            // 지뢰가 아닌 나머지 칸에 대해 주변 지뢰 개수 표시
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == '.') {
                        map[i][j] = (char)(bomb(i, j) + '0'); // 주변 지뢰 개수 계산하여 저장
                        visit[i][j] = true;
                        answer += 1; // 클릭 횟수 증가
                    }
                }
            }

            // 결과 출력
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    
    // 주변에 폭탄의 개수를 확인하는 메서드
    static public int bomb(int r, int c) {
        int cnt = 0; // 주변 지뢰 개수 카운트
        for(int d = 0; d < 8; d++) { // 8방향 탐색
            int ni = r + di[d];
            int nj = c + dj[d];
            if(ni >= 0 && ni < N && nj >= 0 && nj < N) { 
                if (map[ni][nj] == '*') { // 지뢰가 있는 경우
                    cnt += 1;
                }
            }
        }
        return cnt; // 주변 지뢰 개수 반환
    }
    
    // BFS를 통해 지뢰가 아닌 영역을 확장하는 메서드
    static public void bfs(int r, int c) {
        ArrayDeque<char[]> deq = new ArrayDeque<>(); // BFS를 위한 큐
        visit[r][c] = true; // 시작점 방문 처리
        deq.offer(new char[] {(char) (r + '0'), (char) (c + '0')}); // 시작점 큐에 추가
        
        while(!deq.isEmpty()) {
            char[] oj = deq.poll(); // 현재 위치
            int i = oj[0] - '0'; // 행 위치
            int j = oj[1] - '0'; // 열 위치
            int cnt = bomb(i, j); // 주변 지뢰 개수 계산
            map[i][j] = (char)(cnt + '0'); // 주변 지뢰 개수 표시
            if (cnt > 0) { // 주변에 지뢰가 있는 경우 더 이상 확장하지 않음
                continue;
            }
            // 주변에 지뢰가 없는 경우 8방향 탐색하여 영역 확장
            for(int d = 0; d < 8; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if(ni >= 0 && ni < N && nj >= 0 && nj < N && !visit[ni][nj] && map[ni][nj] != '*') {
                    visit[ni][nj] = true; // 방문 처리
                    deq.offer(new char[] {(char)(ni + '0'), (char)(nj + '0')}); // 큐에 추가
                }
            }
        }
    }
}
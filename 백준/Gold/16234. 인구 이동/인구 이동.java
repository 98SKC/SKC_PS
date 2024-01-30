import java.util.*;
import java.io.*;

public class Main {
    // 좌표를 나타내는 Point 클래스
    public static class Point {
        int x; 
        int y; 
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int N, L, R; 
    static int[][] map; 
    static boolean[][] visited; // BFS 탐색 중 방문 여부를 확인하는 배열
    static int[] dx = {0, 1, 0, -1}; 
    static int[] dy = {1, 0, -1, 0}; 
    static ArrayList<Point> list; // 인구 이동이 필요한 노드 리스트

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        //각 나라의 인구 수 입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(move());
    }
    
    // 더 이상 인구 이동이 일어나지 않을 때까지 반복하는 메서드
    public static int move() {
        int day = 0; // 이동 일수
        while(true) {
            boolean isMove = false; // 인구 이동 발생 여부
            visited = new boolean[N][N]; // 방문 배열 초기화

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        int sum = bfs(i, j); // BFS 탐색으로 열릴 수 있는 국경선 확인하며 인구 이동할 총 인구수 반환
                        if(list.size() > 1) { // 연합이 형성된 경우
                            movingPeople(sum); // 열린 국경선 내의 노드들 인구 변경
                            isMove = true;
                        }    
                    }
                }
            }
            if(!isMove) return day; // 더 이상 인구 이동이 없으면 반복 중지
            day++;
        }
    }
    
    // BFS를 이용한 인구 이동 가능 여부 및 이동 인구 계산
    public static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        list = new ArrayList<>();
        
        q.offer(new Point(x, y)); // 큐에 시작점 추가
        list.add(new Point(x, y)); // 연합 리스트에 시작점 추가
        visited[x][y] = true; // 방문 처리
        
        int sum = map[x][y]; // 시작점의 인구수
        while(!q.isEmpty()) {
            Point current = q.poll();
            
            // 4방향 탐색
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int sub = Math.abs(map[current.x][current.y] - map[nx][ny]); 
                    if(L <= sub && sub <= R) { // 조건에 부합하면
                        q.offer(new Point(nx, ny)); // 큐에 추가
                        list.add(new Point(nx, ny)); // 연합 리스트에 추가
                        sum += map[nx][ny]; // 총 인구수에 추가
                        visited[nx][ny] = true; // 방문 처리
                    }        
                }
            }
        }
        return sum; // 연합의 총 인구수 반환
    }
    
    // 연합 내의 모든 나라의 인구를 변경하는 메서드
    public static void movingPeople(int sum) {
        int avg = sum / list.size(); // 평균 인구 계산
        for(Point n : list) {
            map[n.x][n.y] = avg; // 연합 내 모든 나라의 인구를 평균으로 변경
        }
    }
}
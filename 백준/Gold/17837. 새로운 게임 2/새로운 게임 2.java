import java.util.*;
import java.io.*;

public class Main {
    
    // 체스판 위의 말을 나타내는 클래스 정의
    static class Node {
        int pi, pj, dir; // pi, pj는 말의 현재 위치, dir은 이동 방향
        Node up; // 위에 쌓여 있는 말을 가리키는 변수
        
        // 생성자: 말의 위치, 방향, 위의 말 정보를 초기화
        public Node(int pi, int pj, int dir, Node up) {
            this.pi = pi;
            this.pj = pj;
            this.dir = dir;
        }
    }
    
    // 이동 방향을 나타내는 배열 (우, 좌, 상, 하)
    static int[] di = {0, 0, 0, -1, 1};
    static int[] dj = {0, 1, -1, 0, 0};
    
    static int[][] map; // 체스판의 각 칸의 색 정보
    static Node[] node; // 각 말의 정보를 담고 있는 배열
    static ArrayList<Integer>[][] pos; // 각 위치에 쌓인 말들의 정보를 저장하는 2차원 리스트 배열
    static int N, K; // 체스판 크기 N, 말의 개수 K

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 체스판 크기와 말의 개수 입력
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N + 1][N + 1]; // 체스판의 색상 정보를 저장할 배열
        node = new Node[K + 1]; // 각 말을 저장할 배열
        pos = new ArrayList[N + 1][N + 1]; // 각 위치에 있는 말들의 리스트
        
        // 체스판의 색상 정보 입력 및 초기화
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                pos[i][j] = new ArrayList<>(); // 각 위치 리스트 초기화
            }
        }

        // 말의 초기 위치 및 방향 정보 입력
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int pi = Integer.parseInt(st.nextToken());
            int pj = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            node[i] = new Node(pi, pj, dir, null); // 각 말 초기화
            pos[pi][pj].add(i); // 말의 위치에 해당 말 번호 추가
        }

        // 최대 1000턴 동안 게임 진행
        for (int turn = 1; turn <= 1000; turn++) {
            for (int i = 1; i <= K; i++) {
                // 말을 이동시키고, 게임이 종료되면 턴 번호 출력 후 종료
                if (moveHorse(i)) {
                    System.out.println(turn);
                    return;
                }
            }
        }

        // 1000턴 내에 게임이 종료되지 않으면 -1 출력
        System.out.println(-1);
    }

    // 말의 이동을 처리하는 메서드
    static boolean moveHorse(int idx) {// 이동하면서 4이상되면 true반환
    	
        Node horse = node[idx]; // 현재 이동할 말의 정보 가져오기
        int ni = horse.pi + di[horse.dir]; // 이동할 위치의 행 번호
        int nj = horse.pj + dj[horse.dir]; // 이동할 위치의 열 번호
        
        // 이동하려는 위치가 체스판을 벗어나거나 파란색 칸인 경우
        if (ni < 1 || ni > N || nj < 1 || nj > N || map[ni][nj] == 2) {
        	if (horse.dir % 2 == 0) {
        	    horse.dir = horse.dir - 1;  // 현재 방향이 짝수일 경우, 반대 방향으로 변경
        	} else {
        	    horse.dir = horse.dir + 1;  // 현재 방향이 홀수일 경우, 반대 방향으로 변경
        	}
        	
        	// 새로운 방향으로 이동할 위치 계산
            ni = horse.pi + di[horse.dir];
            nj = horse.pj + dj[horse.dir];
            if (ni < 1 || ni > N || nj < 1 || nj > N || map[ni][nj] == 2) {
                return false; // 다시 이동하려는 위치도 파란색이거나 범위를 벗어나면 이동하지 않음
            }
        }
        
        moveStack(idx, ni, nj); // 말을 이동시키고 말이 쌓인 경우 처리
        
        return pos[ni][nj].size() >= 4; // 이동 후 말이 4개 이상 쌓이면 게임 종료
    }


    // 말을 이동시키고 쌓인 말을 처리하는 메서드
    static void moveStack(int idx, int ni, int nj) {
        Node horse = node[idx]; // 현재 이동할 말의 정보
        ArrayList<Integer> currentStack = new ArrayList<>(); // 이동할 말과 위에 있는 말들을 담을 리스트
        boolean start = false; // 이동을 시작할지 여부
        
        
        for (int h : pos[horse.pi][horse.pj]) {// 앞에서부터 아래의 말이 있음. idx까지 올라오면 그대부터 start가 활성
            if (h == idx) start = true; // 이동할 말부터 위의 말들을 이동하기 위해 start 활성화
            
            if (start) currentStack.add(h);
            
        }
        
        int size = currentStack.size();

     // 현재 위치에서 idx번 말부터 위의 모든 말을 제거
        for (int i = 0; i < size; i++) {
//        	System.out.println("currentStack.get(i): "+currentStack.get(i));// 결과 1 여기서는 Integer
//          System.out.println("Type of currentStack.get(i): " + currentStack.get(i).getClass().getName());  // 타입 출력       
            pos[horse.pi][horse.pj].remove(currentStack.get(i)); // 하나씩 제거- 말은 중복이 없으니 remove사용
        }
       
        //Integer로 지정한걸 int 로 불러서 Object가 아닌 index로 들어가 배열초과가 일어남
//        for (int h : currentStack) {
//            System.out.println("h: " + h);
//            System.out.println("Type of h: " + h.getClass().getName());  // 타입 출력 -> Cannot invoke getClass() on the primitive type 라 int
//            pos[horse.pi][horse.pj].remove(h); // 하나씩 제거 - 말은 중복이 없으니 remove 사용
//        }
        
     
        // 이동하려는 칸이 빨간색이면 쌓인 순서를 반대로 뒤집음
        if (map[ni][nj] == 1) {
            Collections.reverse(currentStack);
        }

        // 이동하려는 칸으로 말들을 이동시키고 위치 정보 갱신
        for (int h : currentStack) {
            node[h].pi = ni;
            node[h].pj = nj;
            pos[ni][nj].add(h); // 이동한 위치에 말 추가
        }
    }
}
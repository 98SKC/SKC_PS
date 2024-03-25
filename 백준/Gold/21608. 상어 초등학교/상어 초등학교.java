import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
    static class Student implements Comparable<Student>{
        int x;
        int y;
        int cnt;
        int emptyCnt;

        // 학생 위치, 인접한 좋아하는 학생 수, 인접한 빈 자리 수 초기화
        Student(int x, int y, int cnt, int emptyCnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.emptyCnt = emptyCnt;
        }

        // 학생을 비교하기 위한 메서드 (우선순위: 좋아하는 학생 수 > 빈 자리 수 > 행 번호 > 열 번호)
        @Override
        public int compareTo(Student o) {
            if(o.cnt == this.cnt) {
                if(o.emptyCnt == this.emptyCnt) {
                    if (o.x == this.x) {
                        return this.y - o.y;
                    }
                    return this.x - o.x;
                }
                return o.emptyCnt - this.emptyCnt;
            }
            return o.cnt - this.cnt;
        }
    }
    
    static int N;
    
    static int[][] map;
    
    static HashSet<Integer>[] list;
    static int[] student;
    
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        list = new HashSet[N*N+1];
        student = new int[N*N+1];

        for(int i=1; i<=N*N; i++) {
            list[i] = new HashSet<>();
        }

        for(int i=1; i<=N*N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            student[i] = a;

            for(int j=0; j<4; j++) {
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
            }
        }

        map[1][1] = student[1];

        helper();
        getAnswer();
    }

    // 최종 점수를 계산하는 메서드
    public static void getAnswer() {
        int sum = 0;
        for(int x=0; x<N; x++) {
            for(int y=0; y<N; y++) {
                int cnt = 0;
                for(int i=0; i<4; i++) {
                    int nx = x + di[i];
                    int ny = y + dj[i];
                    
                    if(!(0<=nx && nx<N && 0<=ny && ny<N)) continue;
                    if(list[map[x][y]].contains(map[nx][ny])) cnt++;
                }
                switch(cnt) {
                    case 1: sum += 1; break;
                    case 2: sum += 10; break;
                    case 3: sum += 100; break;
                    case 4: sum += 1000; break;
                }
            }
        }

        System.out.println(sum);
    }

    // 학생들을 자리에 배치하는 메서드
    public static void helper() {
        for(int s=2; s<=N*N; s++) {
            setChair(s);
        }
    }

    // 학생의 자리를 결정하는 메서드
    public static void setChair(int a) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] != 0) continue;
                pq.add(getStudent(i, j, a));
            }
        }

        int x = pq.peek().x;
        int y = pq.peek().y;
        map[x][y] = student[a];
    }
    
 // 주어진 위치에 학생을 둘 때의 조건을 계산하는 메서드
    public static Student getStudent(int x, int y, int a) {
        int cnt = 0; // 인접한 좋아하는 학생 수
        int emptyCnt = 0; // 인접한 빈 자리 수

        for(int i=0; i<4; i++) {
            int nx = x + di[i];
            int ny = y + dj[i];

        
            if(0<=nx && nx<N && 0<=ny && ny<N) {
                if(list[student[a]].contains(map[nx][ny])) cnt++;
                if(map[nx][ny] == 0) emptyCnt++;
            }
        }

        return new Student(x, y, cnt, emptyCnt);
    }

   
}
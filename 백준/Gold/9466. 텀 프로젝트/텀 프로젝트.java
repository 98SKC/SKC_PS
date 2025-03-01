import java.io.*;
import java.util.*;

public class Main {
    
    public static int N;                   
    public static int[] student;           
    public static boolean[] visited;       //DFS 방문 여부:한 번이라도 방문하면 true
    public static boolean[] finished;      //해당 노드에 대한 탐색(사이클 판별)이 끝났으면 true. v랑 다른점은 dfs가 끝난 이후의 v라고 생각하면 된다.
    //즉 visited는 그냥 노드를 방문하면 바로 처리고, finished는 이 노드에 대해 dfs를 진행한 적이 있다 라는 의미
    //같은 dfs내에서는 dfs가 끝나기 전에는 아직 true가 아닌상태
    public static int answer;          

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());  
            student = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            
            // 1번 학생부터 N번 학생까지, 각 학생이 선택한 학생 번호 저장
            for (int i = 1; i <= N; i++) {
                student[i] = Integer.parseInt(st.nextToken());
            }
            
            answer = 0; 
            
            // 아직 DFS를 진행하지 않은 학생에 대해 DFS 수행
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) dfs(i);
            }
            
            // 전체 학생 수에서 팀(사이클)에 속한 학생 수를 빼면, 팀에 속하지 않는 학생 수가 나온다.
            sb.append((N - answer) + "\n");
        }
        
        System.out.println(sb);
    }
    

    public static void dfs(int current) {
        visited[current] = true;    // current 학생 방문 표시
        int next = student[current];// current 학생이 선택한 다음 학생
        
        // 다음 학생이 아직 방문되지 않았다면 DFS 수행
        if (!visited[next]) {
        	 	dfs(next);
        }else if (!finished[next]) {            
            // 만약 next가 방문되었는데 아직 finished 되지 않았다면
            // 현재 DFS 경로 내에서 next가 다시 등장하였으므로 사이클 형성
        		// 사이클에 속하는 학생들을 센다.
            // start는 지금 노드의 다음. 즉 사이클의 시작부분. 사이클 시작부분부터 다시 내 위치까지 사이클을 돌면서 카운트를 센다
            for (int start = next; start != current; start = student[start]) {
                answer++;
            }
            answer++;  // current 학생도 사이클에 포함되므로 1 증가
        }
        
        // current 학생에 대한 DFS 탐색을 모두 마쳤음을 표시
        finished[current] = true;
    }
}
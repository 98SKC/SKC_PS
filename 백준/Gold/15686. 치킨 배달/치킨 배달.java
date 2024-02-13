import java.io.*;
import java.util.*;

public class Main {
    static int n, m; // n: 도시의 크기, m: 선택할 수 있는 최대 치킨집의 수

    static ArrayList<int[]> house = new ArrayList<>(); // 모든 집의 위치를 저장하는 배열 리스트
    static ArrayList<int[]> chicken = new ArrayList<>(); // 모든 치킨집의 위치를 저장하는 배열 리스트
   // static ArrayList<int[]> choice = new ArrayList<>(); // 선택된 치킨집의 위치를 저장하는 배열 리스트
    static int[][] choice; 
    
    static int result = Integer.MAX_VALUE; // 최소 치킨 거리를 저장하는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 줄의 입력으로 n과 m을 받는다. n은 도시의 크기, m은 선택할 수 있는 치킨집의 최대 개수를 의미한다.
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        choice=new int[m][2];
        int sub=0;

        // 도시의 지도를 제작. 0은 빈 칸, 1은 집, 2는 치킨집을 나타낸다.
       // map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sub= Integer.parseInt(st.nextToken());
 
                // 집의 위치를 house 리스트에 저장.
                if (sub == 1) {
                    house.add(new int[]{i, j});
                }
    
                // 치킨집의 위치를 chicken 리스트에 저장. 
                if (sub == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        // 백트래킹을 시작하여 최소 치킨 거리를 계산.
        DFS(0, 0);
        System.out.println(result); // 계산된 최소 치킨 거리를 출력.

    }

    // depth는 현재 선택된 치킨집의 개수, start는 탐색을 시작할 치킨집의 인덱스.
    static void DFS(int depth, int start) {
    	//모든 치킨집을 고르면
        if (depth == m) {
           
            // 선택된 치킨집이 m개일 때, 모든 집에 대한 치킨 거리의 합을 계산.
            int sum = 0;
            for (int[] h : house) {
                int min = Integer.MAX_VALUE;
                for (int[] c : choice) {
                    // 각 집과 선택된 치킨집 사이의 거리를 계산. 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|
                    int d = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    // 가장 가까운 치킨집까지의 거리를 탐색.
                    min = Math.min(d, min);
                }
                // 모든 집에 대한 치킨 거리의 합을 구한다.
                sum += min;
            }
            // 현재 선택한 치킨집 조합에 대한 치킨 거리의 합이 이전 조합보다 작으면 업데이트.
            result = Math.min(result, sum);
            return;
        }

        // 가능한 모든 치킨집 조합을 만들기 위해 재귀 수행.
        for (int i = start; i < chicken.size(); i++) {
            choice[depth]=chicken.get(i); // 현재 치킨집을 선택된 치킨집 목록에 추가한다.
            DFS(depth + 1, i + 1); // 다음 치킨집을 선택하기 위해 재귀 호출.
      }
    }
}
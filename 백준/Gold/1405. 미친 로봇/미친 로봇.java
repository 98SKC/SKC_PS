
import java.util.*;
import java.io.*;

public class Main{
    public static int[] di = new int[] {1, -1, 0, 0}; // 동, 서, 남, 북
    public static int[] dj = new int[] {0, 0, -1, 1};
    public static double answer = 0.0;
    public static int N;
    public static double[] arr;
    public static boolean[][] v;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new double[4];
        
        for(int i=0;i<4;i++) {
            arr[i]=Integer.parseInt(st.nextToken()) / 100.0;
        }
        
        v = new boolean[2*N+1][2*N+1];

        v[N][N] = true;

        dfs(N, N, 0, 1.0);

        System.out.print(answer);
    }
    
    public static void dfs(int pi, int pj, int count, double prob) {

        if (count == N) {
            answer += prob;
            return;
        }
        int ni,nj;
        for (int a = 0; a < 4; a++) {
            
            if (arr[a] == 0) continue;
            ni = pi + di[a];
            nj = pj + dj[a];
            
            // 경계 체크 및 해당 위치가 아직 방문되지 않은 경우에만 진행
            if (ni>=0&&ni<=2*N&&nj>=0&&nj<=2*N&&!v[ni][nj]) {
                v[ni][nj] = true;
                dfs(ni, nj, count + 1, prob * arr[a]);
                v[ni][nj] = false;
            }
        }
    }
}

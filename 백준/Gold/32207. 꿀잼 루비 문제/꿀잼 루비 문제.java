
import java.util.*;
import java.io.*;

public class Main{

    public static int[][] map;
    public static int[] di = new int[] {0,1,0,-1};
    public static int[] dj = new int[] {1,0,-1,0};

    public static int N, M, K;


    static class Cell { 
    	int v, i, j; 
    	Cell(int v,int i,int j){
    		this.v=v; this.i=i; this.j=j;
    	} 
    }
    
    static List<Cell> cells = new ArrayList<>();
    static int[] prefix;       
    static int[][] blocked;
    static int best = 0;
    
    

    public static void main(String[] args) throws Exception {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for (int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                cells.add(new Cell(map[i][j], i, j));
            }
        }

        
        cells.sort((a,b) -> Integer.compare(b.v, a.v));
        
        prefix = new int[cells.size()];
        
        for (int i=0;i<cells.size();i++){
            prefix[i] = cells.get(i).v + (i==0 ? 0 : prefix[i-1]);
        }

        blocked = new int[N+1][M+1];

  
        greedyInit();

        dfs(0, 0, 0);

        System.out.println(best);
    }

    // --- 그리디 초기 해: 큰 값부터 가능하면 고르기 ---
    static void greedyInit() {
        int picked = 0, sum = 0;
        List<int[]> touchedAll = new ArrayList<>();
        
        for (int idx=0; idx<cells.size() && picked < K; idx++){
            Cell c = cells.get(idx);
            if (blocked[c.i][c.j]==0) {
                List<int[]> touched = block(c.i, c.j);
                touchedAll.addAll(touched);
                picked++;
                sum += c.v;
            }
        }
        
        best = Math.max(best, sum);
        // 복구
        for (int[] p : touchedAll) blocked[p[0]][p[1]]--;
        
    }


    static void dfs(int idx, int picked, int sum) {
        // 종료 조건
        if (picked == K || idx == cells.size()) {
            if (sum > best) best = sum;
            return;
        }

        int remain = K - picked;
        int last = Math.min(cells.size()-1, idx + remain - 1); // idx..last
        int optimistic = sum + (last >= idx ? (prefix[last] - (idx==0 ? 0 : prefix[idx-1])) : 0);
        if (optimistic <= best) return;


        Cell c = cells.get(idx);
        if (blocked[c.i][c.j]==0) {
            List<int[]> touched = block(c.i, c.j);
            dfs(idx + 1, picked + 1, sum + c.v);
            unblock(touched);
        }

        dfs(idx + 1, picked, sum);
    }




    static List<int[]> block(int i, int j) {
        List<int[]> touched = new ArrayList<>(5);
        touch(i, j, touched);
        for (int d=0; d<4; d++){
            int ni = i + di[d], nj = j + dj[d];
            if (1 <= ni && ni <= N && 1 <= nj && nj <= M) touch(ni, nj, touched);
        }
        return touched;
    }

    static void touch(int i, int j, List<int[]> touched){
        blocked[i][j]++;
        touched.add(new int[]{i,j});
    }

    static void unblock(List<int[]> touched){
        for (int k=touched.size()-1; k>=0; k--){
            int[] p = touched.get(k);
            blocked[p[0]][p[1]]--;
        }
    }
}

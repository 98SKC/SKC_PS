import java.util.*;
import java.io.*;

public class Main {

	static int[] di = new int[] {1, 0, 0, -1};
	static int[] dj = new int[] {0, 1, -1, 0};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        boolean[][] open = new boolean[N][M];
        boolean[][] v = new boolean[N][M];
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < M; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if (arr[i][j] == 1) q.add(i * M + j);
        	}
        }
        
        int p, pi, pj, ni, nj, ci, cj, check, size, time = 0;
        boolean find;
        Queue<Integer> remove;
        while (!q.isEmpty()) {
        	size = q.size();
        	time++;
        	remove = new ArrayDeque<>();
        	
        	// 외부 공기를 탐색하는 BFS
        	for (int i = 0; i < N; i++) {
        		Arrays.fill(open[i], false);
        		Arrays.fill(v[i], false);
        	}
        	Queue<int[]> bfs = new ArrayDeque<>();
        	bfs.add(new int[]{0, 0});
        	v[0][0] = true;
        	
        	while (!bfs.isEmpty()) {
        		int[] current = bfs.poll();
        		int x = current[0];
        		int y = current[1];
        		open[x][y] = true;
        		
        		for (int d = 0; d < 4; d++) {
        			int nx = x + di[d];
        			int ny = y + dj[d];
        			if (nx >= 0 && nx < N && ny >= 0 && ny < M && !v[nx][ny] && arr[nx][ny] == 0) {
        				v[nx][ny] = true;
        				bfs.add(new int[]{nx, ny});
        			}
        		}
        	}

        	// 녹아 없어질 치즈 탐색
        	for (int i = 0; i < size; i++) {
        		p = q.poll();
        		pi = p / M;
        		pj = p % M;
        		check = 0; // 외부 공기와 접촉한 면의 수

        		for (int a = 0; a < 4; a++) {
        			ni = pi + di[a];
        			nj = pj + dj[a];
        			if (ni >= 0 && ni < N && nj >= 0 && nj < M && open[ni][nj]) {
        				check++;
        			}
        		}

        		if (check >= 2) {
        			remove.add(p);
        		} else {
        			q.add(p);
        		}
        	}
        	while (!remove.isEmpty()) {
        		p = remove.poll();
        		pi = p / M;
        		pj = p % M;
        		arr[pi][pj] = 0;
        	}
        }
        
        System.out.println(time);
    }
}
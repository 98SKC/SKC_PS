import java.util.*;
import java.io.*;

public class Main {

	static int[] di=new int[]{0,1,1}; // 회전
	static int[] dj=new int[]{1,1,0};    	
	static int[][] map;
    static int N;
    
    public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 1; j <= N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        ArrayDeque<int[]> q = new ArrayDeque<>(); // 0-head i 위치, 1-head j 위치, 2- 방향
        q.add(new int[]{1, 2, 0}); // 시작 위치는 (1, 2)에서 가로 방향

        int[] sub;
        int count = 0;
        
        while (!q.isEmpty()) {
        	sub = q.poll();
        	
        	// (N, N)에 도달한 경우
        	if (sub[0] == N && sub[1] == N) {
        		count++;
        		continue;
        	}
        	
        	// 현재 방향에 따른 이동 가능 여부 확인
        	if (sub[2] == 0) { // 가로 상태
        		addIfValid(q, straight(sub[0], sub[1], 0));
        		addIfValid(q, diagonal(sub[0], sub[1]));
        	} else if (sub[2] == 1) { // 대각선 상태
        		addIfValid(q, straight(sub[0], sub[1], 0));
        		addIfValid(q, straight(sub[0], sub[1], 2));
        		addIfValid(q, diagonal(sub[0], sub[1]));
        	} else if (sub[2] == 2) { // 세로 상태
        		addIfValid(q, straight(sub[0], sub[1], 2));
        		addIfValid(q, diagonal(sub[0], sub[1]));
        	}
        }
        
        System.out.println(count);
    }
    
    //1일때만 3방향 벽 체크
    static public int[] straight(int i, int j, int dir) {
    	// 우선 갈 수 있는 곳인지 체크
    	int ni = i + di[dir];
    	int nj = j + dj[dir];
    	if (ni > 0 && ni <= N && nj > 0 && nj <= N && map[ni][nj] != 1) {
    		return new int[] {ni, nj, dir};
    	}
    	return null;
    }
    
    static public int[] diagonal(int i, int j) {
    	for (int dir = 0; dir < 3; dir++) {  	
    		int ni = i + di[dir];
    		int nj = j + dj[dir];
        	if (ni <= 0 || ni > N || nj <= 0 || nj > N || map[ni][nj] == 1) {
        		return null;
        	}
    	}
    	return new int[] {i + 1, j + 1, 1};
    }
    
    static public void addIfValid(ArrayDeque<int[]> q, int[] move) {
        if (move != null) {
            q.add(move);
        }
    }
}
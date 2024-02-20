import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m,count;
	static int[][] map;
	static int[] parents;
	static Queue<int[]> q;
	
	static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return Integer.compare(o1[2], o2[2]); 
		}
	});
	
	static boolean[][] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count =2;
		check = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1 && !check[i][j]) {
					findIsland(j, i, count);
					count++;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]!=0) {
					buildBridge(j, i, map[i][j]);
				}
			}
		}
		
		count--;
		parents = new int[count];
		for(int i=1; i<count; i++) {
			parents[i] = i;
		} 
		int answer = kruskal();
		System.out.println(answer == 0 ? -1 : answer);
		
	}
	
	// 섬 찾아서 count로 표시
	static void findIsland(int x, int y, int cnt) {
		q = new ArrayDeque<>();
		
		
		q.add(new int[] {x,y});
		map[y][x] = cnt;
		check[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int px = p[0];
			int py = p[1];
			
			for(int i=0; i<4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];

				if(nx>=0&& ny>=0 && nx <m && ny < n) {
					if(!check[ny][nx]&&map[ny][nx]==1) {
						map[ny][nx] = cnt;
						check[ny][nx] = true;
						q.add(new int[] {nx,ny});
					}	
				}
			}
		}
	}
    
	// 섬들을 연결할 다리를 모두 만들어 둠. 
	static void buildBridge(int x, int y, int idx) {
		q = new LinkedList<>();	
		check = new boolean[n][m];
		for(int d=0; d<4; d++) {
			q.add(new int[] {x,y,0});
			check[y][x] = true;
			
			while(!q.isEmpty()) {
				int[] p = q.poll();
				int px = p[0];
				int py = p[1];
				int move = p[2];
				
				int nx = px + dx[d];
				int ny = py + dy[d];
				
				if(nx<0 || ny <0 || nx > m-1 || ny > n-1 || check[ny][nx]) continue;
				
				if(map[ny][nx]!=idx) {
					if(map[ny][nx] !=0) {
						int from = idx-1;
						int to = map[ny][nx]-1;
						int bridgeLen = move;
						if(bridgeLen>1) {		
							pq.add(new int[]{from, to, bridgeLen});
							break;
						}
					}else {
						check[ny][nx] = true;
						q.add(new int[] {nx, ny, move+1});
					}
				}
			}
			q.clear();
		}
	}

	// 최소 신장트리-크루스칼로 다리를 최소만 남겨 놓고 삭제.
	static int kruskal() {
		int sum =0;
		int size = pq.size();
		for(int i=0; i< size; i++) {
			int[] node=pq.poll();
			int x = node[0];
			int y = node[1];
			
			if(find(x) != find(y)) {
				sum += node[2];
				union(x,y);
			}
		}
		
		int rx = parents[1];
		for(int i=2; i<count; i++) {
			if(rx != find(parents[i])) {
				return 0;
			}
		}
		
		return sum;
	}
	
	
	static int find(int x) {
		if(parents[x] == x) return x;
		int rx = find(parents[x]);
		return rx;
		
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x<y) {
			parents[y]=x;
		}
		else {
			parents[x] =y;
		}
	}
}
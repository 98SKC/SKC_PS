import java.io.*;
import java.util.*;



class Node {
	int x;
	int y;
	int move; // 이동시간
	int key; // 갖고 있는 키들

	public Node(int x, int y, int move, int key) {
		super();
		this.x = x;
		this.y = y;
		this.move = move;
		this.key = key;
	}

}

public class Main {
	
	static int N, M;
	static char map[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static boolean v[][][];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		v = new boolean[N][M][64]; // a~f까지 키 소유 여부

		int startX = 0, startY = 0;
		
		
		//입력
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					startX = i;
					startY = j;
				}
			}
		}

		bfs(startX, startY);

	}

	
	
	private static void bfs(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		
		q.offer(new Node(x, y, 0, 0));
		v[x][y][0] = true;
		map[x][y] = '.';

		while (!q.isEmpty()) {
			
			Node cur = q.poll();
			
			if (map[cur.x][cur.y] == '1') { // 출구 도착
				System.out.println(cur.move);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#' || v[nx][ny][cur.key]) continue;

				if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') { // 열쇠인 경우
					int key = cur.key | (1 << (map[nx][ny] - 'a'));
					q.offer(new Node(nx, ny, cur.move + 1, key));
					v[nx][ny][key] = true;
				} else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') { // 문인 경우
					boolean check = (cur.key & (1 << (map[nx][ny] - 'A'))) != 0; // 키 존재하는지 체크
					if (check) { // 키가 있으면
						q.offer(new Node(nx, ny, cur.move + 1, cur.key));
						v[nx][ny][cur.key] = true;
					}

				} else { // '.' 혹은 도착지일 경우
					q.offer(new Node(nx, ny, cur.move + 1, cur.key));
					v[nx][ny][cur.key] = true;

				}
			}
		}
		
		System.out.println(-1); // 출구 없당
	}

}
import java.util.*;
import java.io.*;

public class Main {
	static int[][] omoc=new int[19][19];

	static int[][] d=  {{0,1}, {1,0}, {1,1}, {-1,1}};

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st;

		int turn=0;
		int count=1;
		int dx;
		int dy;
		//오목판을 받기 위한 반복
		for(int i=0;i<19;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<19;j++) {
				omoc[i][j]=Integer.parseInt(st.nextToken());
				}
			}

		
		// 탐색을 위한 반복
		for (int i = 0; i < 19; i++) {
		    for (int j = 0; j < 19; j++) {
		        if (omoc[i][j] != 0) {//바둑돌 찾음
		            turn = omoc[i][j];
		            for (int k = 0; k < 4; k++) {
		                count = 1; // 초기화
		                dx = j;//처음 위치
		                dy = i;

		                // 현재 위치에서 한 방향으로 탐색
		                while (true) {//오른쪽 혹은 아래쪽 먼저.
		                    dx += d[k][1];
		                    dy += d[k][0];
		                    if (dx >= 0 && dx < 19 && dy >= 0 && dy < 19 && turn == omoc[dy][dx]) {
		                        count++;
		                    } else {
		                        break;
		                    }
		                }

		                // 처음 위치에서 반대 방향으로 탐색
		                dx = j;
		                dy = i;
		                while (true) {//좌측 탐색.
		                    dx -= d[k][1];
		                    dy -= d[k][0];
		                    if (dx >= 0 && dx < 19 && dy >= 0 && dy < 19 && turn == omoc[dy][dx]) {
		                        count++;
		                    } else {// 가장 좌측, 위쪽 좌표를 유지하기 위해, 벽을 만나면 원래 위치로 돌아온다.
		                    	dx += d[k][1];
			                    dy += d[k][0];
		                        break;
		                    }
		                }

		                // 연속된 돌이 정확히 5개인지 확인
		                if (count == 5) {
		                    // 승리 조건 충족
		                    System.out.println(turn);
		                    System.out.println((dy+1) + " " + (dx+1));
		                    return;
		                }
		            }
		        }
		    }
		}
		System.out.println(0);
	}
}
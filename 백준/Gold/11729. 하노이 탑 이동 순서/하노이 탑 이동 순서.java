import java.io.*;
import java.util.*;
 
public class Main {
	 
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		sb.append((int) (Math.pow(2, N) - 1)).append('\n');// Math.pow(2, N) - 1는 귀납적 증명으로 도출된 하노이 탑 최소 이동 횟수.	
		Hanoi(N, 1, 2, 3);
		System.out.println(sb);
 
	}
 
	/*  변수 정리. 
		start : 출발지 
		mid : 옮기기 위해 이동해야 장소 
		to : 목적지
	 */
 
	//옮기는 원판이 n개라고 할 때, 다른 판에 큰 판이 있는지 확인 안해도 되는 이유는, 이미 거기의 판은 옮길 판의 원판들보다 확실히 크다. 
	public static void Hanoi(int N, int start, int mid, int to) {
		// 이동할 원반의 수가 1개일 경우 시작과 출발만 남겨둔다.
		if (N == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		// A -> C로 옮긴다고 가정할 떄,
		// STEP 1 : N-1(맨 아래 원판 제외하고)개를 A(start)에서 B(mid)로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
		Hanoi(N - 1, start, to, mid);//N-1개를 중간판으로 옮겨야 C로 이동 가능. 그렇기에 N-1의 도착지점이 mid고 남은 mid의 위치가 to가 된다.
		
		// STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.위에서 N-1개가 중간 판으로 옮겨졌다.)
		sb.append(start + " " + to + "\n");
		// STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
		Hanoi(N - 1, mid, start, to);
	}
}
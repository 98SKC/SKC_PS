import java.io.*;
 
public class Main {
 
	public static int[] arr;// 각 행의 열의 위치
	public static int N;
	public static int count = 0;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
 
		nQueen(0);
		System.out.println(count);
 
	}
 
	public static void nQueen(int row) {
		// 마지막 행까지 도달하고, 넘어가면 row가 N이다. 즉 체스판을 넘었으므로 Possibility를 실행하지 않아도 된다.
		if (row == N) {
			count++;
			return;
		}
 
		for (int i = 0; i < N; i++) {//
			arr[row] = i;// 이 행(앞에서부터 n줄. 세로가 된다)의 위치를 다시오면 행의 위치도 다시 대입하여 초기화가 이루어지는 것.
			// 놓을 수 있는 위치일 경우, 행을 바꾸고 재귀호출
			if (Possibility(row)) {
				nQueen(row + 1);
			}
		}
 
	}
 
	public static boolean Possibility(int col) {//col이
 
		for (int i = 0; i < col; i++) {//지금까지 입력된 깊이까지의 행의 위치만 확인하면 된다.
			// 해당 가로줄까지 배치된 1줄부터의 퀸의 열의 위치를 확인.  
			if (arr[col] == arr[i]) {
				return false;
			} 
			
			/*
			  대각선상에 놓여있는 경우 백트래킹.
			 (열의 차와 행의 차의 절댓값이 같을 경우)
			 */
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		
		return true;
	}
}
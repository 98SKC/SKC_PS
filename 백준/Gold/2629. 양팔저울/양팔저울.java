
import java.io.*;
import java.util.*;

public class Main{
	
	static public int N, M;
	static public int[] arr;
	static public boolean[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new boolean[31][15001];

		st = new StringTokenizer(br.readLine());

		for(int i=1; i<=N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++){//구슬은 가벼운 순으로 주어지기에 따로 저장 안하고 바로 탐색
			int target = Integer.parseInt(st.nextToken());
			if(target > 15000) sb.append("N ");//추 30개 다 써도 15000보다 커질 수 없음
			else {
				sb.append((dp[N][target]) ? "Y " : "N ");//dp[n][k] n
			}
		}
		System.out.println(sb);
	}

	//					   추의 인덱스  현 무게
	public static void dfs(int idx, int weight){
		if(dp[idx][weight]) return;// 이미 발견되었으면 스킵
			
		dp[idx][weight] = true;//해당 무게는 찾을 수 있다.
		if(idx==N) return; // 배열 초과 시 리턴
			
		dfs(idx+1, weight);// 추 하나를 올리는 것, 0~N-1 인덱스의 그 추 하나만의 weight 공간은 다 true로 될 것.
		dfs(idx+1, weight+arr[idx+1]);// 지금까지 추와 새로운 추 
		dfs(idx+1, Math.abs(weight-arr[idx+1]));// 반대쪽에 새로운 추. 무게가 오히려 빠짐. 음수가 되면 구슬 올리는 위치가 반대쪽이 된다.
	}
}
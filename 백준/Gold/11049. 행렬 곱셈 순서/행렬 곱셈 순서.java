import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, INF = Integer.MAX_VALUE;
	static int[] data;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		data = new int[n+1];
		StringTokenizer st = null;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			data[i] = a; data[i+1] = b;
		}
		
		dp = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], INF);
		}
		System.out.println(solve(0,n-1));
	}
	static int solve(int pos, int cur) {
		if(pos == cur) return 0;
		if(dp[pos][cur] != INF) return dp[pos][cur];
		
		for(int i=pos; i<cur; i++) {
			int value = solve(pos,i) + solve(i+1, cur) + (data[pos] *data[i+1]*data[cur+1]);
			dp[pos][cur] = Math.min(dp[pos][cur], value);
		}
		
		return dp[pos][cur];
	}
}
import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] arr;
	static int[][] dp;
	static int[] sum;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());
        /*
         * dp[0]=
         * */
        for(int test=1;test<=T;test++) {
        	N=Integer.parseInt(br.readLine());
        	arr=new int[N+1];
        	dp=new int[N+1][N+1];// i~j까지 합칠 경우의 최소값. 우리는 1~N까지 합칠 때 최솟값을 구해야 한다.
        	sum = new int[N + 1];
        	st=new StringTokenizer(br.readLine());
        	for(int i=1;i<=N;i++) {
        		arr[i]=Integer.parseInt(st.nextToken());
        		sum[i] = sum[i - 1] + arr[i];
        	}
        	
        	/*
        	 * dp[i][i]=arr[i]
        	 * dp[i][i+1]=arr[i]+arr[i+1]
        	 * dp[i][i+2]=>
        	 * dp[i][i]+dp[i+1][i+2]+(arr[i]+arr[i+1]+arr[i+2]), -> (i+1)~(i+2)까지의 dp와 arr[1]을 합친경우
        	 * dp[i][i+1]+dp[i+2][i+2]+(arr[i]+arr[i+1]+arr[i + 2]) ->i~(i+1)까지의 dp와 i+2를 합친 경우
        	 * dp[i][i+2]를 구하려면 i~(i+2)에서 하나의 분단점을 정하고, 양 사이드 값을 더하고, 누적합을 더해야한다.
        	 * */
        	
            for (int i = 1; i <= N; i++) { //몇장을 묶을 것인가, 최종적으로는 N장을 묶는 경우까지 가야함
                for (int from = 1; from + i <= N; from++) {// 어디까지 묻기 시작할 것인가
                    int to = from + i;//from부터 i장을 묶은 곳이 to
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int divide = from; divide < to; divide++) {// 분단점을 어디로 했을 경우 최소인가를 찾는다.
                      //form~to까지의 최소값                      from~divede의 최소값   diveide+1~to까지 값   form~to까지의 누적합
                        dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }
            
        	sb.append(dp[1][N]).append("\n");
        	
        }
        System.out.println(sb);
    }
}
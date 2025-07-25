import java.util.*;
import java.io.*;

public class Main {

	static long[] arr;
	static long[] STR;
	static long[] maxSum;
	static long[][] dp;

    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new long[N+1];
        STR = new long[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
        	arr[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
        	STR[i] = Long.parseLong(st.nextToken());
        }
        
        int D = Integer.parseInt(br.readLine());
        dp = new long[D+1][N+1];
        maxSum = new long[D+1];
        for(int i = 1; i <= N; i++) {
        	dp[0][i] = arr[i]; // 0일차의 i랩의 수
        	maxSum[0] += arr[i] * STR[i];
        }
        long sub = 0;
        int answer = 0;
        for(int i = 1; i <= D; i++){ // i일차
    		sub = 0; // 이번 회차에서 가장 크게 힘을 높일 수 있는 경우
    		answer = 0;
    		for(int k = 1; k < N; k++) {
    			if(dp[i-1][k] != 0) { // k를 키웠을 경우 - 있어야 키움, N은 키워도 같음, 0은 안키운경우지만 어차피 0
    				if(sub < STR[k+1] - STR[k]) {
    					answer = k;
    					sub = STR[k+1] - STR[k];
    				}
    			}
    		}
    		if(answer!=0) {
    			for(int k = 1; k <= N; k++) {
    				if(k != answer && k != (answer+1)) {
    					dp[i][k] = dp[i-1][k];
    				} else if(k == answer) {
    					dp[i][k] = dp[i-1][k] - 1;
    				} else if(k == answer + 1) {
    					dp[i][k] = dp[i-1][k] + 1;
    				}
    			}
    		}else {
    			for(int k = 1; k <=N; k++) {
    				dp[i][k] = dp[i-1][k];
    			}
    		}
        	
        	maxSum[i] = maxSum[i-1] + sub;
        	sub = 0;
        	// 1 2 3 4 5
        	//   2 3 4   이렇게 2일간 k를 키웠어    i가 4고  j가 2인경우
        	// 1 2 3 4 5  k가 2랩이였는데, 2일 키웠으니 4가됨.  
    		for(int j = 0; j < i; j++) { //j일부터 지금까지 k를 연속으로 키웠을 경우가 혹시라도 지금보다 점수가 높은가	
    			for(int k = 1; k < N; k++) {
    				if(dp[j][k] == 0) continue; // 이 당시 이 랩 캐릭이 없으면 불가
    				if(k+i-j > N) {
    					sub = maxSum[j] + STR[N] - STR[k];
    				} else {
    					sub = maxSum[j] + STR[k+i-j] - STR[k];
    				} 

    				if(maxSum[i] < sub) {

    	        		for(int p = 1; p < N; p++) {
    	    				if(p != k && p != (k+i-j)) {
    	    					dp[i][p] = dp[j][p];
    	    				} else if(p == k) {
    	    					dp[i][p] = dp[j][p] - 1;
    	    				} else if(p == k + i - j) {
    	    					dp[i][p] = dp[j][p] + 1;
    	    				}
    	    			}
    	        		maxSum[i] = sub;
    				}
    			}
    		}
        }

        System.out.println(maxSum[D]);
        
    }
    
}
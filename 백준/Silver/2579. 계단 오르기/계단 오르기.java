import java.io.*;
import java.util.*;

public class Main {




    public static void main(String[] args) throws Exception {
       
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	int N=Integer.parseInt(br.readLine());
    	int[] arr=new int[N+1];
    	int[] dp=new int[N+1];

    	for(int i=1;i<=N;i++) {
    		arr[i]=Integer.parseInt(br.readLine());
    	}
    	

        if (N >= 1) dp[1] = arr[1];
        if (N >= 2) dp[2] = arr[1] + arr[2];
        if (N >= 3) dp[3] = Math.max(arr[1], arr[2]) + arr[3];

        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }// 두칸 전에서 바로 넘어오는 경우 vs 현위치+앞칸 + 3칸전의 최대값
    	System.out.println(dp[N]);
    }
    
 
    
}

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        //2원과 5원이 무한정 많을 때 동전 개수가 최소가 되도록 거스름돈 주기
        //거스름돈이 n일 경우 
        
        int[] dp=new int[N+1];
        for(int i=1;i<=N;i++) {
        	dp[i]=Integer.MAX_VALUE;
        }
        int[] arr=new int[] {2,5};
        if(N>=2) dp[2]=1;//2원 1개,
        if(N>=4) dp[4]=2;//
        if(N>=5) dp[5]=1;
        int min;
        for(int i=1;i<=N;i++) {
        	min=Integer.MAX_VALUE;
        	for(int j=0;j<arr.length;j++) {
        		if(i-arr[j]>0) {
        			min=Math.min(min, dp[i-arr[j]]);
        		}
        	}
        	if(min!=Integer.MAX_VALUE) dp[i]=min+1;
        }
        
        if(dp[N]!=Integer.MAX_VALUE) {
        	System.out.println(dp[N]);
        }else {
        	System.out.println(-1);
        }
        
        
    }
}

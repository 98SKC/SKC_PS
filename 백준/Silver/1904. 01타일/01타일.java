import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        int[] dp=new int[N+1];
        dp[1]=1;//1		
        if(N>=2) {
        	dp[2]=2;
        }
					
//        dp[2]=2;//11   00					1 1     뒤에 00만 붙임.1100 0000
//        dp[3]=3;//111  100  001				1 0		뒤에 1만 붙임. 1111 1001 0011
//        dp[4]=5;//0011 0000 1001 1100 1111  1 1     결과 : 1100 0000 1111 1001 0011
        for(int i=3;i<=N;i++) {//n=짝수일 때 앞뒤 같은게 1개.
        	dp[i] = (dp[i-1]+dp[i-2])%15746;

        }
        System.out.println(dp[N]);

    }
}
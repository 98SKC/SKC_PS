
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        int N;
        int[] arr=new int[] {1,2,3};
        int[] dp=new int[1000001];
        dp[1]=1;//1
        dp[2]=2;//1+1 2
        dp[3]=4;//1+1+1 2+1 1+2 3
        for(int i=4;i<=1000000;i++) {
        	for(int j=0;j<3;j++) {
        		dp[i]=(dp[i]+dp[i-arr[j]])%1000000009;
        	}
        }
        for(int t=1;t<=T;t++) {
        	N=Integer.parseInt(br.readLine());
        	sb.append(dp[N]+"\n");
        }
        
        System.out.println(sb);
        //정수 N이 주어질 때 1 2 3 의 합으로 나타내는 방법
   
    }
}

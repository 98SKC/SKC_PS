import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());// 일 수
        int M=Integer.parseInt(st.nextToken());// 챕터의 수
        // 일수  페이지   (무게 가치)
        int[] price=new int[M+1];
        int[] weight=new int[M+1];
        int[][] dp=new int[M+1][N+1];
        
        
        for(int i=1;i<=M;i++) {
        	st=new StringTokenizer(br.readLine());
        	weight[i]=Integer.parseInt(st.nextToken());
        	price[i]=Integer.parseInt(st.nextToken());
        }
        
        for(int i=1;i<=M;i++) {//m
        	for(int j=1;j<=N;j++) {
        		if(j<weight[i]) {
        			dp[i][j]=dp[i-1][j];
        		}else {
        			dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+price[i]);
        		}
        	}
        }
        System.out.println(dp[M][N]);
        
        
    }
}
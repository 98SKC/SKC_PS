import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        int N=Integer.parseInt(br.readLine());// 노드의 개수
        int M=Integer.parseInt(br.readLine());// 버스(간선)의 개수
        int INF=100000000;
        int[][] dp=new int[N+1][N+1];
        
        for(int i=0;i<=N;i++) {
        	for(int j=0;j<=N;j++) {
        		if(i==j) dp[i][j]=0;
        		else dp[i][j]=INF;
        	}
        }

      
        int start, end, price;
        for(int i=0;i<M;i++){
        	st=new StringTokenizer(br.readLine());
        	start=Integer.parseInt(st.nextToken());
        	end=Integer.parseInt(st.nextToken());
        	price=Integer.parseInt(st.nextToken());
        	dp[start][end]=Math.min(dp[start][end], price);
        }
        
    
        for(int k=1;k<=N;k++) {//k노드를 경유하는 경우
        	for(int i=1;i<=N;i++) {
        		for(int j=1;j<=N;j++) {
        			dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k][j]);
        		}
        	}
        }
        
        
        for(int i=1;i<=N;i++) {
    		for(int j=1;j<=N;j++) {
    			if(dp[i][j]==INF) sb.append(0+" ");
    			else sb.append(dp[i][j]+" ");
    		}
    		sb.append("\n");
    	}
        System.out.println(sb);
    }
}

import java.util.*;
import java.io.*;

public class Main {

	//1차원 dp는 이해가 되니, 2차원 dp로도 풀어보기.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int T = Integer.parseInt(br.readLine().trim());// 보물상자의 보물의 개수
        
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        for(int t=1;t<=T;t++) {
        	st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int W=Integer.parseInt(st.nextToken());
            
        	int[] weight=new int[N+1];
            int[] price=new int[N+1];
            
            int w,p;
            for(int i=1;i<=N;i++) {
            	st=new StringTokenizer(br.readLine());
            	p=Integer.parseInt(st.nextToken());
            	w=Integer.parseInt(st.nextToken());
            	weight[i]=w;
            	price[i]=p;
            }
            
            //2차원 dp 풀이
            int[][] dp=new int[N+1][W+1];
            
            
            //i보물까지 고려할 때
            for(int i=1;i<=N;i++) {
            	//j무게까지 고려하면
            	for(int j=1;j<=W;j++) {
            		if(j<weight[i]){//지금무게에 해당 보물을 넣을 수 없다면, 이전 값 그대로.
            			dp[i][j]=dp[i-1][j];
            		}else {//넣을 수 있다면 비교
            			dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j - weight[i]] + price[i]);
            		}
            	}
            	
            }
            
            sb.append(dp[N][W]+"\n");
        }

        
        System.out.println(sb);
        
    }
}

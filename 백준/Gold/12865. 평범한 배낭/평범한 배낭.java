import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	int N=Integer.parseInt(st.nextToken());
    	int K=Integer.parseInt(st.nextToken());
    	
    	
    	int[] w=new int[N+1];
    	int[] v=new int[N+1];
    	int[][] dp=new int[N+1][K+1];// N까지의 아이템을 넣는 경우 k무게의 최대값
    	
    	for(int i=1;i<=N;i++) {
    		st=new StringTokenizer(br.readLine());
    		w[i]=Integer.parseInt(st.nextToken());
    		v[i]=Integer.parseInt(st.nextToken());
    		
    	}
    	for(int i=1;i<=N;i++) {
    		
    		for(int j=1;j<=K;j++) {
    			if(j-w[i]>=0){
    				dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
    			}else {
    				dp[i][j]=dp[i-1][j];// 이전 아이템의 무게를 가져온다
    			}
    		}
    	}
    	System.out.println(dp[N][K]);
    	
    }
        
    
}
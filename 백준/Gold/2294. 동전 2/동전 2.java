
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[] dp=new int[K+1];
        int[] coin=new int[N];
        for(int i=0;i<N;i++) {
        	coin[i]=Integer.parseInt(br.readLine());
        }
        int INF=10001;//1원으로 10000을 채우는 경우
        Arrays.fill(dp, INF);
        
        dp[0] = 0;
        
        for(int c:coin) {
        	for(int i=c;i<=K;i++) {
        		dp[i]=Math.min(dp[i-c]+1, dp[i]);
        	}
        }
        
        if(dp[K]!=INF) System.out.println(dp[K]);
        else System.out.println(-1);
        
        
        
    }
}


import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[] coin=new int[N];
        int[] dp=new int[K+1];
        for(int i=0;i<N;i++) {
        	coin[i]=Integer.parseInt(br.readLine());
        }
        dp[0]=1;
        for(int c:coin) {
        	for(int k=c;k<=K;k++) {
        		dp[k]+=dp[k-c];
        	}
        }
        System.out.println(dp[K]);
        
        
        
    }
}

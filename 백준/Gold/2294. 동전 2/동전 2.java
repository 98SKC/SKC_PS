import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        
        //int[] coin=new int[N];
        ArrayList<Integer> coin=new ArrayList<>();
        int[] dp=new int[100001]; 
        dp[0]=0;
        int sub; 
        
        for(int i=1;i<=K;i++) {
        	dp[i]=K+1;
        }
        
        for(int i=0;i<N;i++) {
        	//coin[i]=Integer.parseInt(br.readLine());
        	sub=Integer.parseInt(br.readLine());
        	coin.add(sub);
        	dp[sub]=1;// 각 코인의 값은 그 코인 한개로 만들 수 있음
        	//System.out.println(sub+" "+dp[sub]);
        }
        
        	
        for(int i=1;i<=K;i++) {
        	for(Integer price:coin) {
        		if(i-price>0) dp[i]=Math.min(dp[i-price]+1,dp[i]);
        	}
        	
        }
        //System.out.println(Arrays.toString(dp));
        if(dp[K]==K+1) dp[K]=-1;
        System.out.println(dp[K]);
        
    }
}
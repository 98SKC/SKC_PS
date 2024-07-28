import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] coins=new int[n];
        int[] dp= new int[k+1];
        for(int i=0;i<n;i++) {
        	coins[i]=Integer.parseInt(br.readLine());
        	//dp[coins[i]]=1;
        }
        
        dp[0]=1;// 원래는 이게 없고 위의 주석과 아래의 if 조건이 i-coin>0 이였는데, 차이가 있다.
        for(int coin:coins) {
        	for(int i=1;i<=k;i++) {
            	if(i-coin>=0) {
            		dp[i]+=dp[i-coin];
            	}
            }
        }
        

        System.out.println(dp[k]);
        
       
        
    }
}
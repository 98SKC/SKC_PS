import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int C=Integer.parseInt(st.nextToken());//늘려야하는 목표치의 최솟값
        int N=Integer.parseInt(st.nextToken());
        
        int[][] cost=new int[N][2];
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	cost[i][0]=Integer.parseInt(st.nextToken());//비용
        	cost[i][1]=Integer.parseInt(st.nextToken());//리턴
        	
        }
        
        int[] dp=new int[1001];
        int sub;
        for(int i=1;i<=C;i++) {
        	dp[i]=100001;
        	for(int j=0;j<N;j++) {
        		if(i-cost[j][1]>=0) {//j코스트의 경우를 따지는 중
        			for(int k=i-1;k>=i-cost[j][1];k--) {
        				sub=dp[k]+cost[j][0];
        				dp[i]=Math.min(dp[i], sub);
        			}
        			//문제가  j원 기준으로 cost[i][1]원 전이라고 하면 (i-1)~~~(j-cost[i][1])까지의 최소 배열에서 cost[i][0]을 더한걸 최소비교를 해야함.
        		}else{
        			for(int k=i-1;k>=0;k--) {
        				sub=dp[k]+cost[j][0];
        				dp[i]=Math.min(dp[i], sub);
        			}
        		}
        	}
        }
        /*
        for(int i=0;i<=C;i++) {
        	System.out.print(dp[i]+" ");
        }*/
        System.out.println(dp[C]);
        
    	
    }
}
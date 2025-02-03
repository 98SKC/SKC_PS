import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());// 단원의 수
        int T=Integer.parseInt(st.nextToken()); //가방 무게
        
        
        // 한 단원을 공부하는데 걸리는 시간 = W
        // 한 단원의 점수 =P
        int[] weight=new int[N+1];
        int[] price=new int[N+1];
        int[] dp=new int[T+1];
        
        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	weight[i]=Integer.parseInt(st.nextToken());
        	price[i]=Integer.parseInt(st.nextToken());	
        }
        

        
        for(int i=1;i<=N;i++){// i번째 과목부터 N번째 과목까지 고려한다
        	for(int j=T;j>=weight[i];j--){// T시간을 역탐색으로, i무게가 영향을 줄 무게까지 확인한다.
        		dp[j]=Math.max(dp[j], dp[j-weight[i]]+price[i]);// dp[j]는 가방이 j무게일 때 최대 가치.

        	}
        }
        
        System.out.println(dp[T]);
    }
}
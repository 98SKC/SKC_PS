
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //동전이 k가지 동전이 nk개씩. T원의 지폐를 동전으로 바꾸려 한다.
        
        
        int T=Integer.parseInt(br.readLine());
        int K=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        int[] coin=new int[K];
        int[] num=new int[K];
        int[] dp=new int[T+1];
        for(int i=0;i<K;i++) {
        	st=new StringTokenizer(br.readLine());
        	coin[i]=Integer.parseInt(st.nextToken());
        	num[i]=Integer.parseInt(st.nextToken());
        	
        }
        dp[0]=1;
        for(int i=0;i<K;i++) {//coin[i]의 동전
        	//System.out.println(coin[i]+"원으로");
        	for(int j=T;j>=coin[i];j--) {//j원을 만들 수 있는 경우
        		//System.out.println(j+"원을 만드는");
        		for(int k=1;k<=num[i]&&0<=j-coin[i]*k;k++) {//coin[i]를 k개 가지고 만들 수 있는 경우의 수.
        		//	System.out.println(i+" "+coin[i]+"원 "+k+"개");
        			dp[j]+=dp[j-coin[i]*k];
        		}
        	}
        	
        }
        
       // System.out.println(Arrays.toString(coin));
        //System.out.println(Arrays.toString(num));
        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[T]);
        
        
    }
}

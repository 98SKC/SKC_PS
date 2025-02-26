import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N,M;
        String sub;
        int[] dp;
        int[] price;
        int[] weight;
        StringBuilder sb=new StringBuilder();
        while(true) {
        	st=new StringTokenizer(br.readLine());
        	N=Integer.parseInt(st.nextToken());
            sub=st.nextToken();
            if(N==0&&sub.equals("0.00")) {
            	break;
            }
            price=new int[N];
            weight=new int[N];
            
            sub=sub.replace(".","");
            M=Integer.parseInt(sub);
            dp=new int[M+1];
            
            for(int i=0;i<N;i++) {
            	st=new StringTokenizer(br.readLine());
            	price[i]=Integer.parseInt(st.nextToken());
            	sub=st.nextToken();
            	sub=sub.replace(".","");
            	weight[i]=Integer.parseInt(sub);
            }
            
           // System.out.println("price: "+Arrays.toString(price));
           // System.out.println("weight: "+Arrays.toString(weight));
            //System.out.println();
            
            for(int i=0;i<N;i++) {//i 사탕까지 고려했을 때
            	for(int j=weight[i];j<=M;j++){ //j원
            		dp[j]=Math.max(dp[j], dp[j-weight[i]]+price[i]);
            	}
            }
            
            sb.append(dp[M]+"\n");
            
        }
        System.out.println(sb);
        
    }
}
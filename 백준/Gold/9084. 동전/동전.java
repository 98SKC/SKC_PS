
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        int N,M;
        int[] coin;
        int[] dp;
        for(int t=1;t<=T;t++) {
        	N=Integer.parseInt(br.readLine());//동전의 가지 수
        	coin=new int[N];
        	st=new StringTokenizer(br.readLine());
        	for(int i=0;i<N;i++) {
        		coin[i]=Integer.parseInt(st.nextToken());
        	}
        	//N가지 동전으로 만들어야 할 금액 M
        	M=Integer.parseInt(br.readLine());
        	dp=new int[M+1];
        	dp[0]=1;
        	for(int i=0;i<N;i++){
        		for(int j=1;j<=M;j++) {
        			if(j-coin[i]>=0) {
        				//System.out.println(i+"원을 만드는 "+coin[j]+" 원 전의 개수: "+dp[i-coin[j]]);
        				dp[j]+=dp[j-coin[i]];
        			}
        		}
        	}
        	//System.out.println(Arrays.toString(dp));
        	sb.append(dp[M]+"\n");
        	
        }
        System.out.println(sb);
        
        
        
    }
}

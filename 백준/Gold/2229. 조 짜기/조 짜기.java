

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        int[] students=new int[N+1];
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
        	students[i]=Integer.parseInt(st.nextToken());
        }
        
        
        //정렬된 순서에 맞게 조를 짠다.
        int[] dp=new int[N+1];//i까지 고려했을때, j-0: j가 새로운 조일 때, j-1: j가 조에 편입되어 있을 때
        
        int max=0;
        
        //i학생까지 고려했을 때
        //i학생이 생기면 dp[0][i]는 증가하거나 그대로. 증가한다고 하면 마지막 조에 최소 혹은 최대로 편입이 되는 것. 그대로라면 새로운 조를 짜는 것 
        
        for(int i=1;i<=N;i++) {
        	for(int j=i-1;j>=1;j--) {   
        		max=Math.max(max, Math.abs(students[i]-students[j])+dp[j-1]);
        	}
        	
        	dp[i]=max;
        }

       //System.out.println(Arrays.toString(dp));
       System.out.println(dp[N]);
        
        
       
        
    }
        
}



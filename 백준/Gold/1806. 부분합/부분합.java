import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        int min=Integer.MAX_VALUE;
        int[] arr=new int[N+1];
        int[] preSum=new int[N+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        	if(i==1) {
        		preSum[1]=arr[1];
        	}else {
        		preSum[i]=arr[i]+preSum[i-1];
        	}
        }
        //슬라이드 윈도우 적용
        int left=0;
        for(int i=1;i<=N;i++) {      
        	while(left<i) {
        		if(preSum[i]-preSum[left]>=S) {
        			min=Math.min(min, i-left);
        			left++;
        		}else {
        			break;
        		}
        	}
        }
        
        if(min==Integer.MAX_VALUE) min=0;
        System.out.println(min);
  
        
    }
}
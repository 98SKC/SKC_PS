import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        long max=0;
        long min=0;
        int[] num=new int[N+1];
        
        for(int i=1;i<=N;i++) {
        	num[i]=Integer.parseInt(br.readLine());
        	max=Math.max(num[i], max);
        }
        
        max=max*M;// 가장 오래 걸리는 케이스: 가장 오래 걸리는 자리 *M
        
        long mid=0;
        long sum=0;
        // 이분탐색으로 찾은 시간에 각 심사에서 감당 가능한 사람 수를 합함.
        while(min<=max) {
        	mid=(min+max)/2;
        	sum=0;
        	for(int i=1;i<=N;i++) {
        		sum+=mid/num[i];
        		if(sum>=M) {// 시간내에 감당이 가능하다.
        			break;
        		}
        	}
        	
        	if(sum>=M) {
        		max=mid-1;
        	}else {
        		min=mid+1;
        	}
        	
        	
        }
        System.out.println(min);
    }
}
import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] dp=new int[N+1];
		String[] revers=new String[N+1];
		
//		PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1,int[] o2) {
//				return o1[1]-o2[1];
//			}
//			
//		});
		int min;
		String str;
		revers[1]="1";
		for(int i=2;i<=N;i++) {
			min=Integer.MAX_VALUE;
			str="";
			if(i%3==0) {
				if(min>dp[i/3]+1) str=i+" "+revers[i/3];
				min=Math.min(min, dp[i/3]+1);
			}
			
			if(i%2==0) {
				if(min>dp[i/2]+1) str=i+" "+revers[i/2];
				min=Math.min(min, dp[i/2]+1);
				
		
			}
			
			if(min>dp[i-1]+1) str=i+" "+revers[i-1];
			min=Math.min(min, dp[i-1]+1);
			dp[i]=min;
			revers[i]=str;
		}
		
		System.out.println(dp[N]);
		System.out.println(revers[N]);
	}
	
	

}
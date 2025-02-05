import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());//최대 공부시간
		int K=Integer.parseInt(st.nextToken());//과목 수
		
		
		int[] knap=new int[N+1];
		int[] weight=new int[K];
		int[] price=new int[K];
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			price[i]=Integer.parseInt(st.nextToken());
			weight[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<K;i++) {
			for(int j=N;j>=weight[i];j--) {
				knap[j]=Math.max(knap[j], knap[j-weight[i]]+price[i]);
			}
		}
		
		System.out.println(knap[N]);
	}
	
	
}
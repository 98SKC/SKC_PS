import java.io.*;
import java.util.*;

public class Main {

	
	static int[] arr;
	static int N,S;
	static int answer=0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			N=Integer.parseInt(st.nextToken());
			S=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			arr=new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			helper(0,0);
			if(S==0) answer--;
			System.out.println(answer);
	}
	static void helper(int idx, int sum) {
		
		if(idx==N) {
			if(sum==S) {
				answer++;
			}
			return;
		}
		
		helper(idx+1,sum+arr[idx]);
		helper(idx+1,sum);
		
	}

}
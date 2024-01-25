import java.util.*;
import java.io.*;

public class Main {
	//static List<Integer>[] arr;
	static int[][] arr;
	static int max=0;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		//arr=new ArrayList[N];
		arr=new int[N+1][2];//i 날짜,[i][0] 상담 기간, arr[i][1]=급여
		//arr[1][0]->1일날 손님의 상담 기간  arr[1][1] 1일날 상담시 급여.
		for(int i=1;i<N+1;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		helper(0,1);
		System.out.println(max);
		

	}
	static void helper(int sum,int day) {
		if(day>N) {
			max=Math.max(max, sum);
			return;
		}
		//그날 상담을 받은 경우
		if (day + arr[day][0] <= N + 1) {
	        helper(sum + arr[day][1], day + arr[day][0]);
	    }
		//상담을 받지 않은 경우
		helper(sum,day+1);
		
	}

}
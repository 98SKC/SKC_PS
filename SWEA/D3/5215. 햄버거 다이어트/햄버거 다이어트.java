import java.util.*;
import java.io.*;
class Solution
{
	static int max;
	static int limit;
	static int N;
	static int[] foodCal;
	static int[] foodScore;
	static StringBuilder sb=new StringBuilder();
	public static void main(String args[]) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		
		for(int test_case = 1; test_case <= T; test_case++){
			
			StringTokenizer st;
			max=0;
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			limit=Integer.parseInt(st.nextToken());
			foodCal=new int[N];
			foodScore=new int[N]; 
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				foodScore[i]=Integer.parseInt(st.nextToken());
				foodCal[i]=Integer.parseInt(st.nextToken());
			}
			helper(0, 0, 0);
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void helper(int curPos,int curCal,int curScore) {
		if(curCal>=limit) {return;}
		if(curPos==N) {
			max=Math.max(max, curScore);
			return;
		}else {
			helper(curPos+1,curCal+foodCal[curPos],curScore+foodScore[curPos]);// 지금 음식 추가
			helper(curPos+1,curCal,curScore);//지금 음식 생략
		}

	}
}
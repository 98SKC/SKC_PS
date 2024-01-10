import java.util.*;
import java.io.*;



class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			int sub;
			int sum=0;
			for(int i=0;i<10;i++) {
				sub=Integer.parseInt(st.nextToken());
				if(sub%2==1) sum+=sub;
			}
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");

		}
		System.out.println(sb);
	}
}
import java.util.*;
import java.io.*;



public class Solution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String str="";
		ArrayDeque<Integer> q=new ArrayDeque<>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		int[] arr;
		
		
		int Min=Integer.MAX_VALUE;

		
		int sub, T,min;
		
		boolean check;
		for(int tc=1;tc<=10;tc++) {
			min=Integer.MAX_VALUE;
			check=false;
			arr=new int[8];
			T=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<8;i++) {
				sub=Integer.parseInt(st.nextToken());
				arr[i]=sub;
				min=Math.min(sub, min);
				//q.offer(sub);
			}
			sub=min/15;
			for(int i=0;i<8;i++) {
				arr[i]%=sub;
				q.offer(arr[i]+15);
			}
			
			while(true) {
				for(int i=1;i<=5;i++) {
					sub=q.poll()-i;
					if(sub<=0) {
						q.offer(0);
						check=true;
						break;
					}
					
					q.offer(sub);
				}
				if(check) break;
			}
			
			sb.append("#").append(tc).append(" ");
			while(!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	
	}

}
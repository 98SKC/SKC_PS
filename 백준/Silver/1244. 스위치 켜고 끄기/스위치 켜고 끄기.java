import java.io.*;
import java.util.*;


public class Main {
	static int[] arr;
	static int N;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N+1];
		int gender=0;
		int number=0;
	
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int p=Integer.parseInt(br.readLine());
		
		for(int i=0;i<p;i++) {
			st=new StringTokenizer(br.readLine());
			gender=Integer.parseInt(st.nextToken());
			number=Integer.parseInt(st.nextToken());
			change(gender,number);
		}
		br.close();
		for(int i=1;i<=N;i++) {
			
			sb.append(arr[i]).append(" ");
			if(i%20==0) sb.append("\n");
		}
		System.out.println(sb);
		
		
	}
	static void change(int gender, int number) {
		if(gender==1) {
			for(int i=number;i<=N;i+=number) {
				arr[i]=(arr[i]+1)%2;
			}
		}else {
			int point1 = number - 1;
		    int point2 = number + 1;
		    arr[number]=(arr[number] + 1) % 2; // 중앙 스위치 상태 변경
			while(point1>0&&point2<=N&&arr[point1]==arr[point2]) {
				arr[point1]=(arr[point1]+1)%2;
				arr[point2]=(arr[point2]+1)%2;
				point1--;
				point2++;
			}
		}
	}

}
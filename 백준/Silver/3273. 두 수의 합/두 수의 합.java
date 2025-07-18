import java.io.*;
import java.util.*;

public class Main {
	 
	static public StringBuilder sb=new StringBuilder();
	static public int sub=0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		Arrays.sort(arr);	
		
		int x = Integer.valueOf(br.readLine());
		int count = 0;
		int start = 0;
		int end = n - 1;
		int sum = 0;
		
		while(start < end) {
			sum = arr[start] + arr[end];
			if(sum == x) {
				count++;
			}
			
			if(sum <= x) {
				start++;
			}
			else {
				end--;
			}
		}
		
		
		System.out.println(count);
	}
 

}
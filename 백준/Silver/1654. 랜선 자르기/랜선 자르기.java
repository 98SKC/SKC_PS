import java.io.*;
import java.util.*;
 
public class Main {
 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		int K = Integer.parseInt(st.nextToken()); 
		int N = Integer.parseInt(st.nextToken()); 
 
		int[] arr = new int[K];
		
		long max = 0;
        long count;
        long min = 0; 
		long mid = 0; 
 
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max < arr[i]) {
				max = arr[i];
			}
		}
    
		max+=1; 
		while (min < max) { 
			

			mid = (max + min) / 2;
			count = 0;
			
			for (int i = 0; i < arr.length; i++) {
				count += (arr[i] / mid);
			}
			
			if(count < N) {
				max = mid;
			}else {
				min = mid + 1;
			}
			
		}

		System.out.println(min - 1);
	}
}
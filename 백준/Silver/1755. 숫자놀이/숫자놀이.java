import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
        int count = 0;
		int[] arr = {8,5,4,9,1,7,6,3,2,0};
		

		for(int i = 0; i<10; i++) {
			if(arr[i]>=M && arr[i]<=N) {
				sb.append(arr[i]).append(" ");
				if(++count%10 == 0) sb.append("\n");// ++변수 활용 기억.
			}
			if(arr[i]*10>=M-10) {
		
				for(int k = 0; k < 10; k++) {
					int num = arr[i]*10 + arr[k];
					if(num < 10 || num<M || num>N) continue;
	
					sb.append(num).append(" ");
					if(++count%10 == 0) sb.append("\n");
				}
			}
		}

		System.out.println(sb);

	}

}

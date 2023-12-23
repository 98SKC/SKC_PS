import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int M=0;
	public static int N=0;
	
	public static StringBuilder sb=new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		
		M=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[M];
		
		backTracking(1, 0, arr);
		
		System.out.println(sb);
	}
	
	public static void backTracking(int num, int length, int[] arr) {
	    // 수열의 길이가 M이 되면 출력
	    if (length == M) {
	        for (int i = 0; i < M; i++) {
	            sb.append(arr[i]).append(" ");
	        }
	        sb.append("\n");
	        return;
	    }

	    // num > N이면 종료
	    if (num > N) {
	        return;
	    }

	    arr[length] = num;
	    backTracking(num + 1, length + 1, arr);
	    backTracking(num + 1, length, arr);

	}
	

}
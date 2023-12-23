import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	

	public static int N=0;
	
	public static StringBuilder sb=new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N=Integer.parseInt(br.readLine());
		

		helper(N,1);
		

		System.out.println(sb);
	}
	
	public static void helper(int N,long answer) {
	   if(N==0) {
		   sb.append(answer);
		   return;
	   } 
	   
	   helper(N-1, answer*N);
	   

	}
	

}
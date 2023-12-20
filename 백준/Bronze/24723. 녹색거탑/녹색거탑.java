import java.io.*;
import java.util.*;

public class Main{
	public static Deque<Integer> deque = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
//		int answer=1;
//		for(int i=1;i<=N;i++) {
//			answer=answer*2;
//		}
		
		//System.out.println(answer);
		System.out.println((int)Math.pow(2, N));
	}

}



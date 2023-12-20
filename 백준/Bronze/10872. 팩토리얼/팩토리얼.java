import java.io.*;
import java.util.*;

public class Main{
	public static Deque<Integer> deque = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int answer=1;
		if(N!=0) {
			for(int i=N;i>0;i--) {
				answer=answer*i;
			}
		}		
		System.out.println(answer);
	
	}

}



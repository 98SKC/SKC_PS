import java.io.*;
import java.util.*;

public class Main{
	public static Deque<Integer> deque = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int answer=1;
		int sub=1;
		if(N!=0) {
			for(int i=1;i<=K;i++) {
				answer=answer*N;
				sub=sub*i;
				N--;
			}
			
		}		
		System.out.println(answer/sub);
	
	}

}



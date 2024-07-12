import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		int s = 0;
		 
		if(N%2==1){//홀수
			s=(N+1)*(N/2)+(N/2+1);
			
		}else {
			s=(N+1)*(N/2);
		}

		System.out.println(s);
	}
}
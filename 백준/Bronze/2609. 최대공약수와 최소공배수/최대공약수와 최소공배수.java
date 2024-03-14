import java.io.*;
import java.util.*;
 
public class Main {
 
	public static void main(String[] args) throws Exception {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int answerA=a;
		int b = Integer.parseInt(st.nextToken());
        int answerB=b;
		int c, d;
        
        while (b != 0) {
			c = a % b; // 나머지를 구해준다.
 
			a = b;
			b = c;
		}

		d = a;
 
		System.out.println(d);
		System.out.println(answerA * answerB / d);
 
	}
 

}
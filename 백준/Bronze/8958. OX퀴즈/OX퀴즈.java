import java.util.*;
import java.io.*;
 
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringBuilder sb = new StringBuilder();
 		int test_case = Integer.parseInt(br.readLine()); 
 
		for (int i = 0; i < test_case; i++) {
 
			int cnt = 0; 
			int sum = 0; 
 
			for (byte value : br.readLine().getBytes()) {
				
				if (value == 'O') {
					cnt++;
					sum += cnt;
				} 
				else {
					cnt = 0;
				}
			}
			sb.append(sum).append('\n');
		}
		System.out.println(sb);
 
	}
}
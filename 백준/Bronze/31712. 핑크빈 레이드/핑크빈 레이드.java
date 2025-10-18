import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t1 = Integer.parseInt(st.nextToken()); 
		int d1 = Integer.parseInt(st.nextToken()); 
		
		st = new StringTokenizer(br.readLine());
		int t2 = Integer.parseInt(st.nextToken()); 
		int d2 = Integer.parseInt(st.nextToken()); 
		
		st = new StringTokenizer(br.readLine());
		int t3 = Integer.parseInt(st.nextToken()); 
		int d3 = Integer.parseInt(st.nextToken()); 
		
		int n = Integer.parseInt(br.readLine()) - d1 - d2 - d3; 
		int result = 0;
		
		if (n > 0) { 
			for (int i = 1; ; i++) { 
            	
				if (i % t1 == 0) {
					n -= d1;
				}
				
				if (i % t2 == 0) {
					n -= d2;
				}
				
				if (i % t3 == 0) {
					n -= d3;
				}
				
				if (n <= 0) { 
					result = i;
					break;
				}
			}
		}
		
		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}
}

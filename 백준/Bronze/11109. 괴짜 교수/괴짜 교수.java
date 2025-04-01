import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			if((n * s) < ((n * p) + d)) sb.append("do not parallelize").append("\n");
			else if((n * s) == ((n * p) + d)) sb.append("does not matter").append("\n");
			else sb.append("parallelize").append("\n");
            
		}
		System.out.println(sb);
	}

}
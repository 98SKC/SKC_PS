import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());

 
		if (a != b && b != c && a != c) {
			int max;
			if (a > b) {
				if (c > a) {
					max = c;
				} 
				else {
					max = a;
				}
			}
			else {
				if (c > b) {
					max = c;
				}
				else {
					max = b;
				}
			}
			sb.append(max * 100);
			System.out.println(sb);
		}
		else {
			if (a == b && a == c) {
				sb.append(10000 + a * 1000).append("\n");
			}
			else {
				if(a == b || a == c) {
					sb.append(1000 + a * 100).append("\n");
				}
				else {
					sb.append(1000 + b * 100).append("\n");
				}
			}
			System.out.println(sb);
		}
	}
}
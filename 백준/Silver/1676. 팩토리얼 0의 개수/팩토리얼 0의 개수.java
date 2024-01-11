import java.io.*;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int num = Integer.parseInt(br.readLine());
		int count = 0;
		while (num >= 5) {
			count += num / 5;
			num =num/5;
		}
		System.out.println(count);
	}
 
}
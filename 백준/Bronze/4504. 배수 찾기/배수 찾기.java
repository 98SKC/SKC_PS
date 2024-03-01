import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int N;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)break;
	
			System.out.println((N % n == 0) ? N + " is a multiple of " + n + "." : N + " is NOT a multiple of " + n + ".");
		}
	}
}
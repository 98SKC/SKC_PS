import java.io.*;

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
        
		for (int i = 0; i < T; i++) {
			
            int N = Integer.parseInt(br.readLine());

			for (int j = 2; j <= N; j++) {
				if (N % j == 0) {
					int count = 0;
					while (N % j == 0) {
						N /= j;
						count++;
					}
					System.out.println(j + " " + count);
				}
			}
            
		}
	}
}
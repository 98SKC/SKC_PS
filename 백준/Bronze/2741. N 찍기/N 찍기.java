import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

        
		int i = 1;
		while(i<= N) {
            sb.append(i+"\n");
			i++;
		}
        System.out.println(sb);
	}
}
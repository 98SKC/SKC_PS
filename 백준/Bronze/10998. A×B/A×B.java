import java.io.*;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		     
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int num1 = Integer.parseInt(str[0]);
		int num2 = Integer.parseInt(str[1]);
		System.out.println(num1*num2);
 
	}
 
}
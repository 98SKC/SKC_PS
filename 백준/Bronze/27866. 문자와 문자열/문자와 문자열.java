import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//public class baekJoon_27866 {
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int n = Integer.parseInt(br.readLine())-1;
		
		br.close();
		
		System.out.println(str.charAt(n));
		
		
	}
}
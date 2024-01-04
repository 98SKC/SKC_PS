import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a= Integer.parseInt(br.readLine());
		
		int stick = 64;
		int sub=0;
		int count=0;
		int result = a;

		while (true) {
			if (a == 64) {
				count++;
				break;
			}
			stick /= 2; //
			if (stick <= a) {
				sub += stick; 
				count++;
				if (result == sub) {
					break;
				}
				a -= stick;
			}

		}
		System.out.println(count);

	}

}

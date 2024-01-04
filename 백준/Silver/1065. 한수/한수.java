import java.io.*;
import java.util.*;

public class Main {
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer=0;
		int count=0;
		int number=Integer.parseInt(br.readLine());
		if(number<100) {
			System.out.println(number);
		}else {
			count= 99;
			for (int i = 100; i <= number; i++) {
				int X100 = i / 100; 
				int X10 = (i / 10) % 10; 
				int X1 = i % 10;
 
				if ((X100 - X10) == (X10 - X1)) { 
					count++;
				}
			}
			System.out.println(count);
		}
			
	}
 
}
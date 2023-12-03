import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
	static int a,b,c,e,d,f;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] str=br.readLine().split(" ");
		
		a=Integer.parseInt(str[0]);
		b=Integer.parseInt(str[1]);
		c=Integer.parseInt(str[2]);
		d=Integer.parseInt(str[3]);
		e=Integer.parseInt(str[4]);
		f=Integer.parseInt(str[5]);
		for (int i = -999; i < 1000; i++) {
			for (int j = -999; j < 1000; j++) {
				if(a*i+b*j==c && d*i+e*j==f) {
					System.out.println(i+" "+j);
					System.exit(0);
				}
			}
		}
	}

}

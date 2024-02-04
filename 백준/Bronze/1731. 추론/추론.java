import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num =Integer.parseInt(br.readLine());
		int[] n = new int[num];
		
		

		for (int i = 0; i < n.length; i++) {
			n[i] = Integer.parseInt(br.readLine());
		}
	
		if (n[2] - n[1] == n[1] - n[0])
			System.out.println(n[n.length - 1] + (n[1] - n[0]));
		else
			System.out.println(n[n.length - 1] * (n[1] / n[0]));
	}
}
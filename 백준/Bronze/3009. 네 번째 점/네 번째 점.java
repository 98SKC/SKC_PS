import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int[] spot1 = { in.nextInt(), in.nextInt() };	// 첫 번째 좌표
		int[] spot2 = { in.nextInt(), in.nextInt() };	// 두 번째 좌표
		int[] spot3 = { in.nextInt(), in.nextInt() };	// 세 번째 좌표
 
		
		in.close();
		
		int x;
		int y;
 
	
		if (spot1[0] == spot2[0]) {	
			x = spot3[0];
		}
	
		else if (spot1[0] == spot3[0]) {
			x = spot2[0];
		}

		else {
			x = spot1[0];
		}

		if (spot1[1] == spot2[1]) {
			y = spot3[1];
		}

		else if (spot1[1] == spot3[1]) {
			y = spot2[1];
		}

		else {
			y = spot1[1];
		}
		
		System.out.println(x + " " + y);
		
	}
}
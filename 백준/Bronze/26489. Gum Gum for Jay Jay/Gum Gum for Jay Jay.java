import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		while(sc.hasNext()) {
			count++;
			String string = sc.nextLine();
		}
		System.out.println(count);
		sc.close();
	}
}
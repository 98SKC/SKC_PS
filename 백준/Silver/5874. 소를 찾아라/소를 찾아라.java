import java.util.*;

public class Main {
	public static void main(String[] args) {
		
        Scanner input = new Scanner(System.in);
		
        while (input.hasNext()) {
			String[] line = input.nextLine().split("");
			int count = 0;
			int sum = 0;
			for (int i = 1; i < line.length; i++) {
				if (line[i].compareTo(line[i-1]) == 0) {
					if (line[i].compareTo("(") == 0)
						count++;
					else
						sum += count;
				}
			}
			System.out.println(sum);
		}
        
		input.close();
	}
}
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {	
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		
		int n=scanner.nextInt();
		
		for(int i=0;i<n;i++) {
			int sum=0;
			List<Integer> num1=new ArrayList<Integer>();
			List<Integer> num2=new ArrayList<Integer>();
			
			for(int j=0;j<7;j++) {
				num1.add(scanner.nextInt());
				if(num1.get(j)%2==0) {
					num2.add(num1.get(j));
					sum=sum+num1.get(j);
				}
			}
			System.out.println(sum+" " + Collections.min(num2));
		}
    }
}
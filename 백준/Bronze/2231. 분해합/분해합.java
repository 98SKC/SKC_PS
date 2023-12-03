import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
    
		Scanner in = new Scanner(System.in);
    
		// 자릿수의 길이를 알기위해 일단 문자열로 입력받는다.
		String str_N = in.nextLine();
 
		// 해당 문자열의 길이 변수
		int N_len = str_N.length();
 
		// 문자열을 정수(int)로 변환 
		int N = Integer.parseInt(str_N);
		int result = 0;
 
		
	
		for(int i = (N - (N_len * 9)); i < N; i++) {
			int number = i;
			int sum = 0;	// 각 자릿수 합 변수 
			
			while(number != 0) {
				sum += number % 10;	// 각 자릿수 더하기
				number /= 10;
			}
			

			if(sum + i == N) {
				result = i;
				break;
			}
			
		}
 
		System.out.println(result);
	}
 
}
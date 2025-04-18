import java.io.*;
import java.util.*;


public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int sum = 0;

		//문자열을 배열로
		char[] charArr = str.toCharArray();//문자열을 문자 배열로 바꾸는 메서드
		Arrays.sort(charArr);	//정렬
		int len = charArr.length;

		StringBuilder sb = new StringBuilder();
        
		
		for(int i = len - 1; i >= 0; i--) {
			int num = charArr[i] - '0';
			sum += num;
			sb.append(num);
		}
				
		if(charArr[0] != '0' || sum % 3 != 0) {	// 만약 3의 배수가 아니라면
			System.out.println(-1);
			return;
		}
		
		System.out.println(sb.toString());
	}
}
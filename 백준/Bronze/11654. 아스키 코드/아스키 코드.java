import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		 
		String ch = sc.next();//
		
		int result=ch.charAt(0);// 입력받은 문자가 하나. 변수 ch 문자를 int 형식의 result에 저장.
//		묵시적 형변환.
//		byte -> short  -> int -> long -> float -> double
//		char -> int -> long -> float -> double
//		-> 왼쪽을 오른쪽으로 자동 형변환이 가능함.
//		왼쪽이 작은 데이터 타입, 오른쪽으로 갈 수록 큰 데이터 타입.
//
//		명시적 형변환
//		-> 큰데이터->(큰데이터의 자료형) 작은데이터
//		ex) long a=(long) double b;

		
		System.out.print(result);
	}

}

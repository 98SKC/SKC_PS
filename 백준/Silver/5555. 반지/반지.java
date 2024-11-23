import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String s = scan.next();	// 찾고자 하는 문자열
		int sLen = s.length();	// 문자열 s의 길이
		int N = scan.nextInt();	// 반지의 개수
		String[] str = new String[N];
		String[] str2 = new String[N];
		for(int i=0; i<N; i++)
			str[i] = scan.next();
		for(int i=0; i<N; i++)
			str2[i] = "";

		int count = 0;
		
		for(int i=0; i<N; i++) {
			str2[i] += str[i].substring(str[i].length()-sLen+1, str[i].length());
			str2[i] += str[i];
			str2[i] += str[i].substring(0, sLen-1);
		}

		
		for(int i=0; i<N; i++) {
			// 문자열에 찾고자 하는 문자열(s)가 포함하는 경우
			if(str2[i].contains(s)) {
				count ++;
				continue;
			}
		}
		
		System.out.println(count);
		scan.close();
	}

}
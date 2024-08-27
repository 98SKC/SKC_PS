import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//민국이 점수 총합
		int sumA = 0;
		for (int i = 0; i < 4; i++) {
			sumA += sc.nextInt();
		}

		//만세 점수 총합
		int sumB = 0;
		for (int i = 0; i < 4; i++) {
			sumB += sc.nextInt();
		}
		
		System.out.println(Math.max(sumA, sumB)); //큰 수 출력
		sc.close();
	}

}
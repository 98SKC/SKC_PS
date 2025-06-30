import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 1) 이면수 판정: N ≥ 6, 자릿수 합이 홀수
        int temp = N, digitSum = 0;
        while (temp > 0) {
            digitSum += temp % 10;
            temp /= 10;
        }
        boolean isImyeonsu = (N >= 6 && digitSum % 2 == 1);

        // 2) 임현수 판정: N == 2 또는 4 이거나, 합성수이면서 소인수 종류 개수가 짝수
        // 2-1) 합성수 여부
        boolean isComposite = false;
        if (N > 3) {
            if (N % 2 == 0) {
                isComposite = true;
            } else {
                for (int i = 3; i * i <= N; i += 2) {
                    if (N % i == 0) {
                        isComposite = true;
                        break;
                    }
                }
            }
        }
        // 2-2) 소인수 종류 세기
        int factorTypes = 0;
        temp = N;
        if (temp % 2 == 0) {
            factorTypes++;
            while (temp % 2 == 0) temp /= 2;
        }
        for (int p = 3; p * p <= temp; p += 2) {
            if (temp % p == 0) {
                factorTypes++;
                while (temp % p == 0) temp /= p;
            }
        }
        if (temp > 1) {
            factorTypes++;
        }
        boolean isImhyunsoo = (N == 2 || N == 4) || (isComposite && factorTypes % 2 == 0);

        // 3) 결과 출력
        if (isImyeonsu && isImhyunsoo) {
            System.out.println(4);
        } else if (isImyeonsu) {
            System.out.println(1);
        } else if (isImhyunsoo) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}

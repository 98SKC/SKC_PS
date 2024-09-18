import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);
        
        // 첫 번째 줄: 숫자의 개수 입력
        int n = scanner.nextInt();
        
        // 각 숫자를 입력받고 두 번 출력
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            System.out.println(number + " " + number);
        }
        
        // 스캐너 닫기
        scanner.close();
    }
}
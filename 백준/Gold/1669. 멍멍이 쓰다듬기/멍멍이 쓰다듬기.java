import java.io.*;
import java.util.*;

public class Main {
    static int monkey, dog;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        monkey = sc.nextInt();
        dog    = sc.nextInt();

        // 같으면 0
        if (monkey == dog) {
            System.out.println(0);
            return;
        }

        // 거리 차이
        long diff = (long)dog - monkey;

        // n*(n) >= diff 가 되는 최소 n 찾기
        long n = 0;
        while (n * n < diff) {
            n++;
        }
        // 딱 떨어지지 않으면 n-- (n*n > diff 이므로)
        if (n * n != diff) {
            n--;
        }

        // 기본 이동 횟수: 1 + 2 + … + n + (n-1) = 2n – 1
        long ans = 2 * n - 1;
        diff -= n * n;

        // 남은 거리만큼 한 칸에 최대 n만큼 더 이동
        while (diff > 0) {
            diff -= Math.min(n, diff);
            ans++;
        }

        System.out.println(ans);
    }
}

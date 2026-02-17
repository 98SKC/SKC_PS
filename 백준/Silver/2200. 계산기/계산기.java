import java.util.*;

public class Main {
    static int digits(long v) {
        int cnt = 0;
        do {
            cnt++;
            v /= 10;
        } while (v != 0);
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] a = new long[N + 1]; 
        for (int i = N; i >= 0; i--) a[i] = sc.nextLong();

        long cnt = 0;

        cnt += 1;             
        cnt += 2L * (N - 1);   
        for (int k = N - 1; k >= 0; k--) {
            if (a[k] != 0) {
                cnt += 1;              
                cnt += digits(a[k]);   
            }
        }
        cnt += 1; // '='

        System.out.println(cnt);
        sc.close();
    }
}

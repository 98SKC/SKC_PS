import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] time;
    static int maxTime;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 입국 심사대 수
        M = Integer.parseInt(st.nextToken()); // 친구들의 수

        time = new int[N];
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(br.readLine());
            maxTime = Math.max(maxTime, time[i]);
        }

        long left = 1;
        long right = (long) maxTime * M;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (biggerThanMinTime(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(left);
    }

    static boolean biggerThanMinTime(long spendTime) {
        long count = 0;

        for (int t : time) {
            count += spendTime / t;

            if (count >= M) return true;
        }

        return false;
    }
}
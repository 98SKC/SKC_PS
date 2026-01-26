import java.util.*;
import java.io.*;

public class Main {

    public static final int mod = 1_000_000_007;

    public static int N;
    public static long answer = 0;

    public static int[] scoville;
    public static int[] cal = new int[300001]; // 2^i % mod

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        scoville = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scoville[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scoville);

        init(); // 2^i 전처리를 적용
        long maxCount, minCount, sub;
        for (int i = 0; i < N; i++) {
            maxCount = cal[i];               // a[i]가 최댓값이 되는 경우
            minCount = cal[N - i - 1];       // a[i]가 최솟값이 되는 경우

            sub = (maxCount - minCount) % mod;
            answer = (answer + scoville[i] * sub) % mod;
        }

        //음수 보정
        if (answer < 0) answer += mod;

        System.out.println(answer);
    }

    // cal[i] = 2^i % mod
    public static void init() {
        cal[0] = 1;
        for (int i = 1; i <= 300000; i++) {
            cal[i] = (cal[i - 1] * 2) % mod;
        }
    }


}



//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
//
//    }
//
//}
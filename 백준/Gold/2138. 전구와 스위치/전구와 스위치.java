
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String start = br.readLine();
        String goal  = br.readLine();

        int[] A = new int[N];
        int[] B = new int[N];
        int[] check = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = start.charAt(i) - '0';
            B[i] = start.charAt(i) - '0';
            check[i] = goal.charAt(i)  - '0';
        }

        // B :0번 스위치 누름
        B[0] ^= 1;
        B[1] ^= 1;

        int cntA = 0;
        int cntB = 1;

        // 1번 ~ N-2번까지 눌러서 이전 전구 맞추기
        // i를 누르면 i-1이 확정된다.
        for (int i = 1; i < N - 1; i++) {
            if (A[i - 1] != check[i - 1]) {
                A[i - 1] ^= 1;  A[i] ^= 1;  A[i + 1] ^= 1;
                cntA++;
            }
            if (B[i - 1] != check[i - 1]) {
                B[i - 1] ^= 1;  B[i] ^= 1;  B[i + 1] ^= 1;
                cntB++;
            }
        }

        // 마지막 스위치(N-1) 누르기 시뮬레이션 & 검사
        // A 시나리오
        if (A[N - 2] != check[N - 2]) {
            A[N - 2] ^= 1;
            A[N - 1] ^= 1;
            cntA++;
        }
        if (A[N - 1] != check[N - 1]) {
            cntA = Integer.MAX_VALUE;
        }

        // B 시나리오
        if (B[N - 2] != check[N - 2]) {
            B[N - 2] ^= 1;
            B[N - 1] ^= 1;
            cntB++;
        }
        if (B[N - 1] != check[N - 1]) {
            cntB = Integer.MAX_VALUE;
        }

        // 둘 중 최소값
        int answer = Math.min(cntA, cntB);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}

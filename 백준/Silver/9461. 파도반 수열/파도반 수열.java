import java.util.*;
import java.io.*;

public class Main {
    static long[] arr = new long[101]; // 파도반 수열 값을 저장할 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        StringBuilder sb = new StringBuilder(); // 출력을 위한 StringBuilder

        // 파도반 수열의 초기 값 설정
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;

        // 파도반 수열 계산
        for(int i=6; i<101; i++) {
            arr[i] = arr[i-1] + arr[i-5]; // P(N) = P(N-1) + P(N-5)
        }

        // 각 테스트 케이스에 대해 P(N) 출력
        for(int test_case = 1; test_case <= T; test_case++) {
            sb.append(arr[Integer.parseInt(br.readLine())] + "\n");
        }

        // 결과 출력
        System.out.println(sb);
    }
}
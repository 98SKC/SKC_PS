
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long answer;

        // 예외 처리
        if (N == 1) {
            answer = 1;
        } else if (N == 2) {
            answer = 1;
        } else if (N == 3) {
            // 중심칸일 경우 자기 자신만 가능
            if (R == 2 && C == 2) answer = 1;
            else answer = 4;
        } else {
            
            // N >= 4면 처음 위치랑 같은 색은 다 갈 수 있다?
            long total = (long)N * N;
            answer = total / 2;
            
            // 같은 색이 하나 더 많을 때 시작 위치가 그 색이면 +1
            if (total % 2 == 1 && ((R + C) % 2 == 0)) answer++;
        }

        System.out.println(answer);
    }
}

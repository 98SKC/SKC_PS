import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }
        
        answer = new int[N+1];
        answer[1] = 1; // 2x1 직사각형을 채우는 방법은 1가지 (세로 타일 1개)
        answer[2] = 2; // 2x2 직사각형을 채우는 방법은 2가지 (가로 타일 2개 또는 세로 타일 2개)
        
        helper(N);
        
        System.out.println(answer[N]);
    }
    
    static int helper(int n) {
        if (answer[n] != 0) {
            return answer[n];
        }
        
        // 메모이제이션을 활용하여 중복 계산을 방지하고, 모듈로 10007 연산 적용
        answer[n] = (helper(n - 1) + helper(n - 2)) % 10007;
        return answer[n];
    }
}

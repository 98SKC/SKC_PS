import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

    
        int[] DP = new int[N + 1];

    
        // 타일이 없을 경우 아무 것도 채우지 않은 것도 포함이라고 한다.(문제에는 N>=1이지만 미번역본에서는 0도 포함이라고 한다.)
        DP[0] = 1;
        DP[1] = 0;

        if(N%2!=1){ //N이 홀수면 다 채울 수 없음
            DP[2] = 3;
            
            for (int i = 4; i <= N; i += 2) {// 짝수만 보기에 2씩 증가함.
                DP[i] = DP[i - 2] * DP[2];
                
                for (int j = i - 4; j >= 0; j -= 2) {
                    DP[i] = DP[i] + (DP[j] * 2);
                }
                
            }
        } 
        
        // 결과값 출력
        System.out.println(DP[N]);
    }
}
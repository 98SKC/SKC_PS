import java.io.*;
import java.util.*;

public class Main {

    public static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N×N 동전판 크기 입력
        N = Integer.parseInt(br.readLine());
        int[] board = new int[N];
        String str;
        
        // 보드 초기화: 'H'면 해당 비트 1로 설정
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j) == 'H') {
                    board[i] |= 1 << j;
                }
            }
        }
        
        int answer = N * N;
        int fullMask = (1 << N) - 1;  // 한 행 전체를 뒤집는 마스크 (N비트 모두 1)
        
        // 미리 계산해 두는 각 행 뒤집힌 상태
        int[] flipped = new int[N];
        for (int i = 0; i < N; i++) {
            flipped[i] = board[i] ^ fullMask;
        }
        
  
        int[] tmp = new int[N];
        
        // 1) 모든 행 뒤집기 조합(2^N) 순회
        for (int mask = 0; mask < (1 << N); mask++) {
            // mask 비트에 따라 tmp 덮어쓰기 (행 뒤집기 적용)
            for (int i = 0; i < N; i++) {
                tmp[i] = ((mask & (1 << i)) != 0) ? flipped[i] : board[i];
            }
            
            // 2) 각 열별 꼬리(T) 개수 계산 (열 뒤집기는 머리/꼬리 비교만)
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                int heads = 0;
                for (int i = 0; i < N; i++) {
                    if ((tmp[i] & (1 << j)) != 0) {
                        heads++;
                    }
                }
                // 뒤집으면 꼬리=heads, 안 뒤집으면 꼬리=N-heads → 최소값 취함
                cnt += Math.min(heads, N - heads);
            }
            
            answer = Math.min(answer, cnt);
        }
        
        System.out.println(answer);
        
        // 이 문제에서 기억할 것:
        // - 같은 행(또는 열)을 두 번 뒤집으면 원래대로 돌아온다 (짝수번 뒤집힘은 무시)
        // - 행끼리·열끼리·행과 열 사이 뒤집기 순서는 결과에 영향을 주지 않는다 (교환성)
        // → 각 행·열에 대해 “홀수번 뒤집을지” 여부만 결정하면 되므로,
        //    행은 2^N 전수조사, 열은 꼬리 수 최소화 그리디로 처리하면 된다.
    }

}

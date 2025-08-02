import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N=Integer.parseInt(br.readLine());
        int[] board=new int[N];
        String str;
        
        for(int i=0;i<N;i++){
            str=br.readLine();
            for(int j=0;j<N;j++) {
                if(str.charAt(j)=='H') {
                    board[i] |= 1<<j;
                }
            }
        }
        int answer=N*N;
        //HashSet<String> v=new HashSet<>();
        //ArrayDeque<int[]> q=new ArrayDeque<>();
        //q.add(board);
        //int[] sub;
        //String key;
        
        // --- BFS 로직을 제거하고, 행 뒤집기 패턴 전수조사로 교체 ---
        int fullMask = (1 << N) - 1;                     // 한 행 전체 뒤집을 때 쓰는 마스크
        for (int mask = 0; mask < (1 << N); mask++) {   // 모든 행 뒤집기 조합(2^N) 순회
            int[] tmp = new int[N];
            // 1) mask 비트에 따라 각 행을 뒤집거나 그대로 복사
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    tmp[i] = board[i] ^ fullMask;       // i행 전체 뒤집기
                } else {
                    tmp[i] = board[i];                  // 그대로
                }
            }
            // 2) 각 열별 꼬리 개수 계산 (그리디)
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                int heads = 0;
                for (int i = 0; i < N; i++) {
                    if ((tmp[i] & (1 << j)) != 0) {
                        heads++;
                    }
                }
                // j열을 뒤집느냐(=heads 꼬리) vs 안 뒤집느냐(=N-heads 꼬리) 중 최소 선택
                cnt += Math.min(heads, N - heads);
            }
            answer = Math.min(answer, cnt);
        }
        
        System.out.println(answer);
        // 이 문제에서 기억할건 보드판에서 뒤집는 것에 대해
        // 상쇄와 교환.
        // 같은 행,열을 두 번 두집으면 원래대로 돌아온다.
        // ㄴ 1행 뒤집고, 1열 뒤집고, 3행 뒤집고, 1행을 뒤집으면
        // ㄴ 초기 상태에서 1열 뒤집고, 3행 뒤집은거랑 결과가 같음
        // 즉 그 행이 짝수번 뒤집혔냐, 홀수번 뒤집혔냐만 중요함.
        // 전체로 막 1행 뒤집고, 그상태에서 어디를 또 바꾸고 돌아오고를 고려한 필요가 없음
        // 뒤집을 때 행끼리, 열끼리, 행과 영 사이 모든 순서는 무의미
        
    }


}

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 누적합 배열: W로 시작하는 체스판과 B로 시작하는 체스판을 위한 배열
        int[][] sumW = new int[N + 1][M + 1];
        int[][] sumB = new int[N + 1][M + 1];

        // 누적합 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // 현재 좌표가 체스판 패턴과 맞는지 확인
                boolean isWhite = ((i + j) % 2 == 0); // 짝수면 흰색이어야 함
                char current = board[i - 1][j - 1]; // 실제 보드 값 (0-index)

                // W로 시작하는 체스판 패턴과 비교
                sumW[i][j] = sumW[i - 1][j] + sumW[i][j - 1] - sumW[i - 1][j - 1];
                if (isWhite && current != 'W') sumW[i][j]++;
                if (!isWhite && current != 'B') sumW[i][j]++;

                // B로 시작하는 체스판 패턴과 비교
                sumB[i][j] = sumB[i - 1][j] + sumB[i][j - 1] - sumB[i - 1][j - 1];
                if (isWhite && current != 'B') sumB[i][j]++;
                if (!isWhite && current != 'W') sumB[i][j]++;
            }
        }

        // 최소값 찾기
        int minChanges = Integer.MAX_VALUE;

        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                // W로 시작하는 체스판에서 다시 칠해야 하는 칸 수
                int changesW = sumW[i][j] - sumW[i - K][j] - sumW[i][j - K] + sumW[i - K][j - K];
                // B로 시작하는 체스판에서 다시 칠해야 하는 칸 수
                int changesB = sumB[i][j] - sumB[i - K][j] - sumB[i][j - K] + sumB[i - K][j - K];

                // 최소값 갱신
                minChanges = Math.min(minChanges, Math.min(changesW, changesB));
            }
        }

        System.out.println(minChanges);
    }
}
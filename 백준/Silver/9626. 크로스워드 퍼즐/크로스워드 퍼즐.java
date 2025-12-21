import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        char[][] puzzle = new char[M][N];
        for (int i = 0; i < M; i++) {
            puzzle[i] = br.readLine().toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        int totalRows = U + M + D;
        int totalCols = L + N + R;

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                if (i >= U && i < U + M && j >= L && j < L + N) {
                    sb.append(puzzle[i - U][j - L]);
                } else {
                    if ((i + j) % 2 == 0) sb.append('#');
                    else sb.append('.');
                }
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}

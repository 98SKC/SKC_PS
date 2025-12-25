import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] mine;
    static char[][] result;
    static int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        mine = new char[N][N];
        result = new char[N][N];

        
        for (int i = 0; i < N; i++) {
            mine[i] = br.readLine().toCharArray();
        }

        boolean exploded = false;

        
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (line[j] == 'x') {
                    if (mine[i][j] == '*') {
                        exploded = true;
                    } else {
                        int cnt = 0;
                        for (int d = 0; d < 8; d++) {
                            int ni = i + di[d];
                            int nj = j + dj[d];
                            if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
                            if (mine[ni][nj] == '*') cnt++;
                        }
                        result[i][j] = (char) (cnt + '0');
                    }
                } else {
                    result[i][j] = '.';
                }
            }
        }

        
        if (exploded) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mine[i][j] == '*') {
                        result[i][j] = '*';
                    }
                }
            }
        }

        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}

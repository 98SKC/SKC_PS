import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (arr[i][j] == 1) {
                    flip(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void flip(int a, int b) {
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                arr[i][j] = (arr[i][j] + 1) % 2;
            }
        }
    }
}
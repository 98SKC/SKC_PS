import java.io.*;
import java.util.*;

class Main {
    
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        char[][] pan = new char[n][n];
        for (char[] array : pan) {
            Arrays.fill(array, '.');
        }

        int x = 0, y = 0;

        for (int i = 0; i < arr.length; i++) {
            int direction = findDirection(arr[i]);
            int next_x = x + dx[direction];
            int next_y = y + dy[direction];

            if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= n) continue;

            char draw = (direction == 0 || direction == 2) ? '|' : '-';
            pan[y][x] = (pan[y][x] == '.' || pan[y][x] == draw) ? draw : '+';
            x = next_x;
            y = next_y;
            pan[y][x] = (pan[y][x] == '.' || pan[y][x] == draw) ? draw : '+';
        }

        for (char[] array : pan) {
            for (char c : array) {
                System.out.print(c);
            }
            System.out.println();
        }
    }


    private static int findDirection(char c) {
        switch (c) {
            case 'U': return 0;  // 위: dx=0, dy=-1
            case 'L': return 1;  // 왼쪽: dx=-1, dy=0
            case 'D': return 2;  // 아래: dx=0, dy=1
            case 'R': return 3;  // 오른쪽: dx=1, dy=0
            default:  return 0;
        }
    }
}

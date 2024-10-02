import java.util.*;

public class Main {

    static class Pair {  // 정적 중첩 클래스
        int X;
        int Y;

        Pair(int x, int y) {
            this.X = x;
            this.Y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] pictureArr = new int[n + 2][m + 2];
        int[][] visited = new int[n + 2][m + 2];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pictureArr[i][j] = sc.nextInt();
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        int count = 0;
        int maxSize = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (pictureArr[i][j] == 1 && visited[i][j] == 0) {
                    int size = 0;

                    queue.add(new Pair(i, j));
                    visited[i][j] = 1;

                    while (!queue.isEmpty()) {
                        Pair pair = queue.remove();
                        size++;

                        for (int d = 0; d < 4; d++) {
                            int tmpX = pair.X + dx[d];
                            int tmpY = pair.Y + dy[d];

                            if (pictureArr[tmpX][tmpY] == 1 && visited[tmpX][tmpY] == 0) {
                                queue.add(new Pair(tmpX, tmpY));
                                visited[tmpX][tmpY] = 1;
                            }
                        }
                    }
                    count++;
                    if (size > maxSize) maxSize = size;
                }
            }
        }

        System.out.println(count + "\n" + maxSize);
    }
}
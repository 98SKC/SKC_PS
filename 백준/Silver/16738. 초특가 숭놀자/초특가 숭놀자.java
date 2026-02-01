import java.io.*;
import java.util.*;

public class Main {

    static class Room {
        int left, right, people;

        Room(int left, int right, int people) {
            this.left = left;
            this.right = right;
            this.people = people;
        }
    }

    static int N, Q, X, Y;
    static int peopleIndex = 1;
    static Room[] rooms = new Room[5001];
    static boolean[] isFull = new boolean[5001];

    // 연속된 Y개의 빈 방 시작 인덱스 찾기
    static int findIndex(int Y) {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (isFull[i]) {
                cnt = 0;
                continue;
            }
            cnt++;
            if (cnt == Y) {
                return i - Y + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            if (cmd.equals("new")) {
                int index = findIndex(Y);

                if (index == -1) {
                    sb.append("REJECTED\n");
                } else {
                    int right = index + Y - 1;
                    for (int i = index; i <= right; i++) {
                        isFull[i] = true;
                    }
                    rooms[peopleIndex++] = new Room(index, right, X);
                    sb.append(index).append(" ").append(right).append("\n");
                }
            } else if (cmd.equals("in")) {
                rooms[X].people += Y;
            } else { // out
                rooms[X].people -= Y;
                if (rooms[X].people == 0) {
                    for (int i = rooms[X].left; i <= rooms[X].right; i++) {
                        isFull[i] = false;
                    }
                    sb.append("CLEAN ")
                      .append(rooms[X].left)
                      .append(" ")
                      .append(rooms[X].right)
                      .append("\n");
                }
            }
        }

        System.out.print(sb.toString());
    }
}

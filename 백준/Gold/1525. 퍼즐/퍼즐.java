import java.io.*;
import java.util.*;

//bfs로 할걸 Astar 왜이리 배열 문제생겨 하
public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static Map<Integer, Integer> visitedMap = new HashMap<>();
    static Set<Integer> impossibleSet = new HashSet<>();

    static class Node implements Comparable<Node> {
        String board;
        int g;
        int f;

        Node(String board, int g, int f) {
            this.board = board;
            this.g = g;
            this.f = f;
        }

        @Override
        public int compareTo(Node o) {
            if (this.f == o.f) return Integer.compare(this.g, o.g);
            return Integer.compare(this.f, o.f);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder boardStr = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                String token = st.nextToken();
                boardStr.append(token.equals("0") ? "9" : token); // 0을 9로 변환
            }
        }

        String start = boardStr.toString();
        pq.offer(new Node(start, 0, 0));
        visitedMap.put(Integer.parseInt(start), 0);

        aStar();

        if (visitedMap.containsKey(123456789)) {
            System.out.println(visitedMap.get(123456789));
        } else {
            System.out.println(-1);
        }
    }

    private static void aStar() {
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            String numberBoard = current.board;
            int blankIdx = numberBoard.indexOf('9');
            int r = blankIdx / 3;
            int c = blankIdx % 3;

            if (impossibleSet.contains(Integer.parseInt(numberBoard))) return;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < 3 && nc >= 0 && nc < 3) {
                    int swapIdx = nr * 3 + nc;
                    String next = swap(numberBoard, blankIdx, swapIdx);
                    int nextInt = Integer.parseInt(next);

                    if (!visitedMap.containsKey(nextInt)) {
                        int g = current.g;
                        int h = getHeuristic(next);
                        pq.offer(new Node(next, g + 1, g + 1 + h));
                        visitedMap.put(nextInt, g + 1);
                    }
                }
            }

            if (visitedMap.containsKey(123456789)) return;
        }
    }

    private static String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return new String(arr);
    }

    private static int getHeuristic(String s) {
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            if (s.charAt(i) != "123456789".charAt(i)) cnt++;
        }
        return cnt;
    }
}

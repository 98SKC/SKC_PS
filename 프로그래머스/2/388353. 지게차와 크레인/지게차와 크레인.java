import java.util.*;

class Solution {
    public boolean[][] v;

    public int solution(String[] storage, String[] requests) {
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();//바로 접근해서 뽑을 수 있는 컨테이너
        HashSet<Integer>[] alpha = new HashSet[26];

        for (int i = 0; i < 26; i++) {
            alpha[i] = new HashSet<>();
        }

        int row = storage.length;
        int col = storage[0].length();

        v = new boolean[row][col]; //이미 제거된 컨테이너

        answer = row * col;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = storage[i].charAt(j);

                alpha[c - 'A'].add(col * i + j);

                if (i == 0 || j == 0 || i == (row - 1) || j == (col - 1)) {
                    set.add(col * i + j);
                }
            }
        }

        for (String r : requests) {
            char target = r.charAt(0);

            if (r.length() != 1) { //크레인으로 한번에

                //해당 알파벳 컨테이너 전부 제거
                ArrayList<Integer> removeList =
                        new ArrayList<>(alpha[target - 'A']);

                for (int pos : removeList) {
                    int i = pos / col;
                    int j = pos % col;

                    if (v[i][j]) continue;

                    v[i][j] = true;
                    answer--;
                }

                alpha[target - 'A'].clear();

            } else { //접근 가능한 것만.

                ArrayList<Integer> removeList = new ArrayList<>();

                //target 컨테이너 중 현재 외부에서 접근 가능한 것만 확인
                for (int pos : alpha[target - 'A']) {
                    if (set.contains(pos)) {
                        removeList.add(pos);
                    }
                }

                for (int pos : removeList) {
                    int i = pos / col;
                    int j = pos % col;

                    if (v[i][j]) continue;

                    v[i][j] = true;
                    answer--;

                    alpha[target - 'A'].remove(pos);
                }
            }

            /*
             * 컨테이너가 제거되고 나면
             * 기존에는 안쪽에 있던 컨테이너가 외부와 연결될 수 있다.
             *
             * 따라서 현재 제거된 공간을 통해
             * 외부에서 접근 가능한 모든 컨테이너를 다시 구한다.
             */
            set = findAccessible(storage, row, col);
        }

        return answer;
    }

    //현재 외부에서 바로 접근 가능한 컨테이너들을 구한다.
    public HashSet<Integer> findAccessible(String[] storage, int row, int col) {

        HashSet<Integer> set = new HashSet<>();

        boolean[][] visited = new boolean[row][col];
        Queue<Integer> q = new ArrayDeque<>();

        /*
         * 가장자리에서 시작한다.
         *
         * 가장자리의 컨테이너가 아직 남아있으면
         * 그 컨테이너 자체가 접근 가능하다.
         *
         * 이미 제거되어 빈 공간이면
         * 그 빈 공간을 통해 내부로 들어갈 수 있다.
         */
        for (int i = 0; i < row; i++) {
            checkBoundary(i, 0, row, col, visited, q, set);
            checkBoundary(i, col - 1, row, col, visited, q, set);
        }

        for (int j = 0; j < col; j++) {
            checkBoundary(0, j, row, col, visited, q, set);
            checkBoundary(row - 1, j, row, col, visited, q, set);
        }

        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        /*
         * 제거된 빈 공간만 BFS로 이동한다.
         *
         * 이동 중 아직 제거되지 않은 컨테이너를 만나면
         * 해당 컨테이너는 외부에서 바로 접근 가능한 상태이다.
         */
        while (!q.isEmpty()) {
            int cur = q.poll();

            int i = cur / col;
            int j = cur % col;

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];

                if (ni < 0 || nj < 0 || ni >= row || nj >= col) continue;

                if (v[ni][nj]) { //이미 제거된 공간이면 계속 이동
                    if (!visited[ni][nj]) {
                        visited[ni][nj] = true;
                        q.add(col * ni + nj);
                    }
                } else { //남아있는 컨테이너면 접근 가능
                    set.add(col * ni + nj);
                }
            }
        }

        return set;
    }

    public void checkBoundary(
            int i,
            int j,
            int row,
            int col,
            boolean[][] visited,
            Queue<Integer> q,
            HashSet<Integer> set
    ) {

        int pos = col * i + j;

        if (v[i][j]) { //가장자리가 이미 비어있으면 내부 탐색 시작점
            if (!visited[i][j]) {
                visited[i][j] = true;
                q.add(pos);
            }
        } else { //가장자리 컨테이너는 바로 접근 가능
            set.add(pos);
        }
    }
}
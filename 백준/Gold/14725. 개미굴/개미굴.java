import java.io.*;
import java.util.*;

public class Main {

    // 개미굴 트리
    static class Anthill {
        int deep;               // 깊이
        String food;            // 음식 이름
        ArrayList<Anthill> next; // 자식 굴 리스트

        public Anthill(int deep, String food) {
            this.deep = deep;
            this.food = food;
            this.next = new ArrayList<>();// 생성자에서 초기화
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Anthill root = new Anthill(0, null);

        // 트리 구성 복습 중. 나중에 검토해 볼 것 
        for (int t = 0; t < T; t++) {
            String[] cave = br.readLine().split(" ");
            int len = Integer.parseInt(cave[0]);
            Anthill current = root;

            // 자식 개미굴 탐색 및 추가
            for (int i = 1; i <= len; i++) {
                String item = cave[i];
                boolean found = false;
                for (Anthill child : current.next) {
                    // 문자열 비교는 equals 사용을 잊지 말것 
                    if (child.food.equals(item)) {
                        current = child;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    // 새로운 자식을 추가
                    Anthill newNode = new Anthill(i, item);
                    current.next.add(newNode);
                    current = newNode;
                }
            }
        }

        
        StringBuilder sb = new StringBuilder();
        Stack<Anthill> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            Anthill s = stack.pop();
            if (s.food != null) {
                // 깊이만큼 "--" 반복
                for (int d = 1; d < s.deep; d++) sb.append("--");
                sb.append(s.food).append("\n");
            }

            // 자식 노드 사전순 정렬 먼저 실행. 근데 스택에는 거꾸로 쌓여야하느 큰 순으로 정렬
            Collections.sort(s.next, new Comparator<Anthill>() {
                @Override
                public int compare(Anthill o1, Anthill o2) {
                    return o2.food.compareTo(o1.food);
                }
            });
            
            for (int i =0; i < s.next.size(); i++) {
                stack.push(s.next.get(i));
            }
        }

        System.out.print(sb);
    }
}

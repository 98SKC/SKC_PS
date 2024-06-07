import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int num;
        Node parent;
        char command;

        Node(int num, Node parent, char command){
            this.num = num;
            this.parent = parent;
            this.command = command;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());

            Queue<Node> q = new ArrayDeque<>();
            boolean[] visited = new boolean[10000];
            q.add(new Node(start, null, ' ')); // 초기 상태
            visited[start] = true;

            Node finalNode = null;
            while (!q.isEmpty() && finalNode == null) {
                Node current = q.poll();

                int[] nextNumbers = {executeD(current.num), executeS(current.num), executeL(current.num), executeR(current.num)};
                char[] commands = {'D', 'S', 'L', 'R'};

                for (int i = 0; i < 4; i++) {
                    int nextNum = nextNumbers[i];
                    if (!visited[nextNum]) {
                        visited[nextNum] = true;
                        Node newNode = new Node(nextNum, current, commands[i]);
                        if (nextNum == goal) {
                            finalNode = newNode;
                            break;
                        }
                        q.add(newNode);
                    }
                }
            }

            if (finalNode != null) {
                // 역순으로 경로 추적
                Stack<Character> stack = new Stack<>();
                while (finalNode.parent != null) {
                    stack.push(finalNode.command);
                    finalNode = finalNode.parent;
                }

                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static int executeD(int number) {
        return (number * 2) % 10000;
    }

    static int executeS(int number) {
        return number == 0 ? 9999 : number - 1;
    }

    static int executeL(int number) {
        return (number % 1000) * 10 + number / 1000; // 숫자 왼쪽 회전
    }

    static int executeR(int number) {
        return (number / 10) + (number % 10) * 1000; // 숫자 오른쪽 회전
    }
}
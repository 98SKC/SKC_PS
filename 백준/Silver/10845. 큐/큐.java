import java.io.*;
import java.util.*;

public class Main {

    static int[] queue; // 배열로 큐를 구현
    static int front = 0; // 큐의 가장 앞을 가리키는 인덱스
    static int rear = 0; // 큐의 가장 뒤 다음 위치를 가리키는 인덱스 (다음에 삽입될 위치)

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        queue = new int[N];

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {

            case "push":
                push(Integer.parseInt(st.nextToken()));
                break;

            case "pop":
                sb.append(pop()).append('\n');
                break;

            case "size":
                sb.append(size()).append('\n');
                break;

            case "empty":
                sb.append(empty()).append('\n');
                break;

            case "front":
                sb.append(front()).append('\n');
                break;

            case "back":
                sb.append(back()).append('\n');
                break;
            }

        }
        System.out.println(sb);
    }

    public static void push(int item) {
        queue[rear++] = item;
    }

    public static int pop() {
        if (size() == 0) {
            return -1;
        } else {
            int res = queue[front];
            queue[front++] = 0; // 데이터를 제거한 후 front 인덱스 증가
            return res;
        }
    }

    public static int size() {
        return rear - front; // 큐의 크기 = rear 인덱스 - front 인덱스
    }

    public static int empty() {
        return size() == 0 ? 1 : 0;
    }

    public static int front() {
        if (size() == 0) {
            return -1;
        } else {
            return queue[front];
        }
    }

    public static int back() {
        if (size() == 0) {
            return -1;
        } else {
            return queue[rear - 1]; // 큐의 마지막 요소는 rear-1 위치에 있음
        }
    }
}
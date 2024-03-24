import java.io.*;
import java.util.*;

public class Main {

    static int[] deque;
    static int front = 0, rear = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        deque = new int[N];
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push_front":
                    push_front(Integer.parseInt(input[1]));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(input[1]));
                    break;
                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;
                case "pop_back":
                    sb.append(pop_back()).append('\n');
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

    public static void push_front(int item) {
        if (front == 0) {
            front = deque.length;
        }
        deque[--front] = item;
    }

    public static void push_back(int item) {
        deque[rear++] = item;
        if (rear == deque.length) {
            rear = 0;
        }
    }

    public static int pop_front() {
        if (empty() == 1) {
            return -1;
        }
        int value = deque[front++];
        if (front == deque.length) {
            front = 0;
        }
        return value;
    }

    public static int pop_back() {
        if (empty() == 1) {
            return -1;
        }
        if (rear == 0) {
            rear = deque.length;
        }
        return deque[--rear];
    }

    public static int size() {
        if (rear >= front) {
            return rear - front;
        } else {
            return rear - front + deque.length;
        }
    }

    public static int empty() {
        return rear == front ? 1 : 0;
    }

    public static int front() {
        if (empty() == 1) {
            return -1;
        }
        return deque[front];
    }

    public static int back() {
        if (empty() == 1) {
            return -1;
        }
        if (rear == 0) {
            return deque[deque.length - 1];
        }
        return deque[rear - 1];
    }
}
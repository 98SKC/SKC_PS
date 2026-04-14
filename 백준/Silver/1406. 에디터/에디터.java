

import java.util.*;
import java.io.*;

public class Main{

    public static class DoublyLinkedList {

        static class Node {
            char data;
            Node prev;
            Node next;

            Node(char data) {
                this.data = data;
            }
        }

        Node head;
        Node tail;
        Node cursor; // 커서의 왼쪽 노드

        DoublyLinkedList() {
            head = new Node('\0');
            tail = new Node('\0');
            head.next = tail;
            tail.prev = head;
            cursor = head;
        }

        // 초기 문자열 세팅
        void init(String str) {
            for (int i = 0; i < str.length(); i++) {
                addLeft(str.charAt(i));
            }
        }

        // L : 커서를 왼쪽으로
        void moveLeft() {
            if (cursor != head) {
                cursor = cursor.prev;
            }
        }

        // D : 커서를 오른쪽으로
        void moveRight() {
            if (cursor.next != tail) {
                cursor = cursor.next;
            }
        }

        // B : 커서 왼쪽 문자 삭제
        void removeLeft() {
            if (cursor == head) return; // 삭제할 문자 없음

            Node deleteNode = cursor;
            Node leftNode = deleteNode.prev;
            Node rightNode = deleteNode.next;

            leftNode.next = rightNode;
            rightNode.prev = leftNode;

            cursor = leftNode; // 삭제 후 커서는 왼쪽으로 한 칸 간 효과
        }

        // P x : 커서 왼쪽에 문자 추가
        void addLeft(char ch) {
            Node newNode = new Node(ch);

            Node rightNode = cursor.next;

            cursor.next = newNode;
            newNode.prev = cursor;

            newNode.next = rightNode;
            rightNode.prev = newNode;

            cursor = newNode; // 삽입한 문자의 오른쪽에 커서가 있으므로 왼쪽 노드는 새 노드
        }

        // 결과 문자열 만들기
        String buildString() {
            StringBuilder sb = new StringBuilder();
            Node cur = head.next;
            while (cur != tail) {
                sb.append(cur.data);
                cur = cur.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        DoublyLinkedList list = new DoublyLinkedList();
        list.init(str);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);

            if (op == 'L') {
                list.moveLeft();
            } else if (op == 'D') {
                list.moveRight();
            } else if (op == 'B') {
                list.removeLeft();
            } else if (op == 'P') {
                char ch = st.nextToken().charAt(0);
                list.addLeft(ch);
            }
        }

        System.out.println(list.buildString());
    }
}
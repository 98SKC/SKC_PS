import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb;
	static public class Node{
		
		char alpha;
		Node left;
		Node right;
		
		Node(char alpha){
			this.alpha=alpha;
	        this.left = null;
	        this.right = null;
		}
		
		
	}
    public static void main(String[] args) throws Exception {
    	sb=new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        Node[] tree =new Node[N + 1];
        StringTokenizer st;
        
        for(int i=0;i<N;i++) {
        	
        	st=new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            
            //  ASCII 코드를 사용하여 알파벳과 배열 인덱스를 맞춤
            if (tree[root - 'A'] == null) { // 부모 노드가 아직 생성되지 않음. 
                tree[root - 'A'] = new Node(root); // 부모 노드를 생성
            }
            if (left != '.') { // 왼쪽 자식이 존재할 경우
                tree[left - 'A'] = new Node(left); // 왼쪽 자식 노드를 생성
                tree[root - 'A'].left = tree[left - 'A']; // 부모 노드와 연결
            }
            if (right != '.') { // 오른쪽 자식이 존재할 경우
                tree[right - 'A'] = new Node(right); // 오른쪽 자식 노드를 생성
                tree[root - 'A'].right = tree[right - 'A']; // 부모 노드와 연결
            }
            
        }
        
        // 전위 순회
        preorder(tree[0]);
        sb.append("\n");

        // 중위 순회
        inorder(tree[0]);
        sb.append("\n");

        // 후위 순회
        postorder(tree[0]);
        System.out.println(sb);
        
        
    }
    // 전위 순회
    public static void preorder(Node node) {
        if (node == null) return;
        sb.append(node.alpha);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        sb.append(node.alpha);
        inorder(node.right);
    }

    // 후위 순회
    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.alpha);
    }
}
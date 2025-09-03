
import java.util.*;
import java.io.*;

public class Main {
    
	public static class Frame {
        int is, ie, ps, pe;
        
        Frame(int is, int ie, int ps, int pe) {
            this.is = is; this.ie = ie; this.ps = ps; this.pe = pe;
        }
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());//노드 개수
        
        
        /*
         * 전위순회(프리오더)		: root->left->right 순서
         * 중위순회(인오더) 		: left->root->right 순서
         * 후위순회(포스트오더)	: left->right->root 순서
         * 
         * 주어진 트리는 이진 트리라고 명시
         * 후위순회는 root가 맨 뒤에 있다. 포스트오더를 통해 트리의 root를 파악한다.
         * 중위순회는 root를 기준으로 왼쪽 자식 트리와 오른쪽 자식 트리가 나누어진다. root에 대한 정보로 왼쪽 오른쪽을 분할한다.
         * 
         * */
        int[] inorder=new int[N+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
        	inorder[i]=Integer.parseInt(st.nextToken());
        }
        
        int[] postorder=new int[N+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
        	postorder[i]=Integer.parseInt(st.nextToken());
        }
        
        //단순히 트리를 만들고 역탐색하면 시간초과가 일어나기에 인덱스를 보낸다.
        int[] index = new int[N+1];
        for(int i=1;i<=N;i++) {
        	index[inorder[i]]=i; //inorder[i]가 들어있는 위치는 i이다.
        }
        
        Stack<Frame> stack=new Stack<>();
        
        //stack.push(postorder[N]);
        stack.push(new Frame(1,N,1,N));
        StringBuilder sb=new StringBuilder();
        Frame node;
        int root, idx, leftSize;
        
        while (!stack.isEmpty()) {
            Frame f = stack.pop();
            if (f.is > f.ie || f.ps > f.pe) continue;

            root=postorder[f.pe];   // 후위 구간의 마지막이 루트
            sb.append(root+" ");  // 프리오더: 루트 먼저 출력

            idx=index[root];        // 인오더에서 루트의 위치
            leftSize=idx-f.is;    // 왼쪽 서브트리 크기

            // 스택이므로, 나중에 push한 것이 먼저 처리됨
            // 프리오더 순서(root -> left -> right)를 위해
            // 먼저 "오른쪽", 그다음 "왼쪽"을 push
            
            // 오른쪽 서브트리: inorder[idx+1..f.ie], postorder[f.ps+leftSize..f.pe-1]
            stack.push(new Frame(idx + 1, f.ie, f.ps + leftSize, f.pe - 1));
            
            // 왼쪽 서브트리: inorder[f.is..idx-1], postorder[f.ps..f.ps+leftSize-1]
            stack.push(new Frame(f.is, idx - 1, f.ps, f.ps + leftSize - 1));
        }

        System.out.println(sb.toString());
    }
}

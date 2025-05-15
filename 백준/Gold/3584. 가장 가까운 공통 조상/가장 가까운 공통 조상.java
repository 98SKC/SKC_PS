
import java.util.*;
import java.io.*;

public class Main {

	public static int[][] parent;// [i][j] : i번 노드의 2^j번째 조상
	//parent[node][pow] = parent[parent[node][pow - 1]][pow - 1]
	//node의 2^pow번재 조상은     node의 2^(pow-1)번째 조상 노드의 2^(pow-1)번째 조상 노드.
	/*
	 * 				1
	 * 	      2	          3
	 * 	  4      5     6     7
	 *  8   9 10 11  12 13  14 15
	 *16 
	 * 
	 * */
	//희소 테이블
	//16번의 4번째 조상은  16의 2번째 조상(4)의 2번재 조상  
	
	
 	public static int[] level;//
	public static ArrayList<Integer>[] edge;
	
	//LCA 공부
	//2분탐색 
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        //트리가 주어지고, 그 트리상의 두 정점에서 가장 가까운 공통조상
        //두 노드를 모두 자손으로 가지며, 가장 깊은 노드
        StringBuilder sb=new StringBuilder();
        int N,node1,node2;
        int a,b;
        for(int t=1;t<=T;t++) {
        	N=Integer.parseInt(br.readLine());
        	int h = (int)(Math.log(N) / Math.log(2)) + 1;// 트리의 최대높이
        	parent = new int[N + 1][h];
        	HashSet<Integer> findP=new HashSet<>();
        	
        	edge = new ArrayList[N + 1];
        	level=new int[N+1];
        	for (int i = 1; i <= N; i++) {
        	    edge[i] = new ArrayList<>();
        	    findP.add(i);
        	}
        	for(int i=0;i<N-1;i++) {
        		st=new StringTokenizer(br.readLine());
        		//간선 정보
        		a=Integer.parseInt(st.nextToken());
        		b=Integer.parseInt(st.nextToken());
        		//root[b]=a;//b의 부모는 a
        		findP.remove(b);//b는 루트 노드가 아님
        		edge[a].add(b);// a 아래로 b
        		
        	}
        	
        	for(Integer r:findP) {//findP에는 하나만 남아있음. 그걸 꺼내기 위함. 다른 메서드도 있나?
        		setTree(r,1);//r루트 0레벨붙터 시작
        	}
        	
        	st=new StringTokenizer(br.readLine());
        	node1=Integer.parseInt(st.nextToken());
        	node2=Integer.parseInt(st.nextToken());
        	
        	sb.append(LCA(node1, node2)+"\n");
            
        }
        
        System.out.println(sb);
    }
    public static void setTree(int node, int l) {//진입 차수가 없는 노드부터 시작
    	level[node]=l;
        // 1. 현재 노드의 첫 번째 부모(직속 부모)는 이미 DFS를 통해 설정되어 있어야 함
        // parent[node][0] = 바로 위에서 setTree(node, ...) 호출한 쪽에서 설정 필요

    	
        // 2. 2^j 번째 부모를 미리 채워둔다 (j ≥ 1)
        for (int j = 1; j < parent[node].length; j++) {
            int midParent = parent[node][j - 1]; // 2^(j-1) 번째 조상
            if (midParent != 0) {
                parent[node][j] = parent[midParent][j - 1]; // 2^j 번째 조상 = 2^(j-1) 조상의 2^(j-1) 조상
            }
        }

        // 3. 자식 노드들에 대해 재귀 호출 
        for (int child : edge[node]) {
            parent[child][0] = node; // 자식의 2^0번째 부모는 현재 노드
            setTree(child, l + 1);   // 다음 레벨로 내려감
        }
    }
    
    
    public static int LCA(int a, int b) {
        // 1. 두 노드의 깊이를 맞춘다 (더 깊은 쪽을 위로 올림)
        if (level[a] > level[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = level[b] - level[a];// 높이 차이 계산. 모든 수는 2^p의 합으로 구할 수 있다. (2진수로 표현할 수 있다.)
        for (int i = 0; i < parent[b].length; i++) {
            if ((diff & (1 << i)) != 0) { 
                b = parent[b][i];//b 조상 중 같은 레벨을 찾는다.
            }
        }

        if (a == b) return a;

        // 2. 공통 조상까지 동시에 올라간다
        for (int i = parent[a].length - 1; i >= 0; i--) {
            if (parent[a][i] != 0 && parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        // 3. 공통 조상의 바로 아래까지 올라왔으므로 그 위가 LCA
        return parent[a][0];
    }


}

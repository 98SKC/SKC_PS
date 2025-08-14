
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine()); //노드의 개수
        
        StringTokenizer st;
        int p,c;

       
        int LOG = 1;                 // K
        //이론상 노드 N트리의 최대높이를 포괄하는 2^LOG를찾는다
        while ((1 << LOG) <= N) {    // 2^LOG <= N 동안 증가
            LOG++;
        }

        int[][] parent=new int[N+1][LOG];
        
        int root=-1;

        int[] depth=new int[N+1];
        List<Integer>[] edges=new ArrayList[N+1]; 
        
        for(int i=1;i<=N;i++) {
        	edges[i]=new ArrayList<>();
        }
        
        for(int i=0;i<N-1;i++) {
        	st=new StringTokenizer(br.readLine());
            p=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());

            edges[p].add(c);
            edges[c].add(p);
        }
        
        
        ArrayDeque<Integer> q=new ArrayDeque<>();
        int node;
        q.add(1);
        //깊이와 parent[v][1(2^0)] 저장
        while(!q.isEmpty()) {
        	node=q.poll();
 
        	for(Integer next: edges[node]) {
        		if (next != parent[node][0]) {
        			depth[next]=depth[node]+1;
                	parent[next][0]=node; //0=> 2^0  => 즉 한칸위의 부모로 저장
            		q.add(next);
        		}
               	
        	}
        	
        	
        }
        // BFS로 parent[v][0] (직접 부모)와 depth[]를 채웠으므로
        // 이제 2^k번째 조상을 DP로 채운다.
        for (int k = 1; k < LOG; k++) {
            for (int v = 1; v <= N; v++) {
                int mid = parent[v][k-1];      // v의 2^(k-1)번째 조상
                parent[v][k] = (mid == 0) ? 0  // 없으면 0 유지
                               : parent[mid][k-1];
            }
        }
        
        int M=Integer.parseInt(br.readLine());
        int a,b;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	
        	//높이를 맞춤
            if (depth[a] < depth[b]) { // a가 더 깊도록 스왑
                int tmp = a; 
                a = b; 
                b = tmp;
            }
            
            //높이의 차이.
            int diff = depth[a] - depth[b];
            
            // 전제: a가 b보다 같거나 더 깊다. diff = depth[a] - depth[b] (>= 0)
            // 아이디어: diff를 이진수로 분해해서, 켜져 있는 비트(=2^k)에 해당하는 만큼만 a를 위로 점프시킨다.
            //   예) diff = 13 (이진수 1101) → 2^3(8), 2^2(4), 2^0(1) 칸으로 나눠 a를 올림
            // parent[a][k] : 노드 a의 2^k번째 조상
            // (1 << k)     : 2^k 값을 의미
            // 큰 k부터 확인하면 필요한 점프 수를 최소화하면서 O(log N)에 깊이를 맞출 수 있다.
            
            for (int k = LOG-1; k >= 0; k--) {
                if ((diff & (1 << k)) != 0) {
                    a = parent[a][k];
                }
            }
            
            if (a == b) {
            
                sb.append(a+"\n");
                continue;
            }	
        	
        	//부모가 같지 않으면서 다른 곳까지 절반씩 이동
        	while (a != b && parent[a][0] != parent[b][0]) {
                boolean moved = false;
                for (int k = LOG-1; k >= 0; k--) {
                    if (parent[a][k] != 0 && parent[b][k] != 0 && parent[a][k] != parent[b][k]) {
                        a = parent[a][k];
                        b = parent[b][k];
                        moved = true;
                        break; // 가장 큰 점프 1번만 하고 다시 조건 검사
                    }
                }
                if (!moved) break; // 더 이상 멀리 점프할 수 없으면 탈출
        	}
        	
        	
        	//부모가 같은 곳까지 한칸씩 이동
        	//부모가 같은 곳까지 한칸씩 이동
        	while (a != b) {
                a = parent[a][0];
                b = parent[b][0];
        	}
        	sb.append(a+"\n");
        }
        System.out.println(sb);
        
    }
}


import java.util.*;
import java.io.*;

public class Main{
    public static ArrayList<Integer>[] tree;
    public static int[] answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int R=Integer.parseInt(st.nextToken());
        int Q=Integer.parseInt(st.nextToken());
        
        tree=new ArrayList[N+1];

        
        for(int i=1;i<=N;i++) {
        	tree[i]=new ArrayList<>();
        }
        
        int a,b;
        for(int i=1;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	tree[a].add(b);
        	tree[b].add(a);
        }
        
        answer=new int[N+1];

        dfs(R,0);
        

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(answer[query]).append("\n");
        }
        
        System.out.println(sb);
        
        
    }
    static int dfs(int cur, int parent) {
        answer[cur] = 1;  // 자기 자신을 포함
        for (int child : tree[cur]) {
            if (child == parent) continue;  // 부모로 다시 가는 것을 방지
            answer[cur] += dfs(child, cur);
        }
        return answer[cur];
    }
}

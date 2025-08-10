
import java.util.*;
import java.io.*;

public class Main {
	public static int[] parent;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        parent=new int[N+1];
       
        for (int i = 1; i <= N; i++) parent[i] = i;
        int[][] edge=new int[N+1][N+1];
        
        StringTokenizer st;
        int a,b,c;
        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=1;j<=N;j++) {
            	edge[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        // 1) 비용 행렬 → 간선 리스트 (상삼각만 사용: i<j)
        ArrayList<int[]> edges = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                edges.add(new int[]{i, j, edge[i][j]}); // {u, v, w}
            }
        }
        
        edges.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
        
        long answer=0;
        int total=0;
        for(int[] next: edges) {
        	if(union(next[0],next[1])) {
        		
        		answer+=next[2];
        		total++;
        		if(total==N-1) break;
        	}
        }
        
        System.out.println(answer);
        //중심행성 T
        //N개의 행성 간에 플로우 설치
        //모든 행성을 연결하며 유지비용을 최소화
        
        //간선이 많다. 
        
    }
    
    
    public static int find(int a) {
    	if(parent[a]==a) return a;
    	return parent[a]=find(parent[a]);
    }
    
    
    public static boolean union(int a, int b) {
    	int pa=find(a);
    	int pb=find(b);
    	
    	if(pa==pb) return false;
    	
    	if(pa<pb) parent[pb] = pa;
    	else parent[pa] = pb;
    	return true;
    }
}

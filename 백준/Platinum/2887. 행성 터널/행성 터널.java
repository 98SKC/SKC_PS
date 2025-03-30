
import java.util.*;
import java.io.*;

public class Main{

	public static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        parent=new int[N];
        
        for(int i=0;i<N;i++) {
        	parent[i]=i;
        }
        
        StringTokenizer st;
        //1000000000
        int[][] planet=new int[N][3];
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	planet[i][0]=Integer.parseInt(st.nextToken());
        	planet[i][1]=Integer.parseInt(st.nextToken());
        	planet[i][2]=Integer.parseInt(st.nextToken());
        	
        }
        
        int sub;
        ArrayList<int[]> edge=new ArrayList<>();
     // x, y, z 좌표를 index와 함께 저장
        int[][] x = new int[N][2];
        int[][] y = new int[N][2];
        int[][] z = new int[N][2];

        for(int i=0; i<N; i++){
            x[i] = new int[]{i, planet[i][0]};
            y[i] = new int[]{i, planet[i][1]};
            z[i] = new int[]{i, planet[i][2]};
        }

        // 각 좌표 별 정렬 후 인접 행성 간의 간선만 추가
        Arrays.sort(x, (a,b)->a[1]-b[1]);
        Arrays.sort(y, (a,b)->a[1]-b[1]);
        Arrays.sort(z, (a,b)->a[1]-b[1]);

        for(int i=0; i<N-1; i++){
            edge.add(new int[]{x[i][0], x[i+1][0], Math.abs(x[i][1]-x[i+1][1])});
            edge.add(new int[]{y[i][0], y[i+1][0], Math.abs(y[i][1]-y[i+1][1])});
            edge.add(new int[]{z[i][0], z[i+1][0], Math.abs(z[i][1]-z[i+1][1])});
        }
        Collections.sort(edge, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        
        int answer=0;
        for(int[] e:edge) {
        	if(find(e[0])!=find(e[1])){// 사이클이 존재하지 않을 때
        		union(e[0],e[1]);
        		answer+=e[2];
        	}
        }
        System.out.println(answer);
        
    }
    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA; // rootB의 부모를 rootA로 설정
            return true;
        }
        return false;
    }
    
    public static int find(int a) {
    	if(parent[a]==a) return a;
    	return parent[a]=find(parent[a]);
    }
}

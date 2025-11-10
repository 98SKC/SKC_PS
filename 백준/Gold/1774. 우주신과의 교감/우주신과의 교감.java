import java.io.*;
import java.util.*;

public class Main {

	public static boolean[][] v;
	public static int[] parent;
	public static int[][] point;
	public static int N,M;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // A는 우주신과 교감할 수 있다.
        // 우주신은 여럿이 있다.
        // 우주신들은 A와 연결 없이, 이미 우주신끼리 교감이 가능한 루트가 있다.
        
        // 이미 A와 연결된, 혹은 우주신들의 교감 통로와 가중치가 주어ㅣㄴ다.
        // 아직 연결이 되지 않은 우주신들을 연결하라.
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        parent=new int[N+1];
        point=new int[N+1][2];
        v=new boolean[N+1][N+1];
        
        for(int i=1;i<=N;i++) {
        	parent[i]=i;
        	st = new StringTokenizer(br.readLine());
        	point[i][0]=Integer.parseInt(st.nextToken());
        	point[i][1]=Integer.parseInt(st.nextToken());
        }
        
        int A,B;
        for(int i=1;i<=M;i++) {
        	st = new StringTokenizer(br.readLine());
     
        	A=Integer.parseInt(st.nextToken());
        	B=Integer.parseInt(st.nextToken());
        
        	v[A][B]=true;
        	v[B][A]=true;
        	
        	union(A,B);
        	
        }
        
        PriorityQueue<double[]> pq=new PriorityQueue<>(new Comparator<double[]>() {
        	@Override
        	public int compare(double[] o1, double[] o2) {
        		return Double.compare(o1[2], o2[2]);
        	}
        });
        
        for(int i=1;i<=N;i++) {
        	for(int j=i+1;j<=N;j++) {
            	if(!v[i][j]) pq.add(new double[] {i,j,calDis(i,j)});
            }
        }
        
        double answer=0;
        double[] p;

        while(!pq.isEmpty()) {
        	p=pq.poll();
        	
        	if(union((int)p[0],(int)p[1])) {
        		answer+=p[2];
        	}else {
        		continue;
        	}
	
        }
        System.out.printf("%.2f\n", answer);
        
    }
    
    public static boolean union(int A, int B) {
    	int pa=find(A);
    	int pb=find(B);
    	
    	if(pa==pb) return false;
    	
    	if(pa>pb){
    		parent[pa]=pb;
    	}else {
    		parent[pb]=pa;
    	}
    	
    	return true;
    	
    }

    
    public static int find(int A) {
    	if(parent[A]==A) return A;
    	return parent[A]=find(parent[A]);
    }
    
    
    public static double calDis(int A, int B) {
        long dx = (long) point[A][0] - point[B][0];
        long dy = (long) point[A][1] - point[B][1];
        long sq = dx * dx + dy * dy;         
        return Math.sqrt((double) sq);
    }
    
}

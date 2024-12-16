import java.util.*;
import java.io.*;
import java.io.*;
public class Main {

	public static int N,M;
	public static int[][] map;
	public static boolean[] v;
	public static int[] p;
//	public static ArrayList<List<Integer>> g;

	public static void main(String[] args) throws Exception {
    
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	v=new boolean[N];
    	map=new int[N][N];// 간선 정보
    	p=new int[N];
//    	g=new ArrayList<>();
//    	for(int i=0;i<N;i++) {
//    		g.get(i)
//    	}
    	String str;
    	
    	//해놓고 나니 필요 없다. 아니 오히려 틀린다. 그냥 (0,1) (0,2) (0,3) (1,2) 순으로 q에 넣으면 된다
//    	PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
//		
//    		@Override
//    		public int compare(int[] o1, int[] o2) {
//    			//근데 우리가 쓸건 o1[0] o1[1] 둘다 작은 것들만
//    			if(o1[0]==o2[0]) {
//    				return o1[0]-o2[0];
//    			}
//    			return o1[1]-o2[1];
//    			
//    		}
//    	
//    	});
    	ArrayDeque<int[]> q=new ArrayDeque<int[]>();
    	
    	for(int i=0;i<N;i++) {
    		p[i]=i;
    	}
    	
    	for(int i=0;i<N;i++) {
    		str=br.readLine();
    		for(int j=i+1;j<N;j++) {
    			if(str.charAt(j)=='Y') {
    				map[i][j]=1;// 도로가 있다.
    				q.add(new int[]{i,j});// 모든 간선을 우선 넣어둔다.
    			}else {
    				map[i][j]=0;// 도로가 없다.
    			}
    		}
    	}
    	
    	int[] node;

    	int beforeI=-1;
    	int beforeJ=-1;
    	int count=0;
    	StringBuilder sb=new StringBuilder();
    	ArrayDeque<int[]> c=new ArrayDeque<int[]>();
		if(!(q.size()<M)) {
			int[] answer=new int[N];
	    	while(!q.isEmpty()) {
				node=q.poll();
				if(!(node[0]>beforeI&&node[1]>beforeJ)) {
					continue;
				}
				
				if(find(node[0])!=find(node[1])) {// 모든 정점을 연결하는 것을 우선
					//System.out.println("확정된 간선");
					//System.out.println(node[0]+" "+node[1]);
					answer[node[0]]++;
					answer[node[1]]++;// 모든 정점을 연결하는 것을 우선
					union(node[0],node[1]);
					count++;
					
				}else {
					c.add(node);// 나중에 답 출력할 때 들어가기 위해
				}
				
				
			}
	    	if(count!=N-1) {
	    		sb.append(-1);
	    	}else {
	    		int[] sub;
	    		for(int i=N-1;i<M;i++) {// 지금 답에는 딱 점점의 개수-1만큼 들어가있을 것
	    			if(c.isEmpty()) {// 만약 집합의 간선 수가 M이 될 수 없는 경우
	    				sb.append(-1);
	    				break;
	    			}
					
	    			sub=c.poll();
	    			//System.out.println("확정된 간선");
					//System.out.println(sub[0]+" "+sub[1]);
	    			answer[sub[0]]++;
	    			answer[sub[1]]++;
	    		}
	    		for(int i=0;i<N;i++) {
	    			sb.append(answer[i]+" ");
	    		}
	    	}
		}else{
			sb.append("-1");
		}

    	System.out.println(sb);
    }
	
	public static boolean check(int a,int b,int c,int d) {
		if(a<b&&b<d) {
			return true;
		}
		return false;
	}
	static void make() {
		
		p=new int[N];
		for(int i=0;i<N;i++) p[i]=i;
	}
	static int find(int a) {
		if(p[a]==a) return a;
		return find(p[a]);
	}
	
	static boolean union(int a,int b) {
		int pa=find(a);
		int pb=find(b);
		if(pa==pb) return false;
		p[pb]=pa;
		return true;
			
	}
}
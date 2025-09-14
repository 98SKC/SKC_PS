
import java.util.*;
import java.io.*;

public class Main {
	

    public static int N,M,a,b,c;
	public static ArrayList<Integer>[] edges;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());//정점 개수
        M=Integer.parseInt(st.nextToken());//간선 개수
        a=Integer.parseInt(st.nextToken());//타임머신 위치
        b=Integer.parseInt(st.nextToken());//돌아가는 위치
        c=Integer.parseInt(st.nextToken());//돌아가는 시간.
        edges=new ArrayList[N+1];
     
        
        for(int i=1;i<=N;i++) {
        	edges[i]=new ArrayList<>();
        }
        
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	edges[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }
        boolean inf=false;
        
        
        //정점 N개, 간선 M개의 방향 그래프
        //이동에 걸리는 가중치는 1
        //a번 정짐에 도착하면 b정점으로 이동하며 c만큼 시간이 줄어든다.
        //타임머신 이용 횟수에는 제한이 없다.
        //1번에서 N번까지의 최단 거리를 구하라.
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return Integer.compare(o1[1], o2[1]);
        	}
        });
        
        
        //무한으로 시간을 줄일 수 있는가. 
        //a->b->a->b 과정이 음수가 나오는가로 판별.
        int[] distFromB = new int[N+1];
        Arrays.fill(distFromB, Integer.MAX_VALUE);
        ArrayDeque<Integer>q=new ArrayDeque<>();
        q.add(b);
        distFromB[b] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : edges[u]) {
                if (distFromB[v] == Integer.MAX_VALUE){
                    distFromB[v] = distFromB[u] + 1;
                    q.add(v);
                }
            }
        }
        
        
        //무한루프가 있는데, 이게 도달은 가능하냐를 확인
     // (2) 역방향 그래프로 N 도달성
        ArrayList<Integer>[] rev = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) rev[i] = new ArrayList<>();
        for (int u = 1; u <= N; u++) {
            for (int v : edges[u]) rev[v].add(u);
        }
        boolean[] canReachN = new boolean[N+1];
        ArrayDeque<Integer> rq = new ArrayDeque<>();
        rq.add(N);
        canReachN[N] = true;
        while (!rq.isEmpty()) {
            int u = rq.poll();
            for (int prv : rev[u]) {
                if (!canReachN[prv]) {
                    canReachN[prv] = true;
                    rq.add(prv);
                }
            }
        }
        
        //음수사이클이 있는가?
        boolean negCycle = (distFromB[a]!=Integer.MAX_VALUE && distFromB[a]<c);
        
        //사이클 영역에서 N으로 빠질 수 있는가?
        boolean canExit = (canReachN[a]||canReachN[b]);

        
        int[] min=new int[N+1];
        Arrays.fill(min, Integer.MAX_VALUE);
        pq.add(new int[] {1,0});
        int[] p;
        min[1]=0;
        while(!pq.isEmpty()) {
        	p=pq.poll();
        	if(p[1]>min[p[0]]) continue;
        	
        	if(p[0]==a){//타임머신이라면
        		pq.add(new int[] {b,p[1]-c});
        		//이용을 안할 수도 있네.
        		//continue;
        	}
        	//그럼 타임머신을 무한히 이용하는 경우를 고려하면 끝. 
            
        	
        	//실제로 사이클 영역(a/b)에 도달했고 출구가 있으면 즉시 -inf
            if (negCycle && canExit && (p[0]==a || p[0]==b)) {
                System.out.println("-inf");
                return;
            }
        	
        	for(int next:edges[p[0]]) {
        		if(min[next]>p[1]+1) {
        			min[next]=p[1]+1;
        			pq.add(new int[] {next,min[next]});
        		}
        	}
        	
        }
        
        if(min[N]==Integer.MAX_VALUE)System.out.println('x');
        else System.out.println(min[N]);

    }
        
}



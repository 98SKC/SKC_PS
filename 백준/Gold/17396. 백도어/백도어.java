import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken()); //분기점의 수
        int M=Integer.parseInt(st.nextToken()); //분기점 들을 잇는 간선의 수
        
        //챔피언이 N개의 분기점에 위치. 지금 0번째에 위치.
        //N-1은 목적지로, 들킬 수 있는 분기점은 지나치지 않는다.
        
        boolean[] site=new boolean[N+1];
        
        st = new StringTokenizer(br.readLine());
        //각 분기점이 적의 시야에 보이는지를 의미하는 0과 1. 0이 보이지 않는다는 뜻
        for(int i=0;i<N;i++) {
        	if(Integer.parseInt(st.nextToken())==1) {
        		site[i]=true;        		
        	}
        }
        site[N-1]=false;
        long[] dijk=new long[N];
        ArrayList<int[]>[] edges=new ArrayList[N];
        for(int i=0;i<N;i++) {
        	edges[i]=new ArrayList<int[]>();
        }
        
        int a,b,c;
        final long INF = Long.MAX_VALUE / 4;
        Arrays.fill(dijk, INF);
        dijk[0] = 0;
        
        for(int m=0;m<M;m++) {
        	st = new StringTokenizer(br.readLine());
        	//a와b가 c코스트로 연결되어 있다.
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	c=Integer.parseInt(st.nextToken());
        	
        	if(site[a]||site[b]) continue;
        	
        	edges[a].add(new int[] {b,c});
        	edges[b].add(new int[] {a,c});
        	
        }
        
        
        PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long[]>() {
        	@Override
        	public int compare(long[] o1, long[] o2) {
        		return Long.compare(o1[1], o2[1]);
        	}
        });
        
        
        long[] p;
        pq.add(new long[] {0,0});
        
        while(!pq.isEmpty()){
        	p=pq.poll();
        	
        	if(p[0]==(N-1)) break;
        	if(p[1]>dijk[(int)p[0]]) continue;
        	for(int[] next:edges[(int)p[0]]){
        		//next[0]은 다음 노드
        		//next[1]은 코스트
        		//시야에 보이지 않는 분기이며, 지금까지의 최단거리보다 이번 경로가 짧다면
        		if(dijk[next[0]]>p[1]+next[1]){
        			dijk[next[0]]=p[1]+next[1];
        			pq.add(new long[] {next[0],dijk[next[0]]});
        		}
        	}
        	
        }
        
        //System.out.println(Arrays.toString(dijk));
        if(dijk[N-1]==INF) dijk[N-1]=-1;
        System.out.println(dijk[N-1]);
    }

}

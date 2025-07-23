
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); //도시의 수
        int M=Integer.parseInt(st.nextToken()); //도로의 수
        int K=Integer.parseInt(st.nextToken()); //면접장의 수
        //도시는 1번부터 N번까지 존재
        //int[][] road=new int[N+1][N+1];
        //ArrayList<int[]>[] road=new ArrayList[N+1];
        HashMap<Integer,Integer>[] road=new HashMap[N+1];
        for(int i=1;i<=N;i++) {
        	road[i]=new HashMap<>();
        }
        
        int U,V,C;
        
        //도로는 단방향
        //도로가 여러개일 수 있는데, 이렇게 저장하면 최소 도로를 어떻게 저장할까
        
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	U=Integer.parseInt(st.nextToken()); 
            V=Integer.parseInt(st.nextToken()); 
            C=Integer.parseInt(st.nextToken()); 
            //road[U].add(new int[] {V,C});
            if(road[V].containsKey(U)&&road[V].get(U)>C){
            	road[V].put(U,C);
            }else {
            	road[V].put(U,C);// V로 오는 도시는 U가 C의 거리로 있다.
            }
           
        }
        
        long[] answer=new long[N+1];
        for(int i=1;i<=N;i++) {
        	answer[i]=Long.MAX_VALUE;
        }

        PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long[]>() {
        	@Override
        	public int compare(long[] o1, long[] o2) {
        		if(o1[1]==o2[1]) return Long.compare(o2[0],o1[0]);// 큰 도시를 먼저 처리함으로써 작은 수의 도시가 마지막에 처리되도록
        		return Long.compare(o1[1],o2[1]);
        	}
        	
        });
        st=new StringTokenizer(br.readLine());
        int k;
        
        for(int i=0;i<K;i++) {
        	k=Integer.parseInt(st.nextToken());
        	answer[k]=0;
        	pq.add(new long[] {k,0});
        	
        }
        long max=0;
        int city=0;
        long[] p;
        
        
        while(!pq.isEmpty()) {
        	p=pq.poll();
        	
        	if(answer[(int)p[0]]<p[1]) continue;
        	
        	city=(int) p[0];//
        	max=p[1];
        
//        	for(int i=1;i<=N;i++) {
//        		//주의. 도로방향을 역추적 중. 즉 city를 오려면 road[i][city]가 있어야함
//        		if(road[i][city]!=Integer.MAX_VALUE) {// p[0]에서 i도시로 가는 도로가 있으면
//        			
//        			if(road[i][city]+p[1]<answer[i]){
//        				answer[i]=road[i][city]+p[1];
//        				pq.add(new int[] {i,answer[i]});
//        			}
//        		}
//        	}
        	int dis;
        	for(int next:road[city].keySet()) {
        		//주의. 도로방향을 역추적 중. 즉 city를 오려면 road[i][city]가 있어야함
        		dis=road[city].get(next);
        		if(dis+p[1]<answer[next]){
    				answer[next]=dis+p[1];
    				pq.add(new long[] {next,answer[next]});
    			}
        	}
        	
        }
        //System.out.println(Arrays.toString(answer));
        //System.out.println("---------------------");
        
        System.out.println(city);
        System.out.println(max);
        //여러 도시가 있고, 
        //면접장이 배치된 도시가 있고
        //도시끼리 도로가 없거나, 있거나, 여러개 있을 수 있다.
        //모든 면접자는 가장 가까운 면접장을 최단거리로 찾는다.
        //가장 먼 도시에서 오느 면접자에게 교통비를 주려한다.
        //가장 먼 도시와 그 거리를 구하라.
        
        
    }
}

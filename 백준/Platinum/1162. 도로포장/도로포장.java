
import java.util.*;
import java.io.*;

public class Main{

	public static int N,M,K;
	public static long[][] dijk;
	public static ArrayList<int[]>[] road;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); //도시의 수
        M=Integer.parseInt(st.nextToken()); //도로의 수
        K=Integer.parseInt(st.nextToken()); //포장할 도로의 수
        road=new ArrayList[N+1];
        
        for(int i=1;i<=N;i++) {
        	road[i]=new ArrayList<>();
        }
        
        int a,b,c;
        
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	c=Integer.parseInt(st.nextToken());
        	
        	road[a].add(new int[] {b,c});
        	road[b].add(new int[] {a,c});
        	
        }
        
        dijk=new long[N+1][K+1];
        
        PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long[]>() {
        	
        	@Override
        	public int compare(long[] o1, long[] o2) {
        		return Long.compare(o1[1], o2[1]);
        	}
        	
        });
        
        pq.add(new long[] {1,0,0});// 도시, 이동거리, 포장횟수
        
        long[] p;
        long city;
        long distance;
        long cnt;
        for(int i=2;i<=N;i++) {
        	for(int k=0;k<=K;k++) {
        		dijk[i][k]=Long.MAX_VALUE;
        	}
        }
        
        for(int k=0;k<=K;k++) {
    		dijk[1][k]=0;
    	}
        
        //int answer=Integer.MAX_VALUE;
        long answer=0;
        // k+1번 포장했을 때 최소 
        
        //해당 지역을 지금까지보다 포장한 횟수보다 적은 방법으로 갈 수 있다면 갈 필요가 없지.
        //두번 포장해서 가는 곳을 세번포장해서 더 짧게 갈 수는 있는데,
        //두번 포장해서 가능 곳을 한번만 포장해서 갈 수 있....지?
        //지금 이 루트에서 방문을 했었다면 안가도록 해야함.
        //그럼 v를 어떻게 만들어야 하나.
        //배열에 v자체를 넣는건 너무 메모리 낭비같고
        
        boolean[][] v=new boolean[N+1][K+1];
        
        while(!pq.isEmpty()) {
        	p=pq.poll();
        	city=p[0];
        	distance=p[1];
        	cnt=p[2];
        	if(dijk[(int)city][(int)cnt]<distance) continue;
        	
        	//System.out.println(Arrays.toString(p));
        	if(city==N) {
        
        		answer=distance;
        		break;
        	}
        	
        	
        	for(int[] next: road[(int)city]) {
        		
        		if(dijk[next[0]][(int)cnt]>distance+next[1]){// 기록된 최단거리 > 지금까지 이동거리 + 도로길이 
        			dijk[next[0]][(int)cnt]=distance+next[1];
        			pq.add(new long[] {next[0],distance+next[1],cnt});
        		}
        		
        		if(cnt<K && dijk[next[0]][(int)cnt+1]>distance){
        			dijk[next[0]][(int)cnt+1]=distance;
        			pq.add(new long[] {next[0],distance,cnt+1});
        		}
        	}
        	
        }
        

        
//        for(int i=2;i<=N;i++) {
//        	System.out.print(i+" 거리까지 k횟수에 따른 최소 거리 : ");
//        	System.out.println(Arrays.toString(dijk[i]));
//        }
//        System.out.println();
        

        System.out.println(answer);
        
        //N개의 도시. K개의 도로를 포장.
        //포장된 도로는 이동시간이 0으로.
        
        //다익스트라인데, dp?
        //해당 점까지 k번 도로를 포장했을 때 올수 있는 최단 경로 같은
        
        
        
        
        
    }
}

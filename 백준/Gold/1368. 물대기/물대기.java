
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        int[] wells=new int[N];//N개의 논 각자에 대한 우물 파는 비용
        
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return o1[1]-o2[1];
        	
        	}
        });
        
        for(int i=0;i<N;i++) {
        	wells[i]=Integer.parseInt(br.readLine());
        	pq.add(new int[] {i,wells[i]});
        }
        
        int[][] edges=new int[N][N]; //각 논에서 물을 끌어오는 가격
        
        StringTokenizer st;
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
            	edges[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        int[] p;
        boolean[] v=new boolean[N];
        int total=0;
        int answer=0;
        while(!pq.isEmpty()) {
        	if(total==N) break;
        	
        	p=pq.poll();
        	
        	if(v[p[0]]) continue;
        	answer+=p[1];
        	v[p[0]]=true;
        	total++;
        	for(int i=0;i<N;i++){
        		if(v[i]) continue;
        		pq.add(new int[] {i,edges[p[0]][i]});
        	}
        	
        }
        System.out.println(answer);
        // 하나 우물 파는게 10인데, 여기서 연결하는게 다 1이면
        // 하나 하나 파는게 2인것보다 코스트가 낮을 수 있는데
        // 이걸 어떻게 구별하냐는 거지
        
        //N개의 논에 물을 대려고 한다.
        //물을 대는 것은
        //1. 논에 직접 우물을 판다
        //2. 다른 논으로부터 물을 끌어온다.
        
        //각 논에대해 우물을 파는 비용과 물을 끌어오는 비용이 주어질 때 최소 비용
        
        
    }
}

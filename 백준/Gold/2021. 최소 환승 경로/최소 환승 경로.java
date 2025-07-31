
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); //역의 개수
        int L=Integer.parseInt(st.nextToken()); //노선의 개수
        
        int station;
        
        //각 노선이 지나는 역의 정보
        List<int[]>[] list=new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	list[i]=new ArrayList<>();
        }
        
        int start, end;
        int before;
        for(int i=1;i<=L;i++) {
        	st=new StringTokenizer(br.readLine());
        	before=Integer.parseInt(st.nextToken());
        	
        	while(true) {
        		station=Integer.parseInt(st.nextToken());
        		if(station==-1) break;
        		
        		list[station].add(new int[] {before,i});
        		list[before].add(new int[] {station,i});
        		
        		before=station;
        	}
        }
        
        boolean[] v=new boolean[N+1];
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2 ){
        		return o1[2]-o2[2];

        	}
        });
        
        st=new StringTokenizer(br.readLine());
        start=Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());
        
        pq.add(new int[] {start,0,0});//현 위치, 탑승중인 노선 ,환승 횟수
        int[] p;
        int cnt;
        int answer=-1;
        int line;
        
        while(!pq.isEmpty()) {
        	p=pq.poll();
        	
        	station=p[0];
        	line=p[1];
        	cnt=p[2];
        	
        	if(v[station]) continue;
        	v[station]=true;
        	
        	if(station==end) {
        		answer=cnt;
        		break;
        	}
        	
        	for(int[] next: list[station]) {
        		//next[0]- 다음 역
        		//next[1]- 그 역으로 가기위해 타야하는 노선
        		if(!v[next[0]]) {//처음 탑승한 역이거나 || 방문하지 않았다면 이동
        			if(line==0||line==next[1]) {
        				pq.add(new int[] {next[0],next[1],cnt});        	        				
        			}else {
        				pq.add(new int[] {next[0],next[1],cnt+1});  
        			}
        			
        		}

        	}
        	
    		//
        	
        }
        
        
        System.out.println(answer);

        
    }
}

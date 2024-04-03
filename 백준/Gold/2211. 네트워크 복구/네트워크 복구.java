import java.util.*;
import java.io.*;

public class Main {
 
	static class computer implements Comparable<computer>{
		List<int[]> edgeList;// 어떤 경로로 여기까지 왔는지.
		//answer(arr)용.pq용
		
		int num;// 지금 노드번호이자, list[start]의 도착지
		int time;

		//시작 큐 넣기용.
		public computer(int num, int time) {
			edgeList=new ArrayList<>();
			this.num=num;
			this.time=time;
		}
		
		//리스트 저장 용
		public computer(int start,int num, int time) {
			edgeList=new ArrayList<>();
			edgeList.add(new int[] {start,num});
			this.num=num;
			this.time=time;
		}
		
		
		//경로 연결
		public computer(List<int[]> edgeList,int num, int time) {
			this.edgeList=edgeList;
			this.num=num;
			this.time=time;
		}

		@Override
		public int compareTo(computer o) {
			// TODO Auto-generated method stub
			return time-o.time;
		}
	}
	
	static int N,M;
	static List<computer>[] list;
	static computer[] arr;
	static boolean v[];
	static boolean[][] check;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        list=new List[N+1];
        arr=new computer[N+1];
        //arr는 K에서 인덱스까지의 최단경로
        for(int i=0; i<=N; i++) {
            arr[i] = new computer(i, Integer.MAX_VALUE);
        }
        
        v=new boolean[N+1];
        check=new boolean[N+1][N+1];
        for(int i=1;i<=N;i++) {
        	list[i]=new ArrayList<>();
        }
        
        int subNum,subNext,subTime;
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	subNum=Integer.parseInt(st.nextToken());
        	subNext=Integer.parseInt(st.nextToken());
        	subTime=Integer.parseInt(st.nextToken());
        	list[subNext].add(new computer(subNext,subNum,subTime));
        	list[subNum].add(new computer(subNum,subNext,subTime));
        	
        }
        dijkstra();
        
        List<int[]> answer=new ArrayList<>();
        for(computer c:arr) {//질문. 여기도 null이 잡혀. dijkstra(); 에서 arr은 채워지지 않
            
        	for(int[] a:c.edgeList) {
        		if(!check[a[0]][a[1]]) {
        			answer.add(a);
        			check[a[0]][a[1]]=true;
        			check[a[1]][a[0]]=true;
        		}
        	}
        }
        System.out.println(answer.size());
        for(int[] z:answer) {
        	System.out.println(z[0]+" "+z[1]);
        }
        
        
    }
    
    static void dijkstra() {
    	PriorityQueue<computer> q=new PriorityQueue<>();//우선순의 큐를 사용한 다익스트라.
		q.add(new computer(1,0));// 시작 노드를 큐에 삽입
		arr[1].time=0;//스스로에 대한 가중치는 0
		
		while(!q.isEmpty()) {
			computer c=q.poll();
			int num=c.num;
			
			if(v[num]) continue;
			v[num]=true;
			
			for(computer next:list[num]) {
				if(arr[next.num].time>arr[num].time+next.time) {
					arr[next.num].time=arr[num].time+next.time;
					
					List<int[]> newList = new ArrayList<>();
					for (int[] edge : c.edgeList) {
					    newList.add(Arrays.copyOf(edge, edge.length));
					}
					arr[next.num].edgeList = newList;
					//System.out.println("여기 돌긴하나?");
					arr[next.num].edgeList.add(new int[] {num,next.num});
					
	                q.add(new computer(arr[next.num].edgeList, next.num, arr[next.num].time));
				}
			}
			
			
		}
    }
}
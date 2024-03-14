import java.util.*;
import java.io.*;


public class Main {
	static List<Node>[] weight;// 주어지는 가중치
	static int V,E,K;//V- 1부터 V까지의 번호를 갖는 정점. E개의 간선, K 시작 정점의 번호
	static boolean[] check;
	static int[] answer;
	static int count=1;

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());

		V=Integer.parseInt(st.nextToken());//
		E=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(br.readLine());
		
		int a,b,c;
		
		weight=new ArrayList[V+1];
		check=new boolean[V+1];
		answer=new int[V+1];
		
		//answer는 K에서 인덱스까지의 최단경로
		Arrays.fill(answer, Integer.MAX_VALUE);
        
        for(int i = 1; i <=V; i++){
            weight[i] = new ArrayList<>();
        }
		
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			//System.out.printf("%d와 %d의 간선 %d \n" ,a,b,c);
			weight[a].add(new Node(b,c));
		}
		
		
		dijkstra();
		

		for(int i=1;i<=V;i++) {
			if(check[i]) sb.append(answer[i]).append("\n");
			else {sb.append("INF").append("\n");}
			
		}
		
		System.out.println(sb);
	}
	
	static void dijkstra() {
		PriorityQueue<Node> q=new PriorityQueue<>();//우선순의 큐를 사용한 다익스트라.
		q.add(new Node(K,0));// 시작 노드를 큐에 삽입
		answer[K]=0;//스스로에 대한 가중치는 0
		
		while(!q.isEmpty()) {// 큐가 빌때까지.-> 이동 가능한 노드가 없을 때 까지
			Node n=q.poll();
			int next=n.next;// 다음 노드
			
			if(check[next]) continue;// 이미 연결되어 있다.-> 옛날 정보이다.
			
			check[next]=true;// 큐에서 빠지는 순서대로 노드가 연결.
			count++;// 간선의 수가 많은 경우를 대비한 break용 변수
			if(count==V+1) break;
			
//			System.out.println(next);
			
			
			//추가된 노드 그룹에 대해 최단거리를 갱신.
	          for(Node node : weight[next]) {//간선 정보를 확인.
	        	 //지금 추가된 노드에서 뻗는 경우가, 지금까지 저장된 최단 거리보다 짧은 경우 최단 거리를 갱신.
	        	 //node.next: 이번에 연결된 노드에서 갈 수 있는 노드
	        	 //next. 이번에 연결된 노드
	        	 //node.weight: 이번에 연결된 노드에서 갈 수 있는 노드에 대한 가중치 
	             if(answer[node.next] > answer[next] + node.weight) { 
	                answer[node.next] = answer[next] + node.weight;
	                q.add(new Node(node.next,answer[node.next]));
	             }
	          }
		}
		
		
		
		
	}
	static class Node implements Comparable<Node>{// 노드 클래스. 다음 노드의 번호와 간선 데이터를 갖는다.
		public int next;
		public int weight;
		
		Node(int next, int weight){
			this.next=next;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Node o) {// 간선 크기에 따른 우선순위.
			return weight-o.weight;// 가중치가 낮은 노드부터 큐에서 선택
		}
	}

}
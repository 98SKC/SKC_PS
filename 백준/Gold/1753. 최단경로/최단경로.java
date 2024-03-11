import java.util.*;
import java.io.*;


public class Main {
	static List<Node>[] weight;// 주어지는 가중치
	static int V,E,K;
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
		PriorityQueue<Node> q=new PriorityQueue<>();
		q.add(new Node(K,0));
		answer[K]=0;//스스로에 대한 가중치는 0
		
		while(!q.isEmpty()) {
			Node n=q.poll();
			int next=n.next;
			
			if(check[next]) continue;
			
			check[next]=true;
			count++;
			if(count==V+1) break;
			
//			System.out.println(next);
			
			
	          for(Node node : weight[next]) {
	        	// System.out.println(node.next);
	             if(answer[node.next] > answer[next] + node.weight) {
	                answer[node.next] = answer[next] + node.weight;
	                q.add(new Node(node.next,answer[node.next]));
	             }
	          }
		}
		
		
		
		
	}
	static class Node implements Comparable<Node>{
		public int next;
		public int weight;
		
		Node(int next, int weight){
			this.next=next;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return weight-o.weight;
		}
	}

}
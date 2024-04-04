import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static boolean[] v;
	static int[][] map;
	static int[][] answer;
	static int N;
	static int[] di=new int[] {0,1,0,-1};
	static int[] dj=new int[] {1,0,-1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= test; t++) {
			
			N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			v=new boolean[N*N];
			answer=new int[N][N];
			for(int i=0;i<N;i++) {
				Arrays.fill(answer[i], Integer.MAX_VALUE);
			}
			
			String str;
			for(int i=0;i<N;i++) {
				str=br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j]=str.charAt(j)-'0';	
				}
			}
			
			PriorityQueue<Node> pq=new PriorityQueue<>();
			pq.add(new Node(0,0));
			int pos;
			int i,j,ni,nj;
			while(!pq.isEmpty()) {
				Node node=pq.poll();
				pos=node.pos;
				if(v[pos]) continue;
				v[pos]=true;
				i=pos/N;
				j=pos%N;
				if(i==N-1&&j==N-1) {
					sb.append("#"+t+" "+answer[i][j]+"\n");
					break;
				} 
				
				for(int a=0;a<4;a++) {
					ni=i+di[a];
					nj=j+dj[a];
					
					if(ni>=0&&ni<N&&nj>=0&&nj<N) {
						if(answer[ni][nj]>node.weight+map[i][j]) {
							answer[ni][nj]=node.weight+map[i][j];
							pq.add(new Node(ni*N+nj,answer[ni][nj]));
						}
					}

				}
			}
			
		}
		System.out.println(sb);
	}
	static void helper() {
		
	}
	static class Node implements Comparable<Node>{
		int pos;
		int weight;
		
		public Node(int pos, int weight) {
			this.pos=pos;
			this.weight=weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return weight-o.weight;
		}
		
		
	}
	
	
	
	
}
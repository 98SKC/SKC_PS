import java.util.*;
import java.io.*;

public class Main {
	
	
	static List<Room>[] weight;
	static boolean[] check;
	static int[] answer;
	static int[][] map;
	static int N;
	static int count=0;
	static int[] di= {0,1,0,-1};
	static int[] dj= {1,0,-1,0};

	static StringBuilder sb=new StringBuilder();

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


		N=Integer.parseInt(br.readLine());
		do{
			map=new int[N][N];
			check=new boolean[N*N];
			answer=new int[N*N];
			Arrays.fill(answer, Integer.MAX_VALUE);
			
			
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			

			dijkstra();
			
			
			N=Integer.parseInt(br.readLine());
		}while(N!=0);
		
		System.out.println(sb);
	}
	
	static void dijkstra() {
		count++;
		PriorityQueue<Room> q=new PriorityQueue<>();
		
	    q.add(new Room(0, map[0][0])); 
	    answer[0] = map[0][0]; // 시작 위치의 도둑루피 값을 answer 배열에 반영.

		
		while(!q.isEmpty()) {
			Room n=q.poll();
			int nowPosition=n.pos;
			
			if(check[nowPosition]) continue;
			
			check[nowPosition]=true;
			if(nowPosition==N*N-1) {
				sb.append("Problem ").append(count).append(": ").append(answer[nowPosition]).append("\n");
				break;
			} 

			int i=nowPosition/N;
			int j=nowPosition%N;
			int ni,nj;
			
			//배열에서 이동가능한 4칸 확인
			for(int a=0;a<4;a++) {
				ni=i+di[a];
				nj=j+dj[a];
				
				if(ni>=0&&ni<N&&nj>=0&&nj<N) {
					//이동가능한 칸일 때, 그 칸으로 이동하는데의 최소 가중치가, 지금위치까지 가중치 + 그 노드의 가중치보다 크면 갱신 
					if(answer[ni*N+nj] > answer[nowPosition] + map[ni][nj]) {
						answer[ni*N+nj] = answer[nowPosition] + map[ni][nj];
						// 갈수 있는 노드를 가중치와 함께 우선순위 큐에 추가.
		                q.add(new Room(ni*N+nj,answer[ni*N+nj]));
		             }
				}
			}
	          
		}

	}
	
	
	static class Room implements Comparable<Room>{
		public int pos;
		public int price;
		
		Room(int next, int weight){
			this.pos=next;
			this.price=weight;
		}
		
		@Override
		public int compareTo(Room o) {
			return price-o.price;
		}
	}

}
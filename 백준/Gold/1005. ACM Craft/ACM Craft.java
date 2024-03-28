import java.util.*;
import java.io.*;



public class Main {

	

	static int T,N,K;
	static int goal;
	static List<Integer>[] list;
	static int[] building;
	static int[] inLine;
	static int[] answer;

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		T=Integer.parseInt(br.readLine());
		
		

		for(int test_case=1;test_case<=T;test_case++){
			
			
			Queue<Integer> q=new ArrayDeque<>();
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());// 건물의 개수
			K=Integer.parseInt(st.nextToken());// 건물 순서 규칙의 총 개수
			list=new ArrayList[N+1];//idx를 짓는데 지어야 하는 건물 수
			
			building=new int[N+1];// idx를 짓는데 걸리는 시간
			
			inLine=new int[N+1];// idx를 짓기 위해 필요한 남은 건물의 수
			
			answer=new int[N+1];// idx 건물을 짓는데 필요한 시간.
			boolean[] check=new boolean[N+1];
			//이후 각 건물당 건설에 걸리는 시간 공백을 기준으로 한줄 나열
			st=new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				list[i]=new ArrayList<>();//i 건물을 짓기 위해 지어야 하는 건물
				building[i]=Integer.parseInt(st.nextToken());// i건물의 건설시간
			}
			
			//이후 모든 줄은 건물 순서 x y.  x를 지어야 y를 지을 수 있다
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(br.readLine());
				int start=Integer.parseInt(st.nextToken());
				int end=Integer.parseInt(st.nextToken());
				list[start].add(end);
				inLine[end]++;
			}
		
			
			goal=Integer.parseInt(br.readLine());// 이 건물을 지어야함.
			
			for(int i=1;i<=N;i++) {
				if(inLine[i]==0) {
					answer[i]=building[i];// 초기 건물 건설 시간은 스스로의 건설 시간 하나만 하면 된다.
					q.add(i);
				} 
			}
			
			while(!q.isEmpty()) {
			
				int build=q.poll();// build를 짓는다. 
				if(check[build]) continue;// 이미 지었다.
				check[build]=true;
				
				for(int a:list[build]) {//build를 지으면 a를 지을 수 있다.
					if(answer[a]<answer[build]+building[a]) {
						answer[a]=answer[build]+building[a];
					}
					inLine[a]--;//a건물을 짓는데 필요한 건물 하나가 없어짐
					if(inLine[a]==0) q.add(a);;
				}			
				
				
			}
			sb.append(answer[goal]).append("\n");
		}//여기 내부에 구현
			
		
		
		
		System.out.println(sb);
		
	}
	
	
}
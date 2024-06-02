
import java.io.*;
import java.util.*;

public class Main {
	
	static int[] arr;
	static List<Integer>[] list;
	static int N,M;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
			
		int min=Integer.MAX_VALUE;
		int answer=0;
		list=new List[N+1];
		
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<Integer>();
		}
		int a,b;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		int sub;
		for(int i=1;i<=N;i++) {
			sub=dijkstra(i);
			if(min>sub) {
				min=sub;
				answer=i;
				
			}
		}

		System.out.println(answer);
	}
	
	
	static int dijkstra(int start) {
		
		boolean[] v=new boolean[N+1];
		int[] answer=new int[N+1];
		Queue<Integer> q=new ArrayDeque<Integer>();
		
		q.add(start);
		int sub;
		int max=0;
		for(int i=1;i<=N;i++) {
			answer[i]=Integer.MAX_VALUE;
		}
		answer[start]=0;
		
		while(!q.isEmpty()) {
			sub=q.poll();
			if(v[sub]) {
				continue;
			}
			v[sub]=true;
			
			for(int next:list[sub]) {
				if(answer[next]>answer[sub]+1) {
					answer[next]=answer[sub]+1;
					q.add(next);
				}

			}
		
		}
		//System.out.print(start+": ");
		for(int a:answer){
			//System.out.print(a+" ");
			max+=a;
		}
		//System.out.println();
		return max;
	}
}
import java.io.*;
import java.util.*;

public class Main {

	public static class Tree{
		
		int number;
		int next;
		
	}
	
	public static int N;
	public static int[] color;
	public static ArrayList<Integer>[] tree;
	public static boolean[] v;
	public static int answer=0;
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		tree=new ArrayList[N+1];

		color=new int[N+1];
		v=new boolean[N+1];
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for(int i=1;i<=N;i++) {
			tree[i]=new ArrayList<>();// 자식 노드 리스트 초기화
			color[i]=Integer.parseInt(st.nextToken()); // 노드 색 입력
			
		}
		int start;
		int end;
		for(int i=0;i<N-1;i++) {
			st=new StringTokenizer(br.readLine());
			start=Integer.parseInt(st.nextToken());
			end=Integer.parseInt(st.nextToken());
			
			tree[start].add(end);
			tree[end].add(start);
			
		}
		
		
		for(int i=1;i<=N;i++){
			if(!v[i]) dfs(i,0);
			
		}
		
		System.out.println(answer);
		
	}
	public static void dfs(int number, int p) {// number은 노드 넘버, p는 지금 적용될 색
		//System.out.println(number+" "+p);
		v[number]=true;
		int nextColor;
		if(color[number]!=p) {
			answer++;
			nextColor=color[number];
		}else {
			nextColor=p;
		}
		
		for(Integer next: tree[number]) {
			if(!v[next]) dfs(next, nextColor);
		}
		
	}
	
	
}
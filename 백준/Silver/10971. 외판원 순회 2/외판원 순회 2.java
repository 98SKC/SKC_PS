import java.io.*;
import java.util.*;
// 누적합 확실.
public class Main {
	
	static int[][] city;
	static boolean[] v;
	static int N, min=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		city=new int[N][N];
		v=new boolean[N];
		StringTokenizer st;
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				city[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		v[0]=true;
		dfs(1,0,0);
		System.out.println(min);
	}
	
	static void dfs(int cnt,int cost,int before) {
		if(cnt==N) {
			//System.out.println(Arrays.toString(v));
			if(city[before][0]!=0) {
				min=Math.min(min,cost+city[before][0]);
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!v[i]&&city[before][i]!=0) {// i노드가 방문한 적이 없고, 이전 노드에서 갈 수 있음.
				v[i]=true;
				dfs(cnt+1,cost+city[before][i],i);
				v[i]=false;
			}
		}
		
		
	}
}
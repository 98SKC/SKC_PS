
import java.util.*;
import java.io.*;

public class Main {

	public static int N;
    //public static ArrayList<Integer>[] edge;
    public static HashSet<Integer>[] edge;
	public static int[] answer;
    public static boolean[] v;
    public static int cnt=0;
   // public static boolean exit=false;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        //edge=new ArrayList[N+1];
        edge=new HashSet[N+1];
        for(int i=1;i<=N;i++) {
        	edge[i]=new HashSet<>();
        }
        
        int start,end;
        for(int i=0;i<N-1;i++) {
        	st=new StringTokenizer(br.readLine());
        	start=Integer.parseInt(st.nextToken());
        	end=Integer.parseInt(st.nextToken());
        	edge[start].add(end);
        	edge[end].add(start);
        	
        }
        st=new StringTokenizer(br.readLine());
        answer=new int[N+1];
        v=new boolean[N+1];
        for(int i=0;i<N;i++) {
        	answer[i]=Integer.parseInt(st.nextToken());
        }
        answer[N]=-1;
       // System.out.println("주어진 입력: "+Arrays.toString(answer));
        dfs(1);
        if(cnt==N) {
        	System.out.println(1);
        }else {
        	System.out.println(0);
        }
    }
	
	public static void dfs(int node) {
		//System.out.println("node: "+node+" ,cnt: "+cnt+" answer[cnt: ]"+answer[cnt]);
		
		v[node]=true;
		cnt++;// 

		while(edge[node].contains(answer[cnt])) {
			dfs(answer[cnt]);
			//System.out.println("dfs 함수 호출 후 cnt: "+cnt);
		}
		
		
	}
}

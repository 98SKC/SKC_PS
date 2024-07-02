import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Integer>[] list=new List[N+1];
        
        for(int i=1;i<=N;i++) {
        	list[i]=new ArrayList<Integer>();
        }
        int a,b;
        for(int i=0;i<N-1;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	
        	list[a].add(b);
        	list[b].add(a);
        }
        int[] answer=new int[N+1];
        boolean[] v=new boolean[N+1];
        Queue<Integer> q=new ArrayDeque<Integer>();
        q.add(1);
        int p;
        while(!q.isEmpty()) {
        	p=q.poll();
        	v[p]=true;
        	
        	
        	for(int child : list[p]) {
        		if(v[child]) continue;
        		answer[child]=p;
        		q.add(child);
        	}
        	
        	
        }
        for(int i=2;i<=N;i++) {
        	sb.append(answer[i]+"\n");
        	
        }
        System.out.println(sb);
        
    }
}

import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        
        
        StringTokenizer st;
        ArrayList<Integer>[] friend=new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	friend[i]=new ArrayList<>();
        }
        
        int a,b;
        while(true) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	if(a==-1) break;
        	
        	friend[a].add(b);
        	friend[b].add(a);
        	
        }
        //
        int min=Integer.MAX_VALUE;
        ArrayList<Integer> answer=new ArrayList<>();
        for(int i=1;i<=N;i++) {
        	ArrayDeque<int[]> q=new ArrayDeque<>();
        	q.add(new int[] {i,0});
        	boolean[] v=new boolean[N+1];
        	v[i]=true;
        	int[] sub;
        	int score=0;
        	while(!q.isEmpty()){
        		sub=q.poll();
        		score=Math.max(sub[1], score);
        		for(int next:friend[sub[0]]) {
        			if(!v[next]) {
        				q.add(new int[] {next,sub[1]+1});
        				v[next]=true;
        			}
        		}
        	}
        	
        	//새로운 회장 후보의 기준
        	if(score<min) {
        		min=score;
        		answer=new ArrayList<>();
        		answer.add(i);
        	}else if(score==min) {
        		answer.add(i);
        	}
        }
        System.out.println(min+" "+answer.size());
        for(int an:answer) {
        	System.out.print(an+" ");
        }
        
    }
}

import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());

    	int N=Integer.parseInt(st.nextToken());
    	int M=Integer.parseInt(st.nextToken());
    	ArrayList<Integer>[] list=new ArrayList[N+1];
    	
    	for(int i=1;i<=N;i++) {
    		list[i]=new ArrayList<Integer>();
    	}
    	
    	int subA,subB;
    	for(int i=0;i<M;i++) {
    		st=new StringTokenizer(br.readLine());
    		subA=Integer.parseInt(st.nextToken());
    		subB=Integer.parseInt(st.nextToken());
    		
    		list[subB].add(subA);
    		
    		
    	}
    	int sub;
    	int max=0;

    	int[] answer=new int[N+1];
    	for(int i=1;i<=N;i++) {
    		ArrayDeque<Integer> q=new ArrayDeque<>();
    		q.add(i);
    		boolean[] v=new boolean[N+1];
    		int count=0;
    		v[i]=true;
    		
    		while(!q.isEmpty()) {
    			sub=q.poll();
    			count++;
                for (int next : list[sub]) {
                    if (!v[next]) {
                        v[next] = true;  
                        q.add(next);
                    }
                }
                
    		}
    		answer[i]=count;
    		if(max<count) {
    			max=count;
    		}
    		
    	}

    	StringBuilder sb=new StringBuilder();
    	for(int i=1;i<=N;i++) {
    		if(answer[i]==max)sb.append(i+" ");
    	}
    	System.out.println(sb);
    
    	
    }
    
}
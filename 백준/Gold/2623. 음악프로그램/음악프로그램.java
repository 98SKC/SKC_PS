import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] edge=new ArrayList[N+1];
        int[] inDegree=new int[N+1];
        for(int i=1;i<=N;i++) {
        	edge[i]=new ArrayList<>();
        }
        
        int a,before,next;
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	before=Integer.parseInt(st.nextToken());
			for(int j=0;j<a-1;j++) {
	        	next=Integer.parseInt(st.nextToken());
	        	edge[before].add(next);//s 다음은 e다
	        	inDegree[next]++;//e의 진입차수가 증가한다/
	        	before=next;
			}

        }
        
       // System.out.println(Arrays.toString(inDegree));
        ArrayDeque<Integer> q=new ArrayDeque<>();
       // System.out.print("처음 시작:");
        for(int i=1;i<=N;i++) {
        	if(inDegree[i]==0) {
        		q.add(i);
        		//System.out.print(i+" ");
        	} 
        	
        }
        
       // System.out.println();
        StringBuilder sb=new StringBuilder();
        int sub;
        boolean[] v=new boolean[N+1];
        boolean check=true;
       // System.out.println("진입차수: "+Arrays.toString(inDegree));
        int count=0;
        while(!q.isEmpty()){
        	sub=q.poll();
        	if(v[sub]) {
        		break;
        	}
        	v[sub]=true;
        	count++;
        	sb.append(sub+"\n");
        	//System.out.print(sub+" 다음 ");
        	for(int n:edge[sub]) {
        		//System.out.print(n+" ");
        		inDegree[n]--;
        		if(inDegree[n]==0) {
        			//System.out.println("큐 들어간거?: "+n);
        			q.add(n);
        		}
        	}
        	//System.out.println();
        }
        
        if(count==N) {
        	System.out.println(sb);
        }else {
        	System.out.println(0);
        }
        
        
       
    }
}

import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list=new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
        	list[i]=new ArrayList<>();
        }
        boolean[] v=new boolean[N+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        
        int M=Integer.parseInt(br.readLine());
        int a,b;
        for(int m=0;m<M;m++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	
        	
        	list[a].add(b);
        	list[b].add(a);
        	
        }
        
        Stack<int[]> stack=new Stack<>();
        stack.push(new int[] {A,0});
        int len=0;
        int[] sub;
        int answer=-1;
        v[A]=true;
        while(!stack.isEmpty()) {
        	sub=stack.pop();
        	//System.out.println("??: "+Arrays.toString(sub));
        	for(int next:list[sub[0]]){
        
        		if(v[next]) continue;
        		if(next==B) {
        			answer=sub[1]+1;
        			break;
        		}
        		v[next]=true;
        		stack.push(new int[] {next,sub[1]+1});
        	}
        }
        System.out.println(answer);
        
    }
}

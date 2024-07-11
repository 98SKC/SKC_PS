import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws Exception {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	
    	arr=new int[N];
    	st=new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	int[] answer=new int[M];
    	dfs(0,answer,0);
    	System.out.println(sb);
    	
    	
    }
    
    public static void dfs(int pos,int[] answer,int len) {
    	if(len==M) {
    		for(int a:answer) {
    			sb.append(a+" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	int before=-1;
    	int now;
    	for(int i=pos;i<N;i++) {
    		now=arr[i];
    		if(before!=now) {
    			before=now;
    			answer[len]=now;
    			dfs(i,answer,len+1);
    		}
    	}
    } 
        
    
}
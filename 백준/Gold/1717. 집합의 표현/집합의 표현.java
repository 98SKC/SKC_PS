import java.util.*;
import java.io.*;

public class Main {

	static int[] parent;
    static int N,M;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        parent=new int[N+1];
        for(int i=0;i<N+1;i++) {
        	parent[i]=i;
        }
        int order,subA,subB;
        boolean check;
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	order=Integer.parseInt(st.nextToken());
        	subA=Integer.parseInt(st.nextToken());
        	subB=Integer.parseInt(st.nextToken());
        	
        	if(order==0) {
        		union(subA,subB);
        	}else {
        		check=findSame(subA,subB);
        		if(check) {
        			sb.append("YES\n");
        		}else {
        			sb.append("NO\n");
        		}
        	}
        }
        System.out.println(sb);
        
	
	}
    
    static int find(int a) {
    	if(parent[a]!=a) {
    		parent[a]=find(parent[a]);
    	}
    	return parent[a];
    }
    
    static boolean findSame(int a,int b) {
    	if(find(a)==find(b)) {
    		return true;
    	}
    	return false;
    }
    static boolean union(int a,int b) {
    	int rootA=find(a);
    	int rootB=find(b);
    	
    	if(rootA==rootB) {
    		return false;
    	}
    	if(rootA<rootB) {
    		parent[rootB]=rootA;
    	}else {
    		parent[rootA]=rootB;
    	}

    	return true;
    }
}
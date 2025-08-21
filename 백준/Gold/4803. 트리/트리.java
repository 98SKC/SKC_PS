
import java.util.*;
import java.io.*;

public class Main {

	public static int[] parent;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        int N,M;
        int a,b;
        HashSet<Integer> set;
        int pa,pb;
        int answer=0;
        StringBuilder sb=new StringBuilder();
        int turn=1;
        while(true) {
        	st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            if(N==0&&M==0) break;
            parent=new int[N+1];
            
            for(int i=1;i<=N;i++) {
            	parent[i]=i;
            }
            for(int i=0;i<M;i++) {
            	st=new StringTokenizer(br.readLine());
            	a=Integer.parseInt(st.nextToken());
            	b=Integer.parseInt(st.nextToken());
            	
            	pa=find(a);
            	pb=find(b);
            	
            	union(a,b);
//            	if(union(a,b)){//트리가 맞음.
//            		
//            	}else {//트리가 아님
//            		
//            	}
            	
            }
            set=new HashSet<>();
//            System.out.println("부모상태: "+Arrays.toString(parent));
            for(int i=1;i<=N;i++) {
            	set.add(find(parent[i]));
            }
            
            if(set.contains(0)) set.remove(0);
            
            answer=set.size();
            sb.append("Case "+turn+": ");
            if(answer==0) sb.append("No trees.\n");
            else if(answer==1)sb.append("There is one tree.\n");
            else sb.append("A forest of ").append(answer).append(" trees.\n");
            turn++;
        }
        
        System.out.println(sb);
        
    }
    
    
    public static boolean union(int a, int b) {
    	int pa=find(a);
    	int pb=find(b);
    	if(pb<pa) {
    		int tmp=pa;
    		pa=pb;
    		pb=tmp;
    	}
    	
    	if(pa==pb) {
    		parent[pa]=0;
    		return false;
    	}
    	
    	parent[pb]=pa;
    	
    	
    	return true;
    
    }
    
    public static int find(int a) {
    	if(parent[a]==a) return a;
    	return parent[a]=find(parent[a]);
    }
    
    
}

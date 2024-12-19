import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] p;
    public static void main(String[] args) throws Exception {
       
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	int N=Integer.parseInt(st.nextToken());
    	int M=Integer.parseInt(st.nextToken());
    	p=new int[N];
    	
    	for(int i=0;i<N;i++) {
    		p[i]=i;
    	}
    	
    	int a,b;
    	
    	int turn=0;
    	
    	
    	for(int i=1;i<=M;i++) {
    		
    		st=new StringTokenizer(br.readLine());
    		
    		a=Integer.parseInt(st.nextToken());
    		b=Integer.parseInt(st.nextToken());
    		
    		if(!union(a,b)) {
    			turn=i;
    			break;	
    		}
    		
    		//System.out.println("for 횟수: "+i);
    	}
    //	System.out.println(Arrays.toString(p));
    	
    	System.out.println(turn);
    	
    }
    
    public static int find(int a) {
    	
    	if(p[a]==a) return a;
    	
    	return p[a]=find(p[a]);
    }
    
    
    public static boolean union(int a,int b) {
    	
    	int subA=find(a);
    	int subB=find(b);
    	
    	
    	if(subA==subB){
    		return false;
    	}
    	//System.out.println("변경 전 "+a+": 부모: "+subA+" "+b+" 부모: "+subB);
    	
        if (subA < subB) {
            p[subB] = subA;
        } else {
            p[subA] = subB;
        }
    	//System.out.println("변경 후 "+a+": 부모: "+p[a]+" "+b+" 부모: "+p[b]);
    	return true;
    }
}
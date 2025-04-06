
import java.util.*;
import java.io.*;

public class Main{

	public static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G=Integer.parseInt(br.readLine());//공항이 1~G까지 있고,
        int P=Integer.parseInt(br.readLine());//비행기가 P개
        
        parent=new int[G+1];
        for(int i=1;i<=G;i++) {
        	parent[i]=i;
        }
        int count=0;
        boolean[] d=new boolean[G+1];
        int g;
        for(int i=0;i<P;i++) {
        	g=Integer.parseInt(br.readLine());//이번 비행기는 1~g중 하나 도킹 가능
//        	if(!d[g]) {
//        		d[g]=true;
//        		if(g>1){
//        			union(g,g-1);
//        		} 
//        	}else{//차선책에 도킹
//        		g=find(g);
//        		if(!d[g]) {
//            		d[g]=true;
//            		if(g>1){
//            			union(g,g-1);
//            		} 
//            	}else {
//            		break;
//            	}
//        	}
        	g=find(g);
        	if(d[g]) {
        		break;        		
        	}
        	d[g]=true;
        	//System.out.println(g+"에 도킹");
        	if(g>1)union(g,g-1);
        	//도킹하는 곳과, 이전 칸의 차선책을 유니온
        	count++;
        }
        System.out.println(count);
        
        
    }
    public static int find (int a) {
    	if(parent[a]==a) return a;
    	else return parent[a]=find(parent[a]);
    	
    }
    
    public static boolean union(int a,int b) {
    	int pa=find(a);
    	int pb=find(b);
    	if(pa==pb) {
    		return false;
    	}
    	if(pa<pb) {
    		parent[b]=pa;
    	}else {
    		parent[a]=pb;
    	}
    	return true;
    }
}

import java.util.*;
import java.io.*;


public class Main {
	    public static void main(String[] args) throws Exception {


	    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    	StringTokenizer st;
	    	boolean[][] visit=new boolean[100][100];
	    	
	    	int T=Integer.parseInt(br.readLine());
	    	int count=0;
	    	int x;
	    	int y;
	    	
	    	for(int square=0;square<T;square++) {
	    		st=new StringTokenizer(br.readLine());
	    		y=Integer.parseInt(st.nextToken());//x부터 10
	    		x=Integer.parseInt(st.nextToken());//y부터 10
	    		
	    		//#1 continue
//	    		for(int i=y;i<y+10;i++) {
//	    			for(int j=x;j<x+10;j++) {
//	    				if(visit[i][j]==true) continue;
//	    				visit[i][j]=true;
//	    				count++;
//	    			}
//	    		}
	    		
	    		//#2 if 이후 else
	    		for(int i=y;i<y+10;i++) {
	    			for(int j=x;j<x+10;j++) {
	    				if(visit[i][j]==true) {
	    					
	    				}else {
	    					visit[i][j]=true;
		    				count++;
	    				}

	    			}
	    		}
	    		
//	    		//#3 if만
//	    		for(int i=y;i<y+10;i++) {
//	    			for(int j=x;j<x+10;j++) {
//	    				if(visit[i][j]!=true) {
//	    					visit[i][j]=true;
//		    				count++;
//	    				}
//
//	    			}
//	    		}

	    		
	    	}
	    	 System.out.println(count);    	
	    }
	}
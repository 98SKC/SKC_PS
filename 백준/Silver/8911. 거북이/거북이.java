
import java.util.*;
import java.io.*;

public class Main{
	public static int[] di=new int[] {1,0,-1,0};// 위 좌 아래 우
	public static int[] dj=new int[] {0,-1,0,1};
	public static int dir=0;
	public static int pi=0;
	public static int pj=0;
	
	public static int maxI,minI,maxJ,minJ;
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maxI=0;
        minI=0;
        maxJ=0;
        minJ=0;
        
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        
        for(int test_case=1;test_case<=T;test_case++) {
        	String str=br.readLine();
        	int len=str.length();
            pi=0;
            pj=0;
        	maxI=0;
            minI=0;
            maxJ=0;
            minJ=0;
            dir=0;
        	
            for(int i=0;i<len;i++) {
                comand(str.charAt(i));
                maxI=Math.max(pi, maxI);
                maxJ=Math.max(pj, maxJ);
                minI=Math.min(pi, minI);
                minJ=Math.min(pj, minJ);
            }
            
        	//System.out.println(maxI+" "+minI+" "+maxJ+" "+minJ);
        	
        	int r=maxI+Math.abs(minI);
        	int c=maxJ+Math.abs(minJ);
        	sb.append(r*c+"\n");
        	
        }
        
        System.out.println(sb);

    }
    
    
    
    public static void comand(char c) {
    	switch(c) {
    		case 'F':
    			foward();
    			break;
    		case 'B':
    			back();
    			break;
    		case 'L':
    			left();
    			break;
    		case 'R':
    			right();
    			break;
    	}
    }
    
    public static void foward(){
    	
    	pi+=di[dir];
    	pj+=dj[dir];
    }
    
    public static void back(){
    	pi+=di[(dir+2)%4];
    	pj+=dj[(dir+2)%4];
    }
    
    
    public static void left(){
    	dir=(dir+1)%4;
    	return;
    }
    
    public static void right(){
    	dir-=1;
    	if(dir==-1) dir=3;
    	return;
    }    
}



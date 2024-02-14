import java.io.*;
import java.util.*;

public class Main {

	
	static int[] di= {0,0,1,1};
	static int[] dj= {0,1,0,1};
	static int N,R,C, cnt;
	static boolean terminate;
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	N=Integer.parseInt(st.nextToken());
    	R=Integer.parseInt(st.nextToken());
    	C=Integer.parseInt(st.nextToken());
    	int size=(int) Math.pow(2, N);
    	int ini=size;
    	int a=0;
    	int b=0;
    	cnt=0;
    	int sub1;
    	int sub2;
    	
    	while(!check(a,b)) {
    		
    		if(size==2) {// 왜 여기서 안걸리나~
    			
        		for(int c=0;c<4;c++) {
        			sub1=a+di[c];
        			sub2=b+dj[c];
        			if(a+di[c]==R&&b+dj[c]==C) {
        				System.out.println(cnt);
        				return;
        			}
        			cnt++;
        		}
        	}
    		if(R<a+size/2) {
        		if(C<b+size/2) {
//        			System.out.println("1사분면");
        			size/=2;
        		}else {
 //       			System.out.println("2사분면");
        			size/=2;
        			b+=size;
        			cnt+=Math.pow(size,2);
        		}
        		
        	}else {
        		if(C<b+size/2) {
        			size/=2;
        			a+=size;
        			cnt+=Math.pow(size,2)*2;
        		}else {
        //			System.out.println("4사분면");
        			size/=2;
        			a+=size;
        			b+=size;
        			cnt+=Math.pow(size,2)*3;
        		}
        		
        	}
    		
    	}
    	System.out.println(cnt);
    	
    }
    static boolean check(int a,int b) {
    	if(a==R&&b==C) return true;
    	return false;
    }
    
}
import java.io.*;
import java.util.*;

public class Main {

	static int[][] arr;
	static int N;
	static StringBuilder sb=new StringBuilder();
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	N=Integer.parseInt(br.readLine());
    	String str;
    	arr=new int[N][N];
    	for(int i=0;i<N;i++) {
    		str=br.readLine();
    		for(int j=0;j<N;j++) {
    			arr[i][j]=str.charAt(j)-'0';
    		}
    	}
    	
    	quarter(0,0,N);
    	System.out.println(sb);
    	
    }
    
    static boolean check(int i, int j, int size) {
    	int sub=arr[i][j];
    	for(int a=i;a<i+size;a++) {
    		
    		for(int b=j;b<j+size;b++) {
    			if(arr[a][b]!=sub) {
    				
    				return false;
    			}
    
    		}
    	}
    	return true;
    }
    
    static void quarter(int i, int j, int size) {
    	if(size==1||check(i,j ,size)) {
    		sb.append(arr[i][j]);
    	}else {//4분할
    		int sub=size/2;
    		sb.append("(");
    		quarter(i,j,sub);
    		
    		quarter(i,j+sub,sub);
    		
    		quarter(i+sub,j,sub);
    		
    		quarter(i+sub,j+sub,sub); 		
    		sb.append(")");
    	}
    	
    }
}
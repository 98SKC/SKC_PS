
import java.util.*;
import java.io.*;

public class Main{

	public static int[][] map;
	public static int N;
	public static int[] answer=new int[3];
	
	
	//분할 정복의 연습.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        
        map=new int[N][N];
        StringTokenizer st;
        
        //조건 1. N은 3^k 형식. 무조건 9개로 나눌 수 있다.
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.add(new int[] {0,0,N});
        
        int[] part;
        int result;
        int n,m,k;
        while(!q.isEmpty()) {
        	part=q.poll();
        	n=part[0];
        	m=part[1];
        	k=part[2];
        	
        	result=find(n,m,k);
        	
        	if(result!=2) {
        		answer[result+1]++;
        	}else {
            	for(int i=n;i<n+k;i+=k/3) {
            		for(int j=m;j<m+k;j+=k/3) {
            			q.add(new int[] {i,j,k/3});
            		}
            	}
        	}
        	
        }
        
        
        
        
        for(int i=0;i<3;i++) {
        	System.out.println(answer[i]);
        }
        
        
    }
    
    
    
    public static int find(int n, int m, int k){// i,j를 시작점으로, 변의 길이는 k.
    	
    	int target=map[n][m];
    	
    	for(int i=n;i<n+k;i++) {
    		for(int j=m;j<m+k;j++) {
    			if(map[i][j]!=target) {
    				return 2;
    			}
    		}
    	}
    	
    	
    	return target;
    	
    }
}

import java.util.*;
import java.io.*;

public class Main {
	public static int cc=1;
	public static ArrayDeque<Integer> q;
	public static int N;
	public static int answer=0;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N=Integer.parseInt(br.readLine());
        int[][] map=new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        	}       
        }
        
        simul(0,map);
        System.out.print(answer);
    }
    
    
    
    public static int[][] up(int[][] map) {
    	q=new ArrayDeque<Integer>();
    	int[][] copyMap=new int[N][N];
    	ArrayDeque<Integer> subQ=new ArrayDeque<>();
    	int before;
    	for(int j=0;j<N;j++) {
    		for(int i=0;i<N;i++) {
    			q.add(map[i][j]);
    		}
    		before=-1;
    		while(!q.isEmpty()) {
    			if(before==q.peek()) {// 이전 블록이랑 같다.
    				subQ.add(before*2);
    				before=-1;
    				q.poll();
    			}else if(q.peek()==0){
    				q.poll();
    			}else if(before==-1){// 이전 블록이 이미 합쳐졌거나 이번이 처음 블록이다
    				before=q.poll();
    			}else{// 이전 블록이랑 다르다.
    				subQ.add(before);
    				before=q.poll();
    			}
    		}
    		
    		if(before!=-1) {
    			subQ.add(before);
    		}
    		
    		int count=0;
    		while(!subQ.isEmpty()) {
    			copyMap[count][j]=subQ.poll();
    			count++;
    		}
    	}
    	
    	return copyMap;
    }
    
    
    
    public static int[][] down(int[][] map) {
    	q=new ArrayDeque<Integer>();
    	int[][] copyMap=new int[N][N];
    	ArrayDeque<Integer> subQ=new ArrayDeque<>();
    	int before;
    	for(int j=0;j<N;j++) {
    		for(int i=N-1;i>=0;i--) {
    			q.add(map[i][j]);
    		}
    		before=-1;
    		while(!q.isEmpty()) {
    			if(before==q.peek()) {
    				subQ.add(before*2);
    				before=-1;
    				q.poll();
    			}else if(q.peek()==0){
    				q.poll();
    			}else if(before==-1){// 이전 블록이 이미 합쳐졌거나 이번이 처음 블록이다
    				before=q.poll();
    			}else{
    				subQ.add(before);
    				before=q.poll();
    			}
    		}
    		if(before!=-1) {
    			subQ.add(before);
    		}
    		int count=N-1;
    		while(!subQ.isEmpty()) {
    			copyMap[count][j]=subQ.poll();
    			count--;
    		}
    	}
    	
    	return copyMap;
    }
    
    
    public static int[][] left(int[][] map) {
    	q=new ArrayDeque<Integer>();
    	int[][] copyMap=new int[N][N];
    	ArrayDeque<Integer> subQ=new ArrayDeque<>();
    	int before;
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			q.add(map[i][j]);
    		}
    		before=-1;
    		while(!q.isEmpty()) {
    			if(before==q.peek()) {
    				subQ.add(before*2);
    				before=-1;
    				q.poll();
    			}else if(q.peek()==0){
    				q.poll();
    			}else if(before==-1){// 이전 블록이 이미 합쳐졌거나 이번이 처음 블록이다
    				before=q.poll();
    			}else{
    				subQ.add(before);
    				before=q.poll();
    			}
    		}
    		if(before!=-1) {
    			subQ.add(before);
    		}
    		int count=0;
    		while(!subQ.isEmpty()) {
    			copyMap[i][count]=subQ.poll();
    			count++;
    		}
    	}
    	
    	return copyMap;
    }
    
    
    public static int[][] right(int[][] map) {
    	q=new ArrayDeque<Integer>();
    	int[][] copyMap=new int[N][N];
    	ArrayDeque<Integer> subQ=new ArrayDeque<>();
    	int before;
    	for(int i=0;i<N;i++) {
    		for(int j=N-1;j>=0;j--) {
    			q.add(map[i][j]);
    		}
    		before=-1;
    		while(!q.isEmpty()) {
    			if(before==q.peek()) {
    				subQ.add(before*2);
    				before=-1;
    				q.poll();
    			}else if(q.peek()==0){
    				q.poll();
    			}else if(before==-1){// 이전 블록이 이미 합쳐졌거나 이번이 처음 블록이다
    				before=q.poll();
    			}else{
    				subQ.add(before);
    				before=q.poll();
    			}
    		}
    		if(before!=-1) {
    			subQ.add(before);
    		}
    		int count=N-1;
    		while(!subQ.isEmpty()) {
    			copyMap[i][count]=subQ.poll();
    			count--;
    		}
    	}
    	
    	return copyMap;
    }
    public static void simul(int count,int[][] copyMap) {
    	//System.out.println(count);
    	if(count==5) {
    		//System.out.println(cc++);
    		for(int i=0;i<N;i++) {
    			for(int j=0;j<N;j++) {
    				//System.out.print(copyMap[i][j]+" ");
    				answer=Math.max(answer, copyMap[i][j]);
    			}
    			//System.out.println();
    		}
    		//System.out.println("---------------------");
    		return;
    	}
    	
    	simul(count+1,up(copyMap));
    	simul(count+1,down(copyMap));
    	simul(count+1,left(copyMap));
    	simul(count+1,right(copyMap));
    	
    	
    }
    
    
}
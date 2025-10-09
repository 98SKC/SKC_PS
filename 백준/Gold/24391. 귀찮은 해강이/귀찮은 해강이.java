

import java.util.*;
import java.io.*;

public class Main {

	public static int[] parent;
	public static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        //강의코드 1~N까지의 강의
        //모든 강의는 강의코드와 동일한 번호의 건물에서 진행.
        //강의 시간표 순서대로 모든 강의를 들으며 한 건물에서 다른 건물로 이동하는 횟수를 최소화
        //연결되있는 건물들이 있어 나오지 않고 이동가능(그룹)이 있음
        //강의 시간표가 주어질때 최소 몇번만 나오면 되는지 구하라.
        
        //강의의 개수 N, 연결되어있는 건물의 쌍의 개수
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        parent=new int[N+1];
        
        for(int i=1;i<=N;i++) {
        	parent[i]=i;
        }
        
        int a,b;
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	
        	union(a,b);
        }
        
        st=new StringTokenizer(br.readLine());
    	int before=Integer.parseInt(st.nextToken());
        int now;
        int answer=0;
        

        
    	for(int i=1;i<N;i++){
        	now=Integer.parseInt(st.nextToken());
    		if(find(now)!=find(before)) {
    			answer++;
    		}
    		before=now;
        }
    	
    	
        System.out.println(answer);
        
    }
    
    
    public static boolean union(int a, int b) {
    	int pa=find(a);
    	int pb=find(b);
    	
    	if(pa==pb) return false;
    	
    	if(pa<pb){
    		parent[pb]=pa;
    	}else {
    		parent[pa]=pb;
    	}
    	
    	return true; 
    	
    }
    
    
    public static int find(int a) {
    	if(parent[a]==a) return a;
    	
    	return parent[a]=find(parent[a]);
    
    }
        
}



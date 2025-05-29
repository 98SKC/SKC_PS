
import java.util.*;
import java.io.*;

public class Main {

	public static int[] parent;
	public static ArrayList<Integer>[] friend;
	public static ArrayList<Integer>[] enermy;
	public static int N,M;
	public static boolean[] v;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());//학생 수
        int M=Integer.parseInt(br.readLine());//인간관계 수
        
        StringTokenizer st;
        char ef;
        int A,B;
        friend=new ArrayList[N+1];
        enermy=new ArrayList[N+1];
        parent=new int[N+1];
       
        for(int i=1;i<=N;i++) {
        	friend[i]=new ArrayList<>();
        	enermy[i]=new ArrayList<>();
        	parent[i]=i;
        }
        
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	ef=st.nextToken().charAt(0);
        	A=Integer.parseInt(st.nextToken());
    		B=Integer.parseInt(st.nextToken());
    		
        	if(ef=='F') {
        		friend[A].add(B);
        		friend[B].add(A);
        	}else {
        		enermy[A].add(B);
        		enermy[B].add(A);
        	}
        	
        }
        int p;
        for(int i=1;i<=N;i++) {
        	//친구의 친구는 나의 친구
        	

        	for(int f:friend[i]) {
        		p=find(i);
        		if(find(f)==p) continue;// 이미 같은 팀이면 패스
        		union(i,f);// 둘은 직접 친구니 우선 친구.
//        		System.out.println(i+" "+f+" 는 친구1");
//				어차피 for문 도는데 할 필요가 있나
//        		for(int ff:friend[f]){// 친구의 친구도 나의 친구
//        			if(find(ff)==find(f)) continue;// 이미 같은 팀이면 패스
//            		union(f,ff);// 둘은 직접 친구니 우선 친구.
//            		
//        		}
        		
        	}
        	
        	//원수의 원수는 나의 원수
        	for(int e:enermy[i]) {//e는 원수
        		for(int ee:enermy[e]){//원수의 원수
        			p=find(i);
        			if(find(ee)==p) continue;
        			//System.out.println(i+" "+ee+" 는 친구2");
        			union(i,ee);
        		}
        	}
        	
        }
        
        
        HashSet<Integer> set=new HashSet<>();
        for(int i=1;i<=N;i++) {
        	if(!set.contains(find(parent[i]))){
        		set.add(parent[i]);
        	}
        }
        
        
      //  System.out.println(set.toString());
        System.out.println(set.size());
        
        
    }
    
    public static int find(int child) {
    	if(parent[child]==child) return child;
    	else return parent[child]=find(parent[child]);
    }
    
    public static boolean union(int A, int B) {
    	int parentA=find(A);
    	int parentB=find(B);
    	
    	if(parentA==parentB){
    		return false;
    	}
    	
    	if(parentA<parentB) {
    		parent[parentB]=parentA;
    	}else{
    		parent[parentA]=parentB;
    	}
    	
    	return true;
    }
}

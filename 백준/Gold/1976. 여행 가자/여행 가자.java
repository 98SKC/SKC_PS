import java.util.*;
import java.io.*;

public class Main {

	 static int N,M;
	 static int[] goal;
	 static int[] parent;
	 public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        N=Integer.parseInt(br.readLine());

	        M=Integer.parseInt(br.readLine());
	        parent=new int[N+1];
	        goal=new int[M+1];
	        for(int i=1;i<=N;i++) {
	        	parent[i]=i;// 부모 노드 초기화
	        }
	        for(int i=1;i<=N;i++) {
	        	st=new StringTokenizer(br.readLine());
	        	for(int j=1;j<=N;j++) {
	        		if(Integer.parseInt(st.nextToken())==1){
	        			union(i,j);
	        		}
	        	}
	        }
	        st=new StringTokenizer(br.readLine());

	        for(int i=1;i<=M;i++) {
	        	goal[i]=Integer.parseInt(st.nextToken());
	        }
	        
	        for(int i=1;i<M;i++) {
	        	if(find(goal[i]) != find(goal[i+1])) {
	        		System.out.println("NO");
	        		return;
	        	}
	        }
	        System.out.println("YES");
	    } 

	 	// union 연산
		static boolean union(int x, int y) {
			x = find(x);
			y = find(y);
			
			if(x == y) return false;
			
			if(x <= y) parent[y] = x;
			else parent[x] = y;
			return true;
		}

		static int find(int a) {
		    if (parent[a] != a) 
		        parent[a] = find(parent[a]); 
		    return parent[a];
		}
	 
	 

	}
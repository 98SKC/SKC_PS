
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        

        int p,c;
        int[] number=new int[N+1];
        HashSet<Integer> set=new HashSet<>();// 내가 누군가의 자식이요. 
        ArrayList<Integer>[] parent=new ArrayList[N+1];
        boolean[] v=new boolean[N+1];
        for(int i=1;i<=N;i++) {
        	parent[i]=new ArrayList<Integer>();
        	set.add(i);
        }
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	p=Integer.parseInt(st.nextToken());
        	c=Integer.parseInt(st.nextToken());// c를 풀기 위해서는 p를 푸는게 중요하다.
//        	parent[c]=p;
        	set.remove(c);
        	parent[p].add(c);
        	number[c]++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
             
   
        for(Integer root:set) {
        	pq.add(root);
        }
        


        StringBuilder sb=new StringBuilder();
        int target;
        
        while(!pq.isEmpty()) {
        	target=pq.poll();
        	if(v[target]) continue;
        	v[target]=true;
        	sb.append(target+" ");
        	for(Integer next: parent[target]) {
        		if(v[next]) continue;
        		number[next]--;
        		if(number[next]==0) {
        			pq.add(next);
        		}

        		//pq.add(next);
        		
        	}
        }
        
        
        System.out.println(sb);

        
        
    }

}

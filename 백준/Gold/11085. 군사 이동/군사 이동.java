
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        StringTokenizer st=new StringTokenizer(br.readLine());

        int P=Integer.parseInt(st.nextToken());
        int W=Integer.parseInt(st.nextToken());
        
        st=new StringTokenizer(br.readLine());
       
        int C=Integer.parseInt(st.nextToken());  //출발
        int V=Integer.parseInt(st.nextToken()); //도착
        
        ArrayList<int[]>[] edges=new ArrayList[P+1];
        
        
        int[] min=new int[P+1];
        for(int i=0;i<P;i++) {
        	edges[i]=new ArrayList<>();
        	//min[i]=Integer.MAX_VALUE;
        }
        
        
        
        
        int a,b,c;
        for(int i=0;i<W;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	c=Integer.parseInt(st.nextToken());
        	
        	edges[a].add(new int[] {b,c});
        	edges[b].add(new int[] {a,c});
        	
        	
        }
 
        ArrayDeque<int[]> q=new ArrayDeque<>();
        int[] p;

        min[C]=Integer.MAX_VALUE;
        q.add(new int[] {C, min[C]});
        int city, cost, sub;
        while(!q.isEmpty()) {
            p=q.poll();
            city=p[0];
            cost=p[1];

            
            if(cost < min[city]) continue;

            for(int[] next:edges[city]) {
                sub=Math.min(cost, next[1]); 
                if(min[next[0]] < sub){
                    min[next[0]] = sub;
                    q.add(new int[]{next[0], sub});
                }
            }
        }

        System.out.println(min[V]);
    }
        // 두 국가의 전쟁.
        // b국가와 c국가는 p개의 지점과 w개의 길로 표현
        // b국가는 c국가로 가는 경로를 정하고, 그 경로로만 모든 군사를 보냄
        // b국가는 경로상 길 중 너비가 가장 좁은 길의 너비를 최대화함.
        // 해당 루트를 구하라.
        
        // 1. 도착이 가능하야하고
        // 2. 루트상 경로의 최소 가중치가 최대야한다.
        // bfs 아닌가
        
        
}


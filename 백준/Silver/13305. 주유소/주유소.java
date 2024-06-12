import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] price=new int[N];
        long[] dis=new long[N];
        String[] distance=br.readLine().split(" ");
        String[] oil=br.readLine().split(" ");
        int min=Integer.MAX_VALUE;
        Queue<Integer> q=new ArrayDeque<Integer>();
        
        for(int i=0;i<N;i++) {
        	price[i]=Integer.parseInt(oil[i]);
        	if(price[i]<min) {
        		q.add(i);// 최소가 갱신되는 노드의 번호는 i
        		min=price[i];
        	}
        	if(i!=0) {
        		dis[i]=Integer.parseInt(distance[i-1])+dis[i-1];
        	}else {
        		dis[i]=0; 	
        	}
        	
        }

        int before=q.poll();
        int node=0;
        long answer=0;
        while(!q.isEmpty()) {
        	node=q.poll();
        	answer+=(dis[node]-dis[before])*price[before];
        	before=node;
        }
        
        answer+=price[before]*(dis[N-1]-dis[node]);
        System.out.println(answer);
        
        
    }
}
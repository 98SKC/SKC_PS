import java.util.*;
import java.io.*;

public class Main {
  
    static int[] arr;// 내가 채워야 하는 노드
    static boolean[] check;// 최소거리. true가 되어야 도착. 확정
    static List<Node>[] list;// 주어지는 가중치
    static int N,goal,answer=0;
    static int D=10000;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args)throws Exception {
        
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        goal=Integer.parseInt(st.nextToken());
        
        arr = new int[D+1];
        check = new boolean[D+1];
        list = new ArrayList[D+1];
        
        Arrays.fill(arr, Integer.MAX_VALUE);
        
        for(int i = 0; i <= D; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<D;i++) {
        	list[i].add(new Node(i+1,1));
        }//  기본 간선 가중치 1.
        
        for(int i=0;i<N;i++) {
           st = new StringTokenizer(br.readLine());
           int before = Integer.parseInt(st.nextToken());
           int after = Integer.parseInt(st.nextToken());
           int num = Integer.parseInt(st.nextToken());
           
           list[before].add(new Node(after,num));
        }
        
        dijkstra();
        System.out.println(answer);
    }
    
    public static void dijkstra() {
       PriorityQueue<Node> queue = new PriorityQueue<>();
       queue.add(new Node(0,0));
       arr[0] = 0;
       
       while(!queue.isEmpty()) {
          Node n = queue.poll();
          int end = n.end;
          
          
          if(check[end]) continue;
          
          check[end] = true;
          
          if(end==goal) {
        	  answer=arr[end];
        	  break;
          }
          for(Node node : list[end]) {
             if(arr[node.end] > arr[end] + node.weight) {
                arr[node.end] = arr[end] + node.weight;
                queue.add(new Node(node.end,arr[node.end]));
             }
          }
          
       }
       
    }

}

class Node implements Comparable<Node>{
   public int end;
   public int weight;
   
   Node(int end,int weight){
      this.end = end;
      this.weight = weight;
   }
   @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
 
}
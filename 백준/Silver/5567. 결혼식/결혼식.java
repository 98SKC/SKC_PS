 import java.io.*;
 import java.util.*;
 
 public class Main {
     
     static int N, M;
     static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
     static boolean[] visited;
 
     public static void main (String[] args) throws IOException {
         
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st; 
         N = Integer.parseInt(br.readLine());
         M = Integer.parseInt(br.readLine());
         
         for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
         
         visited = new boolean[N + 1]; 
         visited[1] = true;
         int answer = 0;

         
         for (int i = 0; i < M; i++) {
             st = new StringTokenizer(br.readLine());
             int from = Integer.parseInt(st.nextToken());
             int to = Integer.parseInt(st.nextToken());
             graph.get(from).add(to);
             graph.get(to).add(from);
         }
         
         dfs(1, 0);
         for (int i = 2; i < visited.length; i++) {
             if(visited[i]) answer++;
         }
         System.out.println(answer);
     }
     
     private static void dfs(int point, int cnt){
         if(cnt == 2) { 
             return;
         }
         for(int i : graph.get(point)) {
             visited[i] = true;
             dfs(i, cnt+1);
         }
     }

 }
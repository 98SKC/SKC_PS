import java.util.*;
import java.io.*;

public class Main {
    
	public static class Edge {
        int to, weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        // 인접 리스트 초기화
        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for (int i=1;i<=N;i++) {
            graph[i]=new ArrayList<>();
        }
        
        int A,B,C;
        int maxC=0;
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            A=Integer.parseInt(st.nextToken());
            B=Integer.parseInt(st.nextToken());
            C=Integer.parseInt(st.nextToken());
            // 양방향 그래프 구성
            graph[A].add(new Edge(B,C));
            graph[B].add(new Edge(A,C));
            maxC=Math.max(maxC,C);
        }
        
        st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int goal=Integer.parseInt(st.nextToken());
        

        int left=1;
        int right=maxC;
        int answer=0;
        //이분탐색 + bfs   최대 중량을 이분탐색으로 찾으면서, bfs로 그 최대중량으로 start->goal을 갈 수 있는지 탐색
        while (left<=right) {
            int mid=left+(right-left)/2;
            
            Queue<Integer> queue=new LinkedList<>();
            boolean[] visited=new boolean[N+1];
            queue.add(start);
            visited[start]=true;
            boolean possible=false;
            // 이분탐색
            while(!queue.isEmpty()) {
                int cur=queue.poll();
                if(cur==goal) {
                    possible=true;
                    break;
                }
                for(Edge edge:graph[cur]) {
                    if(!visited[edge.to]&&edge.weight>= mid) {
                        visited[edge.to]=true;
                        queue.add(edge.to);
                    }
                }
            }
            
            if(possible){
                answer=mid;     // mid 중량으로 goal 도달 가능
                left=mid+1;   // 더 높은 중량 시도
            } else {
                right=mid-1;  // mid 중량으로는 불가능하므로 낮춰봄
            }
        }
        
        
        System.out.println(answer);
    }
}
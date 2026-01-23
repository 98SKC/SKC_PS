import java.util.*;
import java.io.*;

//원본

public class Main {

    public static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        N=Integer.parseInt(st.nextToken()); //집하장(노드) 개수
        M=Integer.parseInt(st.nextToken()); //간선의 개수
        List<int[]>[] edges = new ArrayList[N+1];

        for(int n=1;n<=N;n++){
            edges[n]=new ArrayList<>();
        }

        int node1, node2, dist;
        for(int m=0;m<M;m++){
            st=new StringTokenizer(br.readLine());
            node1=Integer.parseInt(st.nextToken());
            node2=Integer.parseInt(st.nextToken());
            dist=Integer.parseInt(st.nextToken());

            edges[node1].add(new int[]{node2,dist});
            edges[node2].add(new int[]{node1,dist});


        }

        int[][] answer=new int[N+1][N+1]; // [i][j]는 i에서 j로 최단경로의 첫번째 방문지
        int[][] dijkstra=new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j){
                    dijkstra[i][j]=0;
                    continue;
                }
                dijkstra[i][j]=Integer.MAX_VALUE;
                dijkstra[j][i]=Integer.MAX_VALUE;

            }

        }

        //i에서 출발하는 경로.
        for(int i=1;i<=N;i++){
            for(int j=i+1;j<=N;j++){
                //if(i==j) continue;
                answer[i][j]=j;
                answer[j][i]=i;
            }

        }
        // 처음 노드, 이전노드, 경로
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int[] p;
        int mid;

        for(int i=1;i<=N;i++){
            pq.clear();
            pq.add(new int[]{i,0,0});
            while(!pq.isEmpty()){
                p=pq.poll();

                if(dijkstra[i][p[0]]<p[2]) continue;


                for(int[] next:edges[p[0]]){
                    //next[0] =지금 노드에서 갈 수 있는 다음 노드
                    //next[1] =그 노드까지의 거리
                    if(dijkstra[i][next[0]]>p[2]+next[1]){
                        dijkstra[i][next[0]]=p[2]+next[1];
                        mid=-1;
                        if(p[1]==0){
                            mid=next[0];
                        }else{
                            mid=p[1];
                        }

                        answer[i][next[0]]=mid;//

                        pq.add(new int[]{next[0],mid,next[1]+p[2]});
                    }
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) sb.append("- ");
                else sb.append(answer[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

}


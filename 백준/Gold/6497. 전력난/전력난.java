import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    static int count; // 연결된 간선의 수

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, M;
        StringBuilder sb=new StringBuilder();
        while(true){
            st=new StringTokenizer(br.readLine());
            M=Integer.parseInt(st.nextToken()); // 집의 수
            N=Integer.parseInt(st.nextToken()); // 간선의 수
            if(N==0 && M==0) break;

            parent=new int[M];
            int a, b, c;
            long total=0;
            PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });
            for(int i=0; i<M; i++) {
                parent[i] = i;
            }
            for(int i=0; i<N; i++){
                st=new StringTokenizer(br.readLine());
                a=Integer.parseInt(st.nextToken());
                b=Integer.parseInt(st.nextToken());
                c=Integer.parseInt(st.nextToken());
                pq.add(new int[] {a, b, c}); // a와 b 연결 c 거리
                total+=c;
            }

            long sum=0;
            count=0; // 초기화
            int[] sub;
            while(!pq.isEmpty()){
                if(count == M - 1) break; // 모든 노드가 연결되었음을 확인
                sub=pq.poll();
                if(union(sub[0], sub[1])){
                    sum+=sub[2];
                    count++;
                }
            }
            sb.append(total - sum).append("\n");
        }

        System.out.println(sb);
    }

    static int find(int a){
        if(parent[a] != a){
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    static boolean union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x == y) return false;

        if(x < y){
            parent[y] = x;
        } else {
            parent[x] = y;
        }

        return true;
    }
}

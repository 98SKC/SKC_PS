
//import java.io.*;
//import java.util.*;
//
//public class Main{
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//    }
//}


import java.io.*;
import java.util.*;

public class Main{

    public static int N,K;
    public static int[] fountain;
    public static HashSet<Integer> v=new HashSet<>();
    public static HashSet<Integer> inQueue=new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        fountain=new int[N];
        // 수직선 상에 N개의 샘터가 있으며,
        // K개의 집을 수직선 위에 짓고자 한다.
        // 집과 가장 가까운 샘의 거리가 불행도이며, 이 불행도가 최소가 되도록 한다.
        
        //N과 K는 둘 다 10만.
        // 거리는 -1억~1억.  (long을 해야하는 문제인가 흠)

        //

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            fountain[i]=Integer.parseInt(st.nextToken());
            v.add(fountain[i]); //샘에는 집을 지을 수 없다. //샘의 좌우 옆으로 큐에 삽입
            inQueue.add(fountain[i]);
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });

        for(Integer i : v){
            if(!inQueue.contains(i+1)){ //큐에 없으며, 범위 안
                pq.add(new int[]{i+1,1,0}); //p[2]가 0이면 우측으로 퍼지는 방향.
                inQueue.add(i+1);
            }

            if(!inQueue.contains(i-1)){ //큐에 없으며, 범위 안
                pq.add(new int[]{i-1,1,1}); //p[2]가 1이면 좌측으로 퍼지는 방향.
                inQueue.add(i-1);
            }

        }
        int cnt=0;
        long answer=0;
        int[] p;
        while(!pq.isEmpty()){
            p= pq.poll();
            if (v.contains(p[0])) continue;

            answer+=p[1];
            v.add(p[0]);
            cnt++;

            if(cnt==K) break;
            
            //p[2]==0 우측으로
            if(p[2]==0){
                if(!v.contains(p[0]+1)) pq.add(new int[]{p[0]+1,p[1]+1,0});
            }else{//p[2]==1 좌측으로
                if(!v.contains(p[0]-1)){
                    if(!v.contains(p[0]-1)) pq.add(new int[]{p[0]-1,p[1]+1,1});
                }
            }
        }

        System.out.println(answer);



        //호수 가장 가까이에 집을 지으면 되는게 아닌가?




    }
}

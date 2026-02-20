import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 후보자는 N명
        // 투표자는 M명
        // 1번을 뽑으려고 하지 않ㄴ는 사람을 매수.
        //
        int N=Integer.parseInt(br.readLine());

        //자료구조를 잘 고르면 한번에 끝날지도
        //pq는 음... 중간에 갱신이 안되고
        //매번 정렬은 흐음...
        if(N==1){
            System.out.println(0);
            return;
        }
        int[] arr=new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
    
        int answer=0;

        boolean find=false;
        int[] sub;
        int[] sub2;
        while(true){
            PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1]-o1[1];
                }
            });
            for(int i=1;i<=N;i++){
                pq.add(new int[]{i,arr[i]});
            }
            sub=pq.poll();
            if(sub[0]==1){
                sub2=pq.poll();
                if(sub2[1]<sub[1]){
                    break;
                }else{
                    arr[sub2[0]]--;
                    arr[1]++;
                }
            }else{
                arr[sub[0]]--;
                arr[1]++;
            }

            answer++;
        }
        System.out.println(answer);


    }

}

//import java.io.*;
//import java.util.*;
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
//
//    }
//
//}
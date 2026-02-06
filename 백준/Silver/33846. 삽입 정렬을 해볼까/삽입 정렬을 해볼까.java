import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //삽입정렬문제인데, 삽입정렬로 구현할 때 배열이 밀리는데 시간복잡도가 괜찮나

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());


        PriorityQueue<Integer> pq=new PriorityQueue<>();
        StringBuilder sb=new StringBuilder();

        for(int i=1;i<=K;i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        while(!pq.isEmpty()){
            sb.append(pq.poll()+" ");
        }

        for(int i=K+1;i<=N;i++){
            sb.append(Integer.parseInt(st.nextToken())+" ");
        }

        System.out.println(sb);


    }


//    public static int searchPos(int k){
//        int answer=k;
//
//
//        for(int i=k-1;i>=0;i--){
//            if(arr[i]<=arr[k]){// 작은 위치를 발견하면,
//                answer=i+1;
//                break;
//            }
//        }
//        return answer;
//
//    }


//    public static int searchPos(int k) {
//        int left = 1;
//        int right = k - 1;
//        int target = arr[k];
//        int answer = k;   // 기본값: 맨 뒤에 삽입
//
//        while (left <= right) {
//            int mid = (left + right) / 2;
//
//            if (arr[mid] <= target) {
//                left = mid + 1;
//            } else {
//                answer = mid;
//                right = mid - 1;
//            }
//        }
//
//        return answer;
//    }
//
//    //pos에 arr[k]를 넣기 위함
//    public static void move(int k, int pos){
//        int sub=arr[k];
//
//        for(int i=k;i>pos;i--){
//            arr[i]=arr[i-1];
//        }
//        arr[pos]=sub;
//    }

}


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

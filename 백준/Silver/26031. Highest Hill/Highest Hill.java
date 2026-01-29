import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 산맥의 데이터가 주어진다.
        // 하나의 산맥은 다음과 같이 표현된다.
        // 같은 간격으로 측정한 n개의 지점
        // 각 지점의 높이
        // i<j<k를 만족하는 세 지점이 있을 때, i~j에서 높이가 증가하거나 같고, j~k에서 높이가 감소하거나 같음
        // 높이는 Hj-Hi , Hj-Hi 중 낮은 쪽.
        // 모든 봉우리에서 가장 큰 봉우리를 구하라

        int N=Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer=0;

        long[] height=new long[N];

        for(int i=0;i<N;i++){
            height[i]=Long.parseLong(st.nextToken());
        }

        //브루드포스냐 우선순위큐냐, dp는 아니겠고,
        int uphill=0;

        long uplen=0;
        long downlen=0;

        for(int i=1;i<N;i++){
            if(height[i-1]<height[i]){//오르고 있다.
                //System.out.println(i+"는 오르고있다.");
                if(uphill!=1){//이미 오르는 상태였다면
                   // System.out.println("up: "+uplen+" down: "+downlen);
                    answer=Math.max(answer,Math.min(uplen,downlen));
                    uphill=1;
                    uplen=0;
                }
                uplen+=height[i]-height[i-1];
            }else if(height[i-1]>height[i]){
               // System.out.println(i+"는 내리고있다.");
                if(uphill!=2){//이미 내려오는는 상태였다면
                    uphill=2;
                    downlen=0;
                }
                downlen+=height[i-1]-height[i];
            }else{//같으면 이전하고 같으니 아무것도 안하지만 가독성을 위해 명시
                continue;
            }
        }
        //System.out.println("uphill "+uphill+" up: "+uplen+" down: "+downlen);
        if(uphill==2){
            answer=Math.max(answer,Math.min(uplen,downlen));
        }
        System.out.println(answer);

    }

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

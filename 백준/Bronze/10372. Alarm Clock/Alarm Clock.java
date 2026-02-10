import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;


public class Main {
    //          idx를 만드는데 드는 코스트 0 1 2 3 4 5 6 7 8 9
    public static int[] time=new int[]{6,2,5,5,4,5,6,3,7,6};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // a+b+c+d=n 이 되는 시간을 하나 출력하라..

        //a는 0혹은 1,
        //b는 앞이 0이면 1~9
        //   앞이 1이면 0~2
        //c d는 같이 00~60까지 만들 수 있다.
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<=60;i++){
            int a=i/10;
            int b=i%10;
            set.add(time[a]+time[b]);
        }

        //

        int answer=-1;
        int sub;
        for(int i=0;i<10;i++){//앞이 0으로 고정일 때, 두번째 숫자
            sub=time[0]+time[i];
            if(sub<N){
                answer=cal(N-sub);
                if(answer!=-1) {
                    if(answer<10){
                        //System.out.println("위치1");
                        System.out.println("0"+i+":0"+answer);
                        return;
                    }
                    //System.out.println("위치2");
                    System.out.println("0"+i+":"+answer);
                    return;
                }
            }
        }

        for(int i=0;i<3;i++){//앞이 1로 고정일 때, 두번째 숫자
            sub=time[1]+time[i];
            if(sub<N){
                answer=cal(N-sub);
                if(answer!=-1) {
                    if(answer<10){
                        //System.out.println("위치3");
                        System.out.println("0"+i+":0"+answer);
                        return;
                    }
                   // System.out.println("위치4");
                    System.out.println("1"+i+":"+answer);
                    return;
                }
            }
        }


        System.out.println("Impossible");




    }

    public static int cal(int n){ //앞에 사용하고 남은 카운트
        int answer=-1;

        //앞에는 0부터 6까지가능
        for(int i=0;i<=6;i++){
            //뒤에는 0부터 9까지가능
            for(int j=0;j<=9;j++){
                if(time[i]+time[j]==n) {
                    //System.out.println("n: "+n+", i: "+i+", j: "+j);
                    return i*10+j;
                }
            }
        }


        return answer;
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


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

    public static int N;
    public static int[] card;
    public static int[] even;
    public static int[] odd;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        card=new int[N];
        even=new int[N];
        odd=new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i=0;i<N;i++){
            card[i]=Integer.parseInt(st.nextToken());
        }

        even[0]=card[0];
        even[1]=even[0];
        odd[1]=card[1];

        for(int i=2;i<N;i++){
            if(i%2==0){//짝수면
                even[i]=even[i-2]+card[i];
                odd[i]=odd[i-1];
            }else{
                odd[i]=odd[i-2]+card[i];
                even[i]=even[i-1];
            }
        }

        //System.out.println(Arrays.toString(even));
        //System.out.println(Arrays.toString(odd));

        //밑장을 빼지 않는다면 -> 나는 짝수만 받는다. even만.




        //밑장을 빼기 전까지는 짝수번째 카드만 정상적으로 받는다. 밑장 뺀 이후로 홀수번째 카드를 받는다.


        //내 차례에 밑장을 뺐다면 -> 밑장을 뺀 even[i]-card[i]+card[N-1]이 밑장 뺀 턴까지 먹음. 이후 i+1부터 홀수만 먹는다. odd[N-1]-odd[i]


        //상대 차례에 밑장을 뺐다면 -> even[i]+odd[N-1]-odd[i]

        
        //밑장을 빼지 않은경우를 최대로 초기화
        int max=even[N-1];
        
        //i턴에 밑장을 뺐다.
        for(int i=0;i<N;i++){
            if(i%2==0){ // 내 차례
                //                                 밑장으로 얻은 마지막 카드도 홀수에 포함되어있음
                max=Math.max(max,even[i]-card[i] + odd[N-1]-odd[i]);
            }else{// 상대차례
                max=Math.max(max,even[i] + odd[N-1]-odd[i-1]-card[N-1]);
            }
        }

        System.out.println(max);




    }



}


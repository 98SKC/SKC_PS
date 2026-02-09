import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static HashMap<Character, Integer> type;
    //public static HashSet<Character> type;
    public static long[] trash=new long[7];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //버려야 하는 쓰레기가 N개.
        //품목이 P C V S G F 로 나누어져 있다.  +(일반은 따로)
        //특정 쓰레기가 하나의 품목 X로만 구성되면 그 품목에 버린다.
        //2가지 이상의 서로 다른 품목으로 구성되거나, 분리배출이 가능하지 않다면 일반쓰레기로 버린다.
        //재활용을 제외한 모든 쓰레기는 일반 쓰레기로 버린다.
        //X의 비용=스레기의 크기 * X의 단위 크기당 비용이다.
        //쓰레기의 크기는 문자열의 길이와 같다.

        init();
        N=Integer.parseInt(br.readLine());

        long answer=0;
        String t;
        boolean nomal;

        int len;

        for(int i=0;i<N;i++){
            t=br.readLine();
            nomal=false;
            len=t.length();
            char c=t.charAt(0);

            if(type.containsKey(c)){
                for(int j=1;j<len;j++){
                    if(t.charAt(j)!=c){
                        //System.out.println("무슨 단어가: "+c+" 위치: "+j+"에서 안맞는 단어가 뭐길래: "+t.charAt(j));
                        nomal=true;
                        break;
                    }
                }
            }else{
                nomal=true;
            }



            if(nomal){
                trash[6]+=len;
            }else{
                trash[type.get(c)]+=len;
            }

        }

        StringTokenizer st=new StringTokenizer(br.readLine());


        int[] cost=new int[7];

        for(int i=0;i<6;i++){
            cost[i]=Integer.parseInt(st.nextToken());
        }
        cost[6]=Integer.parseInt(br.readLine());

        answer+=trash[6]*cost[6];


        for(int i=0;i<6;i++){
            //System.out.println(i+"의 양: "+trash[i]);
            answer+=trash[i]*Math.min(cost[i],cost[6]);
        }

        System.out.println(answer);



    }

    public static void init(){
        //type =new HashSet<>();
        type=new HashMap<>();
        type.put('P',0);
        type.put('C',1);
        type.put('V',2);
        type.put('S',3);
        type.put('G',4);
        type.put('F',5);
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

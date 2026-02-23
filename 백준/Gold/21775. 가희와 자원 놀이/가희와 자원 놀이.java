import java.io.*;
import java.util.*;
public class Main {


    //메모리 초과??
    public static int N,T;
    //public static int[] card=new int[2000000001];
    public static HashMap<Integer, Integer> card=new HashMap<>(); //key카드를 value가 가지고 있다.
    //public static HashMap<Integer, HashSet<Integer>> acquire=new HashMap<>(); //Integer 사용자는 사용해야하는 카드가 있다.
    public static int[][] acquire;

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // T개의 연산카드와 int 범위의 자연수가 순서대로 적혀있는 카드
        // 연산카드의 종류는 3가지,
        // next: 이 카드를 버린다,

        // acquire n: 자연수 n이 적힌 카드를 획득하려고 시도
        // n이 공용공간에 있으면 가져오고 acquire n 카드를 버림
        // 다른 유저가 가지고 있으면 카드를 버리지 않고 다음 차례에 재사용

        // release n: 자연수 n이 적힌 카드를 반납하고 이 카드를 버린다.

        // T턴동안 수행된 연산 카드의 id를 말하라.

        // 사람의 수 N, 턴의 수 T

        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        acquire=new int[N+1][2];

        st=new StringTokenizer(br.readLine());
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<T;i++){ //각 턴을 수행한 사람
            q.add(Integer.parseInt(st.nextToken()));
        }

        ArrayDeque<String> top=new ArrayDeque<>();

//        for(int i=0;i<T;i++){
//            top.add(br.readLine());
//        }

        //String[] c;
        String str;
        StringBuilder sb=new StringBuilder();
        int id,target;
        String order;
        int user;

        while(!q.isEmpty()){

            user=q.poll();

            //acquire 카드를 가지고 있음
            if(acquire[user][0]!=0){
                sb.append(acquire[user][1]+"\n");


                if(!card.containsKey(acquire[user][0])){// 카드를 사용할 수 있다.
                    card.put(acquire[user][0],1);
                    //card[acquire[user][0]]=user;


                    acquire[user][0]=0;
                    acquire[user][1]=0;
                }
            }else{
                //카드를 가지고 있지 아니함

                //c=br.readLine().split(" ");
                st=new StringTokenizer(br.readLine());
                //c=top.poll().split(" ");
//                id=Integer.parseInt(c[0]);
//                order=c[1];

                id=Integer.parseInt(st.nextToken());
                order=st.nextToken();

                if(order.equals("next")){
                    sb.append(id+"\n");
                    continue;
                }

//                target=Integer.parseInt(c[2]);
                target=Integer.parseInt(st.nextToken());
                if(order.equals("acquire")){
                    if(!card.containsKey(target)){//카드를 가져올 수 있으면
                        //card[target]=user;
                        card.put(target,user);
                    }else{
                        acquire[user][0]=target;
                        acquire[user][1]=id;
                    }
                }else{ //release  흭득하지 못한 카드를 release하는 경우는 주어지지 않음
                    //card[target]=0;
                    card.remove(target);
                }
                sb.append(id+"\n");
            }
        }

        System.out.println(sb);
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
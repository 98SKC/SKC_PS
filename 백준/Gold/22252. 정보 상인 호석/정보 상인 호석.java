import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 여러명에게 정보를 모은다.
        // 각 정보상인이 C1,C2...CK 만큼의 가치를 가진 정보 k개를 얻었다는 것을 안다.
        // 언제 정보를 몇개 살 것인지 정할 수 있다. 가장 비싼 정보들을 구매한다.


        //정보상인이 정보를 얻는 사건과, 필자가 거래하는 정보가 시간순으로 주어진다.

        int Q=Integer.parseInt(br.readLine()); //쿼리의 개수

        //쿼리가 1로 시작하면 정보상인의 이름과 얻은 정보
        //쿼리가 2로 시작하면 정보상인의 이름과 구매하려는 정보의 개수
        long answer=0;
        HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();



        StringTokenizer st;
        int q,b;
        String name;
        int cnt=0;
        for(int t=0;t<Q;t++) {
            st=new StringTokenizer(br.readLine());
            q=Integer.parseInt(st.nextToken());
            name=st.nextToken();
            b=Integer.parseInt(st.nextToken());
            if(q==1){
                if(!map.containsKey(name)){
                    map.put(name, new PriorityQueue<>(Comparator.reverseOrder()));
                }
                for(int j=0;j<b;j++){
                    map.get(name).add(Integer.parseInt(st.nextToken()));
                }
            }else{
                if(!map.containsKey(name)) continue;

                int len=map.get(name).size();
                cnt=0;

                while(!map.get(name).isEmpty()&&cnt<b){
                    answer+=map.get(name).poll();
                    cnt++;

                }
                //System.out.println(t+"에서 "+answer);
            }

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

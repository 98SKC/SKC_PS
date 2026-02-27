import java.io.*;
import java.util.*;

public class Main{


    public static int N,K;
    public static int[] schedule;
    public static int[] next;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        K=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());

        schedule=new int[N];
        next=new int[N];

        st=new StringTokenizer(br.readLine());



        //사용 순서는 고정
        //누굴 뽑을지가 관건
        //뽑는 best -> 이후에 안나옴
        //남기는 best -> 이후에 나옴. 많이나옴. 근래에 있음?

        for(int i=0;i<N;i++){
            schedule[i]=Integer.parseInt(st.nextToken());
        }
        HashMap<Integer,Integer> save=new HashMap<>();

        //i인덱스에 나온 요소는 next[i]인덱스에서 다시 나온다. 300이면 다시 나오지 않는다. 제거1순위
        for(int i=N-1;i>=0;i--){
            next[i]=save.getOrDefault(schedule[i],300);
            save.put(schedule[i],i);
        }

        //System.out.println(Arrays.toString(next));
        //그리디라고 생각을 하자.
        //멀티탬 크기만큼 뒤를 봤을 때,
        //똑같은 대상이 있으면 걔는 남겨야함.
        //HashSet<Integer> set=new HashSet<>();

        int point=0;
        int answer=0;


        save.clear();
        HashMap<Integer,Integer> map=new HashMap<>();

        //다음 사용
//        TreeMap<Integer,Integer> map=new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o2,o1);
//            }
//        });

        while(map.size()<K&&point<N){
            //set.add(schedule[point++]);
            map.put(schedule[point],next[point]);
            point++;
        }

        //point부터 K범위까지 슬라이드 윈도우
        //멀티탭 하나로만 바꿔도 상관없지않나

        //이후에 사용을 안하면 빼버려도 된다.
        //다음 사용하는 숫자가 가까울 수록 대상순위는 밀린다.
        //그러면 지금 위치는, 다음에 자신이 언제 다시 나오는지 알아야 한다.
        //그리고 이미 꽃혀있는 타겟이 들어오면 다음 위치도 갱싱되어야 한다.
        //트리맵 사용
        int target,n;
        for(int i=point;i<N;i++){
            if(!map.containsKey(schedule[i])){//이미 사용중이 아니라면
                //System.out.println(map.toString());

                target=-1;
                n=-1;
                for(Integer key:map.keySet()){
                    if(map.get(key)>n){
                        target=key;
                        n=map.get(key);
                    }
                }
                //System.out.println(i+"턴에 "+target+"제거");
                map.remove(target);

                answer++;
            }
            map.put(schedule[i],next[i]);
        }

        System.out.println(answer);
    }
}

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
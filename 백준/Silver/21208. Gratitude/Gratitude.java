import java.io.*;
import java.util.*;

public class Main {

    public static int N,K;
    public static class Word{
        String word;
        int cnt;


        public Word(String word, int cnt) {

            this.word = word;
            this.cnt = cnt;

        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer>  last= new HashMap<>();

        String str;

        int len=3*N;

        for(int i=0;i<len;i++){
            str=br.readLine();
            last.put(str,i);
            map.put(str,map.getOrDefault(str,0)+1);
        }

        PriorityQueue<Word> pq=new PriorityQueue<>(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                if(o1.cnt==o2.cnt){//
                    return last.get(o2.word).compareTo(last.get(o1.word));
                }
                //return o2.cnt-o1.cnt;
                return Integer.compare(o2.cnt,o1.cnt);
            }
        });

        for(String key:map.keySet()){
            pq.add(new Word(key,map.get(key)));
        }
        while(!pq.isEmpty()){
            sb.append(pq.poll().word+"\n");
            K--;
            if(K==0) break;
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

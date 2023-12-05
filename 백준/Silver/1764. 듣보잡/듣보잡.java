import com.sun.jdi.IntegerType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        //split으로 배열 반들지 말고, StringTokenizer 사용해보기
        //매 순간 출력하지 말고 StringBuilder 사용해보기
        //StringBuilder sb = new StringBuilder();
        //sb.append(map.get(number)).append(" ");
        //System.out.println(sb);


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        HashSet<String> set=new HashSet<>();
        ArrayList<String> list=new ArrayList<>();

        int count=0;
        String str;
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            str=br.readLine();
            set.add(str);
        }
        for(int j=0;j<M;j++){
            str=br.readLine();

            if(set.contains(str)){
                count++;
                list.add(str);
            }
        }
        Collections.sort(list);
        System.out.println(count);
        for(String answer:list){
            System.out.println(answer);
        }

    }
}

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

    public static int answer=0;
    public static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //나이가 17보다 많거나 몸무게가 80이상이면 성인

        StringTokenizer st;
        String name;
        int age,weight;
        while(true){
            st=new StringTokenizer(br.readLine());
            name=st.nextToken();
            age=Integer.parseInt(st.nextToken());
            weight=Integer.parseInt(st.nextToken());

            if(name.equals("#")) break;

            sb.append(name+" ");
            if(age>17||weight>=80) sb.append("Senior");
            else sb.append("Junior");

            sb.append("\n");

        }

        System.out.println(sb);

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

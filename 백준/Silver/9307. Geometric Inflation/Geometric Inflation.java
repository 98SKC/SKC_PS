import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<Double> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        //arr[i]=(arr[i-1]*arr[i-2])/arr[i-2]  최종은
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            list=new ArrayList<>();

            list.add(Double.parseDouble(st.nextToken()));


            if(list.get(0)==-1) break;

            list.add(Double.parseDouble(st.nextToken()));
            list.add(Double.parseDouble(st.nextToken()));

            //4를 입력받고, 답은 list.get(3)이 될 것. 2까지 출력 가능. N은 3이다.
            int N=Integer.parseInt(st.nextToken());
            N-=1;

            if(N<3) {
                //sb.append(String.format("Month %d cost: $%.2f%n", (N+1), list.get(N)));
                sb.append( String.format("Month %d cost: $%,.2f%n", (N+1),  list.get(N)));
                continue;
            }

            Double sub;

            for(int i=3;i<=N;i++){
                sub=(list.get(i-3)*list.get(i-2))/ list.get(i-1);
                sub = Math.round(sub * 100) / 100.0D;
                list.add(sub);
            }
            //sb.append(String.format("Month %d cost: $%.2f%n", (N+1), list.get(N)));
            sb.append( String.format("Month %d cost: $%,.2f%n", (N+1),  list.get(N)));

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

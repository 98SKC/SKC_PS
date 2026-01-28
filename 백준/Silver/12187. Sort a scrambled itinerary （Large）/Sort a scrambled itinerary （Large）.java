import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        int N;

        StringBuilder sb = new StringBuilder();

        String start,goal;

        //도착지로 선택되지 않는 곳이 출발점, 이후로 따라쓰기?
        //

        for(int test_case=1;test_case<=T;test_case++){
            sb.append("Case #"+test_case+": ");
            HashMap<String, String> ticket=new HashMap<>();
            HashSet<String> save=new HashSet<>();
            N=Integer.parseInt(br.readLine());
            for(int i=0;i<N;i++){
                start=br.readLine();
                goal=br.readLine();

                ticket.put(start,goal);
                if(save.contains(start)) save.remove(start);
                else save.add(start);

                if (save.contains(goal)) save.remove(goal);
                else save.add(goal);
            }
            String s="";
            for(String station:save){
                if(ticket.containsKey(station)) s=station;
            }

            while(ticket.containsKey(s)){
                sb.append(s);
                sb.append("-"+ticket.get(s)+" ");
                s=ticket.get(s);
            }
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

import java.io.*;
import java.util.*;
public class Main {

    public static int N;
    public static HashMap<String, Integer> map=new HashMap<>();
    public static String[] str;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        str=new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            map.put(st.nextToken(),i);
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            str[i]=st.nextToken();
        }
        int answer=0;

        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(check(str[i],str[j])) answer++;
            }
        }
        int p=N*(N-1)/2;
        System.out.println(answer+"/"+p);


    }
    public static boolean check(String fir, String sec){
        if(map.get(fir)<map.get(sec))return true;
        return false;
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
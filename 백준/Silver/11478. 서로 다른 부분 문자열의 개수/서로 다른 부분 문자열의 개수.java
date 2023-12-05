import com.sun.jdi.IntegerType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] str=br.readLine().split("");
        HashSet<String> set=new HashSet<>();
       // StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<str.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<str.length;j++) {
                sb.append(str[j]);
                set.add(sb.toString());
            }
        }
        System.out.println(set.size());
    }
}

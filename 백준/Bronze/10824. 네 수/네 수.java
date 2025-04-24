
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        //concat 사용 연습
        System.out.println(Long.parseLong(str[0].concat(str[1]))+ Long.parseLong(str[2].concat(str[3])));

    }
}

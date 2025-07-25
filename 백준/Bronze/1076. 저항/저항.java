import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        long answer;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //색과 저항값을 저장할 map
        
        HashMap<String,String> map1 = new HashMap<>(){{
            put("black","0");
            put("brown", "1");
            put("red", "2");
            put("orange", "3");
            put("yellow", "4");
            put("green", "5");
            put("blue", "6");
            put("violet", "7");
            put("grey", "8");
            put("white", "9");
        }};  
        
        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();
        
        answer = Long.parseLong(map1.get(color1) + map1.get(color2));
        
        answer *= Math.pow(10.0, (double) Integer.parseInt(map1.get(color3)));
        System.out.print(answer);
    }
}
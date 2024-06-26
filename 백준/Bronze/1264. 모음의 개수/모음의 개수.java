import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb=new StringBuilder();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        int answer;
        while (true) {
            answer = 0;
            String[] str = br.readLine().split(" ");
            if (str[0].equals("#")) break; 
            for (int i = 0; i < str.length; i++) { 
                for (int j = 0; j < str[i].length(); j++) { 
                    if (set.contains(str[i].charAt(j))) answer++;
                }
            }
            sb.append(answer+"\n");
        }
        System.out.println(sb); 
    }
}
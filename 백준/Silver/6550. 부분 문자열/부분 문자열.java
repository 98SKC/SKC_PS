import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          while (true){
              String temp= br.readLine();
              if(temp == null) break;
              StringTokenizer st = new StringTokenizer(temp," ");
              String str = st.nextToken();
              String str2 = st.nextToken();

              checking(str,str2);
          }
    }
    static void checking(String str,String str2){
        int count = 0;
        int index = 0;
        
        for(int i =0;i<str2.length();i++){
            if(str.charAt(index) == str2.charAt(i)){
                index++;
                count++;
                if(index == str.length()) break;
            }
        }

        if(count == str.length()){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }
}
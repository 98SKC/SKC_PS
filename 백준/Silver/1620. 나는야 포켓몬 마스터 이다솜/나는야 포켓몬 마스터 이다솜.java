import com.sun.jdi.IntegerType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> numberOutput=new HashMap<>();
        HashMap<Integer, String> stringOutput=new HashMap<>();
        String sub;

        String[] str=br.readLine().split(" ");

        int N= Integer.parseInt(str[0]);
        int M= Integer.parseInt(str[1]);

        for(int i=1;i<=N;i++){
            sub=br.readLine();
            numberOutput.put(sub,i);
            stringOutput.put(i,sub);
        }
        for(int j=0;j<M;j++){
            sub=br.readLine();
            if(49 <= sub.charAt(0) && sub.charAt(0) <= 57){
                System.out.println(stringOutput.get(Integer.parseInt(sub)));
            }else{
                System.out.println(numberOutput.get(sub));
            }

        }
    }
}

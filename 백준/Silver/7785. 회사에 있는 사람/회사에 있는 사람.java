import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String > set=new HashSet<>();
        ArrayList<String> answer;


        int N=Integer.parseInt(br.readLine());
        String[] str;

        for(int i=0;i<N;i++){
            str=br.readLine().split(" ");
            if(str[1].equals("enter")){
                set.add(str[0]);
            }else if(str[1].equals("leave")){
                set.remove(str[0]);
            }
        }
        answer=new ArrayList<>(set);
        Collections.sort(answer,Collections.reverseOrder());

        for(String sub: answer){
            System.out.println(sub);
        }
    }
}

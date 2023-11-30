import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] str=br.readLine().split(" ");
        char position;
        long sub;
        long answer=0;

        int B=Integer.parseInt(str[1]);
        String N=str[0];
        int max=N.length()-1;

        for(int i=0;i<N.length();i++){
            position=N.charAt(i);

            if('0'<=position && position<='9'){
                //sub=position;//이와 같이 작성하면, position의 아스키값이 들어감.
                sub=position-'0';
                answer+=sub*Math.pow(B,max);
            }else{
                sub=position-'A'+10;
                answer+=sub*Math.pow(B,max);
            }
            max--;
        }
        System.out.println(answer);
    }
}

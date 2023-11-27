import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] str=br.readLine().split(" ");
        StringBuffer sbOne=new StringBuffer(str[0]);// 문자열을 뒤집기 위한 StringBuffer
        String reverseA = sbOne.reverse().toString();//StringBuffer는 객체이기 떄문에 String과 달리 변형이 가능하나
                                                    //객체이기 떄문에 String에 넣기위해 toString으로 문자열로 바꿔야함

        StringBuffer sbTwo=new StringBuffer(str[1]);
        String reverseB=sbTwo.reverse().toString();

        System.out.println(Math.max(Integer.parseInt(reverseA),Integer.parseInt(reverseB)));
    }
}
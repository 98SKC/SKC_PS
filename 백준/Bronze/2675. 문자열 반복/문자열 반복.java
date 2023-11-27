import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        for(int test_case=0;test_case<T;test_case++){

            String[] str=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);

            for(char a: str[1].toCharArray()){//toCharArray()는 문자열을 문자의 배열로 반환하는 메서드
                                                /*ex) String str = "abcd";
                                                      char[] charArray = str.toCharArray();*/
                for(int i=0;i<n;i++){
                    System.out.print(a);
                }

            }
            System.out.println();
        }





    }
}
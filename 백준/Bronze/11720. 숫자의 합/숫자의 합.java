import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        String str=br.readLine();
        int sum=0;
        for(int i=0;i<n;i++){
            //sum+=Integer.parseInt(str.charAt(i));// str.charAt(i)의 반환값이 char이므로, 이를 Integer.parseInt()에 바로 넘겨주는 것이 불가
            sum+=Integer.parseInt(String.valueOf(str.charAt(i)));// char 값을 문자열로 변환하고, 그 결과를 Integer.parseInt()에 전달하여 문자열을 정수로 변환합니다
        }
        System.out.println(sum);
    }
}
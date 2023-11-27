import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        for(int test_case=0;test_case<T;test_case++){
            String str=br.readLine();
            //System.out.println(str.charAt(0)+str.charAt(str.length()-1));//Java에서 문자는 내부적으로 ASCII 값으로 관리되기 때문에, + 연산을 사용하면 문자들의 ASCII 값이 더해지게 됨
            System.out.println(str.charAt(0)+""+str.charAt(str.length()-1));
        }

    }
}

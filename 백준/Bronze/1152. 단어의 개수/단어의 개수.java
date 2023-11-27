import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        //String[] str=br.readLine().trim().split(" ");// 문자열 맨 앞, 맨 뒤의 공백 제거 trim.
                                                    //만약 문자열 내부의 연속된 공백을 하나의 공백으로 대체해려면
                                                    //String str = "a           b";
                                                    //str = str.replaceAll("\\s+", " ");
                                                    //왜 split 사용할때 공백 입력하면 길이가 1이지?...
                                                    // -> br.readLine().trim().split(" "); 결과로 ""라는 결과가 나오고 이게 str에 들어가니, ""가 원소인 배열 생성.

        String str=br.readLine().trim();
        if(str.isBlank()){
            System.out.println(0);
        }else{
            String[] answer=str.split(" ");
            System.out.println(answer.length);
        }
        
    }
}
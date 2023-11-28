import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int count = n;  //일단 전체 문자열 개수
        for (int i = 0; i < n; i++) {
            boolean[] arr = new boolean[26];  // 문자 확인 배열 
            String s = br.readLine();
            arr[(int)s.charAt(0) - 97] = true;  //첫번째 단어 확인.
            for (int j = 1; j < s.length(); j++) {
                char c = s.charAt(j);
                //이전 문자와 같으면 페스
                if (c == s.charAt(j-1)) continue;

                //이전 문자와 다르고 이미 나타난 문자면 그룹 단어가 아니다. count - 1 이후 브레이크
                if (arr[(int)c - 97]) {
                    count--;
                    break;
                }
                arr[(int)c - 97] = true;  //나타난 단어라고 확인
            }
        }
        System.out.println(count);
    }
}
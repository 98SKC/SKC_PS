import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 이름의 길이를 입력 받음 (사용하지 않음)
        int nameLength = Integer.parseInt(br.readLine());
        
        // 두 번째 줄에서 이름을 입력 받음
        String name = br.readLine();
        
        // 이름 점수를 계산할 변수 초기화
        int nameScore = 0;
        
        // 이름의 각 문자를 순회하면서 점수를 계산
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c >= 'A' && c <= 'Z') { // 대문자만 처리
                nameScore += (c - 'A' + 1);
            }
        }
        
        // 계산된 이름 점수를 출력
        System.out.println(nameScore);
    }
}
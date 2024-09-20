import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while (true) {
            s = br.readLine();
            if (s.equals("end")) {
                break;
            }

            boolean check = true;  // 기본적으로 유효한 패스워드인지 체크
            boolean hasVowel = false;  // 모음이 있는지 체크
            int Astack = 0; // 모음 연속 카운트
            int Zstack = 0; // 자음 연속 카운트

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // 모음이면
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    hasVowel = true;  // 모음이 하나라도 있으면 true
                    Astack++; // 모음 연속 카운트 증가
                    Zstack = 0; // 자음 연속 카운트 초기화
                } else { // 자음이면
                    Zstack++; // 자음 연속 카운트 증가
                    Astack = 0; // 모음 연속 카운트 초기화
                }

                // 모음 또는 자음이 3개 연속으로 오면 안 된다
                if (Astack == 3 || Zstack == 3) {
                    check = false;
                    break;
                }

                // 같은 글자가 연속으로 두 번 오면 안된다. 다만 'ee'와 'oo'는 예외
                if (i > 0 && s.charAt(i) == s.charAt(i - 1) && !(c == 'e' || c == 'o')) {
                    check = false;
                    break;
                }
            }

            // 모음이 하나도 없으면 check는 false로 설정
            if (!hasVowel) {
                check = false;
            }

            // 최종적으로 check가 true면 "acceptable", false면 "not acceptable"
            if (check) {
                System.out.println("<" + s + "> is acceptable.");
            } else {
                System.out.println("<" + s + "> is not acceptable.");
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = br.readLine();

        //문제의 개수는 초기값이 0
        int cnt = 0;
        if (inputStr.equals("고무오리 디버깅 시작")) {
            inputStr = br.readLine();

            // 종료 문구를 받을때까지 반복
            while (!inputStr.equals("고무오리 디버깅 끝")) {

                //문제를 받으면 1을 더하고
                if (inputStr.equals("문제")) {
                    cnt++;

                //고무오리를 받을 경우
                } else if (inputStr.equals("고무오리")) {
                    
                    // 0보다 크면 1을 빼고
                    if (cnt > 0) {
                        cnt--;
                        
                    // 0보다 작으면 2를 더합니다.
                    } else {
                        cnt = cnt + 2;
                    }
                }
                inputStr = br.readLine();
            }
        }

        // 문제가 0보다 크면 힝구
        // 0보다 작으면 고무오리야 사랑해를 출력합니다.
        String outputStr = "고무오리야 사랑해";
        if (cnt > 0) {
            outputStr = "힝구";
        }
        System.out.println(outputStr);
    }


}


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	//bigInteger 안쓰고 풀어보기
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        char op = br.readLine().charAt(0);
        String M = br.readLine();
        String answer = "";

        if (op == '+') {
            if (N.length() > M.length()) {
                answer = N;
                
                // 뒤에서 M 길이만큼 겹치는 자리의 '0' → '1'
                StringBuilder sb = new StringBuilder(answer);
                int pos = N.length() - M.length();
                sb.setCharAt(pos, '1');
                answer = sb.toString();

            } else if (N.length() < M.length()) {
                answer = M;
                // 뒤에서 N 길이만큼 겹치는 자리의 '0' → '1'
                StringBuilder sb = new StringBuilder(answer);
                int pos = M.length() - N.length();
                sb.setCharAt(pos, '1');
                answer = sb.toString();

            } else {
                // 10제곱만 알고있다고 하니 안나올 것 같지만, 혹시 모르니
            	answer = M;
                // 앞자리 2로
                StringBuilder sb = new StringBuilder(answer);
                int pos = M.length() - N.length();
                sb.setCharAt(0, '2');
                answer = sb.toString();
            }

        } else {  // op == '*'
            // '1' 뒤에 (N.length()-1)+(M.length()-1)개의 '0' 붙이기
//            int zeros = (N.length() - 1) + (M.length() - 1);
//            String fmt = "%s%0" + zeros + "d";    // ex) "%s%04d"
//            answer = String.format(fmt, "1", 0);
        	
        	//★위에서 둘 다 한자리 수 일때 . zeros가 0이됨. 이게 문제가 된다고 한다.
        	//Java 의 Formatter는 %[argument_index$][flags][width][.precision]conversion로 이루어져있다고함
        	//많이 복잡하니 여기에서의 문제만 먼저 살펴보자면 zeros가 0일 때 문자열이 "%s%00d"가 되는데
        	//첫 번째 0 은 flags 로 해석되고, 그 뒤에 “width” 로 읽힐 만한 숫자가 전혀 남아 있지 않다고 본다고 한다.
        	//이게 무슨 뜻이냐면 두번째 0자리에 원래 1,2,3,4 같은 최소 너비가 와야하는데 0으로 와서 최소너비로 읽힐만한 숫자가 없다고
        	//판단되어 런타임에러가 난다고 한다.
        	//오류 내용은 java.util.DuplicateFormatFlagsException: Flags = '0
        	//브론즈에서 알찬거 배워가니 버릴 문제가 없도다
        	int zeros = (N.length() - 1) + (M.length() - 1);
        	if (zeros == 0) {
        	    // A와 B가 모두 “1”인 경우, 1*1 = "1"
        	    answer = "1";
        	} else {
        	    // 정상적인 format 사용
        	    String fmt = "%s%0" + zeros + "d";
        	    answer = String.format(fmt, "1", 0);
        	}
        }

        System.out.println(answer);
    }
}

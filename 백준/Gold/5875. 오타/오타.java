import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        int len=str.length();
        // ()는 올바른 괄호쌍이다
        // A가 올바르면 (A)도 올바르다
        // A,B가 올바르면 AB또한 올바르다.
        // 최대 한번의 오타가 있다.
        // 하나의 문자만 고쳐서 올바른 괄호쌍이 될 수 있는 경우의 수를 출력하라.
        
        // 올바른 괄호란 열린만큼 닫을 수 있음
        // 오타를 수정한다는 것은 두가지
        // 1. (를 )로 바꾼다. 이게 가능하려면 수정하는 ( 이전에 (가 하나 있어야 한다.
        // 2. )를 (로 바꾼다. 이건 될지 안될지 전부 보긴 해야함.
        int[] dp=new int[len];
        for(int i=0;i<len;i++) {
        	if(str.charAt(i)=='(') dp[i]++;
        	else dp[i]--;
        }
        
        for(int i=1;i<len;i++) {
        	dp[i]+=dp[i-1];
        }
        
        
        //정확히는 음수냐 양수냐기보단 -2 혹은 2야만 하나만을 고쳐서 올바른 괄호로 만들 수 있다인가?
        //(가 많다. (인 곳들을 )로 바꿀 수 있는지 판별한다. 
        
        // prefix 최소 누적합: 0..i 구간에서 dp의 최솟값
        int[] minPrefix = new int[len];
        minPrefix[0] = dp[0];
        for (int i = 1; i < len; i++) {
            minPrefix[i] = Math.min(minPrefix[i - 1], dp[i]);
        }
        
        // suffix 최소 누적합
        int[] minSuffix = new int[len];
        minSuffix[len - 1] = dp[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            minSuffix[i] = Math.min(dp[i], minSuffix[i + 1]);
        }

        int answer = 0;

        // '(' 가 많은 경우 → '(' 를 ')' 로

        if (dp[len - 1] == 2) {
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) != '(') continue;

                // i 이전(prefix 0..i-1)이 단 한 번도 음수가 아니어야 함
                if (i > 0 && minPrefix[i - 1] < 0) continue;

                // i 이후는 전부 -2 되므로, 최소값도 -2 되어도 0 이상이어야 함
                if (minSuffix[i] - 2 >= 0) answer++;
            }
        }
        // ')' 가 많은 경우 → ')' 를 '(' 로 (최종합은 반드시 -2)
        else if (dp[len - 1] == -2) {
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) != ')') continue;

                // i 이전(prefix 0..i-1)이 단 한 번도 음수가 아니어야 함
                if (i > 0 && minPrefix[i - 1] < 0) continue;

                // i 이후는 전부 +2 되므로, 최소값도 +2 했을 때 0 이상이어야 함
                if (minSuffix[i] + 2 >= 0) answer++;
            }
        }
        
        System.out.println(answer);
        
    }
    // 문제는 구현부
    // (라고 전체를 탐색하는 식이면 최대 N^2 : 10000000000
    // 그럼 어떻게 시간을 줄일 수 있는가 
   

}

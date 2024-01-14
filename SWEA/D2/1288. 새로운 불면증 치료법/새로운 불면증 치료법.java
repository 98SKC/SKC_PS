import java.util.*;
import java.io.*;

class Solution {
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int answer;
        int N;

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            int curNumber = N;
            HashSet<Integer> set = new HashSet<Integer>();

            while (set.size() < 10) {
                int sub = curNumber;
                while (sub > 0) {
                    set.add(sub % 10);
                    sub /= 10;
                }
                curNumber += N;
            }
            answer = curNumber - N; // 마지막으로 추가된 숫자를 제거
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

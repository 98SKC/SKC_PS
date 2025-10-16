import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Character> dq = new ArrayDeque<>();
        Stack<Boolean> stk = new Stack<>();

        while (n-- > 0) {
            String input = br.readLine();
            char op = input.charAt(0);

            if (op == '1') {
                dq.offerLast(input.charAt(2));
                stk.push(true);
            } else if (op == '2') {
                dq.offerFirst(input.charAt(2));
                stk.push(false);
            } else if (!dq.isEmpty()) {
                if (stk.pop()) dq.removeLast();
                else dq.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : dq)
            sb.append(c);

        bw.write(sb.length() > 0 ? sb.toString() : "0");
        bw.flush();
    }

}


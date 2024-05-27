import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String sub = br.readLine();
            sub = sub.replace("[", "").replace("]", "");
            String[] subArr = sub.split(",");
            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                dq.add(Integer.parseInt(subArr[i]));
            }

            boolean r = false;
            boolean isError = false;

            for (char c : str.toCharArray()) {
                if (c == 'R') {
                    r = !r;
                } else {
                    if (dq.isEmpty()) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                    if (r) {
                        dq.pollLast();
                    } else {
                        dq.pollFirst();
                    }
                }
            }

            if (!isError) {
                sb.append("[");
                while (!dq.isEmpty()) {
                    if (r) {
                        sb.append(dq.pollLast());
                    } else {
                        sb.append(dq.pollFirst());
                    }
                    if (!dq.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }

        System.out.println(sb.toString());
    }
}
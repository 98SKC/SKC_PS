import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            br.readLine(); // A B 입력은 의미 없이, 모든 수는 1과 -1로 표현이 가능하기에....
            sb.append("yes\n");
        }
        System.out.print(sb);
    }
}

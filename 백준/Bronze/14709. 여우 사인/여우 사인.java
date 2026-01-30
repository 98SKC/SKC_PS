import java.io.*;
import java.util.*;

public class Main {

    static int key(int a, int b) {
        if (a > b) { int t = a; a = b; b = t; }
        return a * 10 + b; // 1..5라 안전
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Set<Integer> s = new HashSet<>();
        boolean bad = false;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 2 || b == 2 || a == 5 || b == 5) bad = true;
            s.add(key(a, b));
        }

        Set<Integer> need = new HashSet<>();
        need.add(key(1, 3));
        need.add(key(1, 4));
        need.add(key(3, 4));

        if (!bad && N == 3 && s.equals(need)) {
            System.out.println("Wa-pa-pa-pa-pa-pa-pow!");
        } else {
            System.out.println("Woof-meow-tweet-squeek");
        }
    }
}

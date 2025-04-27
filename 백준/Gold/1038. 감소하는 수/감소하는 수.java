import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        list = new ArrayList<>();

        if (n <= 10) {
            System.out.println(n);
        } else if (n > 1022) {
            System.out.println("-1");
        } else {
            for (int i = 0; i < 10; i++) {
                helper(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(n));
        }
    }

    public static void helper(long num, int idx) {
        if (idx > 10) return;

        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            helper((num * 10) + i, idx + 1);
        }
    }
}

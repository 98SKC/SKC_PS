import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = 4;
        int cnt = 0;

        for (int a = 0; a < SIZE; a++) {
            String line = reader.readLine();

            for (int b = 0; b < SIZE; b++) {
                char ch = line.charAt(b);

                if (ch == '.') continue;

                int val = ch - 'A';

                int row = val / 4;
                int col = val % 4;

                cnt += Math.abs(a - row) + Math.abs(b - col);
            }
        }

        System.out.println(cnt);
        reader.close();
    }
}

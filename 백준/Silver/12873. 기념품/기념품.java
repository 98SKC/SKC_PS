

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long turn = 1;
        int pos = 0; 
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        while (list.size() > 1) {
            long target = (long)Math.pow(turn, 3);
            
            pos = (int)((pos + target - 1) % list.size());

            list.remove(pos);

            turn++;
        }

        System.out.println(list.get(0));
    }
}

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            int operations = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < operations; i++) {
                String[] input = br.readLine().split(" ");
                char type = input[0].charAt(0);
                int number = Integer.parseInt(input[1]);

                if (type == 'I') {
                    map.put(number, map.getOrDefault(number, 0) + 1);
                } else if (!map.isEmpty()) {
                    if (number == 1) { // Delete max
                        int maxKey = map.lastKey();
                        if (map.put(maxKey, map.get(maxKey) - 1) == 1) {
                            map.remove(maxKey);
                        }
                    } else { // Delete min
                        int minKey = map.firstKey();
                        if (map.put(minKey, map.get(minKey) - 1) == 1) {
                            map.remove(minKey);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                int max = map.lastKey();
                int min = map.firstKey();
                sb.append(max + " " + min + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
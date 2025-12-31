

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken());

       
        List<int[]> events = new ArrayList<>();
        List<Character> chars = new ArrayList<>();

        int maxTime = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            events.add(new int[]{person, time});
            chars.add(c);

            maxTime = Math.max(maxTime, time);
        }

        StringBuilder sb = new StringBuilder();

      
        for (int t = 0; t <= maxTime; t++) {
            List<Integer> idxList = new ArrayList<>();

         
            for (int i = 0; i < m; i++) {
                if (events.get(i)[1] == t) {
                    idxList.add(i);
                }
            }

            
            idxList.sort((a, b) ->
                    Integer.compare(events.get(a)[0], events.get(b)[0])
            );

            
            for (int idx : idxList) {
                sb.append(chars.get(idx));
            }
        }

        System.out.print(sb.toString());
    }
}

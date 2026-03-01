import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] masks = new int[M];
        int[] counts = new int[M];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int mask = 0;
            
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == '1') {
                    mask |= (1 << j);
                }
            }
            
            masks[i] = mask;
            counts[i] = Integer.parseInt(st.nextToken());
        }
        
        int validCount = 0;
        int validMask = -1;
        
        int total = 1 << N;
        
        for (int mask = 0; mask < total; mask++) {
            boolean ok = true;
            
            for (int i = 0; i < M; i++) {
                int intersection = mask & masks[i];
                int bitCount = Integer.bitCount(intersection);
                
                if (bitCount != counts[i]) {
                    ok = false;
                    break;
                }
            }
            
            if (ok) {
                validCount++;
                validMask = mask;
                
                if (validCount > 1) {
                    System.out.println("NOT UNIQUE");
                    return;
                }
            }
        }
        
        if (validCount == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if ((validMask & (1 << i)) != 0) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            System.out.println(sb.toString());
        }
    }
}
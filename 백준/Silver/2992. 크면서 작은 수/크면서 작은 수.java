
import java.io.*;
import java.util.*;

public class Main {
    static int N, num, min = Integer.MAX_VALUE;
    static int[] arr, list;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        String X = br.readLine();
        num = Integer.parseInt(X);
        N = X.length(); 
        arr = new int[N];
        list = new int[N];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = X.charAt(i) - '0';
        }
        
        back(0);
        
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);  
    }

    static void back(int depth) {
        
        
        if (depth == N) {
            String s = "";
            for (int i : list) {
                s += i;
            }
            int n = Integer.parseInt(s);

            if (num < n) { 
                min = Math.min(min, n);
            }
            return;
        }
        
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) { 
                visited[i] = true; 
                list[depth] = arr[i]; 
                back(depth + 1);
                visited[i] = false; 
            }
        }
    }
}
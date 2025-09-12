
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] t = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) t[i] = Integer.parseInt(st.nextToken());

          
        Arrays.sort(t);               
        for (int k = n; k >= 0; k--) {         
                if (k == 0 || t[n - k] >= k) {        
                System.out.println(k);
                return;
                }
        }
    }
        
}



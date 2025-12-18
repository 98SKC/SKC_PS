import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int N = Integer.parseInt(br.readLine());
  
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);
        

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + " ");
        }
        

        br.close();
        bw.flush();
        bw.close();
    }
}
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[1001];
        
        arr[0]=0;
        arr[1]=1;
        arr[2]=3;
        for (int i = 3; i <= N; i++) {
            arr[i] = (arr[i - 1] + 2 * arr[i - 2]) % 10007;
        }
        
       System.out.println(arr[N]); 
    }

}
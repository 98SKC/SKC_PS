import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t = Integer.parseInt(br.readLine());
       
        for(int i=0;i<t;i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];

            for (int j = 0; j < n; j++)
                arr[j] = br.readLine();

            Arrays.sort(arr);	
            sb.append(search(arr) + "\n");
        }
        System.out.println(sb);
    }
     //startsWith 메서드의 사용 학습
    static String search(String[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1].startsWith(arr[i]))	
                return "NO";		
        }
        return "YES";	
    }
}
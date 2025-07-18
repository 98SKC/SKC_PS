import java.io.*;
import java.util.*;

public class Main {
	 
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int [] arr = new int[n+1];
        List<Integer> answer = new ArrayList<>();
 
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
 
        for(int i=n; i>=1; i--) {
            answer.add(arr[i], i);
        }
 
        for(int a : answer) {
            System.out.print(a+" ");
        }
    }
 
}
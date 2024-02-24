import java.util.*;
import java.io.*;
 
 
public class Main {
    public static void main(String[] args) throws Exception {
        
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M =Integer.parseInt(st.nextToken());
        int Min = Integer.MAX_VALUE;
 
        int[] arr1 = new int[M];
        int[] arr2 = new int[M];
       
        
        for(int i=0; i<M; i++){
        	st=new StringTokenizer(br.readLine());
            arr2[i] = Integer.parseInt(st.nextToken());
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        //1. 가장 싼 6개짜리 팩 2. 따로 따로 구매 3.가장싼 6개짜리 팩+ 따로따로 구매
        Min = Math.min(((N/6)+1)*arr2[0], N*arr1[0]);    
        Min = Math.min(Min, ((N/6))*arr2[0] + (N%6)*arr1[0]);
        System.out.println(Min);
    }
}
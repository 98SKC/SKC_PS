import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        
        int arr[]=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        for(int i=0;i<N;i++) {
        	if(L<arr[i]) {
        		break;
        	}else {
        		L++;
        	}
        }
        System.out.println(L);
    }


}
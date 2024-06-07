import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[7];
        for(int i=0;i<6;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        	//System.out.println(arr[i]);
        	//arr[6]+=arr[i];// 전체 인원
        }
        int T,P;
        st=new StringTokenizer(br.readLine());
        T=Integer.parseInt(st.nextToken());
        P=Integer.parseInt(st.nextToken());
        int shirt=0;
        for(int i=0;i<6;i++) {
        	if(arr[i]%T==0) {
        		shirt+=arr[i]/T;
        	}else{
        		shirt+=arr[i]/T+1;
        	}
        }
        
        System.out.println(shirt);
        System.out.print(N/P+" "+N%P);
        
        
    }
}
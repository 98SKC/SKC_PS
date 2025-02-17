import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int[] arr;
	public static boolean[] check;
	public static int answer=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr=new int[N];
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
        check=new boolean[N];
        
        permutation(0, 0, 0);
        System.out.println(answer);
    }
    
    public static void permutation(int pos,int before, int total) {
    	//System.out.println(pos);
    	if(pos==N) {
    		//System.out.println("total: "+total);
    		answer=Math.max(answer, total);
    		return;
    	}
    	
    	for(int i=0;i<N;i++) {
    		if(check[i]) continue;
    		check[i]=true;
    		if(pos==0) {
        		permutation(pos+1,arr[i],0);
    		}else {
        		permutation(pos+1,arr[i],total+Math.abs(before-arr[i]));
    		}
    		check[i]=false;
    	}
    	
    }
}
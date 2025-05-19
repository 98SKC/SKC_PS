
import java.util.*;
import java.io.*;

public class Main{

	public static int N,L,R,X;
	public static int[] arr;
	public static int answer=0;

	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        
        int left=0;
        int right=2;
        arr=new int[N];
        
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }


        
        //0 1 2 3
        //0 1 3 6
       // System.out.println("문제 개수: "+N+" 난이도 최소: "+L+" 난이도 최대: "+R+" 양극단 차이: "+X);
        
        comb(Integer.MAX_VALUE,0,0,0,0);
        
        System.out.println(answer);
        
        
        
        
    }
    public static void comb(int min, int max, int sum, int pos, int cnt) {
    	if(sum>R) return;
    	
    	if(pos==N){
    		if(max-min>=X&&cnt>=2&&sum>=L) {
    		//	System.out.println("sum: "+sum+" min: "+min+" max: "+max+" cnt: "+cnt);
    			answer++;
    		}
    		return;
    	}
    	//지금 문제를 포함
    	comb(Math.min(min, arr[pos]),Math.max(max, arr[pos])  , sum+arr[pos] ,pos+1,cnt+1);
    	
    	
    	//지금 문제를 포함하지 않음
    	comb(min,max,sum,pos+1,cnt);
    	
    	
    }
}

import java.util.*;
import java.io.*;

public class Main {

	static int[] lis,reversLis,arr;
	static int[] bitonic;
	static int point;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr=new int[N];
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        

        bitonic=new int[N];
        lis=new int[N];
        reversLis=new int[N]; 
        lis[0]=1;
        reversLis[N-1]=1;
        
        for(int i=0;i<N;i++) {
        	lis[i]=1;
        	for(int j=0;j<i;j++) {
        		if(arr[i]>arr[j]) {
        			lis[i]=Math.max(lis[i], lis[j]+1);
        		}
        	}
        	bitonic[i]+=lis[i];
        }
        
        for(int i=N-1;i>=0;i--) {
        	reversLis[i]=1;
        	for(int j=N-1;i<j;j--) {
        		if(arr[i]>arr[j]) {
        			reversLis[i]=Math.max(reversLis[i], reversLis[j]+1);
        		}
        	}
        	bitonic[i]+=reversLis[i];
        }
        int answer=0;
        for(int i=0;i<N;i++) {
        	answer=Math.max(bitonic[i], answer);
        }
        System.out.println(answer-1);// arr[i]가 중복. 제거
        
    }
}
import java.util.*;
import java.io.*;

public class Main {
	
	static int[] arr;
	static boolean[] v;
	static int N,M;
	static int[] answer;
	static List<int[]> list=new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        st=new StringTokenizer(br.readLine());
        arr=new int[N];
        v=new boolean[N];
        answer=new int[M];
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        comb(0);
        for(int[] a:list) {
        	for(int b:a) {
        		sb.append(b+" ");
        	}
        	sb.append("\n");
       }
        System.out.println(sb);
        
    }
    
    static void comb(int cnt) {
    	if(cnt==M) {
    		list.add(Arrays.copyOf(answer, cnt));
    		return;
    	}
    	
    	for(int i=0;i<N;i++) {
    		if(!v[i]) {
    			v[i]=true;
    			answer[cnt]=arr[i];
    			comb(cnt+1);
    			v[i]=false;
    			
    		}
    	}
    }
}
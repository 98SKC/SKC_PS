import java.util.*;
import java.io.*;

public class Main {

	static int N,M;
	static int[] arr,answer;
	static HashSet<int[]> set;
	static List<int[]> list=new ArrayList<>();
	static boolean[] v;
	static int[] before;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        answer=new int[M];
        v=new boolean[N];
       

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        permute(0);
        //permute2(0);
        
        for(int[] a:list) {
        	for(int b:a) {
        		sb.append(b+" ");
        	}
        	sb.append("\n");
       }
        System.out.println(sb);
    }
    
    static void permute(int cnt) {

    	if(cnt==M) {

    		list.add(Arrays.copyOf(answer, cnt));
    		return;
    	}
    	
    	int before=0;
    	for(int i=0;i<N;i++) {

    		if(!v[i]&&before!=arr[i]) {
    			v[i]=true;
    			answer[cnt]=arr[i];
    			before=arr[i];
    			permute(cnt+1);
    			v[i]=false;
    		}
    	}
    	
    }
    
    static void permute2(int cnt) {
    	if(cnt==N) {
    		if(!list.contains(Arrays.copyOf(answer, cnt))) {
    			list.add(Arrays.copyOf(answer, cnt));
    		}
    		return;
    	}
    	
    	for(int i=0;i<N;i++) {

    		if(!v[i]) {
    			v[i]=true;
    			answer[cnt]=arr[i];
    			permute(cnt+1);
    			v[i]=false;
    		}
    	}
    }
    
}
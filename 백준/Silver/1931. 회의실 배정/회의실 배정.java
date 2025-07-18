import java.io.*;
import java.util.*;

public class Main {

	
	static int N;
	static int[][] arr;
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N=Integer.parseInt(br.readLine());
    	arr=new int[N][2];
    	int answer=1;
    	int beforeEnd;
    	
    	for(int i=0;i<N;i++) {
    		st=new StringTokenizer(br.readLine());
    		arr[i][0]=Integer.parseInt(st.nextToken());
    		arr[i][1]=Integer.parseInt(st.nextToken());
    	}
    	
    	
    	Arrays.sort(arr, new Comparator<int[]>() {
    		@Override
    		public int compare(int[] o1, int[]o2) {
    			if(o1[1]==o2[1]) {
    				return o1[0] - o2[0];
    			}
    			return o1[1] - o2[1];
    		}
    	});

//    	for(int[] a:arr) {
//    		System.out.println(Arrays.toString(a));
//    	}
    	
    	
    	beforeEnd=arr[0][1];
    	for(int i=1;i<N;i++) {
    		if(beforeEnd<=arr[i][0]) {
    			beforeEnd=arr[i][1];
    			answer++;
    		}
    	}
    	
    	System.out.println(answer);
    }
}
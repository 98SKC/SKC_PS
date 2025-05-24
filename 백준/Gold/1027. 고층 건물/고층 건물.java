
import java.util.*;
import java.io.*;

public class Main {
	

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        int[] arr=new int[N];
       
        int[] left=new int[N];
        int[] right=new int[N];
        int[] save=new int[N];
        int l,r;
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }

        int max=0;
        float before;
        
        float inclination=Float.MIN_VALUE;
        for(int i=0;i<N;i++) {
        	//오른쪽 확인
        	
        	// 오른쪽
        	before = Float.NEGATIVE_INFINITY;
        	for(int j = i+1; j < N; j++){
        	    float slope = (float)(arr[j] - arr[i]) / (j - i);
        	    if (slope > before) {
        	        right[i]++;
        	        before = slope;
        	    }
        	}

        	// 왼쪽
        	before = Float.POSITIVE_INFINITY;
        	for(int j = i-1; j >= 0; j--){
        	    float slope = (float)(arr[j] - arr[i]) / (j - i);
        	    if (slope < before) {
        	        left[i]++;
        	        before = slope;
        	    }
        	}

        	max=Math.max(max, left[i]+right[i]);

        	save[i]=left[i]+right[i];
        	
        }
       // System.out.println(Arrays.toString(right));
       // System.out.println(Arrays.toString(left));
       // System.out.println(Arrays.toString(save));
        System.out.println(max);
        // v든
        // ^든
        // 선분 사이에 접점도 안됨
        
        // i에서 시작하는 최장 증가 부분 수열과 i에서 시작하는 최장 감소 부분 수열 둘다 구해얗 하나?
        // 그것도 좌 우로?
        
        
        
    }
}

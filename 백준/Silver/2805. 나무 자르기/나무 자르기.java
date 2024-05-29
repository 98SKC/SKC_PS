import java.util.*;
import java.io.*;

public class Main {


	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //높이를 높여 갈 수록, 가져갈 수 있는 나무의 총 량은 최소.
        //높이가 낮아질 수록 가져갈 수 있는 나무 량은 증가한다.
        int answer=0;
        int max=0,min=0;
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr=new int[N];
        int mid;
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        	max=Math.max(max, arr[i]);
        }
        long sub;
        while(min<=max) {

        	mid = (max + min) / 2;
        	sub=0;
        	for(int a:arr) {
            	sub+=Math.max(0,a-mid);

            }
        	if(sub<M) {//가져가야 하는 나무보다 적으면 왼쪽
        		max=mid-1;
        	}else{// 같거나 높으면 오른쪽 
        		answer=mid;// 지금 위치보다 답이 더 낮으면 바꿈.
        		min=mid+1;

        	}
        }
        
        System.out.println(answer);

    }
}

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        st=new StringTokenizer(br.readLine());
        int[] arr=new int[N];
        int right=0;
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        	right+=arr[i];
        }
        int left=1;

        int count=0;
        int mid;
        while(left<=right) {
        	//System.out.println(""+right);
        	mid=left-(left-right)/2;
        	
        	int size=0;
        	count=1;
        	//System.out.println("mid: "+mid);
        	for(int i=0;i<N;i++) {
        		if(arr[i]>mid) {
        			count=M+1;
        			break;
        		}
            	if(size+arr[i]>mid) {
            		size=arr[i];
            		count++;
            	}else {
            		size+=arr[i];
            	}
            	//if(count>M) break;
            }
        	//System.out.println(count);
        	if(count>M){//크기를 늘린다
        		left=mid+1;
        	}else {//크기를 줄인다.
        		right=mid-1;
        	}
        }
        
        System.out.println(left);
        // 한 공간에, N(혹은 N보다 작은)개의 크기가 다른 뭐시깽이를 넣는다.
        // i와 j 강의를 넣을거면 i~j의 모든 강의를 넣어야 한다.
        
        //M개의 공간에 N개를 넣을건데, 공간 크기를 몇으로 해야 강의를 다 넣을 수 있는가.
        
        
    }
}

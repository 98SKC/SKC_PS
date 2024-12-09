import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        
        st=new StringTokenizer(br.readLine());
        int[] arr=new int[N+2];
        arr[0]=0;
        for(int i=1;i<=N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        arr[N+1]=L;
        Arrays.sort(arr);
        
        int left=1;
        int right=L-1;
        
        int result=0;
        int mid=0;
        int cnt=0;
        
        while(left<=right) {
        	mid=(left+right)/2;
        	cnt=0;
        	for(int i=1;i<N+2;i++) {
        		cnt+=(arr[i]-arr[i-1])/mid;// 지금 휴게소 없는 구간에 최소 mid 간격으로 휴게소가 있으려면 그 구간에 몇개를 설치해야하는가
        		
        		if((arr[i]-arr[i-1])%mid==0) {
        			cnt--;
        		} // 거리 5마다 휴게소 설치, 1~11을 확인하고 설치할 때 arr[i]-arr[i-1])/mid는 2지만, 가운데 하나만 설치하면 됨.
        	
        	}
        	
        	if(cnt>M) {
        		left=mid+1;// 휴게소를 적게 설치해도 가능하다-> 더 짧아도 된다.
        	}else {
        		right=mid-1;// 휴게소가 턱없이 부족하다 -> 없는 구간이 더 길어야 한다.
        		

                result=mid;
        	}
        	
        }
        
       // result=right;
        System.out.println(result);

    }
}
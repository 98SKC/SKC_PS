import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());
        int[] house=new int[N];
        for(int i=0;i<N;i++) {
        	house[i]=Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(house);
        
        int left=1;
        int right=house[N-1]-house[0]+1;
        int mid,count,locate,last;
        
        while(left<right) {
        	
        	mid=(right+left)/2;
        	
        	count=1;
        	last=house[0];
        	
        	for(int i=1;i<house.length;i++) {
//        		locate=house[i];
        		if(house[i]-last>=mid) {// mid가 최소 단위라고 하자. 
        			count++;
        			last=house[i];
        		}        		

        	}
        	
        	if(count<C) {// 거리를 더 줄여야함.
        		right=mid;
        	}else{
        		left=mid+1;
        	}
        	
        	
        }
        System.out.println(left-1);
       
    }
}
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());//전체 길이
        int M=Integer.parseInt(st.nextToken());//심판이 있을 수
        int K=Integer.parseInt(st.nextToken());//심판이 있을 수 있는 위치

        int[] arr=new int[K];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
        int left=Integer.MAX_VALUE;
        for(int i=1;i<K;i++) {
        	left=Math.min(arr[i]-arr[i-1], left);
        }
        int right=arr[K-1]-arr[0];
        int mid;
        int before=0;
        int count=0;
        boolean check;
        while(left<=right) {
        	mid=left+(right-left)/2;
        	//System.out.println("mid: "+mid);
        	check=false;
        	
        	count=1;// 첫자리에 심판.
        	before=0;
        	//System.out.println(0+"에 심판");
        	//mid가 가장 가까운 거리이기 위해서는 모든 길이가 mid보다 길어지면 심판을 세운다
        	//이렇게 새었을 때 여유가 있으면 더 짧게. 여유가 있다는 것은 심판을 k보다 더(이상) 세울 수 있을 경우
        	//반대로 k보다 적게 세워진다면 더 짧은 범위를 탐색
        	//System.out.println("before 초기설정: "+before);
        	for(int i=1;i<K;i++){
        		if(count>M) {
        			break;
        		}
        		if(arr[i]-arr[before]>=mid) {
        			//System.out.println(before+" 다음 "+i+"에 심판");
        			count++;
        			before=i;
        			//System.out.println("before는: "+before);
        		}
        	}
        	
    		if(count>=M) {
    			//System.out.println("들어왔다고?");
    			check=true;
    		}
    		
        	if(check) {// 더 넓혀야 한다.
        		//System.out.println("늘린다 "+(count)+" "+(M));
        		left=mid+1;
        	}else {
        		//System.out.println("줄인다 "+(count)+" "+(M));
        		right=mid-1;
        	}
        	
        	//System.out.println("count: "+count);
        	//System.out.println("---------------");
        }
        
        
        count=0;
    	before=0;
    	StringBuilder sb=new StringBuilder();
    	//System.out.println("최소거리: "+left+" "+right);
    	sb.append("1");
    	
    	for(int i=1;i<K;i++){
    		if(arr[i]-arr[before]>=right&&count<M-1) {
    			count++;
    			before=i;
    			sb.append("1");
    		}else {
    			sb.append("0");
    		}
    	}
        System.out.println(sb); 
        
    }
}
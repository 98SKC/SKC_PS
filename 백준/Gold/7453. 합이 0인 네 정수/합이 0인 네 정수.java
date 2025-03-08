
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] arr=new int[N][4];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
            arr[i][2]=Integer.parseInt(st.nextToken());
            arr[i][3]=Integer.parseInt(st.nextToken());
            
        }
        int len=N*N;
        int[] sumA=new int[len];
        int[] sumB=new int[len];
        int point=0;
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
            	sumA[point++]=arr[i][0]+arr[j][1];
            }
        }
        
        point=0;
    
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
            	sumB[point++]=arr[i][2]+arr[j][3];
            }
        }
        Arrays.sort(sumA);
        Arrays.sort(sumB);
        
        int left;
        int right;
        int mid;
        long answer=0;
        int leftPoint=0;
        int rightPoint=0;
        int target;
        for(int i=0;i<len;i++) {
        	leftPoint=0;
        	rightPoint=0;
        	left=0;
        	right=len-1;
        	
        	//(-1)*sumA[i]인 왼쪽 끝을 찾는다.   lower
        	target=-sumA[i];
        	while(left<=right) {
        		mid=left+(right-left)/2;
        		
        		if(sumB[mid]>=target) {
        			right=mid-1;
        		}else{
        			left=mid+1;
        		}
        		
        	}
        	
        	leftPoint=right;
        	left=0;
        	right=len-1;
        	//(-1)*sumA[i]인 오른쪽 끝을 찾는다.  upper
        	while(left<=right) {
        		mid=left+(right-left)/2;
        		
        		if(sumB[mid]>target) {
        			right=mid-1;
        		}else{
        			left=mid+1;
        		}
        		
        	}
        	rightPoint=right;
        	answer+=(long) rightPoint-leftPoint;
        	//System.out.println(rightPoint+" "+leftPoint);
        }
        System.out.println(answer);
    }
}

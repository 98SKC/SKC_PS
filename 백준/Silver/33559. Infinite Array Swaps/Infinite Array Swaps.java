
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        

        int[] arr=new int[N];
        int[] arr2=new int[N];
        
        StringTokenizer st=new StringTokenizer(br.readLine());        
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr2[i]=Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        Arrays.sort(arr2);
        
        int left=0;
        int right,mid,sub;
        int count=0;
        
        for(int i=0;i<N;i++) {
        	if(left>=N) break;
        	right=N-1;
        	//System.out.println(i+" "+left+" "+right);
        	while(left<right) {
        		//System.out.println(left+" "+right);
        		mid=left+(right-left)/2;
        		if(arr[i]>arr2[mid]){//더 큰 arr[mid]를 찾아야한다
        			left=mid+1;
        		}else {
        			right=mid;
        		}
        		
        	}
        	//System.out.println(i+" "+count+" "+left+" "+right);
        	//System.out.println();

        	if(arr[i]==arr2[left]){
        		count++;
        		if(i<left){
        			//System.out.println(i+"에서 arr2를 바꿈");
            		sub=arr2[i];
                	arr2[i]=arr2[left];
                	arr2[left]=sub;
        		}else if(i>left) {
        			//System.out.println(i+"에서 arr를 바꿈");
        			sub=arr[left];
                	arr[left]=arr[i];
                	arr[i]=sub;
        		}
        		left++;
        	}
        	
        }
        StringBuilder sb=new StringBuilder();
        sb.append(count+"\n");
        for(int i=0;i<arr.length;i++) {
            sb.append(arr[i]);
            if(i!=arr.length-1) {
                sb.append(" ");
            }
        }
        sb.append("\n");
        for(int i=0;i<arr2.length;i++) {
            sb.append(arr2[i]);
            if(i!=arr2.length-1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}

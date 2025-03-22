
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int[] arr=new int[N];
        
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        //인덱스가 작을수록 큰 숫자가 오는게 좋음
        //교환은 인접 배열끼리. 횟수는 최대 s회. s회를 진행하면서 가장 정렬이 진행된 상태?
        int S=Integer.parseInt(br.readLine());
        
        int tmp;
        int count=0;

        int start;
        int loop=0;
        int max=0;
        int index=-1;
        while(count<S&&loop<N) {
        	
        	start=Math.min(N-1,loop+S);

        	max=0;
        	index=-1;
        	for(int i=start;i>=loop;i--){
        		if(arr[i]>max){
        			max=arr[i];
        			index=i;
        		}
            }
       	
        	start=index;
        	//System.out.println("시작: "+start+" max: "+max); 
        	for(int i=start;i>0;i--){
        		if(arr[i]>arr[i-1]){
        			tmp=arr[i];
        			arr[i]=arr[i-1];
        			arr[i-1]=tmp;
        			S--;
        			if(S==0) break;
        		}
            }
        	loop++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++) {
        	sb.append(arr[i]+" ");
        }
        System.out.println(sb);
        
        
    }
}

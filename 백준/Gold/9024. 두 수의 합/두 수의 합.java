
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        int S,K;
        int[] arr;
        for(int t=1;t<=T;t++) {
        	st=new StringTokenizer(br.readLine());
        	
        	S=Integer.parseInt(st.nextToken());
        	K=Integer.parseInt(st.nextToken());
        	arr=new int[S];
        	
        	st=new StringTokenizer(br.readLine());
        	
        	for(int i=0;i<S;i++) {
        		arr[i]=Integer.parseInt(st.nextToken());
        	}
        	
        	Arrays.sort(arr);
        	int answer=0;
        	int left=0;
        	int right=S-1;
        	int sum;
        	int min=Integer.MAX_VALUE;
        	int dis;
        	while(left<right) {
        		sum=arr[left]+arr[right];
        		dis=Math.abs(sum-K);
        		if(min>=dis) {
        			if(min>dis) answer=0;// 아래에서 1추가 될 예정
        			min=dis;
        			answer++;
        		}
        		if(sum>=K) right--;
        		else left++;
        	}
        	sb.append(answer+"\n");
        	
        }
        System.out.println(sb);
        //서로 다른 정수집합 S와 또 다른 정수 K가 주어질 때, S의 서로다른 주 정수합이 k에 가장 가까운 정수
        
    }
}

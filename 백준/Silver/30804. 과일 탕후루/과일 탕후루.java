import java.util.*;
import java.io.*;

public class Main {

	
	static int[] arr;// 0은 개수, 1은 0~i까지 과일 종류 수. 앞뒤에서 늘어나면 거기서 추가되는 부분
	static int[] num=new int[10];
	static int max=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr=new int[N];
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        int left=0;
        int right=0;
        int type=1;
        num[arr[0]]++;

        while(right<N) {

        	if(type>2) {// 왼쪽을 증가 시킨다.
        		if(--num[arr[left]]==0) {
        			type--;
        		}
        		left++;
        	}else {//오른쪽을 증가시킨다.
        		//지금까지 위치가 최대인지 갱신
        		
        		max=Math.max(max, right-left+1);
            	//오른쪽을 확장함
            	right++;
            	//확장 후 타입 개수를 확인, 그 전에 배열 끝인지부터 확인
            	if(right==N) break;
            	if(++num[arr[right]]==1) {
            		type++;
            	}
        	}
        	

        }
        
        System.out.println(max);
     }
    

}
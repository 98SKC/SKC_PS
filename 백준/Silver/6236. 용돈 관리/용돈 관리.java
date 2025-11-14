
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        //N일간 사용할 금액을 계산
        //M번만 통장에서 돈을 빼서 사용
        //통장에서 뺀 돈으로 하루를 보낼 수 있으면 그대로 사용하고,
        //모자라게 되면 남은 금액은 통장에 집어넣고 다시 K원을 인출한다.
        //정확히 M번을 맞춰야 하기에, 수중에 돈이 많아도 다시 통장에 넣고 K원을 뽑을 수 있다.
        
        //N과 M, 매일 써야하는 돈이 고정일 때 K의 최소를 구하라
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        int[] days=new int[N+1];

        
        int left=0;
        int right=0;
        
        //i일에 써야하는 금액
        for(int i=1;i<=N;i++) {
        	days[i]=Integer.parseInt(br.readLine());
        	left=Math.max(left, days[i]);// 최소 하루에 써야하는 금액보다는 더 많이 뽑아야 한다.
        	right+=days[i];//
        }

        int mid;
        
        int cnt;
        int money;
        while(left<right){
        	cnt=0;
        	money=0;
        	mid=left+(right-left)/2;
        	
            for(int i=1;i<=N;i++) {
            	if(money<days[i]) {
            		cnt++;
            		money=mid;
            	}
            	money-=days[i];
            }
        	
        	
        	if(cnt>M){ //인출 횟수가 많음. k를 키워야함
        		left=mid+1;
        	}else{//
        		right=mid-1;
        	}
        }
        
        System.out.println(left);
        
    }
        
}




import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int max=0;
        int min=Integer.MAX_VALUE;
        //한번의 연산에서 이루어지는 것
        //수의 각 자리 숫자 중 홀수의 개수를 종이에 적는다!
        // 수가 한자리면 끝, 두자리면 둘로 나누어 더한다. 셋 이상이면 세개 이상으로 나누어 합한다.
        
        //연산이 종료된 순간에 종이에 적힌 수들을 모두 더한다
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.add(new int[] {N,0});
        int[] sub;
        int sum;
        ArrayList<Integer> next;
        while(!q.isEmpty()) {

        	sub=q.poll();
        	sum=sub[1]+getOdd(sub[0]);
        	if(sub[0]<10) {
        		max=Math.max(sum, max);
        		min=Math.min(sum, min);
        		continue;
        	}else if(sub[0]>=10&&sub[0]<100){
        		q.add(new int[] {(sub[0]/10+sub[0]%10),sum});
        	}else {
        		//가능한 조합을 모두 큐에 넣는다.
        		next=comb(sub[0]);
        		//System.out.println(next.toString());
        		for(int n:next) {
        			q.add(new int[] {n,sum});
        		}
        	}
        }
        System.out.println(min+" "+max);
    }
    
    public static int getOdd(int n) {
    	
    	int answer=0;
    	
    	while(n>0){
    		
    		if(n%2==1){//끝자리가 홀수면 나머지가 1.
    			answer++;
    		}
    		//끝자리만 제거.
    		n/=10;
    	}
    	
    	return answer;
    }
    // 1 2 3 4 5 6 7 8 9 
    public static ArrayList<Integer> comb(int n){
    	//n을 3개로 나누는 경우의 수. (n-1)에서 3의 조합. 
    	String sub=Integer.toString(n);
    	int len=sub.length();
    	int one, two,three;
    	
    	ArrayList<Integer> answer=new ArrayList<>();
    	//0~i전까지, i부터 j전까지, 그 이후
    	for(int i=1;i<len-1;i++) {
    		for(int j=i+1;j<len;j++) {
    			one=Integer.parseInt(sub.substring(0, i));//0~i 전까지
    			two=Integer.parseInt(sub.substring(i, j));//i~j 전까지
    			three=Integer.parseInt(sub.substring(j, sub.length()));// j부터 문자열 끝까지
    			answer.add(one+two+three);
    		}
    	}
    	return answer;
    }
}


import java.util.*;
import java.io.*;

public class Main {
	
	
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //양의 정수를 고르고, 각 자리수의 제곱의 합을 구한다. 이를 반복한다.
        //58다음부터 같은 구간이 반복적으로 나오는 경우가 있다.
        //두 숫자가 주어졌을 때, 같은 수가 나올 떄 까지 필요한 수열의 길이의 합의 최솟값을 구하시오
        //
        int A,B;
        StringBuilder sb=new StringBuilder();
        while(true) {
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	A=Integer.parseInt(st.nextToken());
        	B=Integer.parseInt(st.nextToken());
        	if(A==0&&B==0) break;
        	sb.append(A+" "+B+" ");
        	sb.append(search(A,B));
        	sb.append("\n");
        	
        }
        
        System.out.println(sb);
    }
    
    // 자리수 제곱합
    private static int nextSum(int x) {
        int s=0;
        while(x>0){
            int d=x%10;
            s+=d*d;
            x/=10;
        }
        
        return s;
    }
    
    //A,B가 같은 숫자가 나오기까지 최소 합
    public static int search(int A, int B) {
    	int result=Integer.MAX_VALUE;
    	HashMap<Integer,Integer> map=new HashMap<>();
        int v=A;
        int idx=1;
        while(!map.containsKey(v)) {
        	map.put(v, idx++);
            v=nextSum(v);
        }

        
        HashSet<Integer> set=new HashSet<>();
        v=B; 
        idx=1;
        while(!set.contains(v)) {
        	set.add(v);
            if (map.containsKey(v)) {
                result=Math.min(result,map.get(v)+idx);
                
            }
            
            v=nextSum(v);
            idx++;
        }
        
        if(result==Integer.MAX_VALUE) result=0;
        return result;

    	
    }

}



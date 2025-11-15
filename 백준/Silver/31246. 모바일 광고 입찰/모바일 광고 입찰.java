
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //중요한 광고 N개에 대한 입찰 데이터를 분석하여 입찰 가격을 결정한다.
        //광고 i에 대해 우리가 제시한 가격 Ai 와 우리를 제외한 다른 가격 중 최고가격 Bi가 주어진다.
        //모든 입찰가를 일괄적으로 x만큼 올릴 때, k개 이상의 광고를 낙찰받게 되는 음이 아닌 정수 X를 찾고자 한다.
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        
        int A,B;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	A=Integer.parseInt(st.nextToken());
        	B=Integer.parseInt(st.nextToken());//A-B(C)가 음수면 |C|만큼 돈을 더 내야한다.
        	if(A-B>=0) K--;
        	else list.add(A-B); // 돈을 더 내야하는 금액들만 들어올 것.
        }
        
        Collections.sort(list,Collections.reverseOrder());
        
       // System.out.println("K: "+K+" "+list.get(K-1));
        int answer=K<=0 ? 0 : Math.abs(list.get(K-1));
        
        System.out.println(answer);
        
        
    }
        
}



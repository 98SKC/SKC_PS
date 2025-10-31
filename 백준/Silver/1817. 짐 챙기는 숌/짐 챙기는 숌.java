import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        //책을 택배로 보내는데,
        //차곡차곡 쌓여있어 차례대로 박스에 넣을 수 있다.
        //책에는 무게가 있는데, 박스 한도가 있다.
        
        //필요한 박스의 개수의 최솟값을 구해야한다. 
        
        //브루드포스로 가능해보임 일단.
        
        int answer=1;
        if(N==0) {
        	System.out.println(0);
        	return;
        }
        st = new StringTokenizer(br.readLine());
        
        Integer[] arr=new Integer[N];//책의 개수만큼이 최대일 것
        int w;
        int p=0;
        boolean find;
        for(int i=0;i<N;i++) {
        	w=Integer.parseInt(st.nextToken());
        	if(p+w>M) {
        		answer++;
        		p=w;
        	}else {
        		p+=w;
        	}
        	
        }
        
        System.out.println(answer);
        
    }

}

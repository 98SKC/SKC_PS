
import java.util.*;
import java.io.*;

public class Main {


	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());//풍선 개수
        
        //int[] balloon=new int[N];
        
     
        StringTokenizer st=new StringTokenizer(br.readLine());
        int max=1000000;
        int[] arrows=new int[max+2];
        int balloon;
        int answer=0;
        for(int i=0;i<N;i++) {
        	balloon=Integer.parseInt(st.nextToken());//이번 풍선의 높이
        	if(arrows[balloon]>0) {//이 풍선 높이의 화살이 남아 있다면 그걸로 맞춤
        		arrows[balloon]--;
        	}else {
        		answer++;//없다면 새로 사격
        	}
        	
        	arrows[balloon-1]++;// 이 풍선을 맞춘 화살을 그 아래쪽으로 이동
        	
        }
              System.out.println(answer);
        
        
      
    }
}

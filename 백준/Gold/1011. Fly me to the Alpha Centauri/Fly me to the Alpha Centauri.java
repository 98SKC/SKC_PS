import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
    	int T=Integer.parseInt(br.readLine());// 테스트 케이스
    	
    	StringTokenizer st;
    	int x,y;
    	StringBuilder sb=new StringBuilder();

    	
    	for(int t=1;t<=T;t++) {
    		st=new StringTokenizer(br.readLine());
    		x=Integer.parseInt(st.nextToken());
    		y=Integer.parseInt(st.nextToken());
    		
            int dist =y-x;
            int s = (int)Math.sqrt(dist);
            

            if(dist == s * s){
                sb.append(2*s - 1).append("\n") ;
            }else if (dist <= s*s + s ){
                sb.append(2*s).append("\n") ;
            }else {
                sb.append(2*s + 1).append("\n") ;
            }

    	}
    	
    	System.out.println(sb);
    	
    }

}
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        int N=Integer.parseInt(br.readLine());
        int sub;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	sub=Integer.parseInt(st.nextToken());
        	if(sub==0) {
        		if(pq.isEmpty()) sb.append(-1+"\n");
        		else sb.append(pq.poll()+"\n");
        	}else {
        		for(int a=0;a<sub;a++) {
        			pq.add(Integer.parseInt(st.nextToken()));
        		}
        	}
        }
        
  
        System.out.println(sb);
    }
}
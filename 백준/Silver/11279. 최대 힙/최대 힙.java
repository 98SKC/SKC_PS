import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        long sub;
        StringBuilder sb=new StringBuilder();
        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<N;i++) {
        	sub=Long.parseLong(br.readLine());
        	if(sub==0) {
        		if(!pq.isEmpty()) {
        			sb.append(pq.poll()+"\n");
        		}else {
        			sb.append(0+"\n");
        		}
        		continue;
        	}
        	pq.add(sub);
        	
        }
        System.out.println(sb);
    }
}
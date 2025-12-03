import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        
        int N, sub;
        
        //maxHeap은 작은값들을 저장할 힙. 작은값중에서 큰값을 먼저 peek하도록.
        //minHeap은 큰값들을 저장. 큰값중에서 작은값을 먼저 peek한다.
        PriorityQueue<Integer> maxHeap;//클값 먼저
        PriorityQueue<Integer> minHeap;//작은값 먼저
        
        for(int test_case=1;test_case<=T;test_case++) {
        	
        	N=Integer.parseInt(br.readLine());
        	int M=N/10;
        	int remain = N % 10;  
        
            sb.append((N+1)/2).append("\n"); // 출력해야 하는 중앙값 수
            
            maxHeap=new PriorityQueue<>(Collections.reverseOrder());//클값 먼저
            minHeap=new PriorityQueue<>();//작은값 먼저
            
            int cnt = 0; 
            int printed = 0; // 출력한 중앙값 개수
            
            for(int k=0;k<M;k++) {
            	st = new StringTokenizer(br.readLine());
            	
            	for(int i=0;i<10;i++){
            		sub=Integer.parseInt(st.nextToken());
            		cnt++; 
            		
            		maxHeap.offer(sub);
            		
            		if(!minHeap.isEmpty()&&maxHeap.peek()>minHeap.peek()) {
            			minHeap.offer(maxHeap.poll());
            		}
            		
            	    if (maxHeap.size() > minHeap.size() + 1) {
            	        minHeap.offer(maxHeap.poll());
            	    } else if (maxHeap.size() < minHeap.size()) {
            	        maxHeap.offer(minHeap.poll());
            	    }
            	    
            	
            	    if(cnt % 2 == 1) {
            	        sb.append(maxHeap.peek()).append(" ");
            	        printed++;
            	        if(printed % 10 == 0) sb.append("\n");
            	    }
            	}  
            }
        	
        	// 남은 입력 처리 -> 아니 이게 왜 컴파일 오류야 무슨 테케에서 대체
        	//if(remain > 0) st = new StringTokenizer(br.readLine()); 
        	if(remain > 0) {
        	    st = new StringTokenizer(br.readLine());
        	} else {
        	    st = new StringTokenizer(""); // 빈 토크나이저라도 할당
        	}
        	
        
        	for(int i=0;i<remain;i++){
        		sub=Integer.parseInt(st.nextToken());
        		cnt++; 
        		
        		maxHeap.offer(sub);
        		
        		if(!minHeap.isEmpty()&&maxHeap.peek()>minHeap.peek()) {
        			minHeap.offer(maxHeap.poll());
        		}
        		
        	    if (maxHeap.size() > minHeap.size() + 1) {
        	        minHeap.offer(maxHeap.poll());
        	    } else if (maxHeap.size() < minHeap.size()) {
        	        maxHeap.offer(minHeap.poll());
        	    }
        	    
        	    
        	    if(cnt % 2 == 1) {
        	        sb.append(maxHeap.peek()).append(" ");
        	        printed++;
        	        if(printed % 10 == 0) sb.append("\n");
        	    }
        	}
        	
        	sb.append("\n"); // 테스트케이스 간 줄 구분
        }
        
        System.out.println(sb);
    }
}

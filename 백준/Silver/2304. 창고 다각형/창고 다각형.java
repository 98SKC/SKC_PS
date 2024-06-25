import java.util.*;
import java.io.*;


public class Main {

	
    public static void main(String[] args) throws Exception {
    
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int N=Integer.parseInt(br.readLine());
    	StringTokenizer st;
    
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        	
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]); // 인덱스 1의 값을 기준으로 내림차순 정렬
            }
        });
    	
    	int a,b;
    	

    	for(int i=0;i<N;i++) {
    		st=st=new StringTokenizer(br.readLine());
    		a=Integer.parseInt(st.nextToken());
    		b=Integer.parseInt(st.nextToken());  		
    		
    		pq.add(new int[] {a,b});
    		
    		
    		
    	}
    	
    	int[] start=pq.poll();
    	int answer=start[1];// 가장 큰 높이 넓이
    	int[] left=new int[] {start[0],start[1]};
    	int[] right=new int[] {start[0],start[1]};
    	int[] leftEnd=new int[] {start[0],start[1]};
    	int[] rightEnd=new int[] {start[0],start[1]};
    	
    	int[] point;
    	
    	while(!pq.isEmpty()) {
    		point=pq.poll();
    		if(point[0]<leftEnd[0]&&point[0]<left[0]) {// 가장 높은 곳 보다 왼쪽, 지금 제일 왼쪽보다 왼쪽
    			if(point[1]<leftEnd[1]) {// 지금 왼쪽보다 높이가 낮음
    				if(left[0]!=leftEnd[0]) {
    		    		answer+=(left[0]-leftEnd[0])*left[1];
    		    		left=leftEnd;
    		    	}
    				
    				answer+=(left[0]-point[0])*point[1];  				
    				//System.out.println("L "+left[0]+"부터 "+point[0]+"까지 높이"+point[1]+"을 곱해서 "+((left[0]-point[0])*point[1]));
    				left=new int[] {point[0],point[1]};
    				leftEnd=new int[] {point[0],point[1]};
    			}else if(point[1]==left[1]) {// 높이는 같은데, 더 왼쪽
    				//System.out.println("L "+left[0]+"부터 "+point[0]+"까지 높이"+point[1]+"가 같음 leftEnd[0] "+leftEnd[0]+"가"+point[0]+"로 바뀜");
    				
    				leftEnd=new int[] {point[0],point[1]};
    			}
    		}else if(point[0]>rightEnd[0]&&point[0]>right[0]) {// 가장 높은 곳 보다 오른쪽, 지금 제일 오른쪽 보다 오른쪽
    			if(point[1]<rightEnd[1]) {// 지금 왼쪽보다 높이가 낮음
    				if(right[0]!=rightEnd[0]) {
    		    		answer+=(rightEnd[0]-right[0])*right[1];
    		    		right=rightEnd;
    		    	}
    				
    				answer+=(point[0]-right[0])*point[1];  				
    				//System.out.println("R "+right[0]+"부터 "+point[0]+"까지 높이"+point[1]+"을 곱해서 "+((point[0]-right[0])*point[1]));
    				right=new int[] {point[0],point[1]};
    				rightEnd=new int[] {point[0],point[1]};
    			}else if(point[1]==right[1]) {
    				//System.out.println("R "+right[0]+"부터 "+point[0]+"까지 높이"+point[1]+"가 같음 rightEnd[0]"+rightEnd[0]+"가"+point[0]+"로 바뀜");
    				rightEnd=new int[] {point[0],point[1]};
    			}
    		}
    	}
    	
    	if(left[0]!=leftEnd[0]) {
    		answer+=(left[0]-leftEnd[0])*left[1];
    	}
    	if(right[0]!=rightEnd[0]) {
    		answer+=(rightEnd[0]-right[0])*right[1];
    	}
    	
    	System.out.println(answer);

    }
    
    
    
   
}
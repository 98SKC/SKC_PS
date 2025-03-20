
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
       
        int start,end;
        int beforeEnd=0;
        int answer=0;
        int sum=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	
        	@Override
        	public int compare(int[] o1,int[] o2) {
        		
        		return o1[0]-o2[0];
        	}
        });
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	start=Integer.parseInt(st.nextToken());
        	end=Integer.parseInt(st.nextToken());
        	pq.add(new int[] {start,end});
        	
        	
        }
        int[] sub;
        while(!pq.isEmpty()) {
        	sub=pq.poll();
        	start=sub[0];
        	end=sub[1];
        	
        	if(beforeEnd>=start) start=beforeEnd+1;
        	if(start>=end) continue;
        	//System.out.print(start+"부터 ");
        	sum=(end-start)/L;
        	if((end-start)%L>0) sum+=1;
        	
        	beforeEnd=start+(sum*L)-1;
        	//System.out.println(beforeEnd+"까지 "+sum+"개");
        	answer+=sum;
        }
        /*
         111222..333444555.... // 길이 3인 널빤지
		 .MMMMM..MMMM.MMMM.... // 웅덩이
		 012345678901234567890 // 좌표
         * */
        System.out.println(answer);
        
    }
}

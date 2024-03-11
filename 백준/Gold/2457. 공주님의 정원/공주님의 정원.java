import java.util.*;
import java.io.*;

public class Main {
	
	
	static class Node implements Comparable<Node>{
		public int start;
		public int end;
		
		Node(int start, int end) {
			this.start=start;
			this.end=end;
		}
		
		@Override
		public int compareTo(Node o) {
			if(start!=o.start) {
				return start-o.start;
			}else {
				return end-o.end;
			}
		}
		
	}
	

	static int N;
	static List<Node> list=new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int start;
        int end;
        N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            //'월' 과 '일'을 구분하는 방법
            start=Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken());
            end=Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken());
            list.add(new Node(start,end));
        }
        Collections.sort(list);
       
        int line=301;
        int max = 0,ans = 0;
        int index=0;
		while(line<1201) {
			boolean ch = false;
			for(int i=index; i<N; i++) {
				
				if(list.get(i).start > line) break;
				//start값이 max값보다 작은 것들 중 end의 값이 가장 큰것을 선택한다.
				//시작점이 지금 마지막보다 앞에 있는 것들중, 가장 늦게 죽는 놈이 선택.
				if(list.get(i).start <=line && max<list.get(i).end) {
					max = list.get(i).end;
					index = i+1;
					ch = true;
				}
			}
			if(ch) {				
				line= max;
				ans++;
			}else break;
		}
		
		if(max<1201) System.out.println(0);
		else System.out.println(ans);
        
        
        System.out.println();
    }
    
}
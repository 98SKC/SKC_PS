
import java.util.*;
import java.io.*;

public class Main{

	
	public static class Part{
		
		int number;
		int count;//이 부품이 지금 몇개 있는가.
		
		
		HashMap<Integer, Integer> subPart;// 하위 부품의 번호와 그의 개수
		public Part(int number, int count) {
			this.number=number;
			this.count=count;
			subPart=new HashMap<>();
		}
		
		public void setPart(int subNumber, int count) {
			subPart.put(subNumber, count);
		}
		
		public boolean isThisBasic(){
			if(subPart.isEmpty()) return true;
			return false;
		}
		
		
		
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //기본부품과, 기본보품을 조립하여 만든 중간 부품으로 장난감을 조립하려함
        
        //1~N-1까지 기본 부품, 중간 부품의 번호
        //N은 완제품 번호
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
      
        Part[] parts=new Part[N+1];
        
        for(int i=1;i<=N;i++) {
        	parts[i]=new Part(i,0);
        }
        
        int X,Y,Z;
        StringTokenizer st;
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	X=Integer.parseInt(st.nextToken());
        	Y=Integer.parseInt(st.nextToken());
        	Z=Integer.parseInt(st.nextToken());
        	parts[X].setPart(Y,Z);
        }
        
        ArrayDeque<int[]> q=new ArrayDeque<>();
        int size;
        
        int[] part;
        int p;   //p번호 파츠
        int cnt; //cnt를 만들려면, p만드는데 드는 부품을 cnt개
        
        q.add(new int[] {N,1});//N을 1개 만들기 위함
        HashMap<Integer, Integer> sub;
        while(!q.isEmpty()){
        	size=q.size();
        	sub=new HashMap<>();
        	for(int i=0;i<size;i++){
        		part=q.poll();
        		p=part[0];
        		cnt=part[1];
        		for(Integer key:parts[p].subPart.keySet()){
        			//key 부품이 parts[p].subPart.get(key)개 필요한데, 이게 cnt개 필요함
        			if(parts[key].isThisBasic()) {
        				parts[key].count+=parts[p].subPart.get(key)*cnt;
        			}else {
        				sub.put(key, sub.getOrDefault(key, 0)+parts[p].subPart.get(key)*cnt);
        			}
        		}
        		
        	}
    		for(Integer key:sub.keySet()){
    			q.add(new int[] {key,sub.get(key)});
    		}
        	
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=N;i++) {
        	if(parts[i].isThisBasic()) {
        		sb.append(i+" "+parts[i].count+"\n");
        	}
        }
        
        System.out.println(sb);
    }
        
}



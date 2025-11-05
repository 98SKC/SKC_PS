import java.io.*;
import java.util.*;

public class Main{
	
	public static int N,M,K,answer;
	public static int[] parent;
	public static int[] cost;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        answer=0;
        N=Integer.parseInt(st.nextToken()); //학생의 수
        M=Integer.parseInt(st.nextToken()); //친구 관계의 수
        K=Integer.parseInt(st.nextToken()); //가지고 있는 돈
        
        
        //N명의 학생이 입학
        //모두와 친구가 될거다.
        //친구비를 내서 친구를 구할거다
        //k원의 돈이 있을 때, 친구의 친구는 친구일 때, 가장 적은 비용으로
        //모두와 친구가 되어라
        
        //친구비가 간선의 가중치로 생각했는데, 지금 보니까
        //기존의 친구 그룹의 가장 싼 친구를 코스트로, 유니온 파인드 해야하는 문제 같다.
        st = new StringTokenizer(br.readLine());

        cost=new int[N+1];
        parent=new int[N+1];
        for(int i=1;i<=N;i++){
        	parent[i]=i;
        }
        for(int i=1;i<=N;i++){
        	cost[i]=Integer.parseInt(st.nextToken());
        }
        int a,b;
        for(int i=0;i<M;i++){
        	st = new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	
        	union(a,b);
        }
        HashSet<Integer> friend=new HashSet<>();
        //System.out.println(Arrays.toString(parent));
        for(int i=1;i<=N;i++) {
        	if(friend.contains(find(i))) {
        		continue;
        	}
        	friend.add(find(i));
        	//System.out.println("친구: "+i);
        	answer+=cost[find(i)];
        }
        
        if(answer>K) {
        	System.out.println("Oh no");
        	return;
        }
        
        System.out.println(answer);
        
        
    }
    
    
    public static int find(int a){
    	if(parent[a]==a) {
    		return a;
    	}
    	//여기서 부모 자식 압축 뿐 아니라, 코스트도 압축하고 싶은데,
    	
    	return parent[a]=find(parent[a]);
    }
    
    public static boolean union(int a, int b) {
    	int pa=find(a);
    	int pb=find(b);
    	
    	if(pa==pb) {
    		return false;
    	}
    	if(cost[pa]>cost[pb]){
    		parent[pa]=pb;
    	}else {
    		parent[pb]=pa;
    	}
    	
    	return true;
    	
    	
    }

}

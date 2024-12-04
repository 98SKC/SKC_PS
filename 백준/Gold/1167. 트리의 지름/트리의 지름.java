import java.util.*;
import java.io.*;

public class Main {

	public static int max=0;
//	public static int[] maxLen;
	public static boolean[] v;
	public static int V;
	public static ArrayList<int[]>[] list;
	public static int node;
	
	
	// 트리라서 사이클은 없음. 퍼질 수는 있는데, 퍼진게 다시 한점에서 뭉칠 수는 없다. 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        V=Integer.parseInt(br.readLine());
        StringTokenizer st;
        //int[][] tree=new int[V+1][V+1];
        list = new ArrayList[V + 1];
        
        
//        maxLen=new int[V+1];
        v=new boolean[V+1];
        
        int num;
        int end=0, len=0;
        for(int i=1;i<=V;i++) {
        	st=new StringTokenizer(br.readLine());
        	num=Integer.parseInt(st.nextToken());// 정점
        	list[num]=new ArrayList<int[]>();
        	while(true) {
        		end=Integer.parseInt(st.nextToken());// 끝점
            	if(end==-1) {
            		break;
            	}
            	len=Integer.parseInt(st.nextToken());// 거리
            	list[num].add(new int[] {end,len});
        	}
        }
        
    
        v=new boolean[V+1];
        dfs(1,0);
        //System.out.println("1차결과 max: "+max+" node: "+node);
        v=new boolean[V+1];
        dfs(node,0);
        //System.out.println("2차 결과max: "+max+" node: "+node);
        System.out.println(max);
        
    }
    // 가장 먼 거리의 정점과 거리를 구함. 처음에는 정점만, 두번째는 거리도
    public static void dfs(int point,int len) {
//    	System.out.println("dfs");
    	if(max<len) {
    		
    		max=len;
    		node=point;
    	//	System.out.println("max: "+max+" node: "+node);
    	}
    	
    	if(v[point]) return;
    	
    	v[point]=true;
    	
		for(int[] next:list[point]) {

			if(!v[next[0]]){
				dfs(next[0],len+next[1]);
		
			}
		}
    	
    	
    	return;
    }
}
import java.io.*;
import java.util.*;

public class Main {

	public static int N;
	public static int min=Integer.MAX_VALUE;
	public static int[] cost;
	public static String[] s;
	public static HashMap<Character,Integer> goal=new HashMap<>();
	public static HashMap<Character,Integer> state=new HashMap<>();
	
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str=br.readLine();
        for(int i=0;i<str.length();i++) {
        	goal.put(str.charAt(i), goal.getOrDefault(str.charAt(i), 0)+1);
        }
        
        N=Integer.parseInt(br.readLine());
        
        cost=new int[N];
        s=new String[N];
        StringTokenizer st;
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	cost[i]=Integer.parseInt(st.nextToken());
        	s[i]=st.nextToken();
        }
        dfs(0,0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

        
        
    }

    public static void dfs(int pos, int c) {
    	if (c >= min) return;
    	if(pos==N) {
    		
    		if(check()) {
    			//System.out.println("??? "+c);
    			min=Math.min(min, c);
    		} 
    		return;
    	}
    	
    	//지금 책을 선택할 경우
    	for(int i=0;i<s[pos].length();i++){
    		state.put(s[pos].charAt(i), state.getOrDefault(s[pos].charAt(i), 0)+1);
    	}
    	dfs(pos+1,c+cost[pos]);
    	//선택하지 않음
    	for (int i = 0; i < s[pos].length(); i++) {
    	    char ch = s[pos].charAt(i);
    	    int v = state.get(ch) - 1;
    	    if (v == 0) state.remove(ch);
    	    else state.put(ch, v);
    	}
    	
    	dfs(pos+1,c);
    	
    }
    
    public static boolean check(){
    	//System.out.println(goal.size());
    	for(char key:goal.keySet()) {
    		//System.out.println(!state.containsKey(key)||state.get(key)<goal.get(key));
    		if(!state.containsKey(key)||state.get(key)<goal.get(key)) return false;
    	
    	}
    	
    	return true;
    }
    
    
    
}

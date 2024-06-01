import java.util.*;
import java.io.*;

public class Main {

	static List<boolean[]> list=new ArrayList<boolean[]>();
	static int[] select=new int[3];
	static int Min;
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());
        int N;
        for(int test_case=1;test_case<=T;test_case++) {
        	list.clear();
        	N=Integer.parseInt(br.readLine());
        	String[] str=br.readLine().split(" ");
        	if(N>32) {
        		sb.append(0+"\n");
        		continue;
        	}
        	for(int i=0;i<N;i++) {
        		boolean[] sub=new boolean[4];
        		if(str[i].charAt(0)=='E') sub[0]=true;
        		if(str[i].charAt(1)=='S') sub[1]=true;
        		if(str[i].charAt(2)=='T') sub[2]=true;
        		if(str[i].charAt(3)=='J') sub[3]=true;
        		list.add(sub);
        	}

            Min = Integer.MAX_VALUE;
            
            
            comb(0, 0);
           sb.append(Min+"\n");

        }
        System.out.println(sb);

    }
    
    static void comb(int cnt,int start) {
    	if(cnt==3) {
    		boolean[] one=list.get(select[0]);
    		boolean[] two=list.get(select[1]);
    		boolean[] three=list.get(select[2]);
    		Min=Math.min(Min, helper(one,two)+helper(one,three)+helper(two,three));

    		return;
    	}
    	
    	for(int i=start;i<list.size();i++) {
    		select[cnt]=i;
    		comb(cnt+1,i+1);
    	}
    	
    }
    static int helper(boolean[] a,boolean[] b) {

    	int answer=0;
    	for(int i=0;i<4;i++) {
    		if(a[i]!=b[i]) answer++;
    	}
    	
    	return answer;
    }
}
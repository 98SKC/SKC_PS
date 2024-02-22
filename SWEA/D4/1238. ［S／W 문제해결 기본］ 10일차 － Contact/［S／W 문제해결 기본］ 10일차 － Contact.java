import java.util.*;

import org.xml.sax.HandlerBase;

import java.io.*;
 
 
 
public class Solution {
	
     


	static boolean[] v;
	static Queue<Integer> q=new ArrayDeque<>();
	static int max;
	static int N, start, from, to;
	static HashSet<Integer>[] setArr;
    public static void main(String[] args) throws Exception{
       // System.setIn(new FileInputStream("res/input (6).txt"));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        int len, sub;
        for(int tc=1;tc<=10;tc++) {
        	st=new StringTokenizer(br.readLine());
        	N=Integer.parseInt(st.nextToken());
        	start=Integer.parseInt(st.nextToken());
        	setArr=new HashSet[101]; for(int i=1;i<101;i++) {setArr[i]=new HashSet<>();}
        	v=new boolean[101];
        	
        	
        	st=new StringTokenizer(br.readLine());
        	
        	for(int i=0;i<N/2;i++) {
        		from=Integer.parseInt(st.nextToken());
        		to=Integer.parseInt(st.nextToken());
        		setArr[from].add(to);
        	}
        	
        	q.add(start);
        	
        	while(!q.isEmpty()) {
        		max=0;
        		len=q.size();
        		for(int i=0;i<len;i++) {
        			sub=q.poll();
        			max=Math.max(max, sub);
        			for(int a:setArr[sub]) {
        				if(!v[a]) q.add(a); v[a]=true;
        			}
     
        		}
        	}
        	
        	
        	
        	
        	
        	
        	
            
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
    
   
    

}
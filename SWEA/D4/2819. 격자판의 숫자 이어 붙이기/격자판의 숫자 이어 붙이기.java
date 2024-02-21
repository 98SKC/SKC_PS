import java.util.*;

import org.xml.sax.HandlerBase;

import java.io.*;
 
 
 
public class Solution {
     

	static int[] di= {0,1,0,-1};
	static int[] dj= {1,0,-1,0};
	static int[][] arr=new int[4][4];
    static HashSet<Integer> set=new HashSet<>();
	
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("res/s_input.txt"));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());
    
        for(int tc=1;tc<=T;tc++) {
        	set.clear();
        	for(int i=0;i<4;i++) {
    			st=new StringTokenizer(br.readLine());
        		for(int j=0;j<4;j++) {
        			arr[i][j]=Integer.parseInt(st.nextToken());
        		}
                
    		}
        	String str="";
        	
    		for(int i=0;i<4;i++) {
    			for(int j=0;j<4;j++) {
    				perm(i,j,str+arr[i][j],1);
        		}
                
    		}
            
            sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
        }
        System.out.println(sb);
    }
    

    static void perm(int i, int j,String number, int cnt) {
    	if(cnt==7) {
    		//System.out.println(cnt);
    		set.add(Integer.parseInt(number));
    		return;
    	}
    	int ni=0;
    	int nj=0;
    	for(int a=0;a<4;a++) {
    		ni=i+di[a];
    		nj=j+dj[a];
    		if(ni>=0&&ni<4&&nj>=0&&nj<4) {
    			perm(ni,nj,number+arr[ni][nj],cnt+1);
    		}
    	}
    }
}
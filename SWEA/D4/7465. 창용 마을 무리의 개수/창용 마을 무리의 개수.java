import java.util.*;
import java.io.*;
 
 
 
public class Solution {
     

	static int N,M;// N과 M
	static ArrayList<Integer>[] arr;
	static boolean[] v;
	static int answer;
     
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("res/s_input.txt"));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());
        int a;
		int b;
        for(int tc=1;tc<=T;tc++) {
        	st=new StringTokenizer(br.readLine());
        	N= Integer.parseInt(st.nextToken());// 사람의 수
    		M= Integer.parseInt(st.nextToken());// 관계의 수
    		answer=0;

    		arr= new ArrayList[N];
    		v=new boolean[N];
    		
    		for(int i=0;i<N;i++) {
    			arr[i]=new ArrayList<>();
    		}
    		
    		for(int i=0;i<M;i++) {
    			st=new StringTokenizer(br.readLine());
    			a=Integer.parseInt(st.nextToken());
    			b=Integer.parseInt(st.nextToken());			
    			arr[b-1].add(a-1);
    			arr[a-1].add(b-1);
    		}
    		
    		for(int i=0;i<N;i++) {
    			if(!v[i]) {
    				v[i]=true;
        			Find(i,1);	
        			answer++;
    			}
    			
    		}
            
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    
	static void Find(int number, int rank) {
		
		for(int a:arr[number]) {
			if(!v[a]) {
				v[a]=true;
				Find(a,rank+1);
			}	
		}		
	}
   
 
}
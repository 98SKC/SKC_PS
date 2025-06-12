
import java.util.*;
import java.io.*;

public class Main{

	public static int[][] arr;
	public static int N,K;
	
	public static int answer=3000000;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());// N몀의 적 병사
        K=Integer.parseInt(st.nextToken());// N몀의 적 병사
        
        arr=new int[N][3];
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	arr[i][0]=Integer.parseInt(st.nextToken());
        	arr[i][1]=Integer.parseInt(st.nextToken());
        	arr[i][2]=Integer.parseInt(st.nextToken());
        }
        //100*100*100*100   100000000
        int STR,DEX,INT;
        int count=0;
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		for(int k=0;k<N;k++) {
                	STR=arr[i][0];
                	DEX=arr[j][1];
                	INT=arr[k][2];
        			count=0;
        			for(int a=0;a<N;a++) {
        				
        				if(arr[a][0]<=STR&&arr[a][1]<=DEX&&arr[a][2]<=INT) {
        					count++;
        				}
        			}
        			if(count>=K) {
        				answer=Math.min(answer, STR+DEX+INT);
        			}
        			
                }
            }
        }
        System.out.println(answer);
        
    }

    
}

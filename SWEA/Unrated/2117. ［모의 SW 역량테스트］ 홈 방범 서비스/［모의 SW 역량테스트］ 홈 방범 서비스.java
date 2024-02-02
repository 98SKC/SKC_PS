import java.io.*;
import java.util.*;

public class Solution

{
	
	static int[][] city;
	static int N ,M;
    public static void main(String args[]) throws Exception
    {

    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st;
    	int T=Integer.parseInt(br.readLine());
    	
    	
    	for(int tc=1;tc<=T;tc++) {
    		int max=0;
        	int answer=0;
        	int sub=0;
    		st=new StringTokenizer(br.readLine());
    		N=Integer.parseInt(st.nextToken());
    		M=Integer.parseInt(st.nextToken());

    		
    		//도시 배열 입력
    		city=new int[N][N];
    		for(int i=0;i<N;i++) {
    			st=new StringTokenizer(br.readLine());
    			for(int j=0;j<N;j++) {
        			city[i][j]=Integer.parseInt(st.nextToken());
        			if(city[i][j]==1) max+=M;
        		}
    		}
    		
    		
    		for(int i=0;i<N;i++) {
    			for(int j=0;j<N;j++) {
    				int k=1;//k초기화
    				while(true) {
    					if(operMoney(k)>max) break;//운영비가 이익보다 작으면 나감.
    					sub=neighbor(k,j,i);//집 수 변경.
    					if(sub*M-operMoney(k)>=0) {
    						answer=Math.max(answer,sub);
    					}

    					k++;
    				}

        		}
    		}
    		sb.append("#").append(tc).append(" ").append(answer).append("\n");
    	}
    	System.out.println(sb);
       
    }
    //운영비 따로
    static int operMoney(int k) {
    	return k*k+(k-1)*(k-1);
    }

    //가칭 주변에 집이 얼마인지 찾는 메서드-> 배열 범위 안넘도록 하는 반복 주의
    //가로 2*k-1 그리고 상하로 갈수록 줄이자.
    static int neighbor(int k, int x, int y) {
    	int house=0;

    	int lx=x-k+1;
    	int rx=x+k-1;
    	int ny=y;
    	//중
    	for(int i=lx;i<=rx;i++) {  		
    		if((i>=0&&i<N)&&city[ny][i]==1)house++;//범위를 넘거나 집이 없으면 x
    	
    	}
    	//상
    	for(int i=1;i<k;i++) {
    		lx+=1;
    		rx-=1;
    		ny-=1;
    		if(ny<0) break;
    		for(int j=lx;j<=rx;j++) {
    			if((j>=0&&j<N)&&city[ny][j]==1)house++;//범위를 넘거나 집이 없으면 x
        		
        	}		
    	}
    	
    	lx=x-k+1;
    	rx=x+k-1;
    	ny=y;
  	
    	//하
    	for(int i=1;i<k;i++) {
    		lx+=1;
    		rx-=1;
    		ny+=1;
    		if(ny>=N) break;
    		for(int j=lx;j<=rx;j++) {
    			if((j>=0&&j<N)&&city[ny][j]==1)house++;//범위를 넘거나 집이 없으면 x
        		
        	}		
    	}
    	
    	return house;
    		
    }

}
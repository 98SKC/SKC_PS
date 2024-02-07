import java.util.*;
import java.io.*;


public class Main {

	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	
	
	public static void main(String[] args) throws Exception {


	    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    	StringTokenizer st;
	    	boolean[][] visit=new boolean[100][100];

	    	
	    	int T=Integer.parseInt(br.readLine());
	    	int count=0;
	    	int x;
	    	int y;
	    	boolean before=true;
	    	
	    	for(int square=0;square<T;square++) {
	    		st=new StringTokenizer(br.readLine());
	    		y=Integer.parseInt(st.nextToken());//x부터 10
	    		x=Integer.parseInt(st.nextToken());//y부터 10
	    		
	    		for(int i=y;i<y+10;i++) {
	    			for(int j=x;j<x+10;j++) {
	    				if(visit[i][j]!=true) {
	    					visit[i][j]=true;
	    				}
	    			}
	    		}
	    	}
	
	    	
	    	// 색종이 둘레 계산
	    	for (int i = 0; i < 100; i++) {
	    	    for (int j = 0; j < 100; j++) {
	    	        if (visit[i][j]) {
	    	            for (int k = 0; k < 4; k++) { // 상하좌우 탐색. 이동하는게 아닌 주변 값만 확인
	    	                int nx = i + dx[k];
	    	                int ny = j + dy[k];
	    	                if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || !visit[nx][ny]) {
	    	                    count++; // 도화지와 만나는 경우 둘레로 카운트
	    	                }
	    	            }
	    	        }
	    	    }
	    	}
    		
    	
    		
	    	 System.out.println(count);    	
	    }
	}
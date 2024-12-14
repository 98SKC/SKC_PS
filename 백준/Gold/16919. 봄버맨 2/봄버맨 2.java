import java.util.*;
import java.io.*;

public class Main {

	public static int R,C,N;
	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0};
	public static int[][] map;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int R=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        map=new int[R][C];
        String sub;
        
        for(int i=0;i<R;i++) {
        	sub=br.readLine();
        	for(int j=0;j<C;j++) {
        		if(sub.charAt(j)=='O') {
        			map[i][j]=2;
        		}else {
        			map[i][j]=-1;// 폭탄이 없음
        		}
        	}
        }
//    	System.out.println("1 턴 후");
//    	
//	    for(int k=0;k<R;k++) {
//	    	for(int j=0;j<C;j++) {
//	    		if(map[k][j]>0) {
//	    			System.out.print('O');
//	    		}else {
//	    			System.out.print('.');
//	    		}
//	    	}
//	    	System.out.println("\n");
//	    }
//	    System.out.println("----------------------");
	    if(N%2==0&&N!=0) {
	    	N=4;
	    }else if(N%4==1&&N!=1){
	    	N=5;
	    }else if(N%4==3) {
	    	N=3;
	    }
	    
	    
        for(int i=2;i<=N;i++) {// 처음 설치 후 1초 대기 지난 후
        	// i%2==0 폭탄 설치
        	ArrayDeque<int[]> q=new ArrayDeque<int[]>();
        	boolean[][] v=new boolean[R][C];
        	// 턴이 지났으니 타이머 감소
            for(int k=0;k<R;k++) {
            	for(int j=0;j<C;j++) {
            		if(map[k][j]>0) {// 폭탄이 있다.
            			map[k][j]--;
            			if(map[k][j]==0) {// 0초가 나오는턴이 정해져있음
            				q.add(new int[] {k,j});
            			}
            		}
            	}
            }
            
        	if(i%2==0) {// 폭탄 설치할 곳 탐색 및 설치
        		q=new ArrayDeque<int[]>();
                for(int k=0;k<R;k++) {
                	for(int j=0;j<C;j++) {
                		if(map[k][j]==-1) {// 폭탄이 없으면 설치
                			map[k][j]=3;
                		}else if(map[k][j]<0) {
                			System.out.println("대체뭐니?: "+map[k][j]);
                		}
                	}
                }
        	}else {// 폭발
        		int[] arr;
        		int ni,nj;
        		
        		while(!q.isEmpty()) {
        			arr=q.poll();
        			map[arr[0]][arr[1]]=-1;
        			for(int a=0;a<4;a++) {
        				ni=arr[0]+di[a];
        				nj=arr[1]+dj[a];
        				if(ni>=0&&ni<R&&nj>=0&&nj<C&&!v[ni][nj]) {
        					if(map[ni][nj]!=-1) {// 이미 터질 폭탄들은 큐에 들어가있음
        						map[ni][nj]=-1;
        					}
        				}
        			}
        			
        		}
        		
        		
        	}
//        	System.out.println(i+"턴 후");
//    	    for(int k=0;k<R;k++) {
//    	    	for(int j=0;j<C;j++) {
//    	    		if(map[k][j]>0) {
//    	    			System.out.print('O');
//    	    		}else {
//    	    			System.out.print('.');
//    	    		}
//    	    	}
//    	    	System.out.println("\n");
//    	    }
//    	    System.out.println("----------------------");
        }
       
        StringBuilder sb=new StringBuilder();
       // System.out.println("답");
	    for(int k=0;k<R;k++) {
	    	for(int j=0;j<C;j++) {
	    		if(map[k][j]>0) {
	    			sb.append('O');
	    		}else {
	    			sb.append('.');
	    		}
	    	}
	    	sb.append("\n");
	    }
        System.out.println(sb);
        
        
    }
}
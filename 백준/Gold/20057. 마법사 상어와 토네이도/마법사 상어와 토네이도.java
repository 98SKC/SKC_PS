import java.util.*;
import java.io.*;

public class Main {
   
	static int N;
	static int[][] map;
	static int answer=0;

    //dir0 		  인덱스0	   1  2  3  4 5 6  7 8   9
    static int[] rli= {0, -1, 1,-2,-1,1,2,-1,1,  0};//모래 날리는 범위 좌부터, 또 상부터의 좌표그런데 알파를 9로 뺀. 
    static int[] rlj= {-2,-1,-1, 0, 0,0,0, 1,1, -1};
    //dir 1
    static int[] udi= {2, 1, 1,  0,  0,0,0, -1,-1,  1};
    static int[] udj= {0,-1, 1, -2, -1,1,2, -1, 1,  0};    

    //dir 2

    static int[] lri= {0, -1, 1,-2,-1,1,2,-1, 1,  0};
    static int[] lrj= {2,  1, 1, 0, 0,0,0,-1,-1,  1};
    //dir 3

    static int[] dui= {-2, -1, -1, 0, 0, 0, 0, 1 ,1,  -1}; 
    static int[] duj= {0,-1, 1, -2, -1,1,2, -1, 1,  0};  
    
	
    static int[] rp= { 5,10,10, 2, 7,7,2, 1,1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        // 지도 만들기
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
            	map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        movingTonado();
        System.out.println(answer);
        
        
      }
    
    static void distributionSand(int i,int j, int dir, int sand) {//sub는 원래 있던 양.
   

    	int[] di;
    	int[] dj;
    	int ni;
    	int nj;
    	int alpha=sand;
    	int sub;
    	

    	if(dir==0) {
    		di=rli;
    		dj=rlj;
    	}else if(dir==1) {
    		di=udi;
    		dj=udj;
    	}else if(dir==2) {
    		di=lri;
    		dj=lrj;
    	}else{
    		di=dui;
    		dj=duj;
    	}
    	
    	map[i][j] = 0; // 토네이도가 위치한 곳은 모래를 제거.

    	for (int a = 0; a < 10; a++) {
    		ni = i + di[a];
	    	nj = j + dj[a];
    		if(a==9) {
    	    	if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
    	    	    map[ni][nj] += alpha; // 격자 내부라면 알파 모래 분배.
    	    	} else {
    	    	    answer += alpha; // 격자 외부라면 answer에 알파 모래 양 추가.
    	    	}
    	    }else {
        	    sub = (int) (sand * (rp[a] * 0.01)); // 분배될 모래 양 계산.

        	    if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
        	        map[ni][nj] += sub; // 격자 내부라면 모래 분배.
        	    } else {
        	        answer += sub; // 격자 외부라면 answer에 모래 양 추가.
        	    }
        	    alpha -= sub; // 분배된 모래 양만큼 alpha에서 차감.
    	    }
    		
    	}

    

    }
  
    static void movingTonado() {

    	int ni=N/2;
    	int nj=N/2;
    	int dir=-1;
    	int a=0;
    	int b=0;
    	boolean escape=true;
    	while(escape) {
    		
    		dir=(dir+1)%4;
    		switch(dir) {
    			case 0:
    				a++;
    				for(int c=0;c<a;c++) {
    					nj-=1;
    					if(ni==0&&nj==-1) {
    						escape=false;
    						break;
    					}
    					distributionSand(ni,nj,dir,map[ni][nj]);
    				}
    				break;
    			case 1:
    				b++;
    				for(int c=0;c<b;c++) {
    					ni+=1;
    					distributionSand(ni,nj,dir,map[ni][nj]);
    				}
    				break;
    			case 2:
    				a++;
    				for(int c=0;c<a;c++) {
    					nj+=1;
    					distributionSand(ni,nj,dir,map[ni][nj]);			
    				}
    				break;
    			case 3:
    				b++;
    				for(int c=0;c<b;c++) {
    					ni-=1;
    					distributionSand(ni,nj,dir,map[ni][nj]);
    				}

    		}
    		
    	}

    }
   
}
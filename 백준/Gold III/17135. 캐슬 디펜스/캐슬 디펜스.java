import java.io.*;
import java.util.*;

public class Main {

	static int N,M,D;
	static int[][] map;
	static int[][] copy;
	static int[] shooter=new int[3];
	static int[] di= {0,1,0,-1};//우 하 좌 상
	static int[] dj= {1,0,-1,0};
	static int answer=0;
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	
    	//Queue<Integer> queue=new ArrayDeque<>();

    	
    	N=Integer.parseInt(st.nextToken());
    	M=Integer.parseInt(st.nextToken());
    	D=Integer.parseInt(st.nextToken());
    	
  
    	map=new int[N][M];
    	copy=new int[N][M];
    	int enermy=0;
    	int stage=-1;
    	int ni,nj;
    	String str;
    	for(int i=0;i<N;i++) {
    		st=new StringTokenizer(br.readLine()); 
    		for(int j=0;j<M;j++) {
    			map[i][j]=Integer.parseInt(st.nextToken());
    			if(stage==-1&&map[i][j]==1) stage=N-i;
        	}
    	}
    	
    	comb(0,0);
    	System.out.println(answer);
    }
    
    public static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
    }

 
    // 거리
    public static int dis(int r1, int r2, int c1, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
    
    
    static void comb(int cnt,int start) {
		if(cnt==3) {
			init();
			score();
			return;
		}
		for(int i=start; i<M; i++) {
		    shooter[cnt] = i;
		    comb(cnt+1, i+1);
		}

	}
    
    
    static void score() {
    	int sc=0,min=D+1;
    	int ni,nj;
    	int line=N;//궁수들 i좌표
    	int sub=0;
    	//shooter는 j좌표의 배열.
    	while(line>0) {
    		//System.out.println("위치확인1");
    		for(int a=0;a<3;a++) {// 궁수의 j좌표
    			ni=-1;
    			nj=-1;
    			min=D+1;
    			//System.out.println("위치확인2");
    			for(int b=0;b<M;b++) {
    				for(int c=line-1;c>=0;c--) {
    					//System.out.println("위치확인3");
    					if(copy[c][b]!=0) {
    						
    						sub=dis(line,c,shooter[a],b);
    						if(sub<min) {
    							ni=c;
    							nj=b;
    							min=sub;
    						}
    					}
    				}
    			}
    			if(ni!=-1) {
    				copy[ni][nj]=2;
    				//System.out.printf(" i는 %d j는 %d \n",ni,nj);
    			}
    		}
    		for(int a=0;a<line;a++) {
    			for(int b=0;b<M;b++) {
    				if(copy[a][b]==2) {
    					copy[a][b]=0;
    					sc++;
    				}
    			}
    		}
    		//System.out.printf("사수 위치 i는 %d, j는 각각 ",line);
//    		for(int b:shooter) {
//    			System.out.printf("%d ",b);
//    		}
//    		System.out.println();
//    		for(int a=0;a<line;a++) {
//    			System.out.println(Arrays.toString(copy[a]));
//    		}
//    		for(int a=line;a<N;a++) {
//    			for(int b=0;b<M;b++) {
//    				System.out.print("0 ");
//    			}
//    			System.out.println();
//    		}
//    		System.out.println("================================");
    		
    		line--;
    	}
    	answer=Math.max(answer, sc);
    }
 
}
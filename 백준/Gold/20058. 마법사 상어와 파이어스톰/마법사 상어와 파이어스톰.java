import java.util.*;

import java.io.*;

public class Main {
   
	static int[][] map;
	static int[] di= {0,1,0,-1};// r,c에서 인접한 칸의 좌표. 우 하 좌 상
	static int[] dj= {1,0,-1,0};
	static int[] rank;
	static int N,Q,size;
	static boolean[][] v;
	static int max=0;
	static int cnt;
	static int total;
	static Queue<Integer> q=new ArrayDeque<Integer>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());// 단계의 개수
        rank=new int[Q];
        //맵의 크기 구하기.
        size=(int)Math.pow(2, N);
        map=new int[size][size];
        v=new boolean[size][size];

        //맵 만들기
        for(int i=0;i<size;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<size;j++) {
            	map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
    
        //랭크 받고 바로 돌리기
        st=new StringTokenizer(br.readLine());
        int cccnt=0;
        for(int i=0;i<Q;i++) {    	
        	tornado(Integer.parseInt(st.nextToken()));
        	melt();
        	cccnt++;
        }
        
        for(int i=0;i<size;i++) {
    		for(int j=0;j<size;j++) {
    			if(map[i][j]!=0&&!v[i][j]) {
    				 cnt=0;
    				 dfs(i,j);
    				 if(cnt>max) max=cnt;
    			} 
        	}
    	}
//        
//
//        for(int[] a:map) {
//        	System.out.println(Arrays.toString(a));
//        }
        System.out.println(total);
        System.out.println(max);

      }
    
    static void dfs(int i, int j) {

    	total+=map[i][j];
    	cnt++;
    	v[i][j]=true;
    	int ni;
    	int nj;
    	for(int a=0;a<4;a++) {
    		ni=i+di[a];
    		nj=j+dj[a];
    		if(ni>=0&&ni<size&&nj>=0&&nj<size&&!v[ni][nj]&&map[ni][nj]!=0) {
    			dfs(ni,nj);
    		}
    	}
    }
    
    static void tornado(int r){
    
    	int number=(int)Math.pow(2, r);
    	//int count=size/number;
    	
    	for(int i=0;i<size;i=i+number) {
    		for(int j=0;j<size;j=j+number) {
    			turn(i,j,r);//좌상단이 i,j인 파트의 회전 로직	
        	}
    	}

    }

    static void turn(int i,int j, int r) {
    	int len= (int)Math.pow(2, r);

    	for(int a=i; a<i+len; a++) {
    		for(int b=j; b<j+len; b++) {
    			q.add(map[a][b]);
    		}
    	}
    	
    	for(int b=j+len-1; b>=j; b--) {
    		for(int a=i; a<i+len; a++) {
    			map[a][b] = q.poll();
    		}
    	}
    	q.clear();// 혹시 모르니 초기화.
    }
    
    static void melt() {
    	int count=0;// 인접한 얼음의 수
    	int ni;
    	int nj;
    	int sub;
    	for(int i=0;i<size;i++) {
    		for(int j=0;j<size;j++) {
    			if(map[i][j]==0)continue;
    			count=0;
        		for(int a=0;a<4;a++) {
        			ni=i+di[a];
        			nj=j+dj[a];
        			if(ni>=0&&ni<size&&nj>=0&&nj<size&&map[ni][nj]>0) {
        				count++;
        			}
        		}
        		if(count<3) {
        			q.add(i*size+j);
        		}
        	}
    	}
    	
    	while(!q.isEmpty()) {
    		sub=q.poll();
    		ni=sub/size;
    		nj=sub%size;
    		map[ni][nj]--;
    	}
    	
    }
 
}
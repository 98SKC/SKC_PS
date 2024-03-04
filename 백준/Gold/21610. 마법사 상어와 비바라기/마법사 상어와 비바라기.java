import java.util.*;

import java.io.*;
// 해야하는거 구름 있던곳은 구름 다시 안만ㄷ,ㅡㅁ..

public class Main {
	static int N,M;
	static int[][] map;
	static Queue<int[]> q;
	static Queue<int[]> subQ;
    static int[][] order;
    static int[] di= {0,0,-1,-1,-1,0,1,1,1};// 0은 x. 좌,좌상,상,우상,우,우하,하,좌하
    static int[] dj= {0,-1,-1,0,1,1,1,0,-1};//대각선 인덱스는 2 4 6 8-> 2의 배수
    static HashSet<Integer> set; 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        map=new int[N][N];
        
        order=new int[M][2];
        //배열 생성
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	order[i][0]=Integer.parseInt(st.nextToken());
        	order[i][1]=Integer.parseInt(st.nextToken());
        }
        
//        for(int[] a:map) {
//        	System.out.println(Arrays.toString(a));
//        }
//    	System.out.println("-------------------------");
    	q=new ArrayDeque<>();
        for(int i=0;i<M;i++) {
//        	System.out.println(i+"회차");
        	if(i==0) {
        		q.add(new int[] {N-1,0});
        		q.add(new int[] {N-1,1});
        		q.add(new int[] {N-2,0});
        		q.add(new int[] {N-2,1});
//        		System.out.println("초기 구름 상태");
//        		for(int[] a:map) {
//                	System.out.println(Arrays.toString(a));
//                }
        	}   
//        	System.out.println("구름 움직이고");
        	movingCloud(order[i][0], order[i][1]);
        	
//        	for(int[] a:map) {
//            	System.out.println(Arrays.toString(a));
//            }
//        	System.out.println("-------------------------");
        	copyWater();
        	
//        	for(int[] a:map) {
//            	System.out.println(Arrays.toString(a));
//            }
//        	System.out.println("-------------------------");
        	makeCloud();
//        	for(int[] a:map) {
//            	System.out.println(Arrays.toString(a));
//            }
        }
        int answer=0;
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		answer+=map[i][j];
        	}
        }
        
        System.out.println(answer);
        

     }
    
    static void makeCloud() {
    	q=new ArrayDeque<>();
//    	System.out.println("구름 생성");
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			if(map[i][j]>=2&&!set.contains(i*N+j)) {
    				map[i][j]-=2;
    				q.add(new int[] {i,j});
    			}
    		}
    	}
    	set.clear();
    }
    // 구름이 움직이고 물을 뿌려줌.
    static void movingCloud(int d, int s) {
    	set=new HashSet<>();
    	subQ=new ArrayDeque<>();
    	int[] pos;
    	int ni;
    	int nj;
    	while(!q.isEmpty()) {
    		pos=q.poll();// 구름의 i j좌표
//    		System.out.printf("이동 전 좌표 %d %d \n",pos[0],pos[1]);
    		ni=pos[0]+di[d]*s;
    		nj=pos[1]+dj[d]*s;
//    		System.out.printf("이동 후 좌표 %d %d \n",ni,nj);
    		if(ni<0) {
    			ni=(ni+N*100);
    			ni=ni%N;
    		}
    		if(nj<0) {
    			nj=(nj+N*100);
    			nj=nj%N;
    		}
    		if(ni>=N) {
    			ni=ni%N;
    		}
    		if(nj>=N) {
    			nj=nj%N;
    		}
//    		System.out.printf("처리 좌표 %d %d \n",ni,nj);
//    		System.out.println();
    		map[ni][nj]++;
    		set.add(ni*N+nj);
    		subQ.add(new int[] {ni,nj});
    	}
    }
    //물 복사 일괄처리 조심
    static void copyWater() {
    	//System.out.println("물복사");
    	int ni=0;
    	int nj=0;
    	int i;
    	int j;
    	int[] sub;
    	int count;
    	while(!subQ.isEmpty()) {
    		count=0;
    		sub=subQ.poll();
    		i=sub[0];
    		j=sub[1];
    		for(int a=2;a<=8;a+=2) {
    			ni=i+di[a];
    			nj=j+dj[a];
    			if(ni>=0&&ni<N&&nj>=0&&nj<N) {
    				if(map[ni][nj]>0) count++;
    			}
    		}
    		map[i][j]+=count;		
    	}
    }

}
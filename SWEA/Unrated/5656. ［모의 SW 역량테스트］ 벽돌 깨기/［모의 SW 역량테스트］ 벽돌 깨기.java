import java.io.*;
import java.util.*;

public class Solution

{
	static int[] di= {0,1,0,-1};
	static int[] dj= {1,0,-1,0};
	static Queue<int[]> q=new ArrayDeque<>();
	static HashSet<Integer> set=new HashSet<>();
	static StringBuilder sb=new StringBuilder();

	
	static int[][] originMap;
	static int[][] map;
	static int N,W,H;
	static int count;
	static int cnt;// 
	static int[] target;
	// 대상 숫자를 담아둘 배열.
	static int[] result;
	static List<int[]> list;
	static int min;

    public static void main(String args[]) throws Exception{
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int T=Integer.parseInt(br.readLine());
    	String str;
    	
    	
    	for(int tc=1;tc<=T;tc++) {
    		count=0;
    		min=Integer.MAX_VALUE;
    		list=new ArrayList<>();
    		st=new StringTokenizer(br.readLine());
    		N=Integer.parseInt(st.nextToken()); //구슬 발싸 횟수
    		W=Integer.parseInt(st.nextToken()); //j
    		H=Integer.parseInt(st.nextToken()); //i
    		
    		originMap=new int[H][W];
    		map=new int[H][W];
    		
    		//맵 입력
    		for(int i=0;i<H;i++) {
    			st=new StringTokenizer(br.readLine());
    			for(int j=0;j<W;j++) {
    				originMap[i][j]=Integer.parseInt(st.nextToken());
    				if(originMap[i][j]!=0) count++;
    			}	
    		}
    		
    		
    		//구슬을 쏠 인덱스
    		target=new int[W];
    		for(int i=0;i<W;i++) {
    			target[i]=i;
    		}
    		//구슬을 쏘는 위치의 순서를 정할 중복순열
    		result=new int[N];
    		permutation(0);
//    		for(int[] a:list) {
//    			System.out.println(Arrays.toString(a));
//    		}
    		for(int[] a:list) {//a는 구슬의 위치와 순서를 저장한 배열
    			//맵 복사
    			//System.out.println(Arrays.toString(a));
        		for(int i=0;i<H;i++) {
        			for(int j=0;j<W;j++) {
        				map[i][j]=originMap[i][j];
        			}	
        		}
        		cnt=count;

    			for(int b:a) {
    				//구슬을 발싸해서 부딪힐 곳을 찾는다.
            		for(int i=0;i<H;i++) {
            			if(map[i][b]!=0) {
            				q.add(new int[] {i*W+b,map[i][b]-1});
            				map[i][b]=0;
        					cnt--;
            				break;
            			}
            		}
        			while(!q.isEmpty()){
        				int[] sub=q.poll();
        				int i=sub[0]/W;
        				int j=sub[0]%W;
        				distory(i, j, sub[1]);
        			}
        			if(cnt==0) break;
        			gravity();

        			
    			}

    			min=Math.min(min, cnt);
    			if(min==0) break;
    		}
    		sb.append("#").append(tc).append(" ").append(min).append("\n");
    	}
    	
    System.out.println(sb);
    }
    
   //중복 순열 구하는 메서드
 	private static void permutation(int cnt) {
 		// 2개를 선택했으므로, 결과를 출력하고 재귀를 종료한다.
 		if (cnt == N) {
 			list.add(Arrays.copyOf(result, result.length)); // 수정된 부분
 	        
 			return;
 		}
 		// 대상 집합을 순회하며 숫자를 하나 선택한다.
 		for (int i = 0; i < W; i++) {
 			// 숫자를 담는다.
 			result[cnt] = target[i];
 			// 자신을 재귀 호출한다.
 			permutation(cnt + 1);
 		}
 	}
    
    
    static void distory(int i,int j,int scope) {// i,j 블록 상하좌우 N-1만큼 파괴
    	int ni;
    	int nj;
    	for(int a=1;a<=scope;a++) {
    		for(int b=0;b<4;b++) {
    			ni=i+di[b]*a;
    			nj=j+dj[b]*a;
    			if(ni>=0&&ni<H&&nj>=0&&nj<W) {
    				if(map[ni][nj]!=0) {
    					q.add(new int[] {ni*W+nj,map[ni][nj]-1});
    					map[ni][nj]=0;
    					cnt--;
    				}
    			}
    		}
    	}
    }
    
    static void gravity() {
    	Queue<Integer> sub=new ArrayDeque<>();
    	
    	for(int j=0;j<W;j++) {
    		for(int i=H-1;i>=0;i--) {
    			if(map[i][j]!=0) {
    				sub.add(map[i][j]);
    				map[i][j]=0;
    			} 
    		}
    		int subCount=H-1;
    		while(!sub.isEmpty()) {
    			map[subCount][j]=sub.poll();
    			subCount--;
    		}
    	}
    	
    	
    }
    
}
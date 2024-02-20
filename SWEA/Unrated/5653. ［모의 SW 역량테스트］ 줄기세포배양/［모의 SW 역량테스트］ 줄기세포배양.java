import java.io.*;
import java.util.*;

public class Solution

{
	static int M;
	static int[][] map;
	static int[][] time;
	static boolean[][] v,active;
	static Queue<int[]> q;
	static int[] di = {-1, 1, 0, 0}; // 상, 하, 좌, 우 
    static int[] dj = {0, 0, -1, 1}; 

	
    public static void main(String args[]) throws Exception{
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb=new StringBuilder();
    
    	int T=Integer.parseInt(br.readLine());
    	
    	for(int tc=1;tc<=T;tc++) {
    		
    		st=new StringTokenizer(br.readLine());
    		int count=0;
    		int[] save;
    		int oN=Integer.parseInt(st.nextToken());
    		int oM=Integer.parseInt(st.nextToken());
    		int k=Integer.parseInt(st.nextToken());
    		//int[][] sub=new int[oN][oM];
    		map=new int[oN+k][oM+k];
    		time=new int[oN+k][oM+k];
    		q=new ArrayDeque<>();
    		
    		for(int i=k/2;i<k/2+oN;i++) {
    			st=new StringTokenizer(br.readLine());
    			for(int j=k/2;j<k/2+oM;j++) {
    				map[i][j]=Integer.parseInt(st.nextToken());
    				time[i][j]=map[i][j];
    			}
    		}
    		
    		active=new boolean[map.length][map[0].length];
    		for(int s=0;s<k;s++) {
    			v=new boolean[map.length][map[0].length];
	
    			//줄기새포 배양
    			simul();
    			while(q.size()!=0) {
    				save=q.poll();
    				if(map[save[0]/M][save[0]%M]<save[1]) {
    					map[save[0]/M][save[0]%M]=save[1];
    					time[save[0]/M][save[0]%M]=save[1];
    					v[save[0]/M][save[0]%M]=true;
    				}
    			}
    			
    			
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        if(!v[i][j]) {
                        	if (!active[i][j]&&time[i][j]>1) {// 활성화 안되있고 시간 남음
                           	 time[i][j]--;
                            } else if (!active[i][j]&&time[i][j]==1) {// 활성화 안되어 있는데 활성화 될 시간
                           	time[i][j] =map[i][j];
                            	active[i][j]=true;
                           }else if(active[i][j]&&time[i][j]>1) {
                           	time[i][j]--;
                           }else if(active[i][j]&&time[i][j]==1) {
                           	time[i][j]--;
                           	map[i][j]=-1;
                           	active[i][j]=false;
                           }
                        }
                    	
                    }
                }
    			
    		}
    		
    		for(int[] a:map) {
    			for(int b:a) {
    				if(b!=0&&b!=-1) count++;
    			}
    		}

    		sb.append("#").append(tc).append(" ").append(count).append("\n");
    	}
    	
    System.out.println(sb);
    }
    
    static void simul() {
    	
    	M=map[0].length;
    	int ni;
    	int nj;
    	for(int i=0;i<map.length;i++) {
    		for(int j=0;j<M;j++) {
    			if(active[i][j]) {//활성화된 세포를 만남
    				for(int a=0;a<4;a++) {// 세포기준 4방향에 분열
    					ni=i+di[a];
    					nj=j+dj[a];
    					if(map[ni][nj]==0) {// 4방향중 세포가 없는 곳
    						q.add(new int[] {ni*M+nj,map[i][j]});

    					}
    				}
    			}
    		}
    	}
    	
    	
    }
    


}
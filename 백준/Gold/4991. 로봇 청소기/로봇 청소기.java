

import java.util.*;
import java.io.*;

public class Main {

	public static int[][] map;
	public static boolean[][][] v;
	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0};
	public static int si,sj;
	public static int W,H;

	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int answer=-1;
        StringTokenizer st;
        String str;
        int ni,nj;
        boolean find=false;
        while(true) {
        	st=new StringTokenizer(br.readLine());
        	W=Integer.parseInt(st.nextToken());
        	H=Integer.parseInt(st.nextToken());
        	find=false;
        	if(W==0&&H==0) break;
        	map=new int[H][W];
        	answer=-1;
        	int cnt=0;
        	char sub;
        	for(int i=0;i<H;i++) {
        		str=br.readLine();
        		for(int j=0;j<W;j++) {
            		sub=str.charAt(j);
            		if(sub=='x'){// 시작 위치 저장
            			map[i][j]=-2;
            		}else if(sub=='*'){
            			map[i][j]=cnt;
            			cnt++;
            		}else {
            			if(sub=='o') {
            				si=i;
            				sj=j;            				
            			}
            			//System.out.println(i+" "+j);
            			map[i][j]=-1;
            		}
            	}	
        		
        	}
        	//cnt가 5면 4개가 들어있음. 
        	//1 2 3 4. 2^4
        	int goal=calGoal(cnt);
        	v=new boolean[H][W][goal+1];
        	//bfs로 시작점을 포함한 모든 정점의 거리를 구하고 크루스칼
        	//문제는 정점의 개수를 다 돌아야 알 수 있네
        	//아니 그 전에 크루스칼 프림 다익스트라로는 왕복 거리를 알 수가 없네
        	ArrayDeque<int[]> q=new ArrayDeque<>();
        	q.add(new int[] {si,sj,0,0});
        	v[si][sj][0]=true;
        	int[] p;
        	int status;

        	
        	while(!q.isEmpty()){
        		p=q.poll();

        		
        		for(int a=0;a<4;a++){
        			ni=p[0]+di[a];
        			nj=p[1]+dj[a];
            		status=p[2];
        			if(ni>=0&&ni<H&&nj>=0&&nj<W&&!v[ni][nj][status]&&map[ni][nj]!=-2){
        				v[ni][nj][status]=true;

        				if(map[ni][nj]>=0) {
        					if(check(status,map[ni][nj])){
            					//System.out.println(status+"상태에: "+map[ni][nj]+"를 방문했다는 의미로 "+Math.pow(2, map[ni][nj])+"를 더함. 이때 거리가: "+(p[3]+1));
            					status+=Math.pow(2, map[ni][nj]);
            					//System.out.println(status);
            					v[ni][nj][status]=true;
        					}

        				}
        				if(status==goal) find=true;
        				q.add(new int[] {ni,nj,status,p[3]+1});
        			}
        		}
        		if(find) {
        			answer=p[3]+1;
        			break;
        		}
        	}
        	
        	sb.append(answer+"\n");
        	//System.out.println("-----------------------------");
        }
        
        System.out.println(sb);
        //직사각형의 격자의 크기 W,H가 주어지고, 격자 상태가 주어질 때
        //격자 내에서 청소기가 모든 더러운 칸을 깨끗이 하는 최소 이동거리를 구하라
        //격자에는 벽이 있고, 방문한 곳을 또 방문하는 것이 가능하다.
        
        
        
    }
    //cnt개의 노드를 다 방문했을 때의 상태
    public static int calGoal(int cnt){
    	int answer=0;
    	
    	for(int i=0;i<cnt;i++){
    		answer+=Math.pow(2, i);
    	}
    	
    	//System.out.println("cnt: "+cnt);
    	//System.out.println("완전한 상태: "+answer);
    	
    	return answer;
    }
    
    //							status 상태는 m을 방문 한것인지 확인
    public static boolean check(int status,int m){
    	boolean answer=true;//방문하지 않았다.
    	int p=(int)Math.pow(2, m);
    	int sub=status|p;
    	//0 1 2 4 8
    	//
    	if(sub==status){//같으면 방문한 적이 있다.
    		answer=false;
    	}
    	
    	return answer;//
    }
    

        
}



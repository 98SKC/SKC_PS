
import java.util.*;
import java.io.*;

public class Main {

	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0};
	public static char[][] map;
	public static int N,H,D;
	public static int[][] HP;//캐릭터의 HP기준
	public static int[][] UP;//소지하고 있는 우산의 hp기준
	public static int answer=Integer.MAX_VALUE;
	
	public static int gi, gj;
	
	public static class User{
		
		int health;
		int umbrella;
		int pi;
		int pj;
		int turn;
		
		public User(int health, int umbrella, int pi, int pj,int turn) {
			this.health=health;
			this.umbrella=umbrella;
			this.pi=pi;
			this.pj=pj;
			this.turn=turn;
		}
		
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //가로세로 길이가 N인 격자
        //두곳을 제외한 곳에 수치가 1식 줄어드는 구역
        //안전지대 두곳중 한곳이 출발점, 한곳은 도착점
        //수치감소를 막는 K개의 내구도 D의 우산이 존재.
        
        //이동한 곳에 우산이 있으면, 우산을 드는데, 가지고 있는 우산을 버리고 든다.
        //우산이 없으면 채력이 1 감소한다.
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());
        
        String str;
        map=new char[N][N];
        HP=new int[N][N];
        UP=new int[N][N];
        
        
        ArrayDeque<User> q=new ArrayDeque<User>();
        for(int i=0;i<N;i++) {
        	str=br.readLine();
        	for(int j=0;j<N;j++){
        		map[i][j]=str.charAt(j);
        		if(map[i][j]=='S') {
        			q.add(new User(H+1,0,i,j,0));
        			HP[i][j]=H;
        		}else if(map[i][j]=='E') {
        			gi=i;
        			gj=j;
        		}else if(map[i][j]=='U') {
        			UP[i][j]=D;
        		}
            }
        }

        User user;
        int ni,nj;
        
        //빠르게 가는 것도 중요하지만 
        //해당 위치에 더 많은 피로 갈 수 있냐도 중요.
        while(!q.isEmpty()) {
        	user=q.poll();
        	
        	if(user.pi==gi&&user.pj==gj) {
        		answer=Math.min(answer, user.turn);
        		continue;
        	}
        	
        	//비로인한 hp처리
        	if(user.umbrella>0) {
        		user.umbrella--;
        	}else {
        		user.health--;
        	}
        	if(user.health==0) continue;
        	

        	for(int a=0;a<4;a++) {
        		ni=user.pi+di[a];
        		nj=user.pj+dj[a];
        		if(inMap(ni,nj)){

        			//해당 위치가 더 많은 우산피로 방문 (우산이 있는 지역이 아니라면)
        			if(map[ni][nj]!='U'&&user.umbrella>UP[ni][nj]){
        				q.add(new User(user.health,user.umbrella,ni,nj,user.turn+1));
        				HP[ni][nj]=Math.max(HP[ni][nj], user.health);
        				UP[ni][nj]=Math.max(UP[ni][nj], user.umbrella);
        			}else if(user.health>HP[ni][nj]){//우산이 있는 지역이든, 어디든 HP가 더 많으면
        				if(map[ni][nj]=='U') {//우산을 새로 든다.
        					q.add(new User(user.health,D,ni,nj,user.turn+1));
        				}else {//
        					q.add(new User(user.health,user.umbrella,ni,nj,user.turn+1));
        				}
        				HP[ni][nj]=Math.max(HP[ni][nj], user.health);
        			}

        			//해당 위치에 더 많은피로 방문
        			
        		}
        				
        	}
        	
        	
        }
        
        if(answer==Integer.MAX_VALUE) answer=-1;
        System.out.println(answer);
        
    }
    public static boolean inMap(int ni,int nj){
    	return ni>=0&&ni<N&&nj>=0&&nj<N;
    }
        
}




import java.util.*;
import java.io.*;

public class Main{

	public static class Shark{
		int si;
		int sj;
		int speed;
		int dir;
		int size;
		
		
		public Shark(int si,int sj,int speed,int dir,int size) {
			this.si=si;
			this.sj=sj;
			this.speed=speed;
			this.dir=dir;
			this.size=size;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        
        int R=Integer.parseInt(st.nextToken()); //격자 세로
        int C=Integer.parseInt(st.nextToken()); //격자 가로
        int M=Integer.parseInt(st.nextToken()); //상어의 수
        ArrayDeque<Shark> q=new ArrayDeque<>();
        
        PriorityQueue<Shark> shark=new PriorityQueue<>(new Comparator<Shark>(){
        	@Override
        	public int compare(Shark s1, Shark s2) {
        		return s2.size-s1.size;
        	}
        });
        
        int[] di=new int[] {0,-1,1,0,0};
        int[] dj=new int[] {0,0,0,1,-1};
        
        int[][] map=new int[R][C];
        int si,sj,speed,dir,size;
        for(int m=0;m<M;m++) {
        	st=new StringTokenizer(br.readLine());
        	si=Integer.parseInt(st.nextToken())-1;
        	sj=Integer.parseInt(st.nextToken())-1;
        	speed=Integer.parseInt(st.nextToken());
        	dir=Integer.parseInt(st.nextToken());
        	size=Integer.parseInt(st.nextToken());
        	map[si][sj]=size;
        	shark.add(new Shark(si,sj,speed,dir,size));
        	
        }
        int number=-1;
        Shark s;
        int ni,nj;
        int distance;
        int answer=0;
        //상어를 한번에 이동시키기, 살아있는 상어를 자료구조에 집어넣기
        for(int j=0;j<C;j++){// j가 낚시꾼의 가로 위치
        	//큰 상어를 먼저
        	number=-1;
        	//낚시꾼의 낚시를 시작한다.
        	for(int i=0;i<R;i++) {
        		if(map[i][j]!=0) {
        			number=map[i][j];
        			answer+=number;
        			break;
        		}
        	}
        	
        	map=new int[R][C];
        	//상어의 이동을 시작한다. 죽은 상어를 발견하면 제거한다. 상어 크기로 구분이 가능하다.
        	while(!shark.isEmpty()) {
        		s=shark.poll();// s.si , s.sj가 기존 위치
        		if(s.size==number){// 해당 상어가 잡혔으면
        			continue;
        		}
        		//map[s.si][s.sj]=0;
        		
        		//상어를 이동 시킨다. 한번에 이동시키고, map 수정하고, 
        		//2*C(혹은 R)-2 가 윈위치 기준
        		if(s.dir==1||s.dir==2){//세로 이동
        			distance=(s.speed)%(2*R-2);
        			//System.out.println("세로이동, 이동거리: "+distance+" 시작위치: "+s.si+" "+s.sj+" 방향: "+s.dir);
        			nj=s.sj;
        			if(s.dir==1){// 
        				if(distance<=s.si){//아래으로 꺾기 전에 끝남
        					
        					ni=s.si-distance;
        				}else if(distance<s.si+R){//방향이 반대임
        					
        					s.dir=2;
        					//distance-=s.si;//여기서 0
        					ni=distance-s.si;
        				}else{// 방향은 같으나 반대쪽에 위치함
        					
        					distance-=s.si;//여기서 0
        					distance-=(R-1);
        					ni=R-distance-1;
        				}
        			}else {
        				if(distance<(R-s.si)){//위로 꺾기 전에 끝남
        					
        					ni=s.si+distance;
        				}else if(distance<(2*R-s.si-1)){//방향이 반대임
        					
        					s.dir=1;
        					//ni=distance-(C-s.si)-1;
        					ni=2*R-distance-s.si-2;
        				}else{// 방향은 같으나 반대쪽에 위치함
        					
        					distance-=(2*R-s.si-2);
        					ni=distance;
        				}
        			}
        			
        		}else{//가로 이동, 2*C-2 가 한바퀴
        			distance=(s.speed)%(2*C-2);
        			//System.out.println("가로이동, 이동거리: "+distance+" 속도: "+s.speed);
        			ni=s.si;
        			if(s.dir==4){// 
        				if(distance<=s.sj){//오른쪽으로 꺾기 전에 끝남
        					nj=s.sj-distance;
        				}else if(distance<s.sj+C){//방향이 반대임
        					s.dir=3;
        					
        					nj=distance-s.sj;
        				}else{// 방향은 같으나 반대쪽에 위치함
        					distance-=s.sj;//여기서 0
        					distance-=(C-1);
        					nj=C-distance-1;
        				}
        			}else {
        				if(distance<(C-s.sj)){//왼쪽로 꺾기 전에 끝남
        					nj=s.sj+distance;
        				}else if(distance<(2*C-s.sj-1)){//방향이 반대임
        					s.dir=4;
        					
        					nj=2*C-distance-s.sj-2;
        				}else{// 방향은 같으나 반대쪽에 위치함
        					distance-=(2*C-s.sj-2);
        					nj=distance;
        					
        				}
        			}
        			
        		}

        		if(map[ni][nj]==0) {
        			map[ni][nj]=s.size;
        			s.si=ni;
        			s.sj=nj;
        			q.add(s);
        		}

        		
        	}
        	
        	//살아있는 상어를 넣는다.
        	while(!q.isEmpty()) {
        		shark.add(q.poll());
        	}

        }

        System.out.println(answer);
    }
}

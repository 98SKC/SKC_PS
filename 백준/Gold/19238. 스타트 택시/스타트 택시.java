
import java.util.*;
import java.io.*;

public class Main{

	public static int[] di=new int[] {-1,0,0,1};
	public static int[] dj=new int[] {0,-1,1,0};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());// 격자 크기
        int M=Integer.parseInt(st.nextToken());// 승개의 수
        int fuel=Integer.parseInt(st.nextToken());// 초기 연료 량
        
        int[][] map=new int[N+1][N+1];
        
        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=1;j<=N;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        st=new StringTokenizer(br.readLine());
        int startI=Integer.parseInt(st.nextToken());
        int startJ=Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer> p=new HashMap<>();
        HashMap<Integer,Integer> g=new HashMap<>();
        int r,c;
        for(int i=1;i<=M;i++) {
        	st=new StringTokenizer(br.readLine());
        	r=Integer.parseInt(st.nextToken());
        	c=Integer.parseInt(st.nextToken());
        	p.put(r*(N+1)+c, i);//r*(N+1)+c 좌표의 사람 i
        	//System.out.println(i+" 번 좌표: "+(r*(N+1)+c));
        	r=Integer.parseInt(st.nextToken());
        	c=Integer.parseInt(st.nextToken());
        	g.put(i, r*(N+1)+c);//i번의 목적지
        	
        }
        boolean possible=true;
        int target=-1;
        int[] pos;
        int pi,pj,ni,nj;
        boolean[][] v;
        PriorityQueue<int[]> findPassengerQ;
        ArrayDeque<int[]> findGoalQ;
        int rememberStart;
        int count=0;
        for(int m=1;m<=M;m++){
        	v=new boolean[N+1][N+1];
        	// 우선순위 1. 이동거리가 짧음. 2 행이 작음. 3. 열이 작음 
        	findPassengerQ=new PriorityQueue<>(new Comparator<int[]>() {
        		@Override
        		public int compare(int[] o1, int[] o2) {
        			if(o1[2]==o2[2]){
        				if(o1[0]==o2[0]) {
        					return o1[1]-o2[1];
        				}
        				return o1[0]-o2[0];
        			}
        			return o1[2]-o2[2];
        		}
        	});
        	findPassengerQ.add(new int[] {startI,startJ,0});
        	v[startI][startJ]=true;
        	
        	while(!findPassengerQ.isEmpty()){
        		pos=findPassengerQ.poll();
        		
        		//pos[1] 거리
        		if(pos[2]>fuel){//승객 태우러 가기 전에 연료가 바닥남
        			possible=false;
        			//System.out.println(m+"번째로 태울 승객 찾지 못하고 끝");
        			break;
        		}
        		
        		pi=pos[0];
        		pj=pos[1];
        		if(p.containsKey(pi*(N+1)+pj)) {// 지금 위치에 승객이 있다면 태운다
        			fuel-=pos[2];//연료는 소모시킨다.
        			target=p.get(pi*(N+1)+pj);
//        			System.out.println(m+"번째로 태운 승객의 번호: "+target+" ,현 연료량: "+fuel+" 여기까지 이동거리: "+pos[2]+" 좌표: "+pi+" "+pj);
//        			for(boolean[] w:v) {
//        				System.out.println(Arrays.toString(w));
//        			}
        			findPassengerQ.clear();//승객을 찾기위한 while을 끝내기 위함
        			v=new boolean[N+1][N+1];// 목적지를 찾기위한 탐색을 위해 방문 배열 초기화
        			findGoalQ=new ArrayDeque<>();//목적지를 찾기 위한 새로운 큐
        			findGoalQ.add(new int[] {pi*(N+1)+pj,0});
        			rememberStart=pi*(N+1)+pj;
        			v[pi][pj]=true;
        			while(!findGoalQ.isEmpty()) {
        				pos=findGoalQ.poll();
        				if(pos[1]>fuel){//목적지 가기 전에 연료가 바닥남
                			possible=false;
                			//System.out.println(m+"번째로 태운 승객 목적지 찾지 못하고 끝");
                			break;
                		}
        				pi=pos[0]/(N+1);
                		pj=pos[0]%(N+1);
        				if(pos[0]==g.get(target)){//현 위치가 타겟의 목적지가 맞다면
        				
        					fuel+=pos[1];//연료 충전량은 이동거리의 두배(근데 이동거리만큼 소모도 함)
        					//택시의 시작 위치 갱신
        					startI=pi;
        					startJ=pj;
        					//System.out.println(m+"번째로 태운 승객: "+target+"번 도착 시 연료량: "+fuel+" 여기까지 이동거리: "+pos[1]+" 좌표: "+pi+" "+pj);
 
        					g.remove(target);//태운 승객 제거
        					//System.out.println(target+" 삭제결과 "+g.containsKey(target));
        					p.remove(rememberStart);//태운 승객 제거
        					//System.out.println(target+" 삭제결과 "+p.containsKey(rememberStart));
        					
        					count++;
        					findGoalQ.clear();
        					break;
        				}else{//아니라면
        					for(int a=0;a<4;a++) {
                				ni=pi+di[a];
                				nj=pj+dj[a];
                				if(ni>0&&ni<=N&&nj>0&&nj<=N&&map[ni][nj]!=1&&!v[ni][nj]){
                					v[ni][nj]=true;
                					findGoalQ.add(new int[] {ni*(N+1)+nj,pos[1]+1});
                				}
                			}
        				}
        			}
        			
        		}else{//없으면 계속 탐색
        			for(int a=0;a<4;a++) {
        				ni=pi+di[a];
        				nj=pj+dj[a];
        				if(ni>0&&ni<=N&&nj>0&&nj<=N&&map[ni][nj]!=1&&!v[ni][nj]){
        					v[ni][nj]=true;
        					findPassengerQ.add(new int[] {ni,nj,pos[2]+1});
        				}
        			}
        		}
        		
        	}
        	if(count!=m) possible=false;
        	if(!possible) break;
        }
        
        if(possible) {
        	System.out.println(fuel);
        }else {
        	System.out.println(-1);
        }
        
        
    }
}

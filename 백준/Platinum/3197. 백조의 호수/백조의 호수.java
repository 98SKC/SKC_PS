
import java.util.*;
import java.io.*;

public class Main {

	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {-1,0,1,0};
	
	public static int[][] swan; // 1, -1의 백조가 해당칸에 도착할 수 있는 턴.
	public static char[][] map; // 물과 얼음의 상태
	public static int R,C; //맵의 크기
	public static int ice;
	
	public static boolean find=false;
	
	//백조가 있을 수 있는 범위
	public static ArrayDeque<int[]> q=new ArrayDeque<>();
	
	//물의 좌표를 저장하는 큐
	public static ArrayDeque<int[]> w=new ArrayDeque<>();
	
	//녹을 얼음의 좌표를 저장하는 큐
	public static ArrayDeque<int[]> m=new ArrayDeque<>();
	
	//얼어서 못갔던 좌표를 기억
	public static HashMap<Integer,Integer> remember=new HashMap<>();
	
	public static boolean[][] v;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
         
        R=Integer.parseInt(st.nextToken()); //세로
        C=Integer.parseInt(st.nextToken()); //가로
        
        swan=new int[R][C];
        map=new char[R][C];
        v=new boolean[R][C];
        
        String[] str;
        int number=1;
        ice=0;
        
        for(int i=0;i<R;i++) {
        	str=br.readLine().split("");
        	for(int j=0;j<C;j++) {
            	map[i][j]=str[j].charAt(0);
            	if(map[i][j]=='L') {
            		swan[i][j]=number;
            		q.add(new int[] {i,j,number});
            		number*=-1;
            		map[i][j]='.';
            		v[i][j]=true;
            		w.add(new int[] {i,j});
            	}else if(map[i][j]=='.') {
            		v[i][j]=true;
            		w.add(new int[] {i,j});
            	}else ice++; 

            	
            }
        }

        int turn=0;
        while(ice>0){
        	
        	//백조가 이동한다.
        	searchSwan();
            //백조가 서로 만날 수 있다.
        	if(find) break;
        	
        	//얼음이 녹는다. 녹으면서 근처에 백조가 있으면 큐에 넣는다.
        	searchMelt();
        	melt();

        	
        	turn++;
//        	System.out.println(turn+" 맵의 상태");
//        	for(char[] mm:map) {
//        		System.out.println(Arrays.toString(mm));
//        	}
//        	System.out.println(turn+" 백조 상태");
//        	for(int[] mm:swan) {
//        		System.out.println(Arrays.toString(mm));
//        	}
//        	System.out.println("----------------------");
        	
        }
        
//        System.out.println("만난 상태: ");
//    	System.out.println(turn+" 맵의 상태");
//    	for(char[] mm:map) {
//    		System.out.println(Arrays.toString(mm));
//    	}
//    	System.out.println(turn+" 백조 상태");
//    	for(int[] mm:swan) {
//    		System.out.println(Arrays.toString(mm));
//    	}
        System.out.println(turn);
        //호수가 있고, 얼어있는 부분, 녹아있는 부분, 백조가 있는 부분이 있다.
        //녹은 곳들로 이동해서 백조끼리 만날 수 있는 일수를 구하는 문제
        //얼음과 물이 가로세로로 닿아있으면 녹는다.
    }
    
    
    
    
    public static void searchSwan(){//백조의 이동
        int[] p;
        int r,c;
        int number;
        int pi,pj;
    	while(!q.isEmpty()){
        	p=q.poll();
        	r=p[0];
        	c=p[1];
        	number=p[2];
        	
        	for(int a=0;a<4;a++) {
        		pi=r+di[a];
        		pj=c+dj[a];
        		//  맵 범위 내이고,              백조가 처음 왔으며      얼음이 아니면
//        		if(pi>=0&&pi<R&&pj>=0&&pj<C&&swan[pi][pj]==0&& map[pi][pj]!='X') {
//        			swan[pi][pj]=number;
//        			q.add(new int[] {pi,pj,number});
//        		}
        	//  맵 범위 내이고,             얼음이 아니면
        		if(pi>=0&&pi<R&&pj>=0&&pj<C){
        			if(map[pi][pj]=='X'){ //얼음이면
        				if(!remember.containsKey(pi*C+pj)){
            				remember.put(pi*C+pj,number);
            				//System.out.println("기억: "+pi+" "+pj);
        				}
        			}else{
            			// 백조가 처음 왔으면
            			if(swan[pi][pj]==0){
                			swan[pi][pj]=number;
                			q.add(new int[] {pi,pj,number});
                			
            			//다른 백조가 왔다면
            			}else if(swan[pi][pj]*swan[r][c]==-1) {
            				//System.out.println("만나는 곳: "+pi+" "+pj);
            				find=true;
            				return;
            			}
        			}
        		}
        	}
        	
        }
    	
    }
    
    public static void searchMelt(){//녹을 위치를 탐색
        int[] p;
        int r,c;
        int number;
        int pi,pj;
    	
    	while(!w.isEmpty()) {
        	p=w.poll();
        	r=p[0];
        	c=p[1];
        	for(int a=0;a<4;a++) {
        		pi=r+di[a];
        		pj=c+dj[a];
        		//  맵 범위 내이고,             얼음이면
        		if(pi>=0&&pi<R&&pj>=0&&pj<C&&map[pi][pj]=='X'&&!v[pi][pj]) {
        			v[pi][pj]=true;
        			m.add(new int[] {pi,pj});
        		}
        	}
    		
    	}
    	
    }
    
    public static void melt() {//녹는 작업을 적용
        int[] p;
        int r,c;
        int number;
        int pi,pj;
    	
    	while(!m.isEmpty()) {
        	p=m.poll();
        	r=p[0];
        	c=p[1];
        	w.add(new int[] {r,c});
        	map[r][c]='.';
    		ice--;
    		if(remember.containsKey(r*C+c)) {
    			q.add(new int[] {r,c,remember.get(r*C+c)});
    			swan[r][c]=remember.get(r*C+c);
    			remember.remove(r*C+c);
    		}
    	}
    	
    }
    
    
    
}



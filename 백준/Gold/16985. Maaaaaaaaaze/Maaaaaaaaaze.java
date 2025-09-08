
import java.util.*;
import java.io.*;

public class Main{

	//시뮬레이션 재활.
	//클래스 세분화 실천
    									//x번 판의 y회전 판의 상태 i,j
	public static int[][][][] cube=new int[5][4][5][5];
	public static int[][][] map=new int[5][5][5];
	public static int[] turn=new int[5];
	public static int[] perm=new int[5];
	public static boolean[] save=new boolean[5];
	public static int[] di=new int[] {0,1,0,-1,0,0};
	public static int[] dj=new int[] {1,0,-1,0,0,0};
	public static int[] dk=new int[] {0,0,0,0,1,-1};
	
	
	public static int answer=126;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        
        StringTokenizer st;
        //3차원 미로.
        //5*5 판이 5개 주어진다. (5*5*5 배열)
        //일부 칸은 침입이 불가능하다.
        //참가자는 판 하나를 시계방향 혹은 반 시계방향으로 자유롭게 회전할 수 있다. 뒤집을 수는 없다.
        //회전을 완료한 후 참가자는 판 5개를 쌓는다. 판을 쌓는 순서는 자유롭게 정할 수 있다.
        //큐브의 입구는 참가자가 임의로 선택한 꼭지점에 위치한 칸. 출구는 입구와 면을 공유하지 않는 꼭점에 위치한 칸이다.
        //참가자 중 본인이 설계한 미로를 가장 적은 이동 횟수로 탈출한 사람이 우승한다.
        //주어진 판에서 가장 적은 이동 횟수로 출구에 도달하려면 몇번 이동해야하는가?
        
        //1. 각 판을 어떻게 회전해서
        //2. 어떤 순서로 쌓아
        //3. 어느 꼭지점에서 출발할 것인가
        
        //Q. 모든 지도의 조합을 구하면 몇가지가 나오는가?
        //A. 한판에 4가지 모양으로 5판을 조합(1024). 각 순서가 다른 5!=120. 즉 122880개의 지도 모양. 입-출구 조합 4개. 1920개의 탐색을, 각 탐색당 최대 125번 탐색.
        //이것만 따졌을 때, 시간복잡도가 극적으로 크지는 않는다.
        //총 61,440,000.
        for(int k=0;k<5;k++) {
        	for(int i=0;i<5;i++) {
        		st=new StringTokenizer(br.readLine());
        		for(int j=0;j<5;j++) {
                	cube[k][0][i][j]=Integer.parseInt(st.nextToken());
                }
            }
        	turnCube(k);
        }

        int subTurn=1;
        out:
        for(int i=0;i<4;i++) {
        	for(int j=0;j<4;j++) {
        		for(int x=0;x<4;x++) {
        			for(int y=0;y<4;y++) {
        				for(int z=0;z<4;z++) {

        					subTurn++;
        					//각 판의 회전 상태를 고정
        				
        					fixTurn(i,j,x,y,z);
        					
        					//고정된 회전 상태를 기반으로 층을 재구성
        					fixCube(0);
        					
//        					if(i==0&&j==0&&x==0&&y==0&&z==1) {
//        						System.out.println("큐브 중간 점검:");
//        						for(int[][] m:map) {
//        							for(int[] mm:m) {
//        								System.out.println(Arrays.toString(mm));
//        							}
//        						}
//        						System.out.println();
//        					}
        					if(answer==13) break out;
                        }
                    }
                }
            }
        }

        
        //출입구 두 쌍에 대해 4번 bfs를 시작.
        
        if(answer==126) answer=0;
        System.out.println(answer-1);
        
        
    }
	
	//큐브의 한 판을 회전하여 저장한다.
	public static void turnCube(int floor) {
		ArrayDeque<Integer> q=new ArrayDeque<>();
		for(int a=1;a<4;a++) {
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					q.add(cube[floor][a-1][i][j]);
				}
			}
			
			for(int j=4;j>=0;j--) {
				for(int i=0;i<5;i++) {
					cube[floor][a][i][j]=q.poll();
				}
			}
		}
		
	}
	
	//층의 조합을 구한다. 즉 0,1,2,3,4 의 순열을 구한다.
	public static void fixCube(int cnt){
		//조합이 하나 나왔다면 map에 저장하고 bfs를 4번 시작
		//System.out.println("cnt가 5면 들어가야함 :"+cnt);
		if(cnt==5){

			makeCube();
			selectPoint();

			//System.out.println("cnt가 5라 들어옴");
			return;
		}
		
		for(int i=0;i<5;i++) {
			if(save[i]) continue;
		//	System.out.println("cnt: "+cnt);
			perm[cnt]=i;
			
			
			save[i]=true;
			
			fixCube(cnt+1);
			
			save[i]=false;
		}
		
		
        //판의 순서를 바꿔 map이라는 미로에 저장.
		
		
		
	}
	//회전과 층이 고정되면 map을 만든다.
	public static void makeCube(){
		
		int pos=0;//map의 1층에 사용될 판의 번호=perm[pos].
        for(int k=0;k<5;k++) {
        	for(int i=0;i<5;i++) {
        		for(int j=0;j<5;j++) {
        			map[k][i][j]=cube[perm[pos]][turn[perm[pos]]][i][j];
                }
            }
        	pos++;
        }
	}
	
	//각 판의 회전 상태를 정한다.
	public static void fixTurn(int i,int j,int x,int y,int z){// 이 회전 상태의 큐브를 
		turn[0]=i;
		turn[1]=j;
		turn[2]=x;
		turn[3]=y;
		turn[4]=z;
	}
	
	//출발점과 도착점을 고른다.
	public static void selectPoint() {
		//(0,0,0) - (4,4,4)
		//(0,4,0) - (4,0,4)
		//(0,0,4) - (4,4,0)
		//(0,4,4) - (4,0,0)
		
		//근데 다 풀고보니, 시작점 고정해놓으면 회전하면서 다 고려됨
		if(map[0][0][0]!=0&&map[4][4][4]!=0) {
			bfs(0,0,0,4,4,4);
		}
//		
//		if(map[0][4][0]!=0&&map[4][0][4]!=0) {
//			bfs(0,4,0,4,0,4);
//		}
//		
//		if(map[0][0][4]!=0&&map[4][4][0]!=0) {
//			bfs(0,0,4,4,4,0);
//		}
//			
//		if(map[0][4][4]!=0&&map[4][0][0]!=0) {
//			bfs(0,4,4,4,0,0);
//		}
		
	}
	
	
	public static void bfs(int sk,int si, int sj, int gk, int gi, int gj){//
		int[][][] v=new int[5][5][5];
		ArrayDeque<int[]> q=new ArrayDeque<>();
		q.add(new int[] {sk,si,sj,1});
		v[sk][si][sj]=1;
		int[] p;
		int ni,nj,nk;
		
		while(!q.isEmpty()) {
			p=q.poll();
			if(p[3]>=answer) break;
			for(int a=0;a<6;a++) {
				nk=p[0]+dk[a];
				ni=p[1]+di[a];
				nj=p[2]+dj[a];
				if(nk>=0&&nk<5&&nj>=0&&nj<5&&ni>=0&&ni<5&&map[nk][ni][nj]==1&&v[nk][ni][nj]==0){
					v[nk][ni][nj]=p[3]+1;
					q.add(new int[] {nk,ni,nj,v[nk][ni][nj]});
				}
				
			}
			
		}
		
//		if(sub&&sub2) {
//			System.out.println("큐브 중간 점검:");
//			for(int[][] m:v) {
//				for(int[] mm:m) {
//					System.out.println(Arrays.toString(mm));
//				}
//			}
//			System.out.println();
//		}
		
		if(v[gk][gi][gj]==0) return;
		
		answer=Math.min(answer,v[gk][gi][gj]);
		
		
	}
	
	
}

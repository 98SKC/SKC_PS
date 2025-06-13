
import java.util.*;
import java.io.*;

public class Main {
	
	public static char[][] map;
	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0};
	public static HashSet<Integer> teacher=new HashSet<>();
	public static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new char[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		map[i][j]=st.nextToken().charAt(0);
        		if(map[i][j]=='T') {
        			teacher.add(i*N+j);
        		}
        	}
        }
        int total=N*N;
        boolean possible=true;
        for(int i=0;i<total;i++) {
        	for(int j=i+1;j<total;j++) {
        		for(int k=j+1;k<total;k++) {
                	if(map[i/N][i%N]=='X'&&map[j/N][j%N]=='X'&&map[k/N][k%N]=='X') {
                		map[i/N][i%N]='O';
                		map[j/N][j%N]='O';
                		map[k/N][k%N]='O';
                		possible=true;
                		for(Integer t:teacher) {
                			possible=find(t/N,t%N);
                			if(!possible) break;
                		}
                		if(possible) {
                			System.out.println("YES");
                			return;
                		}
                		map[i/N][i%N]='X';
                		map[j/N][j%N]='X';
                		map[k/N][k%N]='X';

                	}
                }
            }
        }
        System.out.println("NO");
        //N*N 복도. 선생님들, 장애물, 학생들 위치
        //학생들은 3개의 장애물을 설치
        //3개 설치로 선생님에게 모든 학생이 안보일 수 있는지 출력
        
        //딱 붙어있는 ST가 있으면 불가능
        // 
        
    }
    
    public static boolean find(int pi,int pj) {// 이 선생님의 상하좌우 탐색에서 학생을 찾을 수 있는가?
    	int ni,nj;
    	for(int a=0;a<4;a++){//장애물을 만나거나, 맵을 넘을 때 까지 확장, 학생을 만나면 true를 반환
    		ni=pi+di[a];
    		nj=pj+dj[a];
    		
    		while(ni>=0&&ni<N&&nj>=0&&nj<N) {

    			if(map[ni][nj]=='S'){
    				return false;
    			}else if(map[ni][nj]=='O') {
    				break;
    			}
    			ni=ni+di[a];
    			nj=nj+dj[a];
    		}
    	}
    	return true;
    }
    
}

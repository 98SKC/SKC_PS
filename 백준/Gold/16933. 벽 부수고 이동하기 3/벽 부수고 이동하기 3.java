
import java.util.*;
import java.io.*;

public class Main {

	public static int[] di=new int[] {0,1,0,-1,0};
	public static int[] dj=new int[] {1,0,-1,0,0};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());// 벽을 부술 수 있는 수
        int[][] map=new int[N+1][M+1];
        String str;
        for(int i=1;i<=N;i++) {
        	str=br.readLine();
        	for(int j=1;j<=M;j++) {
        		map[i][j]=str.charAt(j-1)-'0';
        	}
        }
        
        int[][][][] dp=new int[N+1][M+1][K+1][2];// i,j를 k번 이하로 부셔서 올 수 있는 최소값. 밤 낮
        for(int a=0;a<2;a++) {
        	for(int i=1;i<=N;i++) {
        		for(int j=1;j<=M;j++) {
        			for(int k=0;k<=K;k++) {
        				dp[i][j][k][a]=Integer.MAX_VALUE;
        			}
        		}
        	}
        }
        dp[1][1][0][0]=1;// 출발 지점은 1
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.add(new int[] {1,1,0,1,0});// 0-pi, 1-pj, 2-k,3- 현 이동 거리 ,4-(0은 낮, 1은 밤)
        int[] p;
        int pi,pj,pk,pd,night;
        int ni,nj,nd,nextNight;
        int answer=-1;
        while(!q.isEmpty()) {
        	p=q.poll();
        	//System.out.println("루프 배열 확인: "+Arrays.toString(p));
        	pi=p[0];// 현i
        	pj=p[1];// 현j
        	pk=p[2];// 지금까지 벽 부순 수
        	pd=p[3];// 지금까지 움직인 칸 수
        	night=p[4];// 지금 밤 낮 상태
        	if(pi==N&&pj==M){
        		answer=pd;
        		break;
        	}
        	
        	nextNight=(night+1)%2;// 다음 밤 낮 변환
        	nd=pd+1;// 움직인 칸은 1 증가
        	for(int a=0;a<5;a++) {
        		ni=pi+di[a];// 다음 위치 i
        		nj=pj+dj[a];// 다음 위치 j
        		if(ni>0&&ni<=N&&nj>0&&nj<=M){//격자 내부일 때
        			if(map[ni][nj]!=1){//벽이 아니고
        				if(nd<dp[ni][nj][pk][nextNight]) {//지금 이동이 그 칸을 더 적게 올 수 있다면 이동한다
        					dp[ni][nj][pk][nextNight]=nd;
            				q.add(new int[] {ni,nj,pk,nd,nextNight});
        				}
        			}else{//벽이면 pk를 확인
        				//System.out.println("벽을 부술 수 없는 이유확인. 지금 밤낮: "+night+" 벽 부순 수: "+pk+" "+(pk<K)+" "+(night==0)+" "+(nd<dp[ni][nj][pk+1][nextNight]));
        				if((pk<K&&night==0&&nd<dp[ni][nj][pk+1][nextNight])||(a==4&&nd<dp[ni][nj][pk][nextNight])){//벽을 더 부술 수 있으며, 지금 낮이다. 혹은 지금 벽 부수고 와서 제자리 있는 경우
        					if(a!=4) {
        						dp[ni][nj][pk+1][nextNight]=nd;
            					q.add(new int[] {ni,nj,pk+1,nd,nextNight});
        					}else {
        						dp[ni][nj][pk][nextNight]=nd;
            					q.add(new int[]{ni,nj,pk,nd,nextNight});
        					}
        					
        				}
        			}
        		}
        		
        		
        	}
        	
        	
        }
        System.out.println(answer);
        
    }
}

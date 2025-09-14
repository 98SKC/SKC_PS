
import java.util.*;
import java.io.*;

public class Main {
	public static int[][] map;
	public static int[][] presum;
	public static int N,M;
	public static int A,B,C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        
        A=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        
        map=new int[N+1][M+1];
        presum=new int[N+1][M+1];
        
        for(int i=1;i<=N;i++) {
            st=new StringTokenizer(br.readLine());
        	for(int j=1;j<=M;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        for(int i=1;i<=N;i++) {
        	for(int j=1;j<=M;j++) {
        		presum[i][j]=map[i][j];
        		if(i>0) presum[i][j]+=presum[i-1][j];
        		if(j>0) presum[i][j]+=presum[i][j-1];
        		if(i>0&&j>0) presum[i][j]-=presum[i-1][j-1];
        	}
        }
        int answer=Integer.MAX_VALUE;
        answer=Math.min(answer,one());
        answer=Math.min(answer,two());
        answer=Math.min(answer,three());
        //파츠가 두개달린 차. 
        //너비는 같지만, 가로 길이는 다를 수 있다.
        //땅마다 흐림 정도가 있다. 차와 캠핑카가 차지하는 단위 구역의 흐림 정도 합이 낮을수록 맑다
        //가장 맑은 곳에 주차시키는 방법
        System.out.println(answer);
    }
    
    public static int one() {
    	int answer=Integer.MAX_VALUE;


    	int sub;
    	//일직선 모양의 차.
    	//우측 하단은 a,b+c
    	//차의 좌측 상단을 기준
    	for(int i=A;i<=N;i++){
        	for(int j=B+C;j<=M;j++) {
        		sub=getCloud(i, j, B+C, A);
        		if(sub==-1) continue;// 불가능
        		answer=Math.min(answer, sub);
        	}
    	}
    	
    	return answer;
    }
    
    public static int two() {
    	int answer=Integer.MAX_VALUE;
    	int sum;
    	int subA;
    	int subB;
    	//꺾이는 부분의 사각형의 좌측하단을 기준으로.
    	for(int i=A;i<N;i++){
        	for(int j=C;j<M;j++) {
        		//캠핑카
        		subA= getCloud(i, j-1, C, A);
        		if(subA==-1) continue;
        		//차
        		subB= getCloud(i+B, j+A-1, A, B);
        		if(subB==-1) continue;
        		sum=subA+subB;
        		answer=Math.min(answer, sum);
        	}
    	}
    	return answer;
    }
    
    public static int three() {
    	int answer=Integer.MAX_VALUE;
    	int sum;
    	int subA;
    	int subB;
    	//꺾이는 부분의 사각형의 좌측하단을 기준으로.
    	for(int i=A;i<N;i++){
        	for(int j=B;j<M;j++) {
        		//캠핑카
        		subA= getCloud(i, j-1, B, A);
        		if(subA==-1) continue;
        		//차
        		subB= getCloud(i+C, j+A-1, A, C);
        		if(subB==-1) continue;
        		sum=subA+subB;
        		answer=Math.min(answer, sum);
        	}
    	}
    	return answer;
    }
    
    //x,y좌표를 우측 하단으로 잡는, 가로 a, 세로 b의 범위를 구하는 메서드
    public static int getCloud(int x, int y, int a, int b){
    	int answer=-1;
        if(x<1||x>N||y<1||y>M) return -1;
    	if(x-b<0||y-a<0) return answer;
    	
    	answer=presum[x][y];
    	answer-=presum[x][y-a];
    	answer-=presum[x-b][y];
    	answer+=presum[x-b][y-a];
    	
    	
    	return answer;
    }
}



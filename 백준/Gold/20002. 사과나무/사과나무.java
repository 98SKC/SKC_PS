
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        int[][] appleFarm=new int[N][N];
        
        StringTokenizer st;
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
            	appleFarm[i][j]=Integer.parseInt(st.nextToken());
            }
        	
        }
        //N*N크기의 정사각형 모양 과수원이 있고,
        //사과나무가 1*1 크기의 간격으로 심어져 있다.
        //정사각형 범위로 사과를 수확할 때 최대 이윤
        //각 좌표의 이윤은 음수도 섞여있다.
        
        //브루드 포스
        //누적합의 응용
        //이 둘을 적절히 섞어야 할 것 같은데
        
        int[][] profit=new int[N][N];
        //profit[0][0]=appleFarm[0][0];
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
            	profit[i][j]+=appleFarm[i][j];
            	if(i>0) profit[i][j]+=profit[i-1][j];
            	if(j>0) profit[i][j]+=profit[i][j-1];
            	if(i>0&&j>0) profit[i][j]-=profit[i-1][j-1];
            }
        }
        
        
        int answer=-300000;
        
        int sub;
        
        for(int k=1;k<=N;k++) {			//정사각형 길이가 k일 때
        	for(int i=0;i<N;i++) {		//i,
            	for(int j=0;j<N;j++) {	//j를 우측아래 끝단으로 잡을 수 있다면
            		//그 정사각형의 이윤을 누적합으로 빠르게 구하고
            		//최댓값을 비교한다.
            		if((i+1)>=k && (j+1)>=k) {
            			sub=profit[i][j];
            			if(i>=k) sub-=profit[i-k][j];
            			if(j>=k) sub-=profit[i][j-k];
            			if(i>=k && j>=k) sub+=profit[i-k][j-k];
            			answer=Math.max(answer, sub);
            		}
            		
            	}
        	}
        }
        
        System.out.println(answer);
        
        
    }
}

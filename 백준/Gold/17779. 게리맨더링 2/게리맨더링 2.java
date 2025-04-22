
import java.util.*;
import java.io.*;

public class Main {

	public static int[][] map;
	public static int[][] preSum;
	public static int total=0;
	public static int N=0;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        //n * n 격자.  구역을 5구역으로 나누고, 각 구역은 그 중 하나에 포함
        // 같은 구역은 다 연결되어있음.
        map=new int[N+1][N+1];
        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=1;j<=N;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        		//System.out.println(map[i][j]);
        		total+=map[i][j];
        	}
        }
        
        preSum=new int[N+1][N+1];
        for(int i=1;i<=N;i++) {
        	for(int j=1;j<=N;j++) {
        		preSum[i][j]=map[i][j]+preSum[i][j-1];
        	}
        }
        

        int min=Integer.MAX_VALUE;
        //d1, d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N
        //위 for문에서 x랑 y는 고정 되었다고 하면.  d1+d2<=N-x   , d1<=y-1 ,  d2<=N-y
        for(int x=1;x<=N;x++){
        	for(int y=1;y<=N;y++) {
        		for(int d1=1;d1<=y-1;d1++) {
        			for(int d2=1;d2<=N-y;d2++) {
        				if (x + d1 + d2 > N) continue; // 이 조건이 추가되어야 함
        				min=Math.min(min, gerrymandering(x, y, d1, d2));
        			}
        		}
        	}
        }
        System.out.println(min);
        
    }
    
    public static int gerrymandering(int x,int y,int d1, int d2) {
 //       int[][] copy = new int[N+1][N+1];

        // 2) 1번 구역 표시
        int point = y;
//        for (int r = 0; r < x + d1; r++) {
//            for (int c = 1; c <= point; c++) {
//                copy[r][c] = 1;
//            }
//            if (r >= x-1) point--;
//        }
//
//        // 3) 2번 구역 표시
//        point = y;
//        for (int r = 0; r <= x + d2; r++) {
//            for (int c = point + 1; c <= N; c++) {
//                copy[r][c] = 2;
//            }
//            if (r >= x) point++;
//        }
//
//        // 4) 3번 구역 표시
//        point = y - d1-1;
//        for (int r = x + d1; r <= N; r++) {
//            for (int c = 1; c <= point; c++) {
//                copy[r][c] = 3;
//            }
//            if(point<y-d1+d2-1)  point++;
//        }
//
//        // 5) 4번 구역 표시
//        point = y + d2;
//        for (int r = x + d2+1; r <= N; r++) {
//            for (int c = point; c <= N; c++) {
//                copy[r][c] = 4;
//            }
//            if(point>y-d1+d2) point--;
//        }
//
//        // 6) 결과 출력
//        System.out.println("=== zone map for x="+x+" y="+y+" d1="+d1+" d2="+d2+" === N: "+N);
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(copy[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

    	
    	
    	
    	int answer=0;
    	int a=0;//1번구역
    	int b=0;//2번구역
    	int c=0;//3번구역
    	int d=0;//4번구역
    	int e=total;//5번구역
    	//a는 좌측 상단부분. 열부분은 1부터 시작해 y와 걸치고, 행은 1부터 시작해 x+d1보다 작다
    	point=y;
    	
    	for(int r=0;r<x+d1;r++) {// 행을 내려감
    		a+=preSum[r][point];
    		if(r>=x-1) point--;  
    	}
    	e-=a; //e는 total에서 abcd를 뺸 값
    	//b는 우측 상단 부분, 열부분 y+1부터 시작해 N까지, 행은 1부터 시자해 x+d2를 포함
    	point=y;
    	for(int r=0;r<=x+d2;r++) {// 행을 내려감
    		b+=preSum[r][N]-preSum[r][point];
    		if(r>=x) point++; 
    	}
    	e-=b;
    	//c는 좌측 하단 부분, 열부분은 1부터 y-d1+d2 전까지, 행은 x+d1을 시작으로 N까지
    	point =y-d1-1;
    	for(int r=x+d1;r<=N;r++) {
    		c+=preSum[r][point];
    		 if(point<y-d1+d2-1) point++;    		 
    	}
    	e-=c;
    	//d는 우측 하단 부분, 열부분은 y-d1_d2부터 시작해 N까지. 행은 x+d2부터 N을 포함
    	point = y + d2;
    	for(int r=x+d2+1;r<=N;r++) {
    		d+=preSum[r][N]-preSum[r][point-1];
    		if(point>y-d1+d2) point--;
    	}
    	e-=d;
    	//e는 total에서 위를 모두 뺀 값
    	int max=Math.max(a, b);
    	max=Math.max(max, c);
    	max=Math.max(max, d);
    	max=Math.max(max, e);
    	
    	int min=Math.min(a, b);
    	min=Math.min(min, c);
    	min=Math.min(min, d);
    	min=Math.min(min, e);
//    	System.out.println(x+" "+y+" "+d1+" "+d2);
//    	System.out.println(a+" "+b+" "+c+" "+d+" "+e);
//    	System.out.println("어디서: "+(max-min));
   	
    	return max-min;
    }
}




















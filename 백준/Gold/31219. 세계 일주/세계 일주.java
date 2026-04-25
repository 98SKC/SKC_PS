import java.io.*;
import java.util.*;

public class Main {

	public static int N;
	public static double[][] dist;
	public static int[][] point;
	public static double[][] dp;
	public static int c;
	public static double answer=Double.MAX_VALUE;
	public static ArrayList<int[]> v=new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N=Integer.parseInt(br.readLine());
        point=new int[N][2];
        c=(int)Math.pow(2, N)-1;
        dp=new double[N][c+1];
        dist=new double[N][N];
        StringTokenizer st;
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	point[i][0]=Integer.parseInt(st.nextToken());
        	point[i][1]=Integer.parseInt(st.nextToken());
    
        }
        
        for(int i=0;i<N;i++) {
        	for(int j=i+1;j<N;j++) {
        		double d=calDist(i, j);
        		dist[i][j]=d;
        		dist[j][i]=d;
            }
        }
        
        for(double[] sub:dp) {
        	Arrays.fill(sub, -1);
        }
        
        
        //dp[i][j]는 i 위치에 있는 j상태에서, 나머지를 모두 방문하는데 필요한 최소 코스트
        
        
        
        // n개의 국가. 
        calTSP(0,1,0);
        
        if(answer==Double.MAX_VALUE) answer=-1;
        System.out.println(answer);
        
    }
    
    public static void calTSP(int p, int state,double d) {
    	if(state==c){
    		
    		answer=Math.min(answer,d+dist[p][0]);
    		return;
    	}
    	
    	for(int i=1;i<N;i++) {
    		int next=(int)Math.pow(2, i);
    		if((state&next)==next) continue;// 방문한 곳이면 스킵
    		
    		//그 점을 가기위해 이미 방문한 점을 방문해야한다면 스킵
    		//if(crossCheck(p,i)) continue;
    		
    		int sub=state|next;
    		
    		if(dp[i][sub]!=-1&&dp[i][sub]<=d+dist[p][i]) continue;
    		dp[i][sub]=d+dist[p][i];
    		v.add(new int[] {p,i});
    		calTSP(i,sub,d+dist[p][i]);
    		v.remove(v.size()-1);
    		
    	}
    	
    }
    
    public static boolean crossCheck(int s, int e) {
    	
    	for(int[] sub:v) {
    		//선분 se 가 지금까지의 선분 sub[0]sub[1]을 지나는가.
    		if(CCW(sub[0],sub[1],s)*CCW(sub[0],sub[1],e)<0&&CCW(s,e,sub[0])*CCW(s,e,sub[1])<0) return true;
    	
    	}
    	
    	return false;
    }
    
    public static int CCW(int a, int b, int c) {
    	int x1=point[a][0];
    	int y1=point[a][1];
    	
    	int x2=point[b][0];
    	int y2=point[b][1];
    	
    	int x3=point[c][0];
    	int y3=point[c][1];
    	
    	return (x2-x1)*(y3-y1)-(y2-y1)*(x3-x1);
    	
    	
    }
    
    public static double calDist(int p1, int p2) {
    	int d1=point[p1][0]-point[p2][0];
    	int d2=point[p1][1]-point[p2][1];
    	
    	return Math.sqrt(Math.pow(d1, 2)+Math.pow(d2, 2));
    	
    }

}


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        //초기 위치
        
        double x=Float.parseFloat(st.nextToken());
        double y=Float.parseFloat(st.nextToken());
        
        st=new StringTokenizer(br.readLine());
        
        //목표
        double goalX=Float.parseFloat(st.nextToken());
        double goalY=Float.parseFloat(st.nextToken());
        
        //대포 개수
        int N=Integer.parseInt(br.readLine());
        double[][] map=new double[N+2][2];
        map[0][0]=x;
        map[0][1]=y;
        double[] dijk=new double[N+2];
        dijk[0]=0;
        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	map[i][0]=Float.parseFloat(st.nextToken());
        	map[i][1]=Float.parseFloat(st.nextToken());
        	dijk[i]=Float.MAX_VALUE;
        }
        dijk[N+1]=Float.MAX_VALUE;
        map[N+1][0]=goalX;
        map[N+1][1]=goalY;
        //각 좌표로의 이동거리.
        
        //그냥 걷거나 , 그냥 대포에 타서 도착하거나 ,대포까지 걸어가서, 탑승하고, 날아가서, 걸어간다.
        //가중치는 시간.
        PriorityQueue<double[]> pq=new PriorityQueue<>(new Comparator<double[]>() {
        	@Override
        	public int compare (double[] o1,double[] o2) {
        		return Double.compare(o1[1], o2[1]);
        	}
        });
        
        pq.add(new double[] {0,0});

        double[] p;
        double min;
        boolean[] v=new boolean[N+2]; //0은 출발지. N+1은 도착지
        while(!pq.isEmpty()) {
        	p=pq.poll();
        	if(p[1]>dijk[(int)p[0]]) continue;
        	
        	for(int i=0;i<N+2;i++) {
        		if(i==p[0]) continue;
        		//초당 5m, 대포타면 2초 50m
        		if(p[0]==0) {//처음에는 대포에 있지 아니함. 목표지점은 반복문이 끝날 것이니 고려하지 않는다.
        			//무조건 걸어서 감.
        			min=distance(map[0][0],map[0][1],map[i][0],map[i][1])/5;
        			if(dijk[i]>min+p[1]) {
        				dijk[i]=min+p[1];
        				pq.add(new double[] {i,dijk[i]});
        			}
        		}else {// 날아가고, 다음 지점까지 걸어감.
        			double dis=distance(map[(int)p[0]][0],map[(int)p[0]][1],map[i][0],map[i][1]);
        			//이 거리를 걸어갈 경우. 
        			
        			min=Math.min(dis/5, (Math.abs(dis-50)/5)+2);
        			if(dijk[i]>min+p[1]) {
        				dijk[i]=min+p[1];
        				pq.add(new double[] {i,dijk[i]});
        			}
        		}
        	}
        	
        }
        //System.out.println(Arrays.toString(dijk));
        System.out.print(dijk[N+1]);
        
    }
    
    
    public static double distance(double x1,double y1,double x2, double y2) {
    	
    	double x=Math.pow(x2-x1, 2);
    	double y=Math.pow(y2-y1, 2);

    	return Math.sqrt(x+y);
    	
    	
    }
}

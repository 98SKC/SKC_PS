
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        PriorityQueue<double[]> pq=new PriorityQueue<>(new Comparator<double[]>() {
        	@Override
        	public int compare(double[] o1, double[] o2) {
        		return Double.compare(o1[1], o2[1]);// 정렬자체는 양수 음수가 중요해서 형변환 시 손실 감안
        	}
        });
        
        
        StringTokenizer st;
        double[][] point=new double[N][2];
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	point[i][0]=Double.parseDouble(st.nextToken());
        	point[i][1]=Double.parseDouble(st.nextToken());
        	
        }
        
        boolean[] v=new boolean[N];
        pq.add(new double[] {0,0});
        
        double[] p;
        int cnt=0;
        double answer=0;
        
        while(!pq.isEmpty()) {
        	p=pq.poll();
        	if(v[(int)p[0]]) continue;
        	v[(int)p[0]]=true;
        	cnt++;
        	answer+=p[1];
        	if(cnt==N) break;
        	for(int i=0;i<N;i++) {
        		if(v[i]) continue;
        		pq.add(new double[] {i,distance(point[(int)p[0]][0],point[(int)p[0]][1],point[i][0],point[i][1])});
        	}
        }
        
        System.out.printf("%.2f",answer);
        
    }
    
    public static double distance(double x1,double y1,double x2, double y2) {
    	double x=Math.pow(x2-x1, 2);
    	double y=Math.pow(y2-y1, 2);
    	
    	
    	return Math.sqrt(x+y);
    	
    	
    }
}

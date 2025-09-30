
import java.util.*;
import java.io.*;

public class Main {

	public static class Point{
		//int id;
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
			
		}
	}
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        
        Point[] point=new Point[N];
        StringTokenizer st;
        
        int x,y;
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	x=Integer.parseInt(st.nextToken());
        	y=Integer.parseInt(st.nextToken());
        	
        	point[i]=new Point(x,y);
        }
        
        Arrays.sort(point,Comparator.comparingInt(p->p.x));
        
        
        int left=0;
        Point cur;
        long dx;
        long best=Long.MAX_VALUE;
        
        TreeSet<Point> setByY=new TreeSet<>(new Comparator<Point>() {
        	@Override
        	public int compare(Point p1, Point p2) {
        		if(p1.y==p2.y) {
        			return Integer.compare(p1.x, p2.x);
        		}
        		return Integer.compare(p1.y, p2.y);
        	}
        
        });   // y→x 정렬
        Point low, high;

        for(int i=0;i<N;i++) {// i가 피봇
        	cur=point[i];
        	
            while(left<i){//충분히 가까운 x좌표들만 범위
                dx=(long)cur.x-point[left].x;
                if(best!=Long.MAX_VALUE&&dx*dx>best) {
                   setByY.remove(point[left]);
                   left++;
                }else break;
            }
            
            //지나온 점들 중 y좌표가 비슷한 부분만 비교
            if(!setByY.isEmpty()) {
                double r = Math.sqrt((double)best);
                low  = new Point(Integer.MIN_VALUE,(int)Math.floor(cur.y - r));
                high = new Point(Integer.MAX_VALUE,(int)Math.ceil(cur.y + r));
                for (Point cand : setByY.subSet(low, true, high, true)) {
                    long d2 = dist(cur, cand);        // dx,dy 모두 long
                    if (d2 < best) best = d2;
                }
            }
            
            
            //현재 점을 후보 세트에 추가(다음 점들과 비교 대상이 됨)
            setByY.add(cur);
        }
        
        System.out.println(best);
        
    }
       
    
    public static long dist(Point p1, Point p2) {
    	long dx=(long)p1.x-p2.x;
    	long dy=(long)p1.y-p2.y;
    	return dx*dx+dy*dy;
    }
    
}



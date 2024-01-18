import java.io.*;
import java.util.*;

public class Main {
    

    public static void main(String[] args) throws IOException {
        StringBuilder sb=new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int x1,y1,r1,x2,y2,r2;
        for(int test_case=1;test_case<=T;test_case++) {
            st=new StringTokenizer(br.readLine());
            
            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            r1=Integer.parseInt(st.nextToken());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());
            r2=Integer.parseInt(st.nextToken());
            sb.append(searchHelper(x1, x2, y1, y2, r1, r2)).append("\n");
            
        }
      
        System.out.println(sb);
    }
    
   static int searchHelper(int x1,int x2,int y1,int y2,int r1,int r2) {//루트 하지말고 제곱 상태 그대로 두자

			int distance_pow = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));	// 중점간 거리 distance의 제곱 
	 
			//중점이 같으면서 반지름도 같으면 접점이 무한
			if(x1 == x2 && y1 == y2 && r1 == r2) {
				return -1;
			}
			
			// 두 원의 반지름 합보다 중점간 거리가 멀면 만나지 않는다. 접점이 없다 
			else if(distance_pow > Math.pow(r1 + r2, 2)) {
				return 0;
			}
	 
			//원 안에 원이 있으나 내접하지 않을 때 . 원안에 원이 안닿아 있을 때.
			else if(distance_pow < Math.pow(r2 - r1, 2)) {
				return 0;
			}
	
			// 내접할 때 
			else if(distance_pow == Math.pow(r2 - r1, 2)) {
				return 1;
			}
	        
			// 외접할 때 
			else if(distance_pow == Math.pow(r1 + r2, 2)) {
				return 1;
			}

			else {// 그외 는 사그리 점 두개.
				return 2;
			}
			
		
   }
 
    
}
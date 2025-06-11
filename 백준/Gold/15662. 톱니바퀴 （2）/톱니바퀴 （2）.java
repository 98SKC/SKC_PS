
import java.util.*;
import java.io.*;

public class Main {

	//public static int[][] order;
	public static int[] gear;
	public static int N,K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        gear=new int[N];
        String str;
        //3시 방향 인덱스 =2, 9시 방향 인덱스=6
        for(int i=0;i<N;i++) {
        	str=br.readLine();
        	for(int j=0;j<8;j++) {
        		if((str.charAt(j)-'0')==1) {
        			gear[i] |= (1 << j);
        		}
        	}
        }
        
        K=Integer.parseInt(br.readLine());
        //order=new int[K][2];
        StringTokenizer st;
        int p;
        int dir;
        for(int i=0;i<K;i++) {
        	st=new StringTokenizer(br.readLine());
        	p=Integer.parseInt(st.nextToken())-1;
        	dir=Integer.parseInt(st.nextToken());
        	
        	//dir방향으로 돌리고,

        	//반대쪽은 그 방향에 맞게 오른쪽 기어부터
//        	if (p < N - 1&& ((gear[p]  & (1 << 2))== (gear[p+1] & (1 << 6)))){ //p오른쪽에 기어가 있고, p의 2번과, p+1의 6번이 같으면, dir의 반대로
//        		left(p,dir);// p는 돌아가야만 하니 필수
//        		right(p+1,dir*-1);
//        	}else {
//            	left(p,dir);// p는 돌아가야만 하니 필수
//        	}
        	if (p < N - 1 
        		    && (((gear[p]   >>> 2) & 1)    // p의 2번 비트 → 0 or 1
        		      != ((gear[p+1] >>> 6) & 1))) // p+1의 6번 비트 → 0 or 1
        		{
        		    left(p,   dir);
        		    right(p+1, -dir);
        		} else {
        		    left(p, dir);
        		}
        	
        }
        int answer=0;
        for(int i=0;i<N;i++) {
        	if((gear[i]&1)==1) {
        		answer++;
        	}
        }
        System.out.println(answer);
        
    }
    
    
    public static void left(int p, int dir) {//p 위치의 톱니를 왼쪽으로
    	//p가 0보다 클 때, p의 6번과, p-1의 2번이 같으면 left를 재귀. 이 때 dir은 바뀜
    	boolean shouldContinue=false;
    	//if(p>0&&(gear[p]&(1<<6))!=(gear[p-1]&(1<<2))) shouldContinue=true;
    	if (p > 0 
    		    && (((gear[p]   >>> 6) & 1)    // p의 6번 비트
    		      != ((gear[p-1] >>> 2) & 1))) // p-1의 2번 비트
    		{
    		    shouldContinue = true;
    		}
    	int change;
    	//76543210
    	//07654321  시계방향
    	
    	if (dir != 1) { // 시계 방향 회전
    	    int lsb = gear[p] & 1;                // 0 또는 1
    	    // 2) 오른쪽으로 한 칸 쉬프트 후, LSB를 비트 7 위치로 이동
    	    change = (gear[p] >>> 1) | (lsb << 7);
    	    
    	    gear[p] = change;
    	} else {      // 반시계 방향 회전
    	    // 1) 맨 위 비트 추출
    	    int msb = (gear[p] >>> 7) & 1;        // 0 또는 1
    	    
    	    // 2) 왼쪽으로 한 칸 쉬프트 후, MSB를 비트 0 위치로 이동
    	   // change = ((gear[p] << 1)) | msb;
    	    change = ((gear[p] << 1)) | msb;

    	    gear[p] = change;
    	}
    	
    	if(shouldContinue) left(p-1,dir*-1);
    	
    	
    }
    
    public static void right(int p, int dir) {//p 위치의 톱니를 오른족으로
    	//p가 N-1보다 작을 때, p의 2번과, p+1의 6번이 같으면 right를 재귀. 이 때 dir은 바뀜
    	
    	boolean shouldContinue=false;
    	//if(p<N-1&&(gear[p]&(1<<2))!=(gear[p+1]&(1<<6))) shouldContinue=true;
    	if (p < N - 1
    		    && (((gear[p]   >>> 2) & 1)    // p의 2번 비트
    		      != ((gear[p+1] >>> 6) & 1))) // p+1의 6번 비트
    		{
    		    shouldContinue = true;
    		}
    	int change;
    	
    	//76543210
    	//07654321  시계방향
    	if (dir != 1) { // 시계 방향 회전
    	    int lsb = gear[p] & 1;                // 0 또는 1
    	    // 2) 오른쪽으로 한 칸 쉬프트 후, LSB를 비트 7 위치로 이동
    	    change = (gear[p] >>> 1) | (lsb << 7);
    	    
    	    gear[p] = change;
    	} else {      // 반시계 방향 회전
    	    // 1) 맨 위 비트 추출
    	    int msb = (gear[p] >>> 7) & 1;        // 0 또는 1
    	    
    	    // 2) 왼쪽으로 한 칸 쉬프트 후, MSB를 비트 0 위치로 이동
    	    //change = ((gear[p] << 1)) | msb;
    	    change = ((gear[p] << 1)) | msb;
    	    gear[p] = change;
    	}
    	
    	if(shouldContinue) right(p+1,dir*-1);
    	
    }
    
    
}

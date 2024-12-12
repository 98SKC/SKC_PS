import java.util.*;
import java.awt.Container;
import java.io.*;

public class Main {

	public static int[][] robot;
	public static int[][] container;
	public static int N,K;
	public static int answer=0;
	public static int count=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
  
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        container=new int[2][N];
        robot=new int[2][N];
        
        st=new StringTokenizer(br.readLine());
        //System.out.println("N: "+N);
        for(int i=0;i<N;i++) {
        	container[0][i]=Integer.parseInt(st.nextToken());
        	
        	//System.out.println(container[0][i]);
        }
        // [0][0]이 올리는 위치
        // [0][N-1]이 내리는 위치
        
        for(int i=N-1;i>=0;i--) {
        	container[1][i]=Integer.parseInt(st.nextToken());
        }
        
        while(count<K) {
        	answer++;
        	move();
        	
//        	System.out.println(answer+"라운드 로봇: ");
//        	for(int[] arr:robot) {
//        		System.out.println(Arrays.toString(arr));
//        	}
//        	
//        	System.out.println(answer+"라운드 내구도: ");
//        	for(int[] arr:container) {
//        		System.out.println(Arrays.toString(arr));
//        	}
//        	
//        	System.out.println("--------------");
//        	System.out.println(count);
        }
        System.out.println(answer);
        
    }
    
    
    public static void turn(int[][] arr) {
    	int posN=arr[0][N-1];
    	
    	for(int i=N-1;i>0;i--) {
    		arr[0][i]=arr[0][i-1];
    	}
    	
    	arr[0][0]=arr[1][0];
    	
    	for(int i=0;i<N-1;i++) {
    		arr[1][i]=arr[1][i+1];
    	}
    	
    	arr[1][N-1]=posN;
    	
    }
    public static void executionTrun() {
    	// 컨테이너가 돈다.
    	turn(container);
    	
    	
    	
    	//로봇이 돈다.
    	turn(robot);
    	
    }
    
    
    public static boolean checkMoving(int i,int j) {
    	if(i==0&&j<N) {
    		if(robot[i][j+1]==0&&container[i][j+1]>=1) {
    			return true;
    		} 
    	}
//    	else if(i==0&&j==(N-1)) {
//    		if(robot[1][N-1]==0&&container[1][N-1]>=1) {
//    			return true;
//    		}
//    	}else if(i==1&&j<(N-1)&&j!=0) {
//    		if(robot[1][j-1]==0&&container[1][j-1]>=1) {
//    			return true;
//    		}
//    	}else{
//    		if(robot[0][0]==0&&container[0][0]>=1) {
//    			return true;
//    		}
//    	}
    	
    	return false;
    }
    
    
    public static void move() {
    	
    	// 벨트가 각 칸 윈에 있는 로봇과 함께 한 칸 회전한다.
    	executionTrun();
    	
    	if(robot[0][N-1]!=0) {
    		robot[0][N-1]=0;
    	}
    	
    	// 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있으면 이동한다.
    	
    	for(int i=N-2;i>=0;i--) {
    		if(checkMoving(0,i)&&robot[0][i]==1) {// 이동할 수 있으면 로봇을 이동
    			robot[0][i+1]=robot[0][i];
    			robot[0][i]=0;
    			container[0][i+1]--;
    			if(container[0][i+1]==0) count++;
    		}
    	}
    	
    	if(robot[0][N-1]!=0) {
    		robot[0][N-1]=0;
    	}
    	
    	//올리는 위치에 내구도가 0이 아니면 로봇을 올린다.
    	if(container[0][0]!=0) {
        	robot[0][0]=1;
        	container[0][0]--;
        	if(container[0][0]==0) count++;
    	}

    	
    	
    }
}
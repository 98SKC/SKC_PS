import java.io.*;
import java.util.*;

public class Solution

{
	static char[][] map;
	static int[] tank=new int[3];// 0:i i:j 2:방향.   (0-위 1-오른쪽 2-아래 -왼쪽)
	static int[] di= {-1,0,1,0};
	static int[] dj= {0,1,0,-1};
	static int H,W;
	
	
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st;
    	int T=Integer.parseInt(br.readLine());
    
    	
    	for(int tc=1;tc<=T;tc++) {
    		st=new StringTokenizer(br.readLine());
    		H=Integer.parseInt(st.nextToken());
    		W=Integer.parseInt(st.nextToken());
    		map=new char[H][W];
    		
    		
    		String str;
    		
    		for(int h=0;h<H;h++) {
    			str=br.readLine();
    			for(int w=0;w<W;w++) {
        			map[h][w]=str.charAt(w);
        			if(map[h][w]=='^') {
        				tank[0]=h;
        				tank[1]=w;
        				tank[2]=0;
        			}else if(map[h][w]=='>') {
        				tank[0]=h;
        				tank[1]=w;
        				tank[2]=1;
        			}else if(map[h][w]=='v') {
        				tank[0]=h;
        				tank[1]=w;
        				tank[2]=2;
        			}else if(map[h][w]=='<') {
        				tank[0]=h;
        				tank[1]=w;
        				tank[2]=3;
        			}
        			
        		}	
    		}
    		
    		int N=Integer.parseInt(br.readLine());
    		
    		String oper=br.readLine();
    		for(int i=0;i<oper.length();i++) {
    			switch(oper.charAt(i)) {
    	    	case 'U':
    	    		turn(0);
    	    		break;
    	    	case 'D':
    	    		turn(2);
    	    		break;
    	    	case 'L':
    	    		turn(3);
    	    		break;
    	    	case 'R':
    	    		turn(1);
    	    		break;
    	    	case 'S':
    	    		Shoot();
    	    	}
    		}

    		sb.append("#").append(tc).append(" ");
    		for(int h=0;h<H;h++) {
    			for(int w=0;w<W;w++) {
    				sb.append(map[h][w]);
    			}
    			sb.append("\n");
    		}
    	}
    	System.out.println(sb);
       
    }

    static void turn(int dir) {

    	tank[2] = dir; // 방향을 위쪽으로 업데이트
        int nextI = tank[0] + di[tank[2]];
        int nextJ = tank[1] + dj[tank[2]];
        if(nextJ >= 0 && nextJ < W &&nextI >= 0 && nextI < H && map[nextI][nextJ] == '.') { // 맵 안쪽이고 다음 위치가 평지라면
            map[tank[0]][tank[1]] = '.'; // 현재 위치를 평지로 변경
            tank[0] = nextI; // 위치 업데이트
            tank[1] = nextJ; 
        } 
        switch(dir) {
        	case 0:
        		 map[tank[0]][tank[1]] = '^';
        		break;
        	case 1:
        		map[tank[0]][tank[1]] = '>'; 
        		break;
        	case 2:
        		 map[tank[0]][tank[1]] = 'v'; 
        		break;
        	case 3:
        		 map[tank[0]][tank[1]] = '<';
        		break;
        }
        
        
    }
    
    static void Shoot() {

        int boomI = tank[0] + di[tank[2]];
        int boomJ = tank[1] + dj[tank[2]];
        while(boomI >= 0 && boomI < H && boomJ >= 0 && boomJ < W) { // 맵 안쪽인지 체크
            if(map[boomI][boomJ] == '*') { // 벽돌 벽을 만나면 파괴하고 중단
                map[boomI][boomJ] = '.';
                break;
            } else if(map[boomI][boomJ] == '#') { // 강철 벽을 만나면 아무 일도 일어나지 않고 중단
                break;
            }
            // 다음 칸으로 포탄 이동
            boomI += di[tank[2]];
            boomJ += dj[tank[2]];
        }
    }
    
    

}

import java.util.*;
import java.io.*;

public class Main {

	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0}; //우 아래 좌 위
	public static HashSet<Integer> visit=new HashSet<>();
	
	public static char[][] map=new char[5][5];
	public static boolean[][] v=new boolean[5][5];
	
	public static int answer=0;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        for(int i=0;i<5;i++) {
        	str=br.readLine();
        	for(int j=0;j<5;j++) {
        		map[i][j]=str.charAt(j);
        	}
        }
        ArrayDeque<int[]> q=new ArrayDeque<>(); 
        int[] p;
        int pi, pj, status;
        //격자가 주어졌을 때 가로세로 연결로 만들 수 있는 조합 중 s가 적어도 4명이상 포함된 모양의 개수를 출력하는 문제
        int S,Y,pos;
        for(int i=0;i<5;i++) {
        	for(int j=0;j<5;j++) {
        		pos=i*5+j;
        		if(map[i][j]=='S') {
        			S=1;
        			Y=0;
        		}else {
        			Y=1;
        			S=0;
        		}
        		
        
        		q.add(new int[] {S,Y,1<<pos});
        		
        		while(!q.isEmpty()) {
        	    	p=q.poll();
        			int ni,nj;
        	    	int next;
        	    	

        	    	S=p[0];
        	    	Y=p[1];
        	    	status=p[2];
        	    	
        	    	if(S+Y==7){
        	    		answer++;
    	    			continue;
        	    	}
        	    	
        	    	for(int k=0;k<25;k++) {
        	    		if ((status & (1 << k)) == 0) continue; // 선택되지 않은 칸이면 패스
            	    	pi=k/5;
            	    	pj=k%5;
        	    		for(int a=0;a<4;a++) {
            	    		ni=pi+di[a];
            	    		nj=pj+dj[a];
            	    		pos=ni*5+nj;// 이 조합의 비트
            	    		next=status|(1<<pos);
            	    		if(ni>=0&&ni<5&&nj>=0&&nj<5&&!visit.contains(next)){
            	    			pos=ni*5+nj;// 이 조합을 비트에 추가
            	    			visit.add(next);
            	    			if(map[ni][nj]=='S') q.add(new int[] {S+1,Y,next});
            	    			else if(map[ni][nj]=='Y'&&Y<3) q.add(new int[] {S,Y+1,next});

            	    		}
            	    		
            	    	}
        	    	}
        	    	

        		}
        	
        	}
        }
        
        System.out.println(answer); 
        
 
    }

    
}

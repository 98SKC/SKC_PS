import java.io.*;
import java.util.*;

public class Main {
	//								 남, 동  북  서  즉 L이면 +1, R이면 -1 
	public static int[] di=new int[] {1, 0, -1, 0};
	public static int[] dj=new int[] {0, 1, 0, -1};

	public static int left=0;
	public static int right=0;
	public static int top=0;
	public static int bottom=0;
	
	public static int startI=0;
	public static int startJ=0;
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N=Integer.parseInt(br.readLine());
        String str=br.readLine();
        int len=str.length();
        int dir=0;
        int pi=startI;
        int pj=startJ;
        char op;
        for(int i=0;i<len;i++) {
        	op=str.charAt(i);
        	if(op=='F') {
        		pi+=di[dir];
        		pj+=dj[dir];
        		top=Math.min(top,pi);
        		bottom=Math.max(bottom,pi);
        		left=Math.min(left, pj);
        		right=Math.max(right, pj);
        		
        	}else {
        		dir=calDir(dir,op);
        	}
        	
        }
        
        bottom-=top;
        right-=left;
        
        startI-=top;
        startJ-=left;
        top=0;
        left=0;
        char[][] map=new char[bottom+1][right+1];
        for(int i=0;i<=bottom;i++) {
        	Arrays.fill(map[i], '#');
        }
//        for(int i=0;i<=bottom;i++) {
//        	for(int j=0;j<=right;j++) {
//        		sb.append(map[i][j]);
//        	}
//        	sb.append("\n");
//        }
//        sb.append("\n");
        dir=0;
        pi=startI;
        pj=startJ;
//        System.out.println("높이: "+bottom+" 너비: "+right);
//        System.out.println("시작: "+pi+" "+pj);
		map[pi][pj]='.';
        for(int i=0;i<len;i++) {
        	op=str.charAt(i);
        	if(op=='F') {
        		pi+=di[dir];
        		pj+=dj[dir];
        		map[pi][pj]='.';

        	}else {
        		dir=calDir(dir,op);
        	}
        	
        }
        
        for(int i=0;i<=bottom;i++) {
        	for(int j=0;j<=right;j++) {
        		sb.append(map[i][j]);
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
        //미로 안의 한칸에서 남쪽을 보고있다.
        //미로는 직사각형 격자
        //각 칸은 이동가능하거나, 벽이 있음
        //모든 행과 열에는 적어도 하나의 이동 가능한 칸이 있다.
        
        //전진하거나, 회전하거나 가능
        
        
        //이동 가능한 곳 다 갔다고 할 때 당사자 입장에서의 지도
        //지도크기 무한히 늘리면 여러개 나오겠지만
        //이동한 당사자가 느끼는 지도를 그린다 생각
        
        //문제점은 배열이라던가 미리 선언이 불가능 하다는거
        //출발점을 어디라 확신을 못하기에
        
        //시작 좌표를 (0,0)으로 해놓고.
        // 가장 왼쪽 좌표, 가장 오른쪽 좌표, 가장 위 좌표, 가장 아래좌표를 기억한 후
        // 배열을 선언?
        // 이때 가장 왼쪽, 가장 위쪽이 0,0 이 되도록 격자 크기와 기존 (0,0)을 수정
        
        
    
    }
    
    public static int calDir(int dir, char turn) {
    	
    	if(turn=='R'){//오른쪽으로 돈다, -1
    		dir-=1;
    		if(dir==-1) dir=3;
    	}else {//왼쪽으로 돈다 1
    		dir+=1;
    		dir%=4;
    	}
    	
    	return dir;
    }

}

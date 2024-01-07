import java.beans.IntrospectionException;
import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb=new StringBuilder();
	static char answer[][];
	 
    public static void main(String [] args) throws IOException{
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	int N=Integer.parseInt(br.readLine());
    	answer=new char[N][N];
    	drawStar(N, 0, 0, true);
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(answer[i][j]);
			}
			sb.append('\n');
		}
        
		System.out.print(sb);
	}
  
    static public void drawStar(int n,int x,int y, boolean draw) {
    	
    	if(draw) {
    		//쪼갤 수 없는 블록
    		if (n == 1) {
    			answer[x][y] = '*';
    			return;
    		}
    		
    		int size = n / 3;
    		int count = 0;
    		for (int i = x; i < x + n; i += size) {
    			for (int j = y; j < y + n; j += size) {
    				count++;
    				if (count == 5) { //그리는 구간
    					drawStar(size,i, j, false);
    				} else {
    					drawStar(size,i, j, true);
    				}
    			}
    		}
    	}else {//공백 구간
    		for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++) {
					answer[i][j] = ' ';
				}
			}
			return;
    	}
    	
    }

}
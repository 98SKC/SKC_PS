import java.io.*;
import java.util.*;

public class Main {

	static char[][] arr;
	static boolean[] v=new boolean[26];
	static int[] di= {0,1,0,-1};//우 하 좌 상
	static int[] dj= {1,0,-1,0};
	static int R,C;
	static int answer=1;
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	R=Integer.parseInt(st.nextToken());
    	C=Integer.parseInt(st.nextToken());
    	
    	String str;
    	arr=new char[R][C];
    	
    	for(int i=0;i<R;i++) {
    		str=br.readLine();
    		for(int j=0;j<C;j++) {
    			arr[i][j]=str.charAt(j);
    		}
    	}
    	back(0,0,0);
    	System.out.println(answer);
    	
    }


    static void back(int i, int j, int sum) {
        int index = arr[i][j] - 'A';
        if(v[index]) {
            answer = Math.max(answer, sum);
            return;
        }
        v[index] = true;
        sum += 1;
        
        for(int a = 0; a < 4; a++) {
            int ni = i + di[a];
            int nj = j + dj[a];
            
            if(ni >= 0 && ni < R && nj >= 0 && nj < C) {
                back(ni, nj, sum);
            }
        }
        v[index] = false; // 방문 해제
    }


   
}
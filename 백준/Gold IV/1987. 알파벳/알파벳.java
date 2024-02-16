import java.io.*;
import java.util.*;

public class Main {

	static char[][] arr;
	static boolean[][] v;
	static int[] di= {0,1,0,-1};//우 하 좌 상
	static int[] dj= {1,0,-1,0};
	static int R,C;
	static int answer=1;
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st=new StringTokenizer(br.readLine());
    	R=Integer.parseInt(st.nextToken());
    	C=Integer.parseInt(st.nextToken());
    	HashSet<Character> set=new HashSet<>();
    	
    	String str;
    	arr=new char[R][C];
    	
    	for(int i=0;i<R;i++) {
    		str=br.readLine();
    		for(int j=0;j<C;j++) {
    			arr[i][j]=str.charAt(j);
    		}
    	}
    	back(0,0,set,0);
    	System.out.println(answer);
    	
    }
    static void back(int i,int j,HashSet<Character> set,int sum) {
    	
    	if(set.contains(arr[i][j])) {
    		answer=Math.max(answer, sum);
    		return;
    	}else {
    		set.add(arr[i][j]);
    		sum+=1;
    	}
    	
    	int ni;
    	int nj;
    	for(int a=0;a<4;a++) {
    		
    		ni=i+di[a];

    		nj=j+dj[a];
    		
    		if(ni>=0&&ni<R&&nj>=0&&nj<C) {
    			back(ni,nj,set,sum);
    		}
    	}
    	set.remove(arr[i][j]);
    }

   
}

import java.util.*;
import java.io.*;

public class Main{
	
	//public static HashSet<Integer> set=new HashSet<>();
	public static int[][] map;
	public static int[][][] sum;
	public static int N, M;
	
    public static void main(String[] args) throws Exception {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        
        int x, y, l, f;
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	y = Integer.parseInt(st.nextToken());
        	x = Integer.parseInt(st.nextToken());
        	l = Integer.parseInt(st.nextToken());
        	f = Integer.parseInt(st.nextToken());
        	makeMap(x, y, l, f);
        }
        
    	// N*N 격자. 과일이 종류별로 심어짐. 
    	// M번 씨앗을 뿌리는데, 방법이 (X,Y,L,F)로 주어짐. X,Y 좌표를 좌상단으로, L길이의 정사각형 모양에 F씨앗을 뿌린다.
    	// 같은 곳에 씨앗을 뿌리면, 새로운 씨가 뿌려짐
    	
    	// 0을 포함하지 않고, 최대 두 종류의 과일만을 가진 정사각형 격자를 가질 수 있으며,
    	
    	// 이분탐색, 누적합, 완전탐색
    	makeSum();
    	
    	int left = 1;
    	int right = N;
    	int mid;
    	int answer = 0;
    	
//    	for(int i=0;i<N;i++) {
//    		System.out.println(Arrays.toString(map[i]));
//    	}
    	
    	while (left <= right) {
    		
    		mid = left + (right - left) / 2;
    		
    		boolean find = false;
    		
    		for (int i = 0; i + mid <= N; i++) {
    			for (int j = 0; j + mid <= N; j++) {
    				if (map[i][j] == 0) continue;
        			find = search(i, j, mid);
        			if (find) break;
        		}
    			if (find) break;
    		}
    		
    		// 더 크게
    		if (find) {
    			answer = mid;
    			left = mid + 1;
    		} else {
    			right = mid - 1;
    		}
    	}
    	
    	System.out.println(answer * answer);
    }
    
    public static void makeMap(int X, int Y, int L, int F) {
    	int maxI = X + L;
    	int maxJ = Y + L;

    	for (int i = X; i < maxI; i++) {
    		for (int j = Y; j < maxJ; j++) {
    			//set.add(i*N+j);
    			map[i][j] = F;
        	}
    	}
    }
    
    public static void makeSum() {
    	sum = new int[8][N + 1][N + 1];
    	
    	for (int fruit = 0; fruit <= 7; fruit++) {
    		for (int i = 1; i <= N; i++) {
    			int rowSum = 0;
    			for (int j = 1; j <= N; j++) {
    				if (map[i - 1][j - 1] == fruit) {
    					rowSum++;
    				}
    				sum[fruit][i][j] = sum[fruit][i - 1][j] + rowSum;
    			}
    		}
    	}
    }
    
    public static int getCount(int fruit, int X, int Y, int L) {
    	int maxI = X + L;
    	int maxJ = Y + L;
    	
    	return sum[fruit][maxI][maxJ]
    		 - sum[fruit][X][maxJ]
    		 - sum[fruit][maxI][Y]
    		 + sum[fruit][X][Y];
    }
    
    public static boolean search(int X, int Y, int L) {

    	// 이 안에 0이 없어야하고, 두종류 이하의 과일이 있어야 한다.
    	int fruitCount = 0;
    	int total = 0;
    	
    	for (int fruit = 1; fruit <= 7; fruit++) {
    		int cnt = getCount(fruit, X, Y, L);
    		
    		if (cnt > 0) {
    			fruitCount++;
    			total += cnt;
    			
    			if (fruitCount > 2) return false;
    		}
    	}
    	
    	// 0을 포함하면 안 된다.
    	if (total != L * L) return false;
    	
    	return true;
    }
}
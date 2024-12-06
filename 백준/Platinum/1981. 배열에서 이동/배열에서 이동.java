import java.util.*;
import java.io.*;

public class Main {

	public static int[] di=new int[] {0,1,0,-1};
	public static int[] dj=new int[] {1,0,-1,0};
	
	public static int[][] map;
	public static boolean[][]v;
	public static int n;
	public static int max=0;
	public static int min=Integer.MAX_VALUE;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        map=new int[n][n];

        
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<n;j++) {
        		map[i][j]=Integer.parseInt(st.nextToken());
        		min=Math.min(min, map[i][j]);
        		max=Math.max(max, map[i][j]);
        	}
        }
        int start=0;
        int end=max-min;
        int subMin,subMax;
        int mid=(start+end)/2;
        boolean check=false;
        int answer=Integer.MAX_VALUE;
        int count=0;
        while(start<=end) {

        	check=false;
        	
        	//subMin과 subMax 사이의 값으로 bfs가 가능한지 확인.-> subMin과 subMax의 모든 조합을 대상으로 하나라도 찾으면 break
        	for(int i=min;i+mid<=max;i++) {
        		mid=(start+end)/2;
        		subMin=i;
        		subMax=i+mid;
                v=new boolean[n][n];
                
                //시작 위치도 범위 체크를 해야하는 것을 놓침
                if(map[0][0]>=subMin&&map[0][0]<=subMax) {
                	if(bfs(subMin,subMax)) {
            			check=true;
            			break;
            		}
                }
        	}
        	
        	//가능하면 더 작은 범위를 탐색.
	        if(check) {

	        	end=mid-1;
	        	answer=Math.min(answer, mid);
	        }else {
//	        	System.out.println(mid+" 불가능");
	        	start=mid+1;
	        	
	        }

        }
        System.out.println(answer);
    }
    //mid에 대해서긴한데, mid가 4라고 할 때 최소가 0, 최대가 4인 것을 기준으로 각 배열값이 0~4인 칸을 탐색하기에 차이가 4이하인 것으로 이동하게됨.
    public static boolean bfs(int subMin ,int subMax) {
    	
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	q.add(new int[] {0,0});
    	v[0][0]=true;
    	int[] sub;
    	int ni,nj;
    	while(!q.isEmpty()) {
    		sub=q.poll();
    		
    		if(sub[0]==n-1&&sub[1]==n-1) {
    			return true;
    		}
    		for(int a=0;a<4;a++) {
    			
    			ni=sub[0]+di[a];
    			nj=sub[1]+dj[a];
    			
    			if(ni>=0&&ni<n&&nj>=0&&nj<n&&map[ni][nj]>=subMin&&map[ni][nj]<=subMax&&!v[ni][nj]) {
    				//System.out.println(ni+" "+nj);
    				q.add(new int[]{ni,nj});
    				v[ni][nj]=true;
    			}
    		}
    	}
    	
//    	System.out.println(subMin+"~~"+subMax);
//        for(int i=0;i<n;i++) {
//        	for(int j=0;j<n;j++) {
//        		if(v[i][j]) System.out.print("O ");
//        		else System.out.print("X ");
//        	}
//        	System.out.println();
//        }
//        
//        System.out.println();
    	return false;
    }

}
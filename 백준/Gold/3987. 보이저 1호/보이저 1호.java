
import java.util.*;
import java.io.*;



public class Main {

	public static boolean[][][] v;
	public static char[][] map; // \/는 행성. C는 블랙홀, .은 빈칸.
	public static int[] di=new int[] {-1,0,1,-0};
	public static int[] dj=new int[] {0,1,0,-1};
	public static char[] d=new char[] {'U','R','D','L'};
	public static int N,M;
	
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        String str;
        map=new char[N+1][M+1];

        
        for(int i=1;i<=N;i++) {
        	str=br.readLine();
        	for(int j=1;j<=M;j++) {
            	map[i][j]=str.charAt(j-1);
            }
        }
        st=new StringTokenizer(br.readLine());
        int si=Integer.parseInt(st.nextToken());
        int sj=Integer.parseInt(st.nextToken());
        
        int sub;
        int max = -1;
        char answer = 'U';
        for(int a=0;a<4;a++) {
        	sub=search(si,sj,a);
        	//System.out.println();
        	if(sub==-1) {
        		System.out.println(d[a]);
        		System.out.println("Voyager");
        		return;
        	}
        	if(max<sub) {
        		answer=d[a];
        		max=sub;
        	}
        }
        
        System.out.println(answer);
        System.out.println(max);
        
    }
    
    
    public static int calDir(int pi, int pj, int d) {
    	char p=map[pi][pj];
    	
    	//행성이면
        if (p == '\\') {
            switch (d) {
                case 0: return 3;
                case 1: return 2;
                case 2: return 1;
                case 3: return 0;
            }
        } else if (p == '/') {
            switch (d) {
                case 0: return 1;
                case 1: return 0;
                case 2: return 3;
                case 3: return 2;
            }
        }
    	
    	//빈공간이라는 뜻이니 원래 방향 그대로
    	return d;
    }
    
    
    public static int search(int si,int sj, int d){
    	
    	int max=0;
    	
        v=new boolean[N+1][M+1][4];
        
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	q.add(new int[] {si,sj,d,0});
	    int pi=-2;
	    int pj=-2;
	    int pd=-2;
	    int time=-2;
	    
    	while(!q.isEmpty()) {
    		int[] p = q.poll();
    	    
    	    pi = p[0];
    	    pj = p[1];
    	    pd = p[2];
    	    time = p[3];
    	    //System.out.println(d+"에서 위치 추적: "+pi+" "+pj+" "+max);
    	    
    	    max=time; //일직선이라서 값은 늘어나기만하고, 사실 time하고 합쳐서 변수 하나로 써도 되는데 일단 가독성 측면에서 분리
    	    
    	    if(checkOut(pi,pj)||map[pi][pj] == 'C') {
    	    	
    	    	return max; // 블랙홀이면 중지
    	    }
    	    
    	    if(v[pi][pj][pd]) {
    	    	return -1;// 무한반복 가능
    	    } 
    	    
    	    v[pi][pj][pd]=true;
    	    
    	    int nd=calDir(pi, pj, pd);
    	    
    	    q.add(new int[] {pi+di[nd], pj+dj[nd], nd, time + 1});
    	    
    	}
    	
    	
    	
    	
    	return max;
    	
    	
    }
    
    public static boolean checkOut(int pi, int pj) {
    	if(pi>0&&pi<=N&&pj>0&&pj<=M) return false;
    	return true; //ㅅ
    }
        
}



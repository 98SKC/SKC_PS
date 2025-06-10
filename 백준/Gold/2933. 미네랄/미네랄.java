
import java.util.*;
import java.io.*;

public class Main{

	public static char[][] map;
	public static int[] height;
	public static int[] dj=new int[] {0,1,0,-1};
	public static int[] di=new int[] {1,0,-1,0};
	
	public static int R,C,N;
	public static boolean right=true;// true면 오른쪽에서 던짐, false면 왼쪽에서 던짐. 근데 내 map이 반전되있어서 좌우도 반전으로 시작
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        map=new char[R+1][C+1];//1~R, 1~C로 맵을 지정
        String str;
        for(int r=R;r>0;r--) {
        	str=br.readLine();
        	for(int c=C;c>0;c--) {
        		map[r][c]=str.charAt(c-1);
        	}
        }
//        System.out.println("원본 맵: ");
//        for(char[] s:map) {
//        	System.out.println(Arrays.toString(s));
//        }
        
        N=Integer.parseInt(br.readLine());
        height=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	height[i]=Integer.parseInt(st.nextToken());
        }
        //땅의 소유권 쟁탈. 막대기를 서로에게 던짐.
        // 동굴에는 미네랄이 있으며, 던진 막대기가 미네랄을 파괴할 수 있음
        // 각 칸이 비어있거나 미네랄을 포함하고 있고, 네 방향 중 하나로 인접한 미네랄이 포함된 두 칸은 같은 클러스터이다
        // 창은 왼쪽, 상은 오른쪽, 두사람이 번갈아가며 던진다. 던지기 전에 높이를 정한다.
        // 막대는 수평으로 날아감.
        // 막대가 미네랄을 만나면 그 칸의 미네랄은 파괴. 막대는 멈춤.
        // 파괴 후 클러스터가 분리될 수 잇다. 분리된 클러스터는 중력에 의해 떨어진다.
        // 모양은 안변함. 즉 테트리스
        
        // 구현사항
        // 1. 좌 우로 이동하면서 미네랄을 만나기.
        // 미네랄 파괴 후, 클러스터가 분리되는지를 확인
        // 분리되었으면 중력 낙하.
        // 낙하 시 클러스터가 모두 내려옴.
        
        int[] m;
        int dir;
        
        for(int i=0;i<N;i++){
            // 1. 좌 우로 이동하면서 미네랄을 만나기.
            // 반환이 0,0이면 파괴된 미네랄이 없다.
           // System.out.println((i+1)+"턴 결과:");
        	right=!right;
        	
        	m=moving(height[i], right);
        	//System.out.println("부서질 위치: "+Arrays.toString(m));
        	if(m[0]==0) continue;
        	
            //System.out.println("파괴 직후 ");
//            for(char[] m1:map) {
//            	System.out.println(Arrays.toString(m1));
//            }
            // 2. 미네랄 파괴 후, 클러스터가 분리되는지를 확인
            // 반환이 4면 분리된 클러스터가 없다
            dir=checkDir(m[0],m[1]);
            if(dir==4) continue;
            
            
            // 3. 분리되었으면 중력 낙하.
            gravity(m[0],m[1],dir);

//            System.out.println("낙하 후");
//            for(char[] m1:map) {
//            	System.out.println(Arrays.toString(m1));
//            }
            
        }
        StringBuilder sb=new StringBuilder();
        for(int r=R;r>0;r--) {
        	for(int c=1;c<=C;c++) {
        		sb.append(map[r][c]);
        	}
        	sb.append("\n");
        }
        //System.out.println("정답: ");
        System.out.println(sb);

        
        
    }
    
    // 1. 좌 우로 이동하면서 미네랄을 만나기.
    public static int[] moving(int h, boolean right) {
    	int[] answer=new int[2];
//    	System.out.println("h: "+h);
//    	for(char[] m:map) {
//    		System.out.println(Arrays.toString(m));
//    	}
    	if(right){//오른쪽에서 쏜다.
    		//System.out.println("??");
    		for(int i=C;i>0;i--) {
    		//	System.out.print(map[h][i]+" ");
    			if(map[h][i]=='x'){
    				answer[0]=h;
    				answer[1]=i;
    				map[h][i]='.';
    			//	System.out.println("111111");
    				return answer;
    			}
    		}
    		
    	}else{//왼쪽에서 쏜다.
    		//System.out.println("C: "+C);
    		for(int i=1;i<=C;i++) {
    		//	System.out.print(map[h][i]+" ");
    			if(map[h][i]=='x'){
    				answer[0]=h;
    				answer[1]=i;
    				map[h][i]='.';
    		//		System.out.println("222222");
    				return answer;
    			}
    		}
    	}
    	
    //	System.out.println("333333");
    	return answer;
    }
    
    
    // 2. 미네랄 파괴 후 클러스터가 분리되는지를 확인 // 파괴된 곳 기준, 어느 방향에 낙하할 클러스트가 있는가
    public static int checkDir(int pi, int pj) {
    	int answer=4;
    	int ni,nj;
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	int[] pos;
    	boolean[][] v=new boolean[R+1][C+1];
    	for(int a=0;a<4;a++) {
    		ni=pi+di[a];
    		nj=pj+dj[a];
        	int min=100;
    		if(ni>0&&ni<=R&&nj>0&&nj<=C&&!v[ni][nj]&&map[ni][nj]=='x'){
    			q.add(new int[] {ni,nj});
    			v[ni][nj]=true;
    			while(!q.isEmpty()){
    				pos=q.poll();
    				min=Math.min(pos[0], min);
    		    	for(int b=0;b<4;b++) {
    		    		ni=pos[0]+di[b];
    		    		nj=pos[1]+dj[b];
    		    		if(ni>0&&ni<=R&&nj>0&&nj<=C&&!v[ni][nj]&&map[ni][nj]=='x'){
    		    			q.add(new int[] {ni,nj});
    		    			v[ni][nj]=true;
    		    		}
    		    	}
    			}
    			//이 클러스터의 바닥의 높이가 1이 아니면 그 방향 클러스터가 낙하한다.
    	//		System.out.println("클러스터 하나의 높이: "+min);
    			if(min!=1){
  //  				System.out.println("방향: "+a);
    				return a;
    			}
    		}
    		
    	}
    	
    	return answer;//4면 떨어질 클러스터가 없다.
    
    	
    }
    
    //3. 클러스터의 낙하
    //한칸씩 떨어트리다가, 중첩이 있으면 이전으로 복귀?
    public static void gravity(int pi, int pj, int dir) {
    	
    	PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
    		@Override
    		public int compare(int[] o1, int[] o2) {
    			return o1[0]-o2[0];
    		}
    	});
    	
    	//클러스터 원본 좌표 
    	PriorityQueue<int[]> oq=new PriorityQueue<>(new Comparator<int[]>() {
    		@Override
    		public int compare(int[] o1, int[] o2) {
    			return o1[0]-o2[0];
    		}
    	});
    	
    	pi+=di[dir];
    	pj+=dj[dir];
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	q.add(new int[] {pi,pj});
    	oq.add(new int[] {pi,pj});
    	
    	boolean[][] v=new boolean[R+1][C+1];
    	v[pi][pj]=true;
    	int ni,nj;
    	int[] pos;
    	//클러스터를 넣는다.
    	
		while(!q.isEmpty()){
			pos=q.poll();
	//		System.out.println(Arrays.toString(pos));
			pq.add(pos);
			oq.add(pos);
	    	for(int b=0;b<4;b++) {
	    		ni=pos[0]+di[b];
	    		nj=pos[1]+dj[b];
	    		if(ni>0&&ni<=R&&nj>0&&nj<=C&&!v[ni][nj]&&map[ni][nj]=='x'){
	    			q.add(new int[] {ni,nj});
	    			v[ni][nj]=true;
	    		}
	    	}
	    	
		}
		
		int d=100;// 떨어져야 할 높이
	//	System.out.println("클러스터 크기: "+pq.size()+" 방향: "+dir);
		c: while(!pq.isEmpty()){
			pos=pq.poll();
			if(map[pos[0]-1][pos[1]]!='.') {// 그 칸의 아래가 비어있지 않으면 외각이 아님. 스킵.
				continue;
			}
		//	System.out.println("외곽 좌표: "+pos[0]+" "+pos[1]);
			int sub=pos[0]-1;
			while(sub>0){
				if(v[sub][pos[1]]) continue c;
				if(map[sub][pos[1]]=='x'){
					break;
				}
				sub--;
			}
			/*
			 * 6X
			 * 5.
			 * 4.
			 * 3X
			 * 2.
			 * 1.
			 * 0
			 * */
//			System.out.println("낙하값: "+(pos[0]-sub-1));
//			System.out.println();
			d=Math.min(d, pos[0]-sub-1);
			
			
		}
//		System.out.println("내릴 값: "+d);
		//원본 클러스터 좌표들을 d만큼 내린다. 아래쪽 부터
//		System.out.println("움직일 크기: "+oq.size());
		while(!oq.isEmpty()) {
			pos=oq.poll();
			map[pos[0]][pos[1]]='.';
			map[pos[0]-d][pos[1]]='x';
		}
    	
    }
    
}

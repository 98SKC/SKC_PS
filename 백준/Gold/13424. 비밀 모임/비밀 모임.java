
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        // N개의 중복되지않는 1~N의 방
        // 각 방은 M개의 통로로 연결 
        // 각 통로는 양방향 통행
        // 모임에 참석한 인원은 K
        // N개의 방 중 하나를 선택해서 모인다
        // 각 인원들은 N개의 방에서 한군데씩 위치해 있다.
        // 모임 위치까지 최단경로로 이동한다.
        // 이동거리가 최소가 되도록 모임장소를 정하라.
        
        // 플로이드 와샬로 보인다.
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine());
        
        //ArrayList<int[]>[] edges;
        int[][] floyd;
        int[] room;
        int N,M,K;
        
        int a,b,d;
        
        
        int answer;
        int min;
        for(int test_case=1;test_case<=T;test_case++) {
        	
        	st=new StringTokenizer(br.readLine());
        	
        	N=Integer.parseInt(st.nextToken()); //방의 개수
        	M=Integer.parseInt(st.nextToken()); //통로의 개수
        	
//        	edges=new ArrayList[N+1];
//        	for(int i=1;i<=N;i++) {
//        		edges[i]=new ArrayList<>();
//        	}

        	floyd=new int[N+1][N+1];// i에서 j까지의 거리
    		
        	for(int i=1;i<=N;i++) { //i에서 
    			for(int j=1;j<=N;j++) { //j로 가는 최단거리
    				floyd[i][j]=100001;//모든방이 최장거리이고 다 거쳤을 때로 최대
            	}
        	}
        	
        	for(int i=0;i<M;i++) {
        		st=new StringTokenizer(br.readLine());
        		
        		a=Integer.parseInt(st.nextToken());
        		b=Integer.parseInt(st.nextToken());
        		d=Integer.parseInt(st.nextToken());
        		
//        		edges[a].add(new int[] {b,d});
//        		edges[b].add(new int[] {a,d});
        		// 두 방을 잇는 통로는 하나임이 보장
        		floyd[a][b]=d;
        		floyd[b][a]=d;
        		
        		
        		
        	}
        	

        	
    		for(int i=1;i<=N;i++) { //i에서 
    			floyd[i][i]=0;// 자기 자신으로는 무조건 0
        	}
    		
//    		System.out.println("방 거리 확인");
//        	for(int[] n:floyd) {
//        		System.out.println(Arrays.toString(n));
//        	}
        	
        	for(int k=1;k<=N;k++) {//k를 무조건 경유해서 
        		for(int i=1;i<=N;i++) { //i에서 
        			for(int j=1;j<=N;j++) { //j로 가는 최단거리
                		if(floyd[i][k]+floyd[k][j]<floyd[i][j]) {
                			floyd[i][j]=floyd[i][k]+floyd[k][j];
                		}
                	}
            	}
        	}
        	
    		//System.out.println("다 돌고난 후");
//        	for(int[] n:floyd) {
//        		System.out.println(Arrays.toString(n));
//        	}
        	K=Integer.parseInt(br.readLine());
        	room=new int[K];
        	
        	st=new StringTokenizer(br.readLine());
        	for(int i=0;i<K;i++) {
        		room[i]=Integer.parseInt(st.nextToken());
        	}
        	
        	Arrays.sort(room);
        	answer=-1;
        	min=Integer.MAX_VALUE;
        	
//        	System.out.println(test_case+" 번 테케, 초기화 확인: "+answer);
//        	System.out.println("가야하는 방: "+Arrays.toString(room));
        	for(int i=1;i<=N;i++) {//i방에서
            	d=0;//거리 변수 재활용
        		
            	for(int j=0;j<K;j++) {
        			//System.out.println(i+"에서 "+room[j]+"방까지: "+floyd[i][room[j]]);
            		d+=floyd[i][room[j]];
            	}
        		
        		//System.out.println(i+"의 경우 거리 총합: "+d);
        		if(min>d) {
        			min=d;
        			answer=i;
        		}
        	}
        	sb.append(answer+"\n");
        	//System.out.println();
        }
        
        System.out.println(sb);
        
        
    }
        
}



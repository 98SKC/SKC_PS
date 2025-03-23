
import java.util.*;
import java.io.*;

public class Main{

	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        int[] di=new int[] {0,1,0,-1};
        int[] dj=new int[] {1,0,-1,0};
        
        StringTokenizer st;
        char[][] map;
        int w,h;
        String str;
        boolean[][] v;
        boolean possible;
        int[] pos;
        int ni,nj;
        ArrayDeque<int[]> person;
        ArrayDeque<int[]> fire;
        int fLen;

        StringBuilder sb=new StringBuilder();
        for(int t=1;t<=T;t++) {
        	st=new StringTokenizer(br.readLine());
        	w=Integer.parseInt(st.nextToken());
        	h=Integer.parseInt(st.nextToken());
        	map=new char[h][w];
        	v=new boolean[h][w];
        	person=new ArrayDeque<>();
        	fire=new ArrayDeque<>();
   
        	for(int i=0;i<h;i++) {
        		str=br.readLine();
        		for(int j=0;j<w;j++) {
        			map[i][j]=str.charAt(j);
        			if(map[i][j]=='@') {
        				map[i][j]='.';
        				person.add(new int[] {i,j,0});
        				v[i][j]=true;
        			}else if(map[i][j]=='*') {
        				fire.add(new int[] {i,j});
        			}
        		}
        	}
        	possible=false;
        	//int turn=1;
        	while(true) {
        	//	System.out.println((turn++)+"턴");
        		//불이 옮겨붙을 칸에 이동할 수 없으니 불을 먼저 이동
        		fLen=fire.size();
        		int[] f;
        		for(int i=0;i<fLen;i++) {
        			f=fire.poll();
        			for(int a=0;a<4;a++) {
            			ni=di[a]+f[0];
            			nj=dj[a]+f[1];
            			
            			if(ni>=0&&ni<h&&nj>=0&&nj<w&&map[ni][nj]=='.'){
            				map[ni][nj]='*';
            				fire.add(new int[] {ni,nj});
            			}
            			
            		}
        		}
        		
        		//불이 이동된 후 상근이 이동. 상근이가 있는 곳에 불이 있어도 괜찮다

	       		int pLen=person.size();
	       		for(int i=0;i<pLen;i++) {
		       		pos=person.poll();
		        	for(int a=0;a<4;a++) {
		        		ni=di[a]+pos[0];
		        		nj=dj[a]+pos[1];
		        		
	        			if(ni>=0&&ni<h&&nj>=0&&nj<w){// 맵 내부면
	        				if(map[ni][nj]=='.'&&!v[ni][nj]){
	        					person.add(new int[] {ni,nj,pos[2]+1});
	        					v[ni][nj]=true;
	        					//System.out.println(ni+" "+nj);
	        				}
	        			}else {//맵 외부면 탈출 성공
	        				sb.append(pos[2]+1).append("\n");
	        				possible=true;
	        				break;
	        			}
		        		
		        	}
		        	if(possible) break;
	       		}

	        	if(possible||person.isEmpty()) break;
        	}
        	
        	if(!possible) sb.append("IMPOSSIBLE").append("\n");
        }
        System.out.println(sb);
    }
}

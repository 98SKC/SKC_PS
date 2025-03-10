
import java.util.*;
import java.io.*;

public class Main{


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int R=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());
        
        //Stack<int[]> stack=new Stack<>();
        ArrayDeque<int[]> h=new ArrayDeque<>();//고슴도치 위치
        ArrayDeque<int[]> w=new ArrayDeque<>();//퍼질 물
        
        char[][] map=new char[R][C];
        String str;
        
        int[] start=new int[2];
        int[] goal=new int[2];
        int[] di=new int[] {0,1,0,-1};
        int[] dj=new int[] {1,0,-1,0};
        boolean[][] v= new boolean[R][C];        
        for(int i=0;i<R;i++) {
        	str=br.readLine();
        	for(int j=0;j<C;j++) {
            	map[i][j]=str.charAt(j);
            	if(map[i][j]=='S') {
            		h.add(new int[] {i,j,0});
            		v[i][j]=true;
            	}else if(map[i][j]=='*'){
            		w.add(new int[] {i,j});
            	}
            }
        }
        
        int ni,nj;
        int[] sub;
        //.은 이동가능, *은 물, X는 돌
        // 돌과 물은 이동 못하는데, 물이 인접한 칸은 물이 차오른다.
        int size=0;
        int answer=-1;

        
        while(!h.isEmpty()){

        	size=w.size();
        	
        	//물이 차오른다
        	for(int i=0;i<size;i++) {
        		sub=w.poll();
        		for(int a=0;a<4;a++) {
        			ni=di[a]+sub[0];
        			nj=dj[a]+sub[1];
        			if(ni>=0&&ni<R&&nj>=0&&nj<C) {
        				if(map[ni][nj]=='.'){
        					map[ni][nj]='*';
        					w.add(new int[] {ni,nj});
        				}
        			}
        		}
        	}

        	size=h.size();
        	//고슴도치가 이동할 곳
        	for(int i=0;i<size;i++) {
        		sub=h.poll();
        		for(int a=0;a<4;a++) {
        			ni=di[a]+sub[0];
        			nj=dj[a]+sub[1];
        			if(ni>=0&&ni<R&&nj>=0&&nj<C&&!v[ni][nj]) {
        				if(map[ni][nj]=='.'){
        					v[ni][nj]=true;
        					h.add(new int[] {ni,nj,sub[2]+1});
        				}else if(map[ni][nj]=='D') {
        					answer=sub[2]+1;
        					break;
        				}
        				
        			}
        		}
        	}	

        	if(answer!=-1) break;
//        	for(char[] s:map) {
//        		System.out.println(Arrays.toString(s));
//        	}
//        	System.out.println("----------");
        }
        
        if(answer==-1) {
        	System.out.println("KAKTUS");
        }else {
        	System.out.println(answer);
        }
        
        
    }
}

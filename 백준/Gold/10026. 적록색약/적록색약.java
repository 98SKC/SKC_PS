import java.util.*;
import java.io.*;

public class Main {
	static int[] di=new int[] {0,1,0,-1};
	static int[] dj=new int[] {1,0,-1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        String str;
        char[][] map=new char[N][N];
        boolean[][] v1=new boolean[N][N];
        boolean[][] v2=new boolean[N][N];
        int answer1=0;
        int answer2=0;
        int pos,si,sj,ni,nj;
        char save;
        boolean blue;
        for(int i=0;i<N;i++) {
        	str=br.readLine();
        	for(int j=0;j<N;j++) {
            	map[i][j]=str.charAt(j);
            }
        }
        
        Queue<Integer> q=new ArrayDeque<>();
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		//일반
            	if(!v1[i][j]) {
            		v1[i][j]=true;
            		q.add(i*N+j);
            		save=map[i][j];
            		while(!q.isEmpty()) {
            			pos=q.poll();
            			si=pos/N;
            			sj=pos%N;
            			for(int a=0;a<4;a++) {
            				ni=si+di[a];
            				nj=sj+dj[a];
            				//배열 범위 내이고, 방문하지 않았으며, 초기 문자와 같으면 q에 넣는다.
            				if(ni>=0&&ni<N&&nj>=0&&nj<N&&!v1[ni][nj]&&map[ni][nj]==save) {
            					q.add(ni*N+nj);
            					v1[ni][nj]=true;
            				}
            			}
            		}
//            		System.out.println("일반");
//                    for(int x=0;x<N;x++) {
//                    	for(int y=0;y<N;y++) {
//                        	System.out.print(v1[x][y]); 
//                        }
//                    	System.out.println();
//                    }
            		
            		answer1++;
            	}
            	//적록색약
            	if(!v2[i][j]) {
            		q.add(i*N+j);
            		//처음이 파란색인지 아닌지
            		v2[i][j]=true;
            		if(map[i][j]=='B') {
            			blue=true;
            		}else {
            			blue=false;//
            		}
            		
            		while(!q.isEmpty()) {
            			pos=q.poll();
            			si=pos/N;
            			sj=pos%N;
            			for(int a=0;a<4;a++) {
            				ni=si+di[a];
            				nj=sj+dj[a];
            				//배열 범위 내이고, 방문하지 않았으며, .
            				if(ni>=0&&ni<N&&nj>=0&&nj<N&&!v2[ni][nj]&&((map[ni][nj]=='B'&&blue)||(map[ni][nj]!='B'&&!blue))) {
            					q.add(ni*N+nj);
            					v2[ni][nj]=true;
            				}
            			}
            		}
//            		System.out.println("적록색약");
//                    for(int x=0;x<N;x++) {
//                    	for(int y=0;y<N;y++) {
//                        	System.out.print(v2[x][y]); 
//                        }
//                    	System.out.println();
//                    }
            		answer2++;
            	}
            	
            	
            }
        }
        System.out.println(answer1+" "+answer2);
    }
}
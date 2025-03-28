
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());//노트북 크기
        int M=Integer.parseInt(st.nextToken());//노트북 크기
        int K=Integer.parseInt(st.nextToken());//스티커 개수
        int[][] map=new int[N][M];
        //ArrayList<int[][]> list=new ArrayList<>();
        int R,C;
        int total=0;
        int count=0;
        boolean find;
        for(int k=1;k<=K;k++) {
        	st=new StringTokenizer(br.readLine());
        	R=Integer.parseInt(st.nextToken());
        	C=Integer.parseInt(st.nextToken());
        	int[][] smallMap=new int[R][C];
        	count=0;
        	for(int i=0;i<R;i++) {
        		st=new StringTokenizer(br.readLine());
        		for(int j=0;j<C;j++) {
        			smallMap[i][j]=Integer.parseInt(st.nextToken());
        			if(smallMap[i][j]==1) count++;
        		}
        	}
//        	System.out.println("이번 스티커:");
//			for(int[] m:smallMap) {
//				System.out.println(Arrays.toString(m));
//			}
        	//list.add(smallMap);
        	//완전탐색을 한다고 가정하면 최악이 몇번인가
        	//스티커 한번을 붙일 때 한칸씩 다 본다고 하면
        	//40*40*100*100*4* 
        	//N  M  스티커 K   회전
        	//16000000
        	//시간은 되네?
        	find=false;
        	for(int t=0;t<4;t++){//4개의 회전 상태
        		if(t!=0) {
        			smallMap=turn(smallMap,R,C);
        			int tmp=R;
        			R=C;
        			C=tmp;
//                	System.out.println("회전한 스티커:");
//        			for(int[] m:smallMap) {
//        				System.out.println(Arrays.toString(m));
//        			}
        		} 
        		
        		//N-R-1+
            	for(int i=0;i<=N-R;i++) {
            		for(int j=0;j<=M-C;j++) {
            			//좌측 상단이 비었으면 붙일 수 있는지 탐색 시작
//            			if(k==2&&t==1&&i==0&&j==2) {
//            				System.out.println("?????");
//            			}
            			find=true;
            			for(int r=i;r<i+R;r++) {
        					for(int c=j;c<j+C;c++) {
        						//System.out.println("R "+R+" C "+C+" 배열세로 "+smallMap.length+" 배열가로 "+smallMap[0].length+" 좌표"+r+" "+c+" 최대: "+(i+R-1));
        						//System.out.println(smallMap[r][c]);//smallMap에서 크기 2를 넘음
        						if(smallMap[r-i][c-j]==1&&map[r][c]==1){
        							find=false;
        						}
        					}
        				}
        				
        				if(find) {
        					//System.out.println(k+"스티커를 "+t+"번 회전해서 "+i+" "+j+"에 붙였다.");
        					for(int r=i;r<i+R;r++) {
            					for(int c=j;c<j+C;c++) {
            						if(smallMap[r-i][c-j]==1) {
            							map[r][c]=1;
            						}
            					}
            				}
        					total+=count;
//        					for(int[] m:map) {
//        						System.out.println(Arrays.toString(m));
//        					}
        					break;
        				}
            		}
            		if(find) break;
            		//
            	}
            	//
            	if(find) break;
        	}
	
        }
        System.out.println(total);
        //가장 좌상단에 스티커를 붙인다. 
        //좌상단에 스티커를 붙일 수 없으면 회전을 시킨다.
        
    }
    public static int[][] turn(int[][] map,int R,int C){
    	int[][] copy=new int[C][R];
    	//System.out.println("R "+R+" C "+C+" 배열세로 "+map.length+" 배열가로 "+map[0].length);
    	for(int i=0;i<R;i++) {
    		for(int j=0;j<C;j++) {
        		copy[j][R-i-1]=map[i][j];
        	}
    	}
    	return copy;
    }
}

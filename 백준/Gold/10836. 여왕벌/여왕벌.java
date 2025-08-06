
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        
        int[][] honeycomb=new int[M][M];
        
        for(int i=0;i<M;i++) {
        	for(int j=0;j<M;j++) {
            	honeycomb[i][j]=1;
            }
        }
        /*
         * 0 1 2 3 
         * 4 5 6 7
         * 8 9 10 11
         * 11 12 13 14
         * */
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=M-1;i>=0;i--) {
        	list.add(new int[] {i,0});
        }
        
        for(int i=1;i<M;i++) {
        	list.add(new int[] {0,i});
        }
        int size=list.size();
        int[][] increase=new int[M][M];
        int zero, one, two;
        int[] pos;
        
        for(int m=0;m<N;m++) {
        	st=new StringTokenizer(br.readLine());
        	zero=Integer.parseInt(st.nextToken());
        	one=Integer.parseInt(st.nextToken());
        	two=Integer.parseInt(st.nextToken());
        	
        	//System.out.println(m+"번째 턴 1넣기");
            
        	
        	for(int i=zero;i<zero+one;i++) {
        		pos=list.get(i);
        		increase[pos[0]][pos[1]]+=1;
        	}

        	for(int i=zero+one;i<size;i++) {
        		pos=list.get(i);
        		increase[pos[0]][pos[1]]+=2;
        	}
        	
        	
        	
//        	System.out.println(m+"턴 증가량");
//            for(int[] c:increase) {
//            	System.out.println(Arrays.toString(c));
//            }
//            
        	
        }

        for(int i=1;i<M;i++) {
        	for(int j=1;j<M;j++) {
        		increase[i][j]=increase[i-1][j];
            }
        }
        
        
    	for(int i=0;i<M;i++) {
    		for(int j=0;j<M;j++) {
        		honeycomb[i][j]+=increase[i][j];
        	}
    	}
        
        //크기가 MxM인 벌집
        //각 칸에는 애벌레들이 있다.
        //좌표는 0,0 부터. 
        //매일 에너지를 모아 한번 자란다. 이를 N일 반복
        //커지는 정도는 0,1,2 중 하나.
        //규칙은 다음과 같다.
        //제일 왼쪽 혹은 위쪽의 애벌레들은 자라는 정도를 스스로 결정 -> 입력으로 주어짐
        // 왼쪽 제일 아래부터 뒤집힌 ㄱ 자로 주어짐
        // 나머지 애벌레들은 왼쪽, 왼쪽위 위쪽 애벌레들이 다 자라고, 그중 최대값만큼 자신도 자란다.
        
        //근데 처음에 증가하는 형태로 입력을 주면, 나머지는 바로 자기 바로 위에거 보면 안되는건가?
        //ㄴ
//        System.out.println("-----------결과----------------");
//        for(int[] p:honeycomb) {
//        	System.out.println(Arrays.toString(p));
//        }
        StringBuilder sb=new StringBuilder();
        	for(int i=0;i<M;i++) {
        		for(int j=0;j<M;j++) {
            		sb.append(honeycomb[i][j]+" ");
            		
            	}
        		sb.append("\n");
        	}
        System.out.println(sb);
    }
}

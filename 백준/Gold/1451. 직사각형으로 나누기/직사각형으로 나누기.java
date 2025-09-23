
import java.util.*;
import java.io.*;

public class Main {

	public static int[][] map;
	public static long[][] presum;
	public static int N,M;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        map=new int[N+1][M+1];
        presum=new long[N+1][M+1];
        
        String str;
        for(int i=1;i<=N;i++) {
        	str=br.readLine();
        	for(int j=1;j<=M;j++) {
            	map[i][j]=str.charAt(j-1)-'0';
            }
        }
        
        presum = new long[N+1][M+1];
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                presum[i][j] = presum[i-1][j] + presum[i][j-1] - presum[i-1][j-1] + (long) map[i][j];
            }
        }
        
        
        long answer=0;   
        long squarA,squarB,squarC;
        
//        for(int[] m:map) {
//        	System.out.println(Arrays.toString(m));
//        }
        
        for(int i=1;i<=M-1;i++) {
            for(int j=i+1;j<=M-2;j++) {
                squarA = area(1,1,N,i);
                squarB = area(1,i+1,N,j);
                squarC = area(1,j+1,N,M);
                if(answer<squarA*squarB*squarC) {
                    answer = squarA*squarB*squarC;
                }
            }
        }


        for(int i=1;i<=N-1;i++) {
            for(int j=i+1;j<=N-1;j++) {
                squarA = area(1,1,i,M);
                squarB = area(i+1,1,j,M);
                squarC = area(j+1,1,N,M);
                if(answer<squarA*squarB*squarC) {
                    answer = squarA*squarB*squarC;
                }
            }
        }


        for(int i=1;i<M;i++) {
            for(int j=1;j<N;j++) {
                squarA = area(1,1,N,i);
                squarB = area(1,i+1,j,M);
                squarC = area(j+1,i+1,N,M);
                if(answer<squarA*squarB*squarC) {
                    answer = squarA*squarB*squarC;
                }
            }
        }


        for(int i=1;i<N;i++) {
            for(int j=1;j<M;j++) {
                squarA = area(1,1,i,j);
                squarB = area(i+1,1,N,j);
                squarC = area(1,j+1,N,M);
                if(answer<squarA*squarB*squarC) {
                    answer = squarA*squarB*squarC;
                }
            }
        }


        for(int i=1;i<N;i++) {
            for(int j=1;j<M;j++) {
                squarA = area(1,1,i,M);
                squarB = area(i+1,1,N,j);
                squarC = area(i+1,j+1,N,M);
                if(answer<squarA*squarB*squarC) {
                    answer = squarA*squarB*squarC;
                }
            }
        }

        for(int i=1;i<N;i++) {
            for(int j=1;j<M;j++) {
                squarA = area(1,1,i,j);
                squarB = area(1,j+1,i,M);
                squarC = area(i+1,1,N,M);
                if(answer<squarA*squarB*squarC) {
                    answer = squarA*squarB*squarC;
                }
            }
        }

        System.out.println(answer);
        
    }
    
    
    public static long area(int x1, int y1, int x2, int y2) {
        return presum[x2][y2] - presum[x2][y1-1] - presum[x1-1][y2] + presum[x1-1][y1-1];
    }

        
}



import java.util.*;
import java.io.*;



public class Main {

	
	static int max=0;
	static int[][] map;
	static int N,M;
	
	
	/*입력 받은 map에서 한칸씩 완전탐색으로 이동하며, 아래의 모든 경우의 수에 대한 범위의 합을
	구해가며 최댓값을 갱신하고자함. archer는 일자 막대로, 하나로 가로, 세로의 모든 경우에 사용한다.
	아래의 각 배열은 dist 배열의 역할을 하며, 배열에 넣기 전 배열 내부인지 ni,nj를 검색하도록 한다.
	합을 구할 때, 시작점의 위치를 잊지 않고 합하도록 한다. 
	*/
	static int[] archer= {1,2,3};
	
	static int[][] knight= {{1,0},{0,1},{1,1}};
	
	static int[][] pirate1= {{0,-1},{1,-1},{1,-2}};
	static int[][] pirate2= {{0,1},{1,1},{1,2}};
	static int[][] pirate3= {{1,0},{1,-1},{2,-1}};
	static int[][] pirate4= {{1,0},{1,1},{2,1}};
	
	static int[][] magician1= {{0,1},{-1,1},{1,1}};
	static int[][] magician2= {{-1,0},{-1,1},{-1,-1}};
	static int[][] magician3= {{0,-1},{-1,-1},{1,-1}};
	static int[][] magician4= {{1,0},{1,1},{1,-1}};
	
	static int[][] thief1= {{0,-1},{1,-1},{2,-1}};
	static int[][] thief2= {{0,1},{1,1},{2,1}};
	static int[][] thief3= {{1,0},{1,-1},{1,-2}};
	static int[][] thief4= {{1,0},{1,1},{1,2}};
	
	static int[][] thief5= {{0,-1},{-1,-1},{-2,-1}};
	static int[][] thief6= {{0,1},{-1,1},{-2,1}};
	static int[][] thief7= {{-1,0},{-1,-1},{-1,-2}};
	static int[][] thief8= {{-1,0},{-1,1},{-1,2}};
	
	
	

	public static void main(String[] args) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		//완탐시작
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				helper(i,j);
			}
		}
		
		System.out.println(max);
		
	}
	
	// startI, startJ에서의 모든 경우의 수 계산
	static void helper(int startI, int startJ) {

	    // 모든 테트로미노 모양에 대해 반복
	    int[][][] shapes = {pirate1, pirate2, pirate3, pirate4, magician1, magician2, magician3, magician4, thief1, thief2, thief3, thief4,thief5,thief6,thief7,thief8};
	    
	    //'knight' 테트로미노 처리
	    int tempSum = map[startI][startJ]; // 시작점 포함
	    
	    for (int[] a : knight) {
            int ni = startI + a[0];
            int nj = startJ + a[1];
            if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                tempSum += map[ni][nj];
            } else {
                tempSum = 0; // 범위를 벗어나면 합계 무효
                break;
            }
        }
	    max = Math.max(max, tempSum);
	    
	    // 'archer' 테트로미노 처리
	    for (int direction = 0; direction < 2; direction++) {
	        tempSum = map[startI][startJ]; // 시작점 포함
	        for (int a : archer) {
	            int ni = startI + (direction == 0 ? 0 : a); // 가로 또는 세로 방향
	            int nj = startJ + (direction == 0 ? a : 0);
	            if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
	            	
	                tempSum += map[ni][nj];
	            } else {
	                tempSum = 0; // 범위를 벗어나면 합계 무효
	                break;
	            }
	        }
	        //if(max<tempSum) System.out.printf("%d %d 좌표 궁수 방향 %d 에서 최대값 %d\n",startI,startJ,direction,tempSum);
	        max = Math.max(max, tempSum);
	    }


	    // 나머지 테트로미노 처리
	    for (int[][] shape : shapes) {
	   
	        for (int rot = 0; rot < 4; rot++) { // 회전 고려
	            tempSum = map[startI][startJ]; // 시작점 포함
	            for (int[] p : shape) {
	                int ni = startI + p[rot % 2 == 0 ? 0 : 1];
	                int nj = startJ + p[rot % 2 == 0 ? 1 : 0];
	                if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
	                	
	                    tempSum += map[ni][nj];
	                } else {
	                    tempSum = 0; // 범위를 벗어나면 합계 무효
	                    break;
	                }
	            }
	          //  if(max<tempSum) System.out.printf("%d %d 좌표 시작 %d 유니온 %d모양에서 에서 최대값 %d\n",startI,startJ,count,rot,tempSum);
	            max = Math.max(max, tempSum);
	        }
	    }

	}

	
}
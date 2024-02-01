import java.io.*;
import java.util.*;
//행 단위의 누적합 풀이
public class Solution {

	public static void main(String args[]) throws Exception{
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		int N,M,sum;
		int[][] map;
		for(int tc = 1; tc <= T; tc++){
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			map=new int[N][N];
			int max=Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {// N행의 누적합 배열 생성
				st=new StringTokenizer(br.readLine());
				sum=0;
				for(int j=0;j<N;j++) {
					sum+=Integer.parseInt(st.nextToken());
					map[i][j]=sum;
				}
			}
			
			for(int i=0;i<=N-M;i++){//지도를 벗어나지 않도록 주의
			    for(int j=0;j<=N-M;j++){//같은 이유로 여기도 N - M까지.
			        int currentSum=0;//현재 윈도우에서의 파리의 합을 저장할 변수.
			        //탐색 시작.
			        for(int k=0;k<M;k++){//MxM의 누적합을 구하자.
			            if (j==0) {
			                //첫 번째 열인 경우, 누적합을 직접 사용.
			                currentSum += map[i+k][j+M-1];
			            }else{
			                //그 외에는 오른쪽 누적합에서 왼쪽 누적합을 뺀다.
			                currentSum+=map[i+k][j+M-1]-map[i+k][j-1];
			            }
			        }
			        //최대값을 갱신
			        max=Math.max(max, currentSum);
			    }
			}

			System.out.println("#" + tc + " " + max); // 테스트 케이스마다 최대값을 출력합니다.
			
		}

		
		
		
	}

}
import java.io.*;
import java.util.*;


public class Main {

	//static int[][] arr;
	static int N,M,R;
	static int[] di=new int[] {1,0,-1,0};
	static int[] dj=new int[] {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb=new StringBuilder();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int op;
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		int[][] arr=new int[N][M];
		
		//원본 배열 만들기
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine());
		
		for(int r=0;r<R;r++) {
			 op=Integer.parseInt(st.nextToken());
			 switch(op) {
			 case 1:
				 arr=reverseUD(arr);
				 break;
			 case 2:
				 arr=reverseLR(arr);
				 break;
			 case 3:
				 arr=rotate270(arr);
				 break;
			 case 4:
				 arr=rotate90(arr);
				 break;
			 case 5:
				 arr=rotateQuarter(arr);
				 break;
			 case 6:
				 arr=QuarterRevers(arr);
				 break;
			 }
		}
	
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		
		System.out.println(sb);
		
		
	}
	static int[][] reverseUD(int[][] arr) {// 완료
		int sub;
		int n=arr.length;
		int m=arr[0].length;
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<m;j++) {
				sub=arr[i][j];
				arr[i][j]=arr[n-1-i][j];
				arr[n-1-i][j]=sub;
				
			}
		}
		return arr;
	}
	static int[][] reverseLR(int[][] arr) {//완료
		int sub;
		int n=arr.length;
		int m=arr[0].length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m/2;j++) {
				sub=arr[i][j];
				arr[i][j]=arr[i][m-1-j];
				arr[i][m-1-j]=sub;
				
			}
		}
		return arr;
	}
	
	static int[][] rotate90(int[][] arr) {
		int n=arr.length;
		int m=arr[0].length;
		int[][] answer=new int[m][n];

		
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = arr[j][m-1-i];
            }
        }
		return answer;
	}
	
	static int[][] rotate270(int[][] arr) {

		int n=arr.length;
		int m=arr[0].length;
		int[][] answer=new int[m][n];

		
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = arr[n-1-j][i];
            }
        }
		return answer;
	}
	static int[][] rotateQuarter(int[][] arr) {
		int n=arr.length;
		int m=arr[0].length;
		int sub=0;
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<m/2;j++) {
				sub=arr[i][j];
				arr[i][j]=arr[i+n/2][j];
				arr[i+n/2][j]=arr[i+n/2][j+m/2];
				arr[i+n/2][j+m/2]=arr[i][j+m/2];
				arr[i][j+m/2]=sub;
			}
		
		}

		return arr;
	}
	static int[][] QuarterRevers(int[][] arr) {
		int n=arr.length;
		int m=arr[0].length;
		int sub=0;
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<m/2;j++) {
				sub=arr[i][j];
				arr[i][j]=arr[i][j+m/2];
				arr[i][j+m/2]=arr[i+n/2][j+m/2];
				arr[i+n/2][j+m/2]=arr[i+n/2][j];
				arr[i+n/2][j]=sub;
			}
		
		}

		return arr;
		
	}
	

}
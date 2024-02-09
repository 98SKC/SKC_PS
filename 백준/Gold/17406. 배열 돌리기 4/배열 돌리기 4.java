import java.util.*;
import java.io.*;


public class Main {

	static int N,M,K,min;
	static int[][] originArr, oper;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};//하우상좌
	static boolean[] visited;

	
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
	
		
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		int r,c,s;
		min=Integer.MAX_VALUE;
		visited=new boolean[K];
		oper=new int[K][3];
		
		
		
		originArr=new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				originArr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int op=0;op<K;op++) {
			st=new StringTokenizer(br.readLine());
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			s=Integer.parseInt(st.nextToken());
			oper[op][0]=r;
			oper[op][1]=c;
			oper[op][2]=s;
		}
		
		permutation(0,new int[K]);
		
		
		System.out.println(min);
	}
	public static void permutation(int cnt, int[] arr) {
	    if(cnt == K) {
	        rotateArr(arr);
	        return;
	    }
	    for(int i=0; i<K; i++) {
	        if(visited[i]) continue;
	        visited[i] = true;
	        arr[cnt] = i;
	        permutation(cnt+1, arr);
	        visited[i] = false;
	    }
	}
	
	static void rotateArr(int[] order) {
		int nx, ny, sub,len,sum;
		int s,c,r;
		
	    int[][] tmp = new int[N+1][M+1];

	    for(int i=1; i<N+1; i++) {
	        for(int j=1; j<M+1; j++) {
	            tmp[i][j] = originArr[i][j];
	        }
	    }
		
		for(int a=0;a<K;a++) {
			r=oper[order[a]][0];
			c=oper[order[a]][1];
			s=oper[order[a]][2];

			len=2*s+1;
			for(int i=0;i<len/2;i++) {// 1칸씩 안으로
				nx=c-s+i;// 시작할 좌표의 위치
				ny=r-s+i;
				sub=tmp[ny][nx];
				for(int j=0;j<4;j++) {
					while(nx+dx[j]>=c-s+i&&nx+dx[j]<=c+s-i&&ny+dy[j]>=r-s+i&&ny+dy[j]<=r+s-i) {
						tmp[ny][nx]=tmp[ny+dy[j]][nx+dx[j]];
						nx+=dx[j];
						ny+=dy[j];
					}

				}
				tmp[r-s+i][c-s+i+1]=sub;
			}
			
		}
		for(int i=1;i<=N;i++) {
			sum=0;
			for(int j=1;j<=M;j++) {
				sum+=tmp[i][j];
			}
			min=Math.min(sum, min);
		}
			
	}

}
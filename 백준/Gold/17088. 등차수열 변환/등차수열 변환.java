
import java.util.*;
import java.io.*;

public class Main {

	public static int N;
    public static int[] arr;
    public static int min;
    public static int[] di=new int[]{1,1,1, 0,0, 0,-1,-1,-1};
    public static int[] dj=new int[]{1,0,-1,1,0,-1, 0, 1,-1};
    public static int[] count=new int[] {2,1,2,1,0,1,1,2,2};
    
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //크기가 N인 수열 A[A1,A2....An]가 있다.
        //이 수열을 등차수열로 변환하려 한다.
        //각각의 수에는 연산을 최대 한번 적용할 수 있다.
        //연산은 두가지. 1을 더하거나 뺼 수 있다.
        //등차수열로 바꾸기 위한 최소 연산 횟수를 구하라
        //등차수열로 바꿀 수 없다면 -1을 출력
        
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        min=N;
        if(N<2) {
        	System.out.println(0);
        	return;
        }
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
        
        // 생길 수 있는 등차 수열 경우
        // a1 a2
        // 같은 등차 3 이더라도
        // a1 a2인거랑
        // a1+1, a2+1 인거랑 다르다. 완전탐색 필요해보임.

        for(int a=0;a<9;a++) {
        	
        	arr[0]+=di[a];
        	
        	arr[1]+=dj[a];
        	
        	bruteForce(2,arr[1]-arr[0],count[a]);
        	
        	arr[0]-=di[a];
        	
        	arr[1]-=dj[a];
        	
        }
        if(min==N) min=-1;
        System.out.println(min);
        
    }
	
	public static void bruteForce(int p, int m, int cnt) {//위치 등차

		if(p==N) {

			min=Math.min(min, cnt);
			return;
		}
		
		if(cnt>=min) return;
		
		if(arr[p]-arr[p-1]==m) {
			bruteForce(p+1, m, cnt);
		}else if(arr[p]-arr[p-1]+1==m){
			arr[p]+=1;
			bruteForce(p+1, m, cnt+1);
			arr[p]-=1;
		}else if(arr[p]-arr[p-1]-1==m) {
			arr[p]-=1;
			bruteForce(p+1, m, cnt+1);
			arr[p]+=1;
		}
		
	}
  
}

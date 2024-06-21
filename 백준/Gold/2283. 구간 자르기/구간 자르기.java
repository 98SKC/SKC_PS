import java.util.*;
import java.io.*;

public class Main {

	static List<Integer> changed=new ArrayList<Integer>();
    static int[] sum=new int[1000001];
    static int max=0;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int A,B,cnt;

        Queue<int[]> point=new ArrayDeque<int[]>();
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	A=Integer.parseInt(st.nextToken());
        	B=Integer.parseInt(st.nextToken());
        	point.add(new int[] {A,B});
        	max=Math.max(max, B);
        	min=Math.min(A,min);
        }
        //min이 최소
        int[] p;
        while(!point.isEmpty()) {
        	p=point.poll();
        	cnt=1;
        	for(int i=p[0]+1;i<=max;i++) {
        		if(i<p[1]) {
        			sum[i]+=cnt++;
        		}else if(i==p[1]){
        			sum[i]+=cnt;
        		}else {
        			sum[i]+=cnt;
        		}
        	}
//        	for(int i=0;i<max;i++) {
//        		System.out.print(sum[i]+" ");
//        	}
//        	System.out.println();
        }
        

        int ansA=-1;
        int ansB=-1;
        
        for(int i=min;i<=max;i++) {
        	if(sum[i]>=K) {
        		ansA=searchA(i,K);
        	}
        	if(ansA!=-1) {
        		ansB=i;
        		break;
        	}
        }
        
        
        if(ansA==-1&&ansB==-1) {
        	System.out.println("0 0");
        }else{
        	 System.out.println(ansA+" "+ansB);
        }
       
    }
    //63퍼에서 시초인데...
    //지금 그럼 묹제가. 누적합이  
    //000000000000000000000000000000000000000000000000000000000000020 20 21 22 23 24 25인 곳에서  5를 찾으려고 20 25를 오기위해 0~20부분까지 반복하는게 문제?
    //i=min 넣으면서 68퍼로 오름. 근데 또 시초.
    //이 누적합은 길이 누적의 합이라서 계속 늘어나기만 하는 구조. 단 줄이 끊기면 계속 똑같다. 하나만 끊기는게 아니라 다 끊겨야한...근데 그걸 max로 제한하는데? X
    //시초나올만한 테케가 대체 또 뭐가있을까. 이분탐색을 해볼까
    static int searchA(int B,int K) {
        int left = 0;
        int right = B;
        int bestA = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (sum[B] - sum[mid] == K) {
                bestA = mid;
                right = mid - 1; // 더 작은 A를 찾기 위해 왼쪽 부분을 계속 탐색
            } else if (sum[B] - sum[mid] < K) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return bestA;
//
//    	for(int i=0;i<=B;i++) {//ansA를 구하는 파트. 
//    		
//    		if(sum[B]-sum[i]==K) {
//    			//System.out.println(i+" "+B);
//    			return i;
//    		}else if(sum[B]-sum[i]<K) {//여기서 리턴하잖아. 계속 0인부분이 실행도 안돼. 
//    			return -1;//못찾음
//    		}
//    		//누적합이 0인 구간에서 답이 안나왔어. 그럼 이후 누적합이 0인 부분도 다 답이 안되겠지. 그럼 바로 누적합이 0이 아닌 곳까지 가야함
//    		if(sum[i]==0) {
//    			i=min;
//    		}
//    	}
//    	return -1;//못찾음
    }
}
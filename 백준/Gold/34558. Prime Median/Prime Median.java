
import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int len;
	public static boolean[] v=new boolean[1000001];
	public static int[] prefixSum=new int[1000001];
    public static List<Integer> prime=new ArrayList<>();
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        N=Integer.parseInt(br.readLine());
        init();
        len=prime.size();
        //System.out.println(prime.toString());
        //System.out.println(Arrays.toString(prefixSum));
        //구간에서 소수 중 중앙값을 찾는 문제.
        // 처음 생각난건 에라토스테네스의 체로 소수들을 찾아내, 누적합 및 이분탐색을 사용
        
        StringTokenizer st;
        int left,right;
        int start;
        int cnt;
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	left=Integer.parseInt(st.nextToken());
        	right=Integer.parseInt(st.nextToken());
        	start=binarySearch(left);//left보다 처음으로 크거나 같은 소수
        	//System.out.println(left+" "+right+"사이에서 처음 소수는 "+prime.get(start)+"이다.");

        	//찾는 값이 없다.
        	if (start == len || prime.get(start) > right) {
                sb.append(-1).append("\n");
            }else{
        		//해당 구간에 몇개의 소수가 있는가
        		cnt=prefixSum[right]-prefixSum[left-1];
        		if(cnt%2==0) {
        			sb.append(-1+"\n");
        		}else {
        			sb.append(prime.get(start+cnt/2)+"\n");
        		}
        	}

        }
    	System.out.println(sb);
    }
    
    //소수를 찾아냄.
    public static void init() {
        // 0,1은 소수 아님
        v[0]=true;
        v[1]=true;
       
        for (int i = 2; i * i <= 1000000; i++) {
            if (!v[i]) {
                for (int cur = i * i; cur <= 1000000; cur += i) {
                    v[cur] = true;
                }
            }
        }

        
        for (int i = 2; i <= 1000000; i++) {
            if (!v[i]) {
                prime.add(i);
                prefixSum[i] = 1;
            }
            prefixSum[i] += prefixSum[i - 1];
        }
    }
        
    //num 이상의 수에서 처음 나오는 소수를 찾음
    public static int binarySearch(int num) {
    	
    	int left=0;
    	int right=len;
    	//lower 
    	int mid;
    	while(left<right) {
    		mid=left-(left-right)/2;
    		if(prime.get(mid)<num){//지금 포인터가 찾는 수보다 작다. 오른쪽을 봐야한다. left를 줄인다.
    			left=mid+1;
    		}else {
    			right=mid;
    		}
    	}
    	
    	return left;
    	
    	
    }
}




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] wire=new int[N][2];
        StringTokenizer st;
        int a,b;
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	wire[i][0]=a-1;
        	wire[i][1]=b-1;
        	
        }
        
        Arrays.sort(wire,new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return o1[1]-o2[1];
        	}
        });
        int len=1;
        int[] lis=new int[N];
        lis[0]=wire[0][0];
        int[] record=new int[N];
        for(int i=1;i<N;i++) {
        	if (lis[len - 1] < wire[i][0]) {
        	    lis[len] = wire[i][0];
        	    record[i] = len; 
        	    len++;
        	}else {
        		//이진 탐색으로 들어갈 곳을 찾는다. wire[i][0]보다 처음으로 작아지는 곳을 찾아야 하니, upperbound의 이전값
        		int left=0;
        		int right=len-1;
        		int mid;
        		while(left<right){
        			mid=left+(right-left)/2;
        			if(lis[mid]<=wire[i][0]) {
        				left=mid+1;
        			}else {
        				right=mid;
        			}
        		}
        		record[i]=left;
        		lis[left]=wire[i][0];
        	}
        }
        StringBuilder sb = new StringBuilder();
        boolean[] isInLIS = new boolean[N];
        int target = len - 1;

        for (int i = N - 1; i >= 0; i--) {
            if (record[i] == target) {
                isInLIS[i] = true;
                target--;
                if (target < 0) break;
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (!isInLIS[i]) {
                sb.append(wire[i][0] + 1).append("\n"); // 입력에서 -1 했으니 다시 +1
            }
        }
        System.out.println(N - len);
        System.out.print(sb);

    }
}

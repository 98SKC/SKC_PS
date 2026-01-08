
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        //중앙값을 2로 나눈다는건, 사실 그 뒤에는 신경 안쓴다는 거잖아.
        //중앙값을 나누면 무조건 작아지고, 그럼 왼쪽으로 가고, 오른쪽은 건들 일이 없는데
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N+1];
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr[0]=-1;
        
        for(int i=1;i<=N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        
        //정렬 후 절반만 사용.
        Arrays.sort(arr);
        
        int len=(N+1)/2;
        int cnt=0;
        for(int i=1;i<=len;i++) {
        	while(arr[i]>1) {
        		arr[i]/=2;
        		cnt++;
        	}
        }
        System.out.println(cnt+1);
        //나눴을 때 0이 되려면 1이 생겨야 한다는 것.
        //모든 수들이 1이 되고나서야 한번만 더 연산하면 0이 만들어 질 수 있다.
        
        
        //1 2 3 4 5 6 7
    }
        
}



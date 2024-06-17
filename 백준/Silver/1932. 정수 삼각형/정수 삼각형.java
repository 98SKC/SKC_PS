import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Integer>[] arr=new List[N];
        int count=1;
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	arr[i]=new ArrayList<>();
        	for(int j=0;j<count;j++) {
        		arr[i].add(Integer.parseInt(st.nextToken()));
        	}
        	count++;
        }
        List<Integer>[] sum=new List[N];
        sum[0]=new ArrayList<Integer>();
        sum[0].add(arr[0].get(0));
        int sub;
        count=2;
        for(int i=1;i<N;i++) {
        	sum[i]=new ArrayList<>();
        	sum[i].add(sum[i-1].get(0)+arr[i].get(0));
        	for(int j=1;j<count-1;j++) {
        		sub=Math.max(sum[i-1].get(j-1), sum[i-1].get(j));
        		sum[i].add(sub+arr[i].get(j));
        	}
        	sum[i].add(sum[i-1].get(count-2)+arr[i].get(count-1));
        	count++;
        }
        int answer=0;
        for(int a:sum[N-1]) {
        	answer=Math.max(answer, a);
        }
        System.out.println(answer);
    
    }
}
import java.io.*;
import java.util.*;

public class Main {
	
	public static HashSet<Integer> save=new HashSet<>();
	public static int[] arr;
	public static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr=new int[N];
        
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        //길이가 N인 수열이 주어질 때 수열에서 연속한 1개 이상의 수를 뽑았을 때
        //같은 수가 여러번 등장하지 않는 경우의 수를 구하라.
        //
        int start=0;
        int end=0;
        long answer=0;
        
        
        while (end < N) {
            
        	while (save.contains(arr[end])) {
                save.remove(arr[start++]);
            }
            
            save.add(arr[end]);
            answer += (end - start + 1);
            end++;
        }

        System.out.println(answer);
        //1 2 3 4 1 7 8
        
    
    
    }

}

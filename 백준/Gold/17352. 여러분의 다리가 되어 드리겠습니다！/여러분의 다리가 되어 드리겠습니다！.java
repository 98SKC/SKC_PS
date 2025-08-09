
import java.util.*;
import java.io.*;

public class Main {

	public static int[] parent;
	public static int N;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        //1부터 N까지의 N개의 섬
        //다리가 N-1개. 왕복 가능
        
        StringTokenizer st;
        // 다리는 N-2개가 주어짐
        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        
        
        int[] answer=new int[2];
        answer[0]=find(1);

        for(int i=2;i<=N;i++) {
        	if(find(i)!=answer[0]){
        		answer[1]=i;
        		break;
        	}
        }
      //  System.out.println(Arrays.toString(parent));
        System.out.println(answer[0]+" "+answer[1]);
        
    }
    
    public static boolean union(int a, int b) {
    	
    	int parentA=find(a);
    	int parentB=find(b);
    	
    	if(parentA==parentB) return false;
    	
    	if(parentA<parentB) parent[parentB]=parentA;
    	else parent[parentA]=parentB;
    	
    	return true;
    	
    	
    	
    }
    
    
    public static int find(int a) {
    	
    	if(parent[a]==a) return a;
    	else return parent[a] = find(parent[a]);

    }
}

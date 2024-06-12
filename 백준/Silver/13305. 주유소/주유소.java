import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] price=new int[N];
        int[] dis=new int[N];
        String[] distance=br.readLine().split(" ");
        String[] oil=br.readLine().split(" ");
        int min=Integer.MAX_VALUE;
        
        
        for(int i=0;i<N-1;i++) {
        	price[i]=Integer.parseInt(oil[i]);
        	dis[i]=Integer.parseInt(distance[i]);
        }
        
        long total=0;;
        for(int i=0;i<N-1;i++) {
        	if(price[i]<min) {
        		min=price[i];
        	}
        	total+=min*dis[i];
        }
        System.out.println(total);

        
    }
}
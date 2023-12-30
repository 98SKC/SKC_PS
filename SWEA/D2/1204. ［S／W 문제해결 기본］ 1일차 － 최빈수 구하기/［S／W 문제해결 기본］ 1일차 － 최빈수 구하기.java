import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String args[]) throws IOException {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int T=Integer.parseInt(br.readLine());
        
        
        int[] counts;
        int max_count, i, num, max_num;
        for(int test_case=0; test_case<T; test_case++) {
        	int number=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
        	counts = new int[101];
            max_count = 0;
            for(i=0; i<1000; i++) {
                num = Integer.parseInt(st.nextToken());
                counts[num]++;
                if( counts[num] > max_count ) max_count = counts[num];
            }
            max_num = -1;
            for(i=0; i<101; i++) {
                if( counts[i] != max_count ) continue;
                max_num = i;    
            }
           System.out.println("#"+number+" "+max_num);
        }
    }
}
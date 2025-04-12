
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        String[] str;
        HashSet<Integer> set=new HashSet<>();
        boolean[][] arr=new boolean[26][26];
        int point=0;
        int a,b;
        for(int i=0;i<N;i++) {
        	str=br.readLine().split(" ");
        	a=str[0].charAt(0)-'a';
        	b=str[2].charAt(0)-'a';
        	arr[a][b]=true;
        }
        
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }
        
        StringBuilder sb=new StringBuilder();
        int M=Integer.parseInt(br.readLine());
        for(int m=0;m<M;m++) {
        	str=br.readLine().split(" ");
        	a=str[0].charAt(0)-'a';
        	b=str[2].charAt(0)-'a';
        	if(arr[a][b]) {        		
        		sb.append("T\n");
        	}else {
        		sb.append("F\n");
        	}
        }
        System.out.println(sb);
        
    }
    
}

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {


    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    	boolean[][] visit=new boolean[100][100];
    	
    	int T=Integer.parseInt(br.readLine());
    	int count=0;
    	int row;
    	int col;
    	
    	for(int square=0;square<T;square++) {
    		String[] str=br.readLine().split(" ");
    		row=Integer.parseInt(str[0]);
    		col=Integer.parseInt(str[1]);
    		for(int i=row;i<row+10;i++) {
    			for(int j=col;j<col+10;j++) {
    				if(visit[i][j]==true) continue;
    				visit[i][j]=true;
    				count++;
    			}
    		}
    	}
    	 System.out.println(count);    	
    }
}
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] str= br.readLine().split(" ");
    	int n=Integer.parseInt(str[0]);
    	int m=Integer.parseInt(str[1]);
    	int[][] arr=new int[n][m];
    	int[][] arr2=new int[n][m];

    	
    	for(int i=0;i<n;i++) {
    		String[] nums=br.readLine().split(" ");
    		for(int j=0;j<m;j++) {
    			arr[i][j]=Integer.parseInt(nums[j]);
    		}
    	}
    	for(int i=0;i<n;i++) {
    		String[] nums=br.readLine().split(" ");
    		for(int j=0;j<m;j++) {
    			arr2[i][j]=Integer.parseInt(nums[j]);
    		}
    	}
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			System.out.print(arr[i][j]+arr2[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
}
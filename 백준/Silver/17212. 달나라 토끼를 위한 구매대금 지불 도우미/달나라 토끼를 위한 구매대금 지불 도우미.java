import java.io.*;

public class Main {
    static int[] money;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        money=new int[100001];
        
        money[1]=1;
        money[2]=1;
        money[3]=2;
        money[4]=2;
        money[5]=1;
        money[6]=2;
        money[7]=1;
        
        
        for(int i=8;i<=N;i++) {
        	money[i]=Math.min(Math.min(money[i-1], money[i-2]), Math.min(money[i-5], money[i-7]))+1;
        }
        System.out.println(money[N]);
    }
}
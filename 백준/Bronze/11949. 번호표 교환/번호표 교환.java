import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());       
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] stu=new int[N+1];
        
        for(int i=1;i<=N;i++) {
        	stu[i]=Integer.parseInt(br.readLine());
        }
        int a;
        int b;
        int sub;
        for(int i=1;i<=M;i++) {
        	//1번에게 i 카드를 준다.
        	
        	for(int j=1;j<N;j++) {
            	a=stu[j]%i;
            	b=stu[j+1]%i;
            	if(a>b) {
            		sub=stu[j];
            		stu[j]=stu[j+1];
            		stu[j+1]=sub;
            	}
            }
        	
        }
        for(int i=1;i<=N;i++) {
        	sb.append(stu[i]+"\n");
        }
  
        System.out.println(sb);
    }
}
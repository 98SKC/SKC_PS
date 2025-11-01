

import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        
        //홀수의 N명 학생들이 원 모양으로 둘러앉아 있다.
        //각 학생들은 모두 사탕을 다르게 갖고있다.(0이상)
        //반시계 방향으로 1번부터 N번까지 번호를 부여
        //인전한 두 학생이 가지고 있는 사탕의 수의 합을 안다.
        
        //이때 각 학생이 갖고있는 사탕의 수를 구하라.
        
        
        //a+b=9
        //b+c=10
        //c+d=5
        //...
        //
        //f+a
        
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        }
        boolean op=true;
        int sub=arr[0];
        for(int i=1;i<N;i++){
        	if(op){
        		sub=sub-arr[i];
        	}else {
        		sub=sub+arr[i];
        	}
        	//System.out.println("sub: "+sub);
        	op=!op;
        }
        StringBuilder sb=new StringBuilder();
        sub/=2;
        sb.append(sub+"\n");
        
        for(int i=0;i<N-1;i++) {
        	sb.append((arr[i]-sub)+"\n");
        	sub=arr[i]-sub;
        }
        
        System.out.println(sb);
    }
        
}



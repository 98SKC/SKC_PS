import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long N=Long.parseLong(br.readLine());
		long sum=0;//S
		int count=0;
		int i=0;
		
		while(true) {
			sum+=++i;
			if(sum>N) {// 1부터 점점 수를 키우다가 sum이 n을 넘으면 마지막 수를 지금까지의 원소에 1씩 추가해주는 느낌.
				System.out.println(count);
				return;
			}
			count++;
		}
	}
}
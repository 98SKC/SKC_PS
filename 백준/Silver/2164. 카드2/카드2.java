import java.util.*;
import java.io.*;



public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ArrayDeque<Integer> q=new ArrayDeque<>();
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int count=1;
		
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		
		while(q.size()>1) {
			if(count==1) q.pop();
			else {
				q.offer(q.pop());
			}
			count++;
			count%=2;
		}
		
		System.out.println(q.peek());//제일 위의 카드를 버리고, 그 다음 카드를 카드 뭉치 아래로
		
		
	}

}
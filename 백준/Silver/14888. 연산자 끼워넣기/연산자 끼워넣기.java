import java.io.*;
import java.util.*;

 
public class Main {
 
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	static int N;
	static int[] number;
	static int[] op=new int[4];// + - * /
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		
		number=new int[N];
		for(int i=0;i<N;i++) {
			number[i]=Integer.parseInt(st.nextToken());
		}
 
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			op[i]=Integer.parseInt(st.nextToken());
		}
		
		helper(number[0], 1);// 첫 원소는 넣어놓고 시작. 그리고 하나 넣었으니 깊이 1. 깊이는 정수의 개수
		System.out.println(max);
		System.out.println(min);
	}
 
	public static void helper(int num,int depth) {
		
		if(depth==N) {
			max=Math.max(num,max);
			min=Math.min(num,min);
			return;
		}
		 for (int i = 0; i < 4; i++) {//지금 위치에서 시작을 어떤 연산자로 할지 정한다. 다음 재귀에서도 앞에서부터 다시.
	            if(op[i]>0){//그 연산자가 남아 있으면 넣는다.
	            	op[i]--;
	                switch (i) {
	                    case 0: helper(num + number[depth], depth + 1);   break;
	                    case 1:	helper(num - number[depth], depth + 1);   break;
	                    case 2:	helper(num * number[depth], depth + 1);   break;
	                    case 3: helper(num / number[depth], depth + 1);   break;
	                }
	                op[i]++;// 넣은건 다시 뺸다.
	            }
	        }
	}
 
}
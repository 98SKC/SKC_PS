import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack=new Stack<>();
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		int op;
		// 매순간 출력하니 시간오류...
		for(int i=0;i<N;i++) {
			String[] str=br.readLine().split(" ");
			op=Integer.parseInt(str[0]);
			switch(op) {
				case 1:
					stack.push(Integer.parseInt(str[1]));
					break;
				case 2:
					if(stack.isEmpty()) {
						sb.append(-1).append("\n");
						//System.out.println(-1);
					}else {
						sb.append(stack.pop()).append("\n");
						//System.out.println(stack.pop());
					}
					break;
				case 3:
					sb.append(stack.size()).append("\n");
					//System.out.println(stack.size());
					break;
				case 4:
					if(stack.isEmpty()) {
						sb.append(1).append("\n");
						//System.out.println(1);
					}else {
						sb.append(0).append("\n");
						//System.out.println(0);
					}
					break;
				case 5:
					if(stack.isEmpty()) {
						sb.append(-1).append("\n");
						//System.out.println(-1);
					}else {
						sb.append(stack.peek()).append("\n");
						//System.out.println(stack.peek());
					}
					break;
				default: break;
			}
		}
		System.out.println(sb);
	}
}
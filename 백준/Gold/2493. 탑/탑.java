import java.io.*;
import java.util.*;


public class Main {

	static class top {
		int number;
		int heigh;
	
		top(int number,int heigh){
			this.number=number;
			this.heigh=heigh;
		}
	}

	
	public static void main(String[] args) throws Exception{
		
		StringBuilder sb=new StringBuilder();
		ArrayDeque<top> stack=new ArrayDeque<>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		
		st=new StringTokenizer(br.readLine());
		int[] arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			if(stack.isEmpty()) {
				sb.append(0).append(" ");
				stack.push(new top(i+1,arr[i]));
			}else if(stack.peek().heigh>=arr[i]){
				
				sb.append(stack.peek().number).append(" ");
				stack.push(new top(i+1,arr[i]));
				
			}else{//stack.peek().heigh<arr[i]
				while(!stack.isEmpty()) {
					
					if(stack.peek().heigh>=arr[i]) {
						sb.append(stack.peek().number).append(" ");
						stack.push(new top(i+1,arr[i]));
						break;
					}else {
						stack.pop();
					}
				}
				if(stack.isEmpty()) {
					sb.append(0).append(" ");
					stack.push(new top(i+1,arr[i]));
				}
			}
		}
		
		System.out.println(sb);
		
		
	}
	
	

}
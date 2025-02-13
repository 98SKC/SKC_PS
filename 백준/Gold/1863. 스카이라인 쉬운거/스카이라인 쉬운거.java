import java.io.*;
import java.util.*;

public class Main {

	
	
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<int[]> list=new ArrayList<>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
			
		}
		
		// 이전에 자신과 같은 높이가 있었는지,
		// 그 같은 높이의 건물과 자신 사이에 더 낮은 건물이 없는지 를 체크해야함
		// 건물 증가 범위는 높아질 때, 낮아질 때 두 경우 다 있는데, 어떤 시점에 해야하는가
		Stack<int[]> stack=new Stack<>();
		int count=0;
		for(int[] pos:list) {
			
			if(stack.isEmpty()||stack.peek()[1]<pos[1]) {// 스택이 비어있거나, 가장 최근 빌딩 높이가
				//이번 빌딩 높이보다 낮으면 스택에 추가
				stack.push(pos);
			}else {//가장 최근 빌딩 높이가 지금보다 높다. 지금 위치 높이보다 높은 것들 모두 건물 확정. 같은건 아님
				boolean check=true;
				while(check) {
					
					if(!stack.isEmpty()&&stack.peek()[1]>pos[1]) {
						stack.pop();
						//System.out.println(stack.pop()[1]+" 짜리 건물 하나"); 
						count++;
					}else if(!stack.isEmpty()&&stack.peek()[1]==pos[1]){
						check=false;
					}else{
						if(pos[1]>0) stack.push(pos);
						check=false;
					}
				}
			}
			
		}
		
		while(!stack.isEmpty()) {
			if(stack.peek()[1]>0)count++;
			stack.pop();
			//System.out.println(stack.pop()[1]+" 짜리 건물 하나"); 
			
		}
		
		System.out.println(count);
	}
	
	
}
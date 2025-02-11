import java.io.*;
import java.util.*;

public class Main {

	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<Integer>[] tree=new ArrayList[N];
		
		for(int i=0;i<N;i++) {
			tree[i]=new ArrayList<>();
		}
		StringTokenizer st=new StringTokenizer(br.readLine());
		int sub;
		int start=-1;
		for(int i=0;i<N;i++) {
			sub=Integer.parseInt(st.nextToken());
			if(sub!=-1) tree[sub].add(i);
			else start=i;
		}
		int del=Integer.parseInt(br.readLine());
		
		if(del!=start) {
			ArrayDeque<Integer> q=new ArrayDeque<>();
			q.add(start);
			int count=0;
			while(!q.isEmpty()) {
				sub=q.poll();
				if(tree[sub].size()==0||(tree[sub].size()==1&&tree[sub].get(0)==del)) {
					count++;
					continue;
				}
				for(int next:tree[sub]) {
					if(next!=del) {
						q.add(next);
					}
				}
			}
			System.out.println(count);
		}else {
			System.out.println(0);
		}
		
		
		
	}
	
	
}
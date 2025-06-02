import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		
		
		ArrayList<Integer>[] heavy=new ArrayList[N+1];
		ArrayList<Integer>[] light=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			heavy[i]=new ArrayList<>();
			light[i]=new ArrayList<>();
		}
		StringTokenizer st;
		int H,L;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			H=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			heavy[L].add(H);//L보다 무거운 H들
			light[H].add(L);//H보다 가벼운 L들
			
		}
		StringBuilder sb=new StringBuilder();
		int cnt;
		ArrayDeque<Integer> q=new ArrayDeque<>();
		int p;
		boolean[] v;
		for(int i=1;i<=N;i++) {
			cnt=0;
			//i보다 무거운 것들
			q.add(i);
			v=new boolean[N+1];
			v[i]=true;
			while(!q.isEmpty()){
				p=q.poll();
				
				for(int n:heavy[p]) {
					if(v[n]) continue;
					v[n]=true;
					cnt++;
				    q.add(n); // 추가
				}
			}
			
			q.add(i);
			while(!q.isEmpty()){
				p=q.poll();
				
				for(int n:light[p]) {
					if(v[n]) continue;
					v[n]=true;
					cnt++;
				    q.add(n); 
				}
			}
			sb.append((N-cnt-1)+"\n");
			//i보다 가벼운 것들
		}
		System.out.println(sb);

		
		
	}
	

}
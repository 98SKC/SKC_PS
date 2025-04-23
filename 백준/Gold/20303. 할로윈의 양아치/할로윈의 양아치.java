import java.io.*;
import java.util.*;

public class Main{
	

	public static ArrayList<int[]> list=new ArrayList<>();
	public static int K;
	public static int max=0;
	public static int len=0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken()); //아이들의 수
		int M=Integer.parseInt(st.nextToken()); //친구 관계 수
		K=Integer.parseInt(st.nextToken()); //사탕 뺐긴 아이는 K 미만이야 한다
		
		int[] candy=new int[N+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			candy[i]=Integer.parseInt(st.nextToken());//i가 갖고있는 사탕 
		}
		ArrayList<Integer>[] edge=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			edge[i]=new ArrayList<>();
		}
		int a,b;
		
		for(int i=1;i<=M;i++) {
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			edge[a].add(b);
			edge[b].add(a);
			
		}
		boolean[] v=new boolean[N+1];
		int pos;
		int c = 0;//현 그룹의 사탕의 양
		int p=0;//현 그룹의 사람의 양 
		ArrayDeque<Integer> q=new ArrayDeque<>();
		for(int i=1;i<=N;i++) {
			if(v[i]) continue;
			q.add(i);
			c=0;
			p=0;
			//System.out.println("r");
			v[i]=true;
			while(!q.isEmpty()) {
				pos=q.poll();
				c+=candy[pos];
				p++;
				for(Integer next:edge[pos]) {
					if(!v[next]) {
						v[next]=true;
						q.add(next);
					}
				}
			}
			list.add(new int[] {c,p});
		}
		int len=list.size();
		int[][] dp=new int[len+1][K];//k이상이면 안되니까 
		int price,weight;
		for(int i=1;i<=len;i++) {//i-1번째 물건까지 있을 때
			price=list.get(i-1)[0];
			weight=list.get(i-1)[1];
			for(int k=1;k<K;k++) {
				if(k<weight) {
					dp[i][k]=dp[i-1][k];
				}else {					
					dp[i][k]=Math.max(dp[i-1][k], dp[i-1][k-weight]+price);
				}
			}
		}
		System.out.println(dp[len][K-1]);
	}
	
	
	

}
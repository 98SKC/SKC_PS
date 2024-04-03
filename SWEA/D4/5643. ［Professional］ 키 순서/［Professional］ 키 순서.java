import java.io.*;
import java.util.*;

public class Solution {

	static int N,M;
	static int answer,count;
	static List<Integer>[] inList;
	static List<Integer>[] outList;
	static int[] check;
	static boolean v[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= test; t++) {
			answer=0;
			Queue<Integer> q=new ArrayDeque<>();
			N=Integer.parseInt(br.readLine());
			M=Integer.parseInt(br.readLine());
			inList=new List[N+1];
			outList=new List[N+1];
			check=new int[N+1];
			
			for(int i=1;i<=N;i++) {
				inList[i]=new ArrayList<>();
				outList[i]=new ArrayList<>();
			}
			
			int subA;
			int subB;
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				subA= Integer.parseInt(st.nextToken());
				subB= Integer.parseInt(st.nextToken());
				inList[subB].add(subA);
				outList[subA].add(subB);

			}
		
			for(int i=1;i<=N;i++) {
				v=new boolean[N+1];
				inLine(i);
				outLine(i);
				//System.out.println(i+"에서 "+check[i]+"값과 N 비교 "+N);
				//System.out.println();
				if(check[i]==(N-1)) {
					answer++;
				}
					
			}
			
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb);
	}
	
	static void inLine(int start) {
		Queue<Integer> q=new ArrayDeque<>();
		q.add(start);
		int sub=0;
		while(!q.isEmpty()) {
			sub=q.poll();
			
			for(int a:inList[sub]) {
				if(!v[a]) {
					q.add(a);
					v[a]=true;
					check[start]++;
				}	
			}
		}
		//System.out.println(start+"들어오는 노드 수"+check[start]);
	}
	
	static void outLine(int start) {
		Queue<Integer> q=new ArrayDeque<>();
		q.add(start);
		int sub=0;
		while(!q.isEmpty()) {
			sub=q.poll();
			
			for(int a:outList[sub]) {
				if(!v[a]) {
					q.add(a);
					v[a]=true;
					check[start]++;
				}	
			}
		}
		//System.out.println(start+"에서 나간 노드 수까지 합하면"+check[start]);
	
	}
}
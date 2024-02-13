import java.util.*;
import java.io.*;



public class Solution {
	
	static int[] kZero;
	static int[] iZero;
	static int[] sub;
	static boolean[] v;
	static int win;
	static int lose;
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/s_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		HashSet<Integer> set=new HashSet<>();
		for(int tc=1;tc<=T;tc++) {
			set.clear();
			win=0;
			lose=0;
			st=new StringTokenizer(br.readLine());
			kZero=new int[9];
			iZero=new int[9];
			v=new boolean[9];
			sub=new int[9];
			for(int i=0;i<9;i++) {
				kZero[i]=Integer.parseInt(st.nextToken());
				set.add(kZero[i]);
			}
			int count=0;
			for(int i=1;i<=18;i++) {
				if(!set.contains(i)) {
					iZero[count++]=i;
				}
			}
			perm(0);
			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}
	static void perm(int cnt) {
		if(cnt==9) {
			int kWin=0;
			int iWin=0;
			for(int i=0;i<9;i++) {
				if(kZero[i]-sub[i]>0) {
					kWin+=kZero[i]+sub[i];
				}else {
					iWin+=kZero[i]+sub[i];
				}
			}
			if(kWin>iWin) {
				win++;
			}else if(kWin<iWin) {
				lose++;
			}
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(v[i]) continue;
			v[i]=true;
			sub[cnt]=iZero[i];
			perm(cnt+1);
			v[i]=false;
		}
	}


}
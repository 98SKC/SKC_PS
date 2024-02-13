import java.util.*;
import java.io.*;



public class Solution {
	

	static List<Integer> kZero;
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
		
		for(int tc=1;tc<=T;tc++) {
			kZero=new ArrayList<>();
			win=0;
			lose=0;
			st=new StringTokenizer(br.readLine());
			iZero=new int[9];
			v=new boolean[9];
			sub=new int[9];
			for(int i=0;i<9;i++) {
				kZero.add(Integer.parseInt(st.nextToken()));
			}
			int count=0;
			for(int i=1;i<=18;i++) {
				if(!kZero.contains(i)) {
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
				if(kZero.get(i)-sub[i]>0) {
					kWin+=kZero.get(i)+sub[i];
				}else {
					iWin+=kZero.get(i)+sub[i];
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
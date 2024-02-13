import java.util.*;
import java.io.*;
 
 
 
public class Solution {
     
    static int[] kZero;
    static int[] iZero;
    static int[] sub;
    static boolean[] v;
    static int win;
    
     
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());
        HashSet<Integer> set=new HashSet<>();
        for(int tc=1;tc<=T;tc++) {
            set.clear();
            win=0;
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
            perm(0,0);
            sb.append("#").append(tc).append(" ").append(win).append(" ").append(362880-win).append("\n");
        }
        System.out.println(sb);
    }
    static void perm(int cnt,int sum) {
        if(sum>85) {
        	int total=1;
        	for(int i=9-cnt;i>0;i--) {
        		total*=i;
        	}
        	win+=total;
        	return;
        }

     
        for(int i=0;i<9;i++) {
            if(v[i]) continue;
            v[i]=true;
            if(kZero[cnt]>iZero[i]) {
            	perm(cnt+1,sum+iZero[i]+kZero[cnt]);
            }else {
            	perm(cnt+1,sum);
            }
            v[i]=false;
        }
    }
 
 
}
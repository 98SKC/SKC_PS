import java.util.*;
import java.io.*;
 
 
 
public class Solution {
     
    static int[] kZero;
    static int[] iZero;
    static int win;
    
     
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());
        HashSet<Integer> set=new HashSet<>();
        for(int tc=1;tc<=T;tc++) {
        	int sum=0;
            set.clear();
            win=0;
            st=new StringTokenizer(br.readLine());
            kZero=new int[9];
            iZero=new int[9];
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
            
            do {
            	sum=0;
    			for(int i=0;i<9;i++) {
    				if(kZero[i]>iZero[i]) {
    					sum+=kZero[i]+iZero[i];
    					if(sum>85) {
    						win++;
    						break;
    					}
    				}
    			}
    		}while(nPn());
            
            sb.append("#").append(tc).append(" ").append(win).append(" ").append(362880-win).append("\n");
        }
        System.out.println(sb);
    }
   
	static void swap(int i,int j) {
		int T=iZero[i]; iZero[i]=iZero[j]; iZero[j]=T;
		
	}
	
	static boolean nPn() {
		int i=8;//i 교환위치 찾기
		while(i>0 && iZero[i-1]>=iZero[i]) i--;
		if(i==0) return false;
		
		int j=8;//j 교환할값 찾기
		while(		iZero[i-1]>=iZero[j]) j--;
		swap(i-1,j);
		
		int k=8;//k 오름차순 정렬
		while(i<k) swap(i++,k--);
		return true;
	}
 
 
}
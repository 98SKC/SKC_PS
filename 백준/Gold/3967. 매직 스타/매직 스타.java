import java.util.*;
import java.io.*;

public class Main {

	public static StringBuilder sb=new StringBuilder();
	public static int[] alpha=new int[12];
	public static boolean find;
	public static HashSet<Integer> set=new HashSet<>();
	public static HashMap<Integer,int[]> pair=new HashMap<>();
	public static int[][] arr=new int[6][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //시간 복잡도를 줄여보기 위한 배열과 맵 선언
        arr[0]=new int[] {0,2,5,7};
        arr[1]=new int[] {0,3,6,10};
        arr[2]=new int[] {1,2,3,4};
        arr[3]=new int[] {1,5,8,11};
        arr[4]=new int[] {7,8,9,10};
        arr[5]=new int[] {4,6,9,11};
        
        pair.put(0,new int[] {0,1});
        pair.put(1,new int[] {2,3});
        pair.put(2,new int[] {0,2});
        pair.put(3,new int[] {1,2});
        pair.put(4,new int[] {2,5});
        pair.put(5,new int[] {0,3});
        pair.put(6,new int[] {1,5});
        pair.put(7,new int[] {0,4});
        pair.put(8,new int[] {3,4});
        pair.put(9,new int[] {4,5});
        pair.put(10,new int[] {1,4});
        pair.put(11,new int[] {3,5});
        String str;
        int pos=0;
        for(int i=0;i<5;i++) {
        	str=br.readLine();
        	for(int j=0;j<9;j++) {
        		if(str.charAt(j)=='.')continue;
        		if(str.charAt(j)=='x') {
        			pos++;
        		}else {
        			alpha[pos]=str.charAt(j)-'A'+1;
        			set.add(str.charAt(j)-'A'+1);
        			pos++;
        		}
        	}
        }
        //System.out.println(Arrays.toString(alpha));
        dfs(0);
       // System.out.println(Arrays.toString(alpha));
       // System.out.println();
        drawStar();
    }
    
    
    public static void drawStar() {
        sb.append("...." + (char) ('A' + (alpha[0] - 1)) + "....");
        sb.append("\n");
        sb.append("." + (char) ('A' + (alpha[1] - 1))+ "."+ (char) ('A' + (alpha[2] - 1))+ "."+ (char) ('A' + (alpha[3] - 1))+ "." + (char) ('A' + (alpha[4] - 1))+".");
        sb.append("\n");
        sb.append(".." + (char) ('A' + (alpha[5] - 1)) + "..."+(char) ('A' + (alpha[6] - 1))+"..");
        sb.append("\n");
        sb.append("." + (char) ('A' + (alpha[7] - 1))+ "."+ (char) ('A' + (alpha[8] - 1))+ "."+ (char) ('A' + (alpha[9] - 1))+ "." + (char) ('A' + (alpha[10] - 1))+".");
        sb.append("\n");
        sb.append("...." + (char) ('A' + (alpha[11] - 1)) + "....");
        System.out.println(sb);
    }
    
    public static void dfs(int pos) {
    	//System.out.println(pos);
    	
    	if(pos==12) {
    		find=true;
    		return;
    	}
    	if(alpha[pos]!=0) {
    		dfs(pos+1);
    	}else {
    		for(int i=1;i<=12;i++) {
    			if(!set.contains(i)&&check(pos,i)){// 아직 나온 알파벳(숫자)가 아니고, 들어갈 수 있는 숫자.
    				alpha[pos]=i;
    				set.add(i);
    				dfs(pos+1);
    				if(find) return;
    				alpha[pos]=0;
    				set.remove(i);
    			}
                
    		}
    	}
    	
    }
    
    public static boolean check(int pos, int word) {
    	alpha[pos]=word;
    	for(int index : pair.get(pos)) {
    		int sum=0;
    		for(int i=0;i<4;i++) {
    			sum+=alpha[arr[index][i]];
    		}
    		if(sum>26) {
    			alpha[pos]=0;
    			return false;
    		}
    		sum=0;
    	}
    	alpha[pos]=0;
    	return true;
    }

}
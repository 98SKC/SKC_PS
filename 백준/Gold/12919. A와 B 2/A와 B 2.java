import java.io.*;
import java.util.*;

public class Main {

	public static String str, goal;
	public static int goalA,goalB;
	public static int len;
	public static boolean find;
	public static HashSet<String> set=new HashSet<>();

	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		goal=br.readLine();
		str=br.readLine();
		
		dfs(str);
		
		if(find) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}	
	
	public static void dfs(String s) {
		if(find||s.length()==0) return;
		//System.out.println(s);
		if(s.equals(goal)) {
			find=true;
			return;
		}
		int len=s.length();
		if(s.charAt(s.length()-1)=='A') {
			dfs(s.substring(0,len-1));
		}
		if(find) return;
		if(s.charAt(0)=='B') {
			dfs(new StringBuilder(s.substring(1)).reverse().toString());
		}
		
	}
	
	
}
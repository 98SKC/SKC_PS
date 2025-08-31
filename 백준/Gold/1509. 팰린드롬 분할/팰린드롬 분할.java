
import java.util.*;
import java.io.*;

public class Main {
	
	public static boolean[][] palindrome;
	public static int[] dp;
	public static String str;
	public static int len;
    
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        str=br.readLine();
        len=str.length();
        
        
        //일단 최대는 len. (모든 글자가 분할되어있는 상태.)
        //
        
        // dp[i]를 0부터 i까지 팰린드롬 분할의 최소 개수라고 하자.
        dp=new int[len+1];
        
        // palindrome[i][j]는 i부터 j까지 문자열이 팰린드롬이면 true.
        palindrome=new boolean[len+1][len+1]; 
        
        for(int i=1;i<=len;i++) {
        	dp[i]=len+1;//여유있게 하나 더 
        }
        
        findPalindrome(len);
        
        
        //i까지의 최소 팰린드롬 분할 수를 찾는다.
		for (int i = 1; i <= len; i++) {
			
			//j~i까지가 팰린드롬이라면, 지금 i까지의 최소값 구해진 것 vs j직전까지의 최소 +1
			//j~i가 하나의 팰린드롬으로 1,  0~j-1 의 최소에 1더한게 최소.
			for (int j = 1; j <= i; j++) {
				if (palindrome[j][i]) {
					dp[i] = Math.min(dp[i], dp[j - 1] + 1);
				}
			}
		}
		
		System.out.println(dp[len]);
        
    }
    
//    public static void findPalindrome(int index) {
//    	
//    	boolean find;
//    	int s,e;
//    	
//    	
//    	for(int start=1;start<=index;start++){
//    		for(int end=start;end<=index;end++) {
//    			find=true;
//    			s=start-1;
//    			e=end-1;
//				
//    			while (s <= e) {
//    				//앞과 뒤가 다르면? 펠리드롬이 아님.
//    				if (str.charAt(s++) != str.charAt(e--)) {
//						find = false;
//						break;
//					}
//				}
//				
//    			//위에서 false가 안되었다면 팰리드롬이 맞음
//				if(find) palindrome[start][end] = true;
//    			
//    		}
//    	}
//    	
//    	
//    }
	
	public static void findPalindrome(int n) {
	    // 길이가 1인 구간은 항상 팰린드롬
	    for (int i = 1; i <= n; i++) {
	        palindrome[i][i] = true;
	    }

	    // 길이가 2 이상인 구간
	    for (int len = 2; len <= n; len++) {
	        for (int start = 1; start + len - 1 <= n; start++) {
	            int end = start + len - 1;

	            // 양 끝이 같으면서 가운데 구간이 팰린드롬이면 true
	            if (str.charAt(start - 1) == str.charAt(end - 1)) {
	                if (len == 2) { // 길이 2는 그냥 양 끝 같으면 됨
	                    palindrome[start][end] = true;
	                } else {
	                    palindrome[start][end] = palindrome[start + 1][end - 1];
	                }
	            }
	        }
	    }
	}
    
}

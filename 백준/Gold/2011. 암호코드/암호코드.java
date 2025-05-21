
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str=br.readLine();// 5천자리
        
        // 재귀 X, dp  누적합,곱   점화식
        int len=str.length();
        int[] dp=new int[len];//str의 i인덱스까지 의 최대
        int start=str.charAt(0)-'0';
        int second=-1;
        
        if (start == 0) {
            System.out.println(0);
            return;
        }
        dp[0] = 1;

        if (len >= 2) {
            second = str.charAt(1) - '0';
            int firstTwoDigits = start * 10 + second;

            if (second != 0) {
                dp[1] = 1;
                if (firstTwoDigits <= 26) {
                    dp[1]++;
                }
            } else {
                if (firstTwoDigits == 10 || firstTwoDigits == 20) {
                    dp[1] = 1;
                } else {
                    System.out.println(0);
                    return;
                }
            }
        }
        
        int before=second*10;// 이전 수 *10
        int number=0;
        boolean possible=true;
        for(int i=2;i<len;i++) {
        	number=str.charAt(i)-'0';
        	if(number!=0) dp[i]=(dp[i]%1000000+dp[i-1]%1000000)%1000000; // 0이 단독으로 사용될 수는 없음
        	if(before!=0&&(before+number>=1&&before+number<=26)) dp[i]=(dp[i]%1000000+dp[i-2]%1000000)%1000000; //이전 숫자가 0이거나, 두 자리의 합이 1~26이 아니면 이 수는 단독으로만 사용되어야함
        	if(number==0&&before==0) possible=false;
        	else before=number*10;
        	if(!possible) break;
        }
       // System.out.println(Arrays.toString(dp));
        if(possible) {
        	//System.out.println("??");
        	System.out.println(dp[len-1]);
        }else {
        	//System.out.println("?");
        	System.out.println(0);
        }
        
        //dp[0]=1;
        //dp[1]=dp[0]+if(11<=str[0]*10+str[1]<=26)
        
        //암호가 잘못되는 경우 ex) 00이 나오는 경우.
        
        //0 1 2 3 4 5
        //2 2 2 2 2 2
        
        //1 
    }
    //2 5,     25
    //2 5 1,   25 1    
    //2 5 1 1, 25 1 1, 25 11, 2 5 11,
}

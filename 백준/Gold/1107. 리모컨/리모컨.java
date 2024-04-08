import java.util.*;

import javax.management.StringValueExp;

import java.io.*;

public class Main {
	static int goal;
	static int b;
	static boolean[] button=new boolean[10];

	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        goal=Integer.parseInt(br.readLine().trim());
        b=Integer.parseInt(br.readLine());

        
     
        if(b!=0) {
        	StringTokenizer st=new StringTokenizer(br.readLine());	
        	for(int i=0;i<b;i++) {
            	button[Integer.parseInt(st.nextToken())]=true;
            }
        }

        int answer = Math.abs(100-goal);// 번호 이동 없이 순수 +,-	
        int len;// 그냥 입력해서 가는 경우
        int sub=0;
        for(int i=0;i<=999999;i++) {
        	if(!check(i)) continue;
        	len=String.valueOf(i).length();
        	sub=len+Math.abs(i-goal);
        	answer=Math.min(answer, sub);

        }
        
        
        System.out.println(answer);
    }
    
    static boolean check(int g) {
    	if (g == 0) return !button[0]; // goal이 0인 경우에 대한 처리 추가
    	while(g>0) {
    		if(button[g%10]) return false;
    		g=g/10;
    	}
    	
    	return true;
    }
    
    
}
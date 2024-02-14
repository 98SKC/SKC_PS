import java.io.*;
import java.util.*;

public class Main {

	static int[][] arr;
	static boolean answer;
    public static void main(String[] args) throws Exception {
    	
    	StringBuilder sb=new StringBuilder();
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	boolean possible;
    
    	for(int tc=1;tc<=4;tc++) {
    		possible=true;
    		answer=false;
    		arr=new int[6][3];
    		st=new StringTokenizer(br.readLine());
    		for(int team=0;team<6;team++) {
    			for(int score=0;score<3;score++) {
    				arr[team][score]=Integer.parseInt(st.nextToken());
    				if(arr[team][score]==6) {
    					possible=false;
    					break;
    				}
    			}
    			if(arr[team][0]+arr[team][1]+arr[team][2]!=5) {
    				possible=false;
    			}
    			if(!possible) break;
    		}
    		if(possible) {
    			play(15);
    		}
    		if(answer) {
    			sb.append(1).append(" ");
    		}else {
    			sb.append(0).append(" ");
    		}
    		
    	}
    	System.out.println(sb);
    }
  
    
    //15 14 13 12 11      10 9 8 7      6 5 4   3 2  1
    static void play(int count) {// 15번의 경기
    	//System.out.println("위치확인");
    	if(count==0) answer=true;
    	int a=0;
    	int b=0;
    	if(count>10) {//a
    		a=0;
    		b=count-10;
    	}else if(count>6) {//b
    		a=1;
    		b=count-5;
    	}else if(count>3) {//c
    		a=2;
    		b=count-1;
    	}else if(count>1) {
    		a=3;
    		b=count+2;
    	}else {
    		a=4;
    		b=5;
    	}
    	//System.out.printf("%d와 %d의 경기",a,b);
    	//System.out.println();
    	//a가 이김.
		if(arr[a][0]>=1&&arr[b][2]>=1) {
			arr[a][0]--;
    		arr[b][2]--;
			play(count-1);	
			//복구
    		arr[a][0]++;
    		arr[b][2]++;
		}
		if(arr[a][2]>=1&&arr[b][0]>=1) {
			//a가 지는 경우
    		arr[a][2]--;
    		arr[b][0]--;
    		play(count-1);
    		//복구
    		arr[a][2]++;
    		arr[b][0]++;
		}
		if(arr[a][1]>=1&&arr[b][1]>=1) {
			//a가 비기는 경우
    		arr[a][1]--;
    		arr[b][1]--;
    		play(count-1);
    		//복구
    		arr[a][1]++;
    		arr[b][1]++;
		}
    	
    	
    }
    
}
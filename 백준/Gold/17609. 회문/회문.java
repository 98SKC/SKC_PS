import java.util.*;
import java.io.*;

public class Main {

	public static String str;
	public static boolean check;
	public static int palindrome;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        
        StringBuilder sb=new StringBuilder();
        
        for(int t=1;t<=T;t++) {
        	
        	str=br.readLine();
        	//System.out.println(t+" 문자 "+str);
        	int answer=find(0,str.length()-1,true);
        	sb.append(answer+"\n");
        }
        
        
        System.out.println(sb);
    }
    
    public static int find(int f,int b,boolean check) {
    	int pointA,pointB;
    	pointA=f;
    	pointB=b;
    	int answer=0;
    	if(!check) answer=1;
    	while(pointA<=pointB) {
    		if(str.charAt(pointA)==str.charAt(pointB)){// 두 포인트가 같으면 다음
    			pointA++;
    			pointB--;
    			continue;
    		}else{
    			if(check){
    				//System.out.println(pointA+" "+pointB+"위치인 "+str.charAt(pointA)+" "+str.charAt(pointB)+" 가 불일치로 생략 시도");
    				
    				if(str.charAt(pointA+1)==str.charAt(pointB)) {
    					answer=find(pointA+2,pointB-1,false);
        				//System.out.println("왼쪽 생략 결과: "+answer);
    				}
    				//위에서 1이 나왔으면 반대쪽 생략은 한해도 됨.
    				if(answer!=1&&(str.charAt(pointA)==str.charAt(pointB-1))) {
    					answer=find(pointA+1,pointB-2,false);
    					//System.out.println("오른쪽 생략 결과: "+answer);
    				}
    				
    				if(answer==0) {
    					//System.out.println("회문이 아니다1");
        				return 2;
    				}else if(answer==1) {
    					//System.out.println("고로 유사 회문이다");
    				} 
    				return answer;
    				
    			}else{
    				//System.out.println("회문이 아니다2");
    				return 2;
    			}
    		}
    	}
    	
		if(check){//기회를 사용하지 않음. 회문
			return 0;
		}else {//기회를 사용함. 유사회문
			return 1;
		}
		

    }
}
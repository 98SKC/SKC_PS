import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] price=new int[N];
        for(int i=0;i<N;i++) {
        	price[i]=Integer.parseInt(st.nextToken());
        }
        
        int money=Integer.parseInt(br.readLine());
        
        int totalPrice=0;
        int min=1;// 값어치가 가장 낮은 수. 0을 제외하고.
        
        for(int i=2;i<N;i++) {
        	if(price[i]<=price[min]) {
        		min=i;
        	}
        }
        if(N==1||price[min]>money) {
        	System.out.println(0);
        	return;
        }
        int min2=0;
        if(price[0]<price[min]) {
        	min2=0;
        }else {
        	min2=min;
        }
        

        totalPrice+=price[min];
        String str=min+"";
        
        while(totalPrice<=money) {
        	if(totalPrice+price[min2]>money) {
        		break;
        	}
        	str+=min2;
        	totalPrice+=price[min2];
        }
        
        char[] answer=new char[str.length()];
        for(int i=0;i<str.length();i++) {//큰 수부터 바꿀 수 있는가?
        	answer[i]=str.charAt(i);
        }
        int big=N-1;
        int change=money-totalPrice;// 남은 돈. 잔돈
        
        int reMoney;
        
        //System.out.println("시작 전 최장 문자열: "+str);
       // System.out.println("남은 잔돈: "+change);
        for(int i=0;i<str.length();i++) {//큰 수부터 바꿀 수 있는가?
        	if(big<0) break;
        	if(i!=0){
        		reMoney=price[min2];
        	}else {
        		reMoney=price[min];
        	}
        	
        	//System.out.println(big+" 으로 바꾸려고 한다. "+(change+reMoney)+" 로 살 수 있을까");
        	if(price[big]<=(change+reMoney)) {
        		//System.out.println("값을 바꾼다 "+answer[i]+" ->"+(char)(big));
        		answer[i]=(char)(big+'0');
        		change+=reMoney;//기존 숫자의 값 반환
        		change-=price[big];
        		
        	}else {
        		big--;
        		i--;// 한단위 작은 돈으로 가능한지 다시 확인
        	}
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<answer.length;i++) {//큰 수부터 바꿀 수 있는가?
        	sb.append(answer[i]);
        }
        
        System.out.println(sb);
        //파는 숫자는 1의 자리
        
    }
}
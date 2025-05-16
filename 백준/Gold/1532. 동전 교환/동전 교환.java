
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] coin=new int[3];
        int[] price=new int[3];
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++) {
        	coin[i]=Integer.parseInt(st.nextToken());
        }	
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++) {
        	price[i]=Integer.parseInt(st.nextToken());
        }
        
        int turn=0;
        while(coin[0]<price[0]){//금 먼저 채운다.
        	if(coin[1]>=11){//은화가 금으로 바꿀 수 있다.
        		turn++;
        		coin[0]+=1;
        		coin[1]-=11;
        		continue;
        	}else if(coin[2]>=11){//동화를 은으로 바꿀 수 있다.
        		turn++;
        		coin[1]+=1;
        		coin[2]-=11;
        		continue;
        	}else {
        		System.out.println(-1);
        		return;
        	}
        	
        }
        if(coin[0]<price[0]) {
        	System.out.println(-1);
    		return;
        }
        
        while(coin[1]<price[1]){//은을 채운다.
        	if(coin[0]>price[0]){//금이 여유있다
        		turn++;
        		coin[0]-=1;
        		coin[1]+=9;
        		continue;
        	}else if(coin[2]>=11){//동화를 은으로 바꿀 수 있다.
        		turn++;
        		coin[1]+=1;
        		coin[2]-=11;
        		continue;
        	}else {
        		System.out.println(-1);
        		return;
        	}
        	
        }
        if(coin[1]<price[1]) {
        	System.out.println(-1);
    		return;
        }
        
        while(coin[2]<price[2]){//동을 채운다.
        	if(coin[1]>price[1]){//은이 여유있다
        		turn++;
        		coin[1]-=1;
        		coin[2]+=9;
        		continue;
        	}else if(coin[0]>price[0]){//금을 은으로 바꿀 수 있다.
        		turn++;
        		coin[0]-=1;
        		coin[1]+=9;
        		continue;
        	}else {
        		System.out.println(-1);
        		return;
        	}
        	
        }
        
        System.out.println(turn);

        
        
    }
}

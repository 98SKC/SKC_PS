import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        //System.setIn(new FileInputStream("input.txt")); 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        StringBuilder sb=new StringBuilder();
        
        String str;
        int[] legos;
        // while 루프의 조건은 그대로 두는 것이 표준적입니다.
        while ((str = br.readLine()) != null) {
           
            // 빈 줄이 입력될 경우를 대비해 안정성을 높이는 코드
            if (str.trim().isEmpty()) {
                continue; // 혹은 break; 로 루프를 완전히 빠져나갈 수 있습니다.
            }
            int x = Integer.parseInt(str);       // 구멍 너비(cm)
            int n = Integer.parseInt(br.readLine()); // 레고 조각 개수
            int goal=x*10000000;// 두 조각으로 막아야 하는 것
            legos=new int[n];
            
            for(int i=0;i<n;i++) {
            	legos[i]=Integer.parseInt(br.readLine());
            }
            
            Arrays.sort(legos);
            int left=0;
            int right=n-1;
            int sum=0;
            boolean find=false;
            while(left<right) {
            	
            	sum=legos[left]+legos[right];
            	if(sum>goal) {
            		right--;
            	}else if(sum<goal){
            		left++;
            	}else {
            		find=true;
            		break;
            	}
            	
            }
      
            if(find) sb.append("yes "+legos[left]+" "+legos[right]+"\n");
            else sb.append("danger\n");
            //1차 로직: 정렬 후 투포인터.
            
            
        }
        //로봇을 만드는 중 구멍이 생김.
        //구멍을 막을 두 레고가 필요
        //구멍의 너비는 x, 구멍에 넣는 레고의 길이의 합은 너비와 일치해야한다.
        //항상 두개의 조각으로 막아야함
        // 모든 레고의 크기를 알 떼, 이를 완벽하게 막을 두 조각을 구하시오.
        
        //입력은 여러개의 테스트케이스로 이루어짐
        //각 테스트케이스 첫줄은 구멍의 너비가 주어짐 (센티미터)
        //다음 줄에는 레고 조각의 수 n
        //다음 N개의 줄에는 레고 조각의 길이 L. l은 양수인데 단위가 나노미터
        //1센티미터는 10000000 나노미터.

        
        System.out.println(sb);
        
    }

}

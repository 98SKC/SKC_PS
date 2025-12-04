

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        // 형제는 N개의 논을 각각 갖고 있다.
        // 각 논에는 an1 an2 an3.... anN , bn1 bn2 bn3 ... bnN 개씩 볏단이 쌓였다.
        // 매일 밤 서로 같은 정수 i,j (1<i<j<=N) 을 정해서 i번째 논의 볏단을 상대의 j번째 논에 옮겨 놓았다.
        // 형제는 모든 볏단이 N번째 논으로 모일 때까지 매일 밤 볏단을 옮기는 것을 반복했다
        // 모든 볏단을 N번째 논으로 모으는 방법을 시뮬레이션한다.
        // 더 이상 볏단을 옮길 수 없을 때, N번째 논에 모인 두 볏단의 양은 최대 얼마만큼 차이날 수 있는지 구하라.
        
        
        // 경우의수는...안되겠지?
        
        // 자기 볏이 돌아오는 법: 자신의 뒤의 크로스에 보낸다
        // 자기 볏을 보내는 법 : 그냥 바로 N 논에 보낸다.
        // N-1의 논의 볏은 무조건 N논에 넣어야 한다.
        // An+Bn-1, Bn+An-1 중 큰곳에 큰 값들을 몰아준다.
        // 자기 자신에게 주려면 n-1위치로 보내면 되고, 상대에게 줄거면 바로 N에게 옮기면 되기 때문
        int[] oldB=new int[N+1];
        int[] youngB=new int[N+1];
        
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
        	oldB[i]=Integer.parseInt(st.nextToken());
        	
        }
        
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
        	youngB[i]=Integer.parseInt(st.nextToken());
        	
        }
        
        int[] answer=new int[2];
        answer[0]=oldB[N]+youngB[N-1];
        answer[1]=youngB[N]+oldB[N-1];
        
        //answer[0]을 항상 더 크도록
        if(answer[0]<answer[1]){
        	int tmp=answer[0];
        	answer[0]=answer[1];
        	answer[1]=tmp;
        }
        //System.out.println(answer[0]+" "+answer[1]);
        
        int big,small;
        // 1 2 3 4 5 6   N이 6일 때 4까지 봐야함
        for(int i=1;i<N-1;i++){
        	big=Math.max(oldB[i], youngB[i]);
        	small=Math.min(oldB[i], youngB[i]);
        	
        	answer[0]+=big;
        	answer[1]+=small;
        	
        }
        
        
        System.out.println(answer[0]-answer[1]);
    }
        
}



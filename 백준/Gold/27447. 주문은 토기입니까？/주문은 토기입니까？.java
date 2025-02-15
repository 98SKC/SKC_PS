import java.util.*;
import java.io.*;

public class Main {

	// 1의 시간동안 토기를 만들거나, 토기 하나에 커피를 담거나, 토기 하나를 서빙할 수 있다.
    // 손님이 도착하면 바로 서빙 시작해야한다.
    // 커피를 담고나서 M시간이 흐르면 흙탕물이 된다. 서빙 완료 전까지 흙탕물이 되면 안된다.
    // 서빙 완료와 함께 흙탕물이 되는건 허용
    // 일을 시작하는 시간은 0. 이미 만들어져 있는 토기다 커피가 담겨있는 토기는 없다.
    // 손님이 카페에 도착하는 시각들이 주어질 때, 모든 손님에게 제대로된 커피를 제공할 수 있는지 출력해라.
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());// 손님의 수
        int M=Integer.parseInt(st.nextToken());// 흙탕물이 되는 시간
        st=new StringTokenizer(br.readLine());
        int[] time=new int[N];
        
        
        for(int i=0;i<N;i++) {
        	time[i]=Integer.parseInt(st.nextToken());
        }
        
        boolean check=true;
        //커피만들기가 기본, 커피를 담으면 그 커피의 M카운터 실행, 손님오면 서빙
        //손님 수가 N이라는 건 행동이 3N번 한다는 의미
        
        
        // 그리디인가. 커피 서빙을 기준으로 가장 뒤에 커피 만들기,
        // M거리 내에 커피 담기?
        
        int point1=0;
        int point2=0;
        
        // 커피 만들기=1, 커피 담기=2, 커피 서빙=3
        // 커피는 가능한 빨리 만들 수 있을 때 만들어 두기. 커피를 담는 것은 손님 오는 시간 M전부터.
        int[] action=new int[time[N-1]+1];//최대 time[N-1]의 시간까지 행동해야함.
        for(int i=0;i<N;i++){

        	check=false;
        	
        	while(point1<time[i]-2) {
        		if(action[point1]==0&&i<time[i]-1){// 이 시간대의 사람을 위한 커피 제작 && 도착 2시간 전인가??
            		action[point1]=1;
            		point1++;
            		check=true;
            		break;
            	}else{// 다른 행동이 예정되어 있으면 다음 시간 확인
            		point1++;
            	}
        	}
        	
        	if(!check) break;
        	
        	point2=Math.max(point2, time[i]-M);//  커피가 3만큼 시간이 지나면 흑탕물이 된다   0 1 2 3    
        	//커피 담기는 M시간 내에
        	while(point2<time[i]){//서빙 전에는 담아야 한다.
        		if(action[point2]==0) {
        			action[point2]=2;
        			break;
        		}else {
        			point2++;
        		}       		
        	}
        	
        	if(point2<time[i]) {
        		action[time[i]]=3;
        	}else {
        		check=false;
        		break;
        	}	
        }
        
        
        //System.out.println(Arrays.toString(action));
        if(check) {
        	System.out.println("success");
        }else {
        	System.out.println("fail");
        }
        
        
    }
}
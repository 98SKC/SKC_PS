
import java.util.*;
import java.io.*;

public class Main{

	public static class Building{
		int idx;
		int h;
		
		public Building(int idx, int h) {
			this.idx=idx;
			this.h=h;
		}
		
		
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        int[] buildings=new int[N+1]; 
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        
        for(int i=1;i<=N;i++) {
        	buildings[i]=Integer.parseInt(st.nextToken());
        }
        //다양한 높이의 건물 N개.
        //각 건물 옥상에서 양 옆에 몇개를 볼 수 있는지 확인
        //건물보다 높은 건물들만 볼 수 있다.
        
        //그 사이에 두 건물보다 높은 건물이 있으면 볼 수 없다
        
        //i번째 건물에서 볼 수 있는 건물의 개수를 출력
        // 볼수있는 건물이 여러개라면 I번째 건물에서 거리가 가장 가꾸ㅏ운 건물의 번호 중 작은 번호로 출력
        // 건물의 개수 & 가장 가까운 거리의 건물 번호
        
        // 한번의 완탐으로 알아야 할 것 같은데
        
        // 더 높은게 나오면 스택을 비우고 새로 쌓기
        
        Stack<Building> right=new Stack<>();
        Stack<Building> left=new Stack<>();
        
        // 왼쪽에서 오는건 스택으로 본다고 하자. 
        // 오른쪽에서 볼건?
        // 양쪽에서 와야하나?
        int[] buildingNumber=new int[N+1];//가장가깝고, 가장 작은 번호 저장.
        int[] answer=new int[N+1];//볼수 있는 빌딩 수.
        for(int i=1;i<=N;i++) {
        	while(!right.isEmpty()) {
    			if(right.peek().h>buildings[i]) {
    				buildingNumber[i]=right.peek().idx;
    				answer[i]+=right.size();
    				break;
        		}
    			right.pop();
    			
    		}
        	right.add(new Building(i,buildings[i]));
        }
        int a,b;
        for(int i=N;i>0;i--) {
        	while(!left.isEmpty()) {
    			if(left.peek().h>buildings[i]) {
    				if(answer[i]==0) {
    					buildingNumber[i]=left.peek().idx;
    				}else {
        				a=i-buildingNumber[i];
        				b=left.peek().idx-i;
        				if(b<a) {
        					buildingNumber[i]=left.peek().idx;
        				}
    				}
    				answer[i]+=left.size();

    				break;
        		}
    			left.pop();
    			
    		}
        	left.add(new Building(i,buildings[i]));
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=N;i++) {
        	if(answer[i]!=0) {
        		sb.append(answer[i]+" "+buildingNumber[i]+"\n");
        	}else {
        		sb.append(0+"\n");
        	}
        	
        }
        System.out.println(sb);
        
        
    }
}

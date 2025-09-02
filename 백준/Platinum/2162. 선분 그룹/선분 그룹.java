

import java.util.*;
import java.io.*;

public class Main{
	public static int[] parent;
	public static int[][] coordinate;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int x1, y1, x2, y2;
        parent=new int[N+1];
        coordinate=new int[N+1][4];
        
        for(int i=1;i<=N;i++) {
        	parent[i]=i;
        }
        
        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	coordinate[i][0]=Integer.parseInt(st.nextToken());
        	coordinate[i][1]=Integer.parseInt(st.nextToken());
        	coordinate[i][2]=Integer.parseInt(st.nextToken());
        	coordinate[i][3]=Integer.parseInt(st.nextToken());
        	
        	for(int j=1;j<i;j++) {
        		if(segmentsIntersect(j,i)){//같은 그룹이면 그만.
        			union(j,i);
        			
        			//한 선분이 여러 선분에 걸치면 같은 그룹이라 break 가능하다 판단했는데,
        			//i가 이전 선분j,k와 같이 교차할 때, j,k가 이미 같은 그룹이 아니였다면 union을 여러번 진행하여 j,k를 같은 그룹으로 만들어줘야함
        			//break;
        		}
        		
        	}
        }
        
        //결과 집계: 그룹 수와 최대 그룹 크기
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int r = find(i);
            cnt.put(r, cnt.getOrDefault(r, 0) + 1);
        }
        int groups = cnt.size();
        int maxSize = 0;
        for (int v : cnt.values()) maxSize = Math.max(maxSize, v);

        System.out.println(groups + "\n" + maxSize);
        
        //N개의 선분들이 양 끝점의 x,y좌표료 표현되어 있음
        //두 선분이 만나는 경우에 두 선분은 같은 그룹에 속한다고 정의한다.
        //그룹의 크기는 선분의 개수로 정의한다.
        
        //선분들이 총 몇개의 그룹으로 되어있는가, 또 가장 큰 그룹에 속한 선분의 개수는 몇개인가 구하시오
        
        //유니온 파인드가 가장 먼저 떠오르기는 하는데...선분교차 알고리즘이 있다고하니 학습병행
        
        
    }
    
    
    public static boolean union(int a, int b) {
    	int pa=find(a);
    	int pb=find(b);
    	
    	if(pa==pb) return false;
    	if(pa>pb){
    		int tmp=pb;
    		pb=pa;
    		pa=tmp;
    	}
    	parent[pb]=pa;
    	return true;
    	
    }
    
    public static int find(int a) {
    	if(parent[a]==a) return a;
    	return parent[a]=find(parent[a]);
    }
    
    /*선분 교차 알고리즘의 구현
    	ccw는 세 점 a,b,c 가 있을 때, a를 기준으로 세 점이 시계방향으로 꺾이는지, 반시계로 꺾이는지, 일직선인지 판단함
    	이 기하특성을 활용해, 선분 AB, CD가 있을 때, A B C 와 A B C의 ccw를 구해서, 부호가 다른지 확인한다.
    	즉 선분 AB를 기준으로, C,D가 다른 방향에 있는지를 확인하는 절차. 같은 방향이면 교차하지 않고,
    	부호가 다르거나, 하나 이상이 0이면(둘다 0이면 두 선분은 하나의 선분) 교차한다고 판단 한다.
    	단, ccw를 4번을 진행해야 하는 것이 중요하다. (두번의 ccw만 진행하면, c와d는 AB의 양쪽이지만 AB가 CD의 연장선 밖에 있을 수 있)
    	A------B
      		C------D   이 경우 c,d가 AB의 양쪽에 있는 것으로 나온다. 하지만 실제로 AB와 CD는 닿지 않는다.
      	때문에 CCW1=ccw(a,b,c)*ccw(a,b,d) , CCW2=ccw(c,d,a) *ccw(c,d,b) 를 구해서 값을 확인해야한다.
      	
      	또 둘다 0,0 나오는 경우를 예외로 확인를 실시한다. 같은 선분 방향이면 교차할수도, 안할수도 있기 때문
    	
    */
    public static int ccw(int ax, int ay, int bx, int by, int cx, int cy) {
        long v = (long)(bx - ax) * (cy - ay) - (long)(by - ay) * (cx - ax);
        if (v > 0) return 1;
        if (v < 0) return -1;
        return 0;
    }
    
    // 2) 선분 교차(끝점 접촉/겹침 포함) 판정
    
    public static boolean segmentsIntersect(int a, int b){
        int x1=coordinate[a][0];
        int y1=coordinate[a][1];
        int x2=coordinate[a][2];
        int y2=coordinate[a][3];
        int x3=coordinate[b][0];
        int y3=coordinate[b][1];
        int x4=coordinate[b][2];
        int y4=coordinate[b][3];

        int ab_c = ccw(x1, y1, x2, y2, x3, y3);
        int ab_d = ccw(x1, y1, x2, y2, x4, y4);
        int cd_a = ccw(x3, y3, x4, y4, x1, y1);
        int cd_b = ccw(x3, y3, x4, y4, x2, y2);

        // 일반 케이스: 서로 다른 쪽(곱<0)이면서 서로에 대해서도 다른 쪽
        if (ab_c * ab_d < 0 && cd_a * cd_b < 0) return true;

        // 여기서부터는 적어도 하나가 0(끝점이 선분 위 or 일직선)인 경우
        if (ab_c * ab_d > 0 || cd_a * cd_b > 0) return false;

        // 완전 collinear(네 번 모두 0)면 "구간 겹침"을 확인
        if (ab_c == 0 && ab_d == 0 && cd_a == 0 && cd_b == 0) {
            // x축 구간 겹침 && y축 구간 겹침 → 실제로 같은 직선 위에서 범위가 맞닿음
            boolean overlapX = Math.max(Math.min(x1, x2), Math.min(x3, x4))
                             <= Math.min(Math.max(x1, x2), Math.max(x3, x4));
            boolean overlapY = Math.max(Math.min(y1, y2), Math.min(y3, y4))
                             <= Math.min(Math.max(y1, y2), Math.max(y3, y4));
            return overlapX && overlapY;
        }

        // collinear가 아닌데 0이 끼어 있는 경우 = "끝점이 정확히 다른 선분 위" → 교차
        return true;
    }
}

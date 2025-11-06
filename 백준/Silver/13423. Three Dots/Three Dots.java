
import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static int[] point;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T=Integer.parseInt(br.readLine());
        
        StringBuilder sb=new StringBuilder();
        int answer=0;
        for(int test_case=1;test_case<=T;test_case++) {
        	N=Integer.parseInt(br.readLine());
        	st=new StringTokenizer(br.readLine());
        	point=new int[N];// 각 점의 위치. 0부터 할지, 1부터 할지는 추후 돌아와서 확정
        	answer=0;
        	//조합을 다 구한다? 점이 1000개라서 시간 터질 것 같은데
        	for(int i=0;i<N;i++) {
        		point[i]=Integer.parseInt(st.nextToken());
        		
        	}
        	
    		//정렬해서 다시 번호를 부여해도 경우의 수에는 영향을 주지 않는다.
    		Arrays.sort(point);
    		
    		
    		//인덱스를 기준으로 이분탐색해서 중앙에 가장 가까운 인덱스를 찾는 듯 한데,
    		//양끝점을 어떻게 기준으로 잡을까?
    		//조합으로 10C2해도 10000000이니 가능해 보인다.
    		
    		int mid;
    		for(int i=0;i<N;i++) {
    			for(int j=i+1;j<N;j++) {
    				mid=searchIndex(i,j);
    			
    				if(mid==-1) continue; //mid는 인덱스이기에 범위를 넘으면 오류가 발생하기에 continue;
    				//System.out.println(i+"");
    				if(point[mid]-point[i]==point[j]-point[mid]) {
    					answer++;
    				} else {
    					//System.out.println(point[i]+" "+point[mid]+" "+point[j]);
    				}
    			}
    		}
        	
        	sb.append(answer+"\n");
        }
        //직선 위에 서로 다른 점 N개, 1000개. 
        //점 i의 위치는 Xi.
        //점의 위치는 인수점위 내.
        
        //N개의 점에서 간격이 같은 세 점의 경우가 몇가지인지 출력하라.
        System.out.println(sb);
        
        
    }
    
    // point[start]와 point[end]의 중앙에 가장 가까운 값의 인덱스를 찾아 반환한다.
    public static int searchIndex(int start, int end) {
    	int answer=-1;
    	
    	if(end-start==1) return -1;// 중앙값이 없다.
    	
    	int left=start;
    	int right=end;
    	int mid;
    	int goal=(point[left]+point[right]);
    	while(left<=right){
    		
    		mid=(right-left)/2+left;
    		
    		if(point[mid]*2>=goal){// 계산값이 더 작아져야 한다. 왼쪽으로 가야한다.
    			right=mid-1;
    		}else {//계산값이 더 커져야 한다. 오른쪽으로 가야한다.
    			left=mid+1;
    		}
    		
    		
    	}

    	return left;
    	
    }
        
}



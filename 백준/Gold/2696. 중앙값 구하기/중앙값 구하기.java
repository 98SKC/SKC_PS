
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        
        int T=Integer.parseInt(br.readLine());

        int M;
        int[] arr;
        //시간복잡도 생각 안하고 List 구현한 버전
        ArrayList<Integer> list;
        for(int test_case=1;test_case<=T;test_case++){
        	
        	M=Integer.parseInt(br.readLine());// 배열 원소의 개수
        	
        	sb.append(M/2+1);
        	sb.append("\n");
        	//입력과 동시에 처리가 가능한 방법이 있을 것이라 생각이 든다.
        	//arr=new int[N]; //원본 배열을 저장할 곳.
        	
        	int N=M/10;
        	int sub;
        	int cnt=0;
        	list=new ArrayList<>();
        	//System.out.println("T: "+test_case);
        	for(int i=0;i<N;i++){
        		
        		st=new StringTokenizer(br.readLine());
            	for(int j=0;j<10;j++) {
            		list.add(Integer.parseInt(st.nextToken()));
            		Collections.sort(list);
            		//System.out.println(list.toString());
            		if(j%2==0) { //홀수번 : 중앙값을 찾아라.
            			sub=i*10+j;
            			sub/=2;
            			//System.out.println("sub: "+sub+" i: "+i+" ,j: "+j);
            			sb.append(list.get(sub));
            			sb.append(" ");
            			cnt++;
            			if(cnt==10) sb.append("\n");
            		}
            		
            	}

        	}
        	
        	M%=10;
        	st=new StringTokenizer(br.readLine());
        	for(int i=0;i<M;i++) {
        		
        		list.add(Integer.parseInt(st.nextToken()));
        		Collections.sort(list);
        		if(i%2==0) { //홀수번 : 중앙값을 찾아라.
        			sub=N*10+i;
        			sub/=2;
        			sb.append(list.get(sub));
        			sb.append(" ");
        			cnt++;
        			if(cnt==10) sb.append("\n");
        		}
        		
        	}
        	
        	if(cnt!=10) sb.append("\n");
        	//문제의 요지는 매 순간 정렬하면 시간이 오래걸릴 것.
        	//테스트케이스 1000에 삽입 및 삭제가 각 9999이라고 하면 
        	//9999000번의 삽입 탐색 이동 이 필요
        	//이럴 때 시간복잡도는 
        	
        	
        }
        
        
        System.out.println(sb);
        
        
    }
        
}



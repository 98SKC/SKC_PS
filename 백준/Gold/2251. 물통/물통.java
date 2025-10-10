

import java.util.*;
import java.io.*;

public class Main {

	public static boolean[][][] v;
	public static int[] status=new int[3];
	public static int A,B,C;
	public static int[] max=new int[3];
	public static TreeSet<Integer> answer;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        A=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        max[0]=A;
        max[1]=B;
        max[2]=C;
        
        v=new boolean[A+1][B+1][C+1];
        status[2]=C;
        v[0][0][C]=true;//초기 상태.
        //부피가 A,B,C인 세 물통이 있다.
        //앞의 두 물통이 비어있고,C만 가득하다.
        //물을 옮길 때, 한 물통이 비거나, 가득찰 때까지 물을 부운다.
        
        //첫 번째 물통이 비어있을 때, 세번째 물통에 담겨있을 수 있는 물의 양을 모두 구하라.(오름차순)
        
        answer=new TreeSet<>();

        simul();
        
        StringBuilder sb=new StringBuilder();
        for(int s:answer) {
        	sb.append(s+" ");
        }
        
        System.out.println(sb);
    }
    
    public static void simul(){//status[0]
    	if(status[0]==0) answer.add(status[2]);
    	//System.out.println(Arrays.toString(status));
    	int sub;
    	
    	//i 물통을 다른곳에 이동시킨다.
    	for(int i=0;i<3;i++) {
    		if(status[i]==0) continue;// 빈 물통은 스킵
    		for(int j=0;j<3;j++) {
    			if(i==j||status[j]==max[j]) continue;//자기 자신이거나 대상이 가득 차있으면 스킵
    			//i를 j로 옮긴다.
    			//case 1
    			if(status[i]+status[j]<max[j]){//i가 빌때까지 채울 수 있는가?
    				sub=status[i];
    				status[i]=0;
    				status[j]+=sub;
    				if(!v[status[0]][status[1]][status[2]]) {
    					//System.out.println("??");
    					v[status[0]][status[1]][status[2]]=true;
    					simul();
    				}
    				status[i]=sub;
    				status[j]-=sub;
    				
    			}else if(status[i]+status[j]>=max[j]){//j가 가득 찰 떄까지 채울 수 있는가?. i를 비우고 j를 가득채워도 이 케이스
    				sub=status[j];
    				status[j]=max[j];
    				status[i]-=(max[j]-sub);
    				if(!v[status[0]][status[1]][status[2]]) {
    				//	System.out.println("?");
    					v[status[0]][status[1]][status[2]]=true;
    					simul();
    				}
    				status[j]=sub;
    				status[i]+=(max[j]-sub);
    			}
    		}
    	}
    	
    }
        
}



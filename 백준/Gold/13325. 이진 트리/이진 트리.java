
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int K=Integer.parseInt(br.readLine()); //포화이진트리의 높이
        
        StringTokenizer st=new StringTokenizer(br.readLine()); 
        
        //높이가 K일 때, 노드의 개수는 2^(K+1)-1
        int node=(int)Math.pow(2, K+1);// 인덱스는 1부터 시작하기에 +1
     //   System.out.println("node: "+node);
        
        //간성의 개수는 2^(K+1)-2
        int len=(int)(Math.pow(2, K+1)-2);
        
        
       //int[][] edges=new int[node][node];

        int subLen=0;
        int start=0;
        long result=0;
        int sub;
        long[] sum=new long[node+1];
        for(int k=0;k<K;k++) {
        	start=(int)Math.pow(2, k);
        	subLen=start*2;//1-2  2-4  4-8  16 
        	for(int i=start;i<subLen;i++) {
        		//i에서j로 뻗는 노드의 가중치.
        		sub=Integer.parseInt(st.nextToken());
        		result+=sub;
        		sum[i*2]+=(sum[i]+sub);
        		
        		sub=Integer.parseInt(st.nextToken());
        		sum[i*2+1]+=(sum[i]+sub);
        		result+=sub;
        	}
        }
    	start=(int)Math.pow(2, K);
    	subLen=start*2;//1-2  2-4  4-8  16 
       // System.out.println("sum: "+Arrays.toString(sum)+"subLen: "+subLen+" start: "+start);
        long max=0;
        //마지막 노드 변수 재활용
        
        long[] answer=new long[node+1];
        
        for(int i=start;i<subLen;i++) {
        	max=(long) Math.max(max, sum[i]);
        	
        }
       // System.out.println("max: "+max);
        ArrayDeque<Integer> q=new ArrayDeque<>();
        
        for(int i=start;i<subLen;i++) {
        	if(sum[i]<max) answer[i]=max-sum[i];
        	if(i%2==0) q.add(i);
        }
        
        int n;
        long min;
        while(!q.isEmpty()) {
        	n=q.poll();
        	if(answer[n]!=0&&answer[n+1]!=0){
        		min=Math.min(answer[n], answer[n+1]);
        		answer[n]-=min;
        		answer[n+1]-=min;
        		answer[n/2]+=min;
        		//q.add(n/2);
        		int parent = n / 2;
        		if (parent >= 2 && (parent & 1) == 0) { // 부모가 짝수(왼쪽)일 때만 큐에 넣기
        		    q.add(parent);
        		}
        		
        		//System.out.println(n+" "+(n+1)+"의 공통 "+min+"이 "+(n/2)+"로 이동");
        	}
        	
        }

       // System.out.println("answer:");
        
        long save=result;
       // System.out.println(Arrays.toString(answer)); 
        for(int i=0;i<node;i++) {
        	result+=answer[i];
        }
       // System.out.println("추가된 가중치의 합: "+(result-save));
       // System.out.println("기존 가중치의 합: "+save);
        System.out.println(result);
        //1차적으로는 누적합을 떠올렸는데
        /*
         * 	일단 최대를 몇으로 설정할 것인지지. 
			그리고 몇으로 통일한건지 (최대인지, 최대보다 큰 무언가인지)
			그 통일의 기준을 구하는 것이 1차 목표
			최대보다 큰 경우를 줘야 가능한 경우가 있을까?
			
			일단 위에서부터 큰 수를 채워가야 이득. 
			최대를 기준으로 위에서부터 큰 수로 추적한다고 하면 이건 그리디.
			
			아래에서부터 위로 가면서, 짝짓는 것 끼리비교. 작은 수만큼을 위로.
         * */
        
    }
}

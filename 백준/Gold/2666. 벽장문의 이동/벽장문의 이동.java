import java.io.*;
import java.util.*;

public class Main {

	public static int[][] arr;
	public static int N,T;
	public static int[] order;
	public static int answer=Integer.MAX_VALUE;
	public static int[] hh=new int[10];

	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //n개의 벽장들이 일렬로 붙어져 있고, 문은 n-2개만이 있다. 
        //한 벽장 앞에 있는 문은, 이웃에 문이 열려있다면 그 벽장 앞으로 움직일 수 있다.
        //(그러니까, 벽장 문이 벽장에 귀속되지 않고 이리저리 움직일 수 있다는 뜻 같음)
        //입력으로 주어지는 벽장 순서에 따라 벽장문을 이동하는 순서를 찾아야 한다.
        //이때 벽장문의 이동 횟수를 최소화.
        
        //비트마스킹이라 하기에는, 동시 이동이 아니라 하나씩만 이동해야해서
        
        //벽장의 개수가 20.
        
        N=Integer.parseInt(br.readLine());// 벽장의 개수
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        

        
        //사용해야 하는 벽장의 수	
        T=Integer.parseInt(br.readLine());
        
        //그리디냐 비트마스킹이냐 재귀냐.
        
        order=new int[T];
        for(int t=0;t<T;t++){
        	order[t]=Integer.parseInt(br.readLine());
        }
        helper(0,0,a,b);
        
        System.out.println(answer);
    }
    
    public static void helper(int p, int sum, int a1, int a2){
    	if(p==T){
    		answer=Math.min(answer, sum);
    		//System.out.println(Arrays.toString(hh)+" :: "+p);
    		return;
    	}
    	// 목표는 order[p].
    	// a1이 더 작은 포인터
    	
    	if(order[p]==a1||order[p]==a2){
    		//hh[p]=0;//움직이지 아니함
    		helper(p+1,sum,a1,a2);
    		return;
    	}
    
    	
    	// 목표가 두 포인터 사이에
    	if(a1<order[p]&&order[p]<a2){
    		//왼쪽을 움직여 본다.
    		//hh[p]=(order[p]-a1);
    		helper(p+1,sum+(order[p]-a1),order[p],a2);
    		//오른쪽을 움직여본다.
    		//hh[p]=(a2-order[p]);
    		helper(p+1,sum+(a2-order[p]),a1,order[p]);
    	}else if(order[p]<a1){//a1의 왼쪽
    		//hh[p]=(a1-order[p]);
    		helper(p+1,sum+(a1-order[p]),order[p],a2);
    	}else {//a2의 오른쪽
    		//hh[p]=(order[p]-a2);
    		helper(p+1,sum+(order[p]-a2),a1,order[p]);
    	}
    	
    	
    }
    


   
}

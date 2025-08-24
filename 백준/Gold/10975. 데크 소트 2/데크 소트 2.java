
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        
        int[] number=new int[N];
        ArrayList<Integer> sortArr=new ArrayList<>();
        for(int i=0;i<N;i++) {
        	number[i]=Integer.parseInt(br.readLine());
        	sortArr.add(number[i]);
        }
        Collections.sort(sortArr);
        
        boolean[] v=new boolean[N];// list.get(i)의 원소가 정렬이 된 상태인가?
        int index;
        int answer=0;
        for(int i=0;i<N;i++) {
        	index=sortArr.indexOf(number[i]); //number[i]의 정렬 위치.
        	//System.out.println(number[i]+"의 정렬 위치는: "+index);
        	if(index==0) {
        		
        		if(N==1||!v[1]) answer++; 
        		v[0]=true;
        		
        	}else if(index==N-1) {
        		if(!v[N-2]) answer++; 
        		v[N-1]=true;
        	}else{
        		//System.out.println("9가 어디서 나와 "+(index));
        		if(!v[index-1]&&!v[index+1]){
        			answer++;
        		}
        		
        		v[index]=true;
        	}
        	
        	
        }
        System.out.println(answer);
        
        
        
    }
    
    
}


import java.util.*;
import java.io.*;
import java.math.MathContext;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int A=Integer.parseInt(st.nextToken());
        int P=Integer.parseInt(st.nextToken());
        
        HashMap<Integer, Integer> map=new HashMap<>();
        int next=A;
        int turn=1;
        int sub;
        while(!map.containsKey(next)){
        	//System.out.print(next+" ");
        	map.put(next, turn);
        	
        	sub=next;
        	next=0;
        	while(sub!=0){
        		next+=Math.pow((sub%10),P);
        		sub/=10;
        	}
        	turn++;
        }
       // System.out.println();
        //System.out.println("next: "+next);
        System.out.println(map.get(next)-1);
        
        //System.out.println(Math.pow(9, 5));
    }
}


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        int[] cal=new int[367];
        StringTokenizer st;
        int start=0,end=0;
        int min=Integer.MAX_VALUE;
        int max=0;
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	start=Integer.parseInt(st.nextToken());
        	end=Integer.parseInt(st.nextToken());
        	min=Math.min(min, start);
        	max=Math.max(max, end);
        	cal[start]+=1;
        	cal[end+1]-=1;
        	//System.out.println(start+" "+(end+1));
        }

        int answer=0;

        //System.out.println(min+" "+max);
        int h=0;
        int width=0;

        for(int i=min;i<=max;i++) {
        	
        	cal[i]=cal[i-1]+cal[i];// i일의 일정의 수        	
        	//System.out.print(cal[i]+" ");
        	if(cal[i]==0){//이를 기점으로 일정이 없음. 이곳까지의 넓이
        		//System.out.println("가로: "+width+" 세로: "+h);
        		answer+=width*h;
        		h=0;
        		width=0;
        		continue;
        	}
        	width++;
        	h=Math.max(cal[i], h);
        }
       // System.out.println("가로: "+width+" 세로: "+h);
        answer+=h*width;

        System.out.println(answer);
    }
}

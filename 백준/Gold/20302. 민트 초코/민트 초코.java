import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set=new HashSet<>();
        int N=Integer.parseInt(br.readLine());
        int[] m=new int[100000];
        int[] d=new int[100000];
        StringTokenizer st=new StringTokenizer(br.readLine());
        String answer="mint chocolate";
        boolean check=false;
        // 처음 먼저 계산
        int sub=Integer.parseInt(st.nextToken());
        sub=Math.abs(sub);
        for(int j=2;j<=Math.sqrt(sub);j++) {
			while(sub%j==0) {
        		m[j]++;
        		sub/=j;
        	}
		}
        
		if(sub!=1) {
			m[sub]++;
		}
		
		if(sub==0) {
			//System.out.println("0발견1");
			System.out.println(answer);
			return;
		}
		
        for(int i=0;i<N-1;i++) {
        	
        	if(st.nextToken().charAt(0)=='*') {
        		sub=Integer.parseInt(st.nextToken());
        		sub=Math.abs(sub);
        		//System.out.println(sub);
        		
        		if(sub==0) {
        			//System.out.println("0발견2");
        			check=true;
        			break;
        		}
        		
        		for(int j=2;j<=Math.sqrt(sub);j++) {
        			while(sub%j==0) {
        			//	System.out.println(j+" 추가m");
                		m[j]++;
                		sub/=j;
                	}
        		}
        		if(sub!=1) {
        			//System.out.println(sub+" 추가m");
        			m[sub]++;
        		}
        		
        	
        	}else{
        		sub=Integer.parseInt(st.nextToken());
        		sub=Math.abs(sub);
        		//System.out.println(sub);
        		for(int j=2;j<=Math.sqrt(sub);j++) {
        			if(sub%j==0) set.add(j); 
        			while(sub%j==0) {
        				//System.out.println(j+" 추가d");
                		d[j]++;
                		sub/=j;
                	}
        		}
        		if(sub!=1) {
        			set.add(sub);
        			//System.out.println(sub+" 추가d");
        			d[sub]++;
        		}
        	}
        	
        }
        
        if(check) {
        	//System.out.println("??");
        	System.out.println(answer);
        	return;
        }
        
       // System.out.println(set.toString());
        for(Integer p:set) {
        	//System.out.println("p");
        	if(m[p]>=d[p]) {
        		continue;
        	}else {
        		answer="toothpaste";
        		break;
        	}
        }
        
        System.out.println(answer);
        
    }
}

import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //문자열에서 특정 알파벳이 몇번 나타나는지 알아본다.
        //알파벳이 중지나 검지에 오는 알파벳이면 실용적이다.
        //특정 문자열 S, 특정 알파벳 a. 문자열 구간 [l,r] 이 주어지면
        //S의 l~r 사이 a가 몇번 나타나는지 각성하여라.
        //인덱스는 0부터 시작. l과 r을 포함해서 생각
        String str=br.readLine();
        int Q=Integer.parseInt(br.readLine());
        char target;
        //26개
        int len=str.length();
        int[][] prefix=new int[len][26];
        target=str.charAt(0);
        prefix[0][target-'a']=1;
        
        for(int i=1;i<len;i++) {
        	target=str.charAt(i);
        	//System.out.println(target+" 추가");
        	for(int j=0;j<26;j++) {
        		if((target-'a')==j) {
        			prefix[i][j]=prefix[i-1][j]+1;
        		}else {
        			prefix[i][j]=prefix[i-1][j];
        		}
        	}
        }
//        System.out.println();
//        for(int[] n:prefix) {
//        	System.out.println(Arrays.toString(n)+"\n");
//        }
        int l,r;
        StringTokenizer st;
        int idx;
        StringBuilder sb=new StringBuilder();
        for(int q=0;q<Q;q++) {
        	st=new StringTokenizer(br.readLine());
        	target=st.nextToken().charAt(0);
        	idx=target-'a';
        	l=Integer.parseInt(st.nextToken());
        	r=Integer.parseInt(st.nextToken());
        	if(l!=0) {
        		sb.append(prefix[r][idx]-prefix[l-1][idx]+"\n");
        	}else {
        		sb.append(prefix[r][idx]+"\n");
        	}
        }
        System.out.println(sb);
        
    }
}

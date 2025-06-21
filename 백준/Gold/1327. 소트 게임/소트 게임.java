
import java.util.*;
import java.io.*;

public class Main {

	public static int N,K;
	public static class Number{
		String n;
		int count;
		Number(String n,int count){
			this.n=n;
			this.count=count;
		}
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        
        N=Integer.parseInt(st.nextToken());//배열 개수
        K=Integer.parseInt(st.nextToken());//대상 포함 우측으로 K개
        StringBuilder sb=new StringBuilder();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	sb.append(Integer.parseInt(st.nextToken()));
        }
        
        String n=sb.toString();
        
        ArrayDeque<Number> q=new ArrayDeque<>();
        
        //1부터 N까지 오름차순 정렬된 정답
        sb=new StringBuilder();
        for(int i=1;i<=N;i++) {
        	sb.append(i);
        }
        String answer=sb.toString();
        HashSet<String> v=new HashSet<>();
        v.add(n);
        
        int result=-1;
        q.add(new Number(n,0));
        while(!q.isEmpty()){
            Number p = q.poll();//p는 현 문자열
            //System.out.println(p.n+" "+answer);
            if(p.n.equals(answer)){
            	result=p.count;
            	break;
            }

            for(int i = 0; i <= (N - K); i++){//첫 위치부터 가능한만큼 뒤집는다.
                char[] charArr = p.n.toCharArray();
                
                for(int j = 0; j < (K / 2);j++) {
                    char tmp = charArr[i + j];
                    charArr[i + j] = charArr[i + K - 1 - j];
                    charArr[i + K - 1 - j] = tmp;
                }
                
                String newNumber = new String(charArr);
                
                if(!v.contains(newNumber)){
                    Number number = new Number(newNumber, p.count + 1);
                    q.add(number);
                    v.add(number.n);
                }
            }
        }
        System.out.println(result);
        
    }
    

}

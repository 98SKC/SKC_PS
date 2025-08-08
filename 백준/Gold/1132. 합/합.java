
import java.util.*;
import java.io.*;

public class Main {

	public static class Alphabet{
		
		char alpha;
		long number;
		
		public Alphabet(char alpha, long number) {
			this.alpha=alpha;
			this.number=number;
		}
		
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        //A부터 J가 숫자 대신 쓰여있다. 각 0부터9까지 랜덤하게 치환되어있다. 각 수는 모두 다르다.
        //알파벳 하나는 숫자 한자리이다.
        
        
        //알파벳으로 이루어진 숫자들이 주어졌을 때 최대값을 구하라.
        //주어진 숫자들 중 0으로 시작하는 수는 없다.
        
        //앞에 있을 숫자일수록, 또 많이 나온 숫자일수록 큰 숫자를 부여한다.
        
        
        //각 숫자가 나온 가중치별로 숫자를 부여.
        
        boolean[] zeroCheck=new boolean[10]; //변수-A 가 true면 0 불가.
        long[] number=new long[10]; //각 알파벳의 가중치
        int[] change=new int[10];// 알파벳과 숫자의 치환관계
        
        String str;
        int len;
        long cnt;
        char c;
        for(int i=0;i<N;i++) {
        	str=br.readLine();
        	len=str.length();
        	cnt=1;
        	for(int j=len-1;j>0;j--) {
        		c=str.charAt(j);
        		number[c-'A']+=cnt;
        		cnt*=10;
        	}
        	c=str.charAt(0);
        	//System.out.println(c+"는 0이 불가");
        	zeroCheck[c-'A']=true;
        	number[c-'A']+=cnt;
        }
        
        ArrayDeque<Alphabet> save=new ArrayDeque<>();
        
        PriorityQueue<Alphabet> pq=new PriorityQueue<>(new Comparator<Alphabet>() {
        	@Override
        	public int compare(Alphabet o1, Alphabet o2) {
        		return Long.compare(o1.number, o2.number);
        	}
        });
        
        for(int i=0;i<10;i++) {
        	pq.add(new Alphabet((char)(i+'A'), number[i]));
        }
        int sub=0;
        Alphabet p;
        Alphabet s;
        while(!pq.isEmpty()) {
        	p=pq.poll();
        	//System.out.println(p.alpha+"나옴");
        	if(sub==0){//0이라면 이번차례가 0이 될수 있는지 확인.
        		if(zeroCheck[p.alpha-'A']) {//0이 될 수 없다면
        			save.add(p);
        		}else {
        		//	System.out.println(p.alpha+"가1 "+sub);
        			change[p.alpha-'A']=sub++;
        			while(!save.isEmpty()) {
        				s=save.poll();
        				change[s.alpha-'A']=sub++;
        				//System.out.println(p.alpha+"가3 "+sub);
        			}
        		}
        	}else{
    			//System.out.println(p.alpha+"가2 "+sub);
    			change[p.alpha-'A']=sub++;
    		}
        	
        }
//        System.out.println("0이 가능한 알파벳: ");
//        System.out.println(Arrays.toString(zeroCheck));
//        System.out.println("------------------------");
//        
//        
//        System.out.println("각 알파벳의 가중치: ");
//        System.out.println(Arrays.toString(number));
//        System.out.println("------------------------");
//        
//
//        System.out.println("각 알파벳의 변환상태: ");
//        System.out.println(Arrays.toString(change));
//        System.out.println("------------------------");
        


        long answer=0;
        for(int i=0;i<10;i++) {
        	//System.out.println(number[0]+"*"+change[0]+"="+(number[0]*change[0]));
        	answer+=number[i]*change[i];
        }
        
        System.out.println(answer);
    }
}

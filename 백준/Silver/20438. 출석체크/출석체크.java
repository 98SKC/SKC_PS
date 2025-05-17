
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());//학생 수
        int K=Integer.parseInt(st.nextToken());//조는 수
        int Q=Integer.parseInt(st.nextToken());//출석 코드 횟수
        int M=Integer.parseInt(st.nextToken());//주어질 구간 수
        
        //졸고 있을 학생 수
        st=new StringTokenizer(br.readLine());
        HashSet<Integer> sleep=new HashSet<>();
        ArrayDeque<Integer> q=new ArrayDeque<>();
        
        for(int i=0;i<K;i++) {
        	sleep.add(Integer.parseInt(st.nextToken()));
        }
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<Q;i++) {
        	q.add(Integer.parseInt(st.nextToken()));
        }
        
        int S,E;
        boolean[] v= new boolean[N+3];
        while(!q.isEmpty()) {
        	S=q.poll();//시작 학생 위치
        	//System.out.println(S+"부터 출석");
        	if(sleep.contains(S)) continue;
        	for(int i=S;i<=N+2;i=i+S) {
        		if(!sleep.contains(i)) v[i]=true;
        	}
        }
        int[] presum=new int[N+3];
        for(int i=3;i<=N+2;i++) {
        	if(!v[i]) {
        		presum[i]=presum[i-1]+1;
        	}else {
        		presum[i]=presum[i-1];
        	}
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	S=Integer.parseInt(st.nextToken());
        	E=Integer.parseInt(st.nextToken());
        	sb.append((presum[E]-presum[S-1])+"\n");
        }
        
      //  System.out.println("미출석자");
//        int cnt=0;
//        for(int i=3;i<=N+2;i++) {
//        	if(!v[i]) {
//        		System.out.print(i+" "); 
//        		cnt++;
//        	} 
//        }
//       System.out.println();
//       System.out.println("cnt: "+cnt);
//        System.out.println(Arrays.toString(v));
//        System.out.println(Arrays.toString(presum));
        
        System.out.println(sb); 
        
        //접속 순서대로 3~N+2번까지 번호 부여
        //i에게 코드를 보내면, i*j들에게 출석코드를 보냄.
        //중간에 졸고있는 학생들이 있어 끊김.
        //무작위 i에게 코드를 q번 보내, 특정 구간의 학생 중 출석이 안된 학생 수를 구하라.
        
        
    }
}

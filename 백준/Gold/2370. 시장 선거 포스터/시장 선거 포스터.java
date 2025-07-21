
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        int[][] wall=new int[N+1][2];
        int start, end;
        
        

        HashSet<Integer> set=new HashSet<>();
        for(int i=1;i<=N;i++) {
        	
        	st=new StringTokenizer(br.readLine());
            start=Integer.parseInt(st.nextToken());
            end=Integer.parseInt(st.nextToken());
            wall[i][0]=start;
            wall[i][1]=end;
            
            set.add(start);
            set.add(end);
            
            
        }
        ArrayList<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        
        int len=list.size();
        
        int[] v=new int[len];
        
        for(int i=1;i<=N;i++) {
        	start=Collections.binarySearch(list, wall[i][0]);
        	end=Collections.binarySearch(list, wall[i][1]);
        	for(int j=start;j<=end;j++) {
        		v[j]=i;
        	}
            
        }
        HashSet<Integer> answer=new HashSet<Integer>();
        answer.add(0);
        for(int i=0;i<len;i++) {
        	if(!answer.contains(v[i])) {
        		answer.add(v[i]);
        	}
        }
        answer.remove(0);
        
        System.out.println(answer.size());
        
        //앞쪽에 배치되는 순서.
        //배치되는 순서가 같으면 늦게 붙인게 먼저
        
        
        
        
        //늦게 붙인 포스터는 무조건 보이지. 
        //
        
        //시장 후보들이 포스터를 설치한다. 
        //다음과 같은 규칙을 지킨다.
        //모든 후보자들은 오직 한개의 포스터만 붙일 수 있다.
        //모든 포스터는 벽의 높이와 같고, 너비는 자유이다.
        //벽은 조각으로 나누어져 있으며 하나의 조각 단위는 byte다
        //각각의 포스터는 정해진 벽 부분에 빈틈없이 붙어야 한다.
        
        //너비가 100000000(1억)byte의 벽이 준비되어 있다.
        //이미 포스터가 붙어있어도 그 위에 또 다른사람이 붙일 수 있다.
        //선거 전날 보이는 포스터의 총 수를 출력하라.
        
        //모든 포스터를 붙이는 행위마다 완탐을 하며 포스터를 붙이고, 마지막에 완탐해서 보이는 포스터를 보자고 하면.
        //최대 1억개의 너비의 포스터를 10000번 붙일 수 있기에 시간 초과.
    }
}


import java.util.*;
import java.io.*;

public class Main {

//	public static class Computer{
//		int number;
//		int level;
//		int performance;
//		public Computer(int number, int level, int performance) {
//			this.number=number;
//			this.level=level;
//			this.performance=performance;
//		}
//	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //n개의 컴퓨터로 이루어진 시스템.
        //1번부터 N번까지 번호가 부여. 각자의 계급과 동작 속도가 주어짐.
        //i번 컴퓨터와 j번 컴퓨터의 전송 시간은 (i-j)^2이다.
        //n개의 컴퓨터의 계급은 c1,c2,... 일 때, 오름차순으로 정렬하면 앞뒤 차이가 1이상 나지 않는다.
        //제일 낮은 계급은 전달 받을 정보없이 시스템 시동과 동시에 동작.
        //계급이 c인 컴퓨터가 동작을 마치면 c+1 계급에게 정보를 전달 후 종료
        //가장 낮은 계급은 1
        int N=Integer.parseInt(br.readLine()); //컴퓨터의 개수 N
        
        //Computer[] computer=new Computer[N];
        List<Integer>[] step=new ArrayList[N+1];
        for(int i=1;i<=N;i++){
        	step[i]=new ArrayList<>();
        }

        int maxLevel=0;
        int level,performance;
        int[] per=new int[N+1];//i번 컴퓨터의 수행시간
        int[] answer=new int[N+1];
        for(int i=1;i<=N;i++){
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	level=Integer.parseInt(st.nextToken());
        	performance=Integer.parseInt(st.nextToken());
        	step[level].add(i);
        	per[i]=performance;
        	maxLevel=Math.max(maxLevel, level);
        }
        
        
//        Arrays.sort(computer,new Comparator<Computer>(){
//        	@Override
//        	public int compare(Computer c1, Computer c2) {
//        		return Integer.compare(c1.level, c2.level);
//        	}
//        	
//		});

        //동작하고 전송까지.
        //동작시간 +전송시간.
        //한 레벨에서 동작시간+전송시간으로 가장 오래걸린 값이 그 레벨의 최대값.
        int max=0;
        int subMax;
        int[] p;
        int time;
        
        //
        
        ArrayDeque<int[]> q=new ArrayDeque<>();
        
        for(int i=1;i<=maxLevel;i++) {
        	
        	for(int l:step[i]) {
        		q.add(new int[] {l,answer[l]});//l컴퓨터까지 오는데 걸린 시간.
        	}
        	
        	subMax=0;
        	//i레벨 컴퓨터 모두 실행.
        	while(!q.isEmpty()) {
        		p=q.poll();//p[0]컴퓨터
        		
        		time=0;
        		if(i!=maxLevel) {//최상위 컴퓨터가 아님. 전송 시간을 고려해야함
        			for(int next:step[i+1]){ //next 컴퓨터
        				//
        				//System.out.println(p[0]+"에서 "+next+"까지 전송시간: "+Math.pow(p[0]-next, 2));
            			time=(int)(Math.pow(p[0]-next, 2)+p[1]+per[p[0]]);//전송 및 수행시간.
            			//next가 동작하기 위한 시간
            			answer[next]=Math.max(answer[next], time);
            		}
        		}else{//수행 시간만을 따지며 정답을 내야함
        			time=p[1]+per[p[0]];
        			max=Math.max(time, max);
        		}
        	}

        	//System.out.println(i+"레벨만 끝나는데 걸리는 총 시간: "+subMax);
        	max+=subMax;
        	//System.out.println(i+"레벨까지 기준 끝난시간: "+max);
        	//System.out.println();
        }
        
        
        
        System.out.println(max);
        
        
    }
        
}



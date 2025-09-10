
import java.util.*;
import java.io.*;

public class Main {

	public static int N,K;// 손동작의 수 N, 우승을 위해 필요한 승수 K
	public static int[][] act;
//	public static int[] gyoun=new int[20];
//	public static int[] minho=new int[20];
	public static int[][] opponent=new int[3][20];
	public static int[] win=new int[3]; //0,1,2 인덱스에 승리 횟수 기록
	public static boolean[] v;
	//public static HashSet<Integer> set;
	//public static HashSet<Integer>[] setW; //이기기
	public static int answer=0;

	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        
        act=new int[N+1][N+1];
        v=new boolean[N+1];
        //set=new HashSet<>();
        //고의로 져아하는 경우도 있어서, 굳이 분류할 필요가 없어보이는데.
//        setW=new HashSet[N+1];
//        for(int i=1;i<=N;i++) {
//        	for(int j=1;j<=N;j++) {
//        		setW[i]=new HashSet<>()
//        		
//        	}
//        }
        
        
        //각 손동작의 상성 
        //2이면 i가j를 이긴다. 0이면 i가 j에게 진다. 1이면 비긴다.
        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	//set.add(i);
        	for(int j=1;j<=N;j++) {
        		act[i][j]=Integer.parseInt(st.nextToken());
        		//if(act[i][j]==2) setW[j].add(i);//j에 대해서 이길 수 있는 i들.
        	}
        }
         
        st=new StringTokenizer(br.readLine());
    	//경희가 낼 손동작 순서
        for(int i=0;i<20;i++) {
        	opponent[1][i]=Integer.parseInt(st.nextToken());
        }
        

        //민호가 낼 손동작 순서
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<20;i++) {
        	opponent[2][i]=Integer.parseInt(st.nextToken());
        }
        
        //지우, 경희, 민호 순서
        //족보가 매우 꼬인 가위바위보
        //일대일 경기를 여러번 진행해 누가 우숭했는지를 판단.
        //경기 순서가 A,B,C라면 A-B, 승자-C
        //만약 무승부라면 뒤 순서가 승리.
        //특정 사람이 미리 합의된 승수를 달성할 때 까지 3을 반복
        //합의된 승수를 최초로 달성한 사람이 우승한다.
        //지면 게임에서 나가는게 아니라 뒤 순서로 간다.
        
        //지우가 게임에 참가하였고, 3명의 게임. 두명이 어떤 손동작을 낼 지 순서를 알고있다.
        //지우가 이기되, 자신이 내는 모든 손동작을 다르게 내고 싶다.
        //모든 손동작을 다르게 내어 게임에서 우승할 수 있다면 1, 불가능하면 0을 출력한다.

        
        simul(0,0,0,1,2);
        System.out.println(answer);
    }
    
    
    public static int winner(int pi, int ai ,int pj, int aj) {
    
        int r = act[ai][aj]; 		// ai 승, 1: 비김, 0: aj 승
        if (r == 2) return pi;      // ai가 이김
        if (r == 0) return pj;      // aj가 이김
        return Math.max(pi, pj);    // 비김 -> 번호 큰 쪽 승
    }
    
    public static void simul(int g, int m, int A, int B , int C) { //경희가 낼 순서, 민호가 낼 순서. 대전상대 A, 대전상대 B ,대기자 C
    	
    	if(win[0]==K) {
    		//System.out.println(Arrays.toString(v));
    		answer=1;
    	}
    	
    	if(answer==1) return;
    	if(win[0]==K||win[1]==K||win[2]==K) return;

    	//A와 B에 지우가 없다면.
    	int w;
    	int n;// 대기자
    	int sub;
    	if(A!=0&&B!=0){
    		if(A==1) {//A가 경희다.
    			w=winner(A,opponent[1][g],B,opponent[2][m]);
    		}else{
    			w=winner(A,opponent[2][m],B,opponent[1][g]);
    		}
    		n=3-w-C;
    		win[w]++;
    		simul(g+1,m+1,w,C,n);
    		win[w]--;
    	}else{//지우가 껴 있다면.
        	int opp; //지우의 대전자.
    		for(int i=1;i<=N;i++) {
    			if(answer==1) break;
    			if(v[i]) continue;
    			v[i]=true;
    			if(A==0){//A가 지우다. 
        			opp=B;
        			if(opp==1) sub=g;//대전상대가 경희면 g를 사용
        			else sub=m;//경희가 아니면 m을 사용
        			w=winner(A,i,B,opponent[opp][sub]);
        		}else {//B가 지우다.
        			opp=A;
        			if(opp==1) sub=g;//대전상대가 경희면 g를 사용
        			else sub=m;//경희가 아니면 m을 사용
        			w=winner(A,opponent[opp][sub],B,i);
        		}
    			
    			win[w]++;
        		n=3-w-C;
        		if(opp==1){//대전상대가 경희였다.
        			simul(g+1,m,w,C,n);    			        			
        		}else{//대전상대가 민호였다.
        			simul(g,m+1,w,C,n);
        		}
    			win[w]--;
    			v[i]=false;
    			//민수가 i를 낸다.
    		}
 
    	}

    	
    }
    
}

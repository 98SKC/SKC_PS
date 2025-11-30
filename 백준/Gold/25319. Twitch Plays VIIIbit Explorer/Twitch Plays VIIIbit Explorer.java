import java.io.*;
import java.util.*;

public class Main {

	public static int N,M,len;
	public static String S;
	//public static char[][] map;
	public static int[] alpha;
	public static ArrayDeque<Integer>[] pos;
	public static StringBuilder sb=new StringBuilder();
	public static HashMap<Character, Integer> nickname=new HashMap<>();// 
	public static int level=0; //C번 강화
	public static int cnt=0; //cnt번의 행동
	
	
	public static int pi=1, pj=1;
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 직사각형 던전을 탈출하는 문제.
        // 몇몇 격자칸에는 아이템이 놓여져있다.
        // U,D,L,R 은 이동하는 명령어. 던전 밖을 나가면 게임 오버이다.
        // P는 캐릭터 위치에 존재하는 아이템을 줍는 명령어. 아이템이 해당 위치에 없으면 게임 오버
        // Twip으로 미션이 들어오고, 수락하면 새로운 던전으로 이동.
        // 이 던전은 모든 칸에 아이템이 있고, 이를 주어서 나열했을 때 문자열이 아이디와 일치하면
        // 모두 사라지고 캐릭터가 강화.
        // 던전 가장 우츠갛단에서 ALL PERPECT를 외치면 탈출. 아이템을 하나라도 지니면 불가능
        // 캐릭터가 강화될 때마다 1억씩 상금 추가

        //최대한 상금을 얻으면서 던전을 탈출할 방법을 찾아라.
        
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        len=Integer.parseInt(st.nextToken()); //아이디의 길이
        
        String str;
        
        //map=new char[N][M];
        alpha=new int[26];
        pos=new ArrayDeque[26];
        for(int i=0;i<26;i++){
        	pos[i]=new ArrayDeque<>();
        }
        int sub;
        
  
        for(int i=1;i<=N;i++) {
        	str=br.readLine();
        	for(int j=1;j<=M;j++) {
            	//map[i][j]=str.charAt(j);
            	sub=str.charAt(j-1)-'a';
            	
            	pos[sub].add((M+1)*i+j);
            	alpha[sub]++;
            	
            }
        }
        

        
        S=br.readLine();
        for(int i=0;i<len;i++) {
        	nickname.put(S.charAt(i), nickname.getOrDefault(S.charAt(i), 0)+1);
        }
        
        //시작은 1,1에서. 탈출은 N,M 에서. 1,1에서 N,M으로 이동하면서 이름하고 같은 문자열을 최대한 만들것
        //이동횟수가 최소일 필요는 없다. 여러 방법이 있으면 그중 하나를 출력한다.
        
        //예제 그대로 해보면
        
        int gi,gj;
        int p;
        
        while(isAvailable()){
        	level++;
        	
            for(int i=0;i<len;i++) {
            	//System.out.println(alpha[S.charAt(i)-'a']+" "+pos[S.charAt(i)-'a'].size());
            	p=pos[S.charAt(i)-'a'].poll();
            	
            	gi=p/(M+1);
            	gj=p%(M+1);
            	//여기에 대체 왜 0이 어떻게 나오는거야 대체
            	
            	move(gi, gj); //이동 
            	sb.append("P");//아이템 줍기
            	cnt++;
            	//위치상에서 삭제는 큐에서 빠진걸로 이미 완료
            	alpha[S.charAt(i)-'a']--;//알파벳 갯수에서 삭제
            }
        }
        //System.out.println("안해?");
    	move(N, M); //이동 
        
        System.out.println(level+" "+cnt);
        System.out.println(sb);
        
    }
    
    
    public static boolean isAvailable() {
    	//System.out.println("남은 개수를 채크");
    	for(char c: nickname.keySet()){
    		if(alpha[c-'a']<nickname.get(c)) return false;
    		//else System.out.println(c+" 알파벳이 "+nickname.get(c)+"개 필요하고 남은건: "+alpha[c-'a']);
    	}
    	//System.out.println();    	
    	return true;
    	
    }
    
    public static void move(int gi, int gj) {
    	String command;
    	//System.out.println("목적지: "+gi+" "+gj);
    	if(pi>gi) {// 목적지가 위에 있다. U 
    		command="U";
    		sb.append(command.repeat(pi-gi));
    		cnt+=pi-gi;
    	}else if(pi<gi){// 목적지가 아래에 있다 D
    		command="D";
    		sb.append(command.repeat(gi-pi));
    		cnt+=gi-pi;
    	}
    	
    	if(pj>gj) {// 목적지가 왼쪽에 있다. L
    		command="L";
    		sb.append(command.repeat(pj-gj));
    		cnt+=pj-gj;
    	}else if(pj<gj){
    		command="R";
    		sb.append(command.repeat(gj-pj));
    		cnt+=gj-pj;
    	}
    	pi=gi;
    	pj=gj;
    	//System.out.println(pi+" "+pj+"로 이동");
    	
    }

}

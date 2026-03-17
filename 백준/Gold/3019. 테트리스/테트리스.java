import java.util.*;
import java.io.*;

// 내일 아침에 출력 주석 풀고 제출하기
public class Main {

	public static int[] h;
	public static int N;
	public static int answer=0;
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());

        h=new int[N];
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	h[i]=Integer.parseInt(st.nextToken());
        }
        
        select(s);
        
        
        System.out.println(answer);
    }
    
    public static void select(int s) {
    	switch(s) {
	    	case 1:
	    		sequence1();
	    		break;
	    	
	    	case 2:
		    	sequence2();
		    	break;
		    	
	    	case 3:
		    	sequence3();
		    	break;
		    	
	    	case 4:
		    	sequence4();
		    	break;
		    	
	    	case 5:
		    	sequence5();
		    	break;
		    	
	    	case 6:
		    	sequence6();
		    	break;
		    	
	    	case 7:
		    	sequence7();
		    	break;
		    	
		    	
    	}
    }
    
    //길다란 모양
    public static void sequence1() {
    	//세로는 다 가능
    	answer=N;
    	
    	//가로는 연속으로 4칸이 같아야함
    	for(int i=0;i<=N-4;i++) {
    		//효율적인건 슬라이딩 윈도우 - 하지만 일단 구현. 4개가 모두 같으면
    		if(h[i]==h[i+1]&&h[i+2]==h[i+3]&&h[i]==h[i+3]) answer++;
    	}
    	
    }
    
    //네모.
    public static void sequence2() {
    	
    	for(int i=0;i<=N-2;i++) {
    		//효율적인건 슬라이딩 윈도우 - 하지만 일단 구현. 2개가 같으면
    		if(h[i]==h[i+1]) answer++;
    	}
    }
    
    //엎드린 모양 1
    public static void sequence3() {
    	//세로 --왼쪽이 1 높다.
    	for(int i=0;i<=N-2;i++) {
    		if(h[i]==h[i+1]+1) answer++;
    	}

    	//가로 - 001 처럼 같은 것 두개 다음 1칸 올라간다.
    	for(int i=0;i<=N-3;i++) {
    		if(h[i]==h[i+1]&&h[i+1]+1==h[i+2]) answer++;
    	}
    	
    }
    
    //엎드린 모양 2
    public static void sequence4() {
    	//세로 --오른쪽이 1 높다.
    	for(int i=0;i<=N-2;i++) {
    		if(h[i]+1==h[i+1]) answer++;
    	}

    	//가로 - 100 처럼 1칸 높고, 낮은것 두개 연속.
    	for(int i=0;i<=N-3;i++) {
    		if(h[i+2]==h[i+1]&&h[i+1]+1==h[i]) answer++;
    	}
    	
    }
        
    //볼록할 철
    public static void sequence5() {
    	//아래가 평평하다
    	for(int i=0;i<=N-3;i++) {
    		if(h[i]==h[i+1]&&h[i+1]==h[i+2]) answer++;
    	}
    	
    	//왼쪽이 높고, 오른쪽이 낮다
    	for(int i=0;i<=N-2;i++) {
    		if(h[i]==h[i+1]+1) answer++;
    	}
    	
    	//왼쪽이 낮고, 오른쪽이 높다
    	for(int i=0;i<=N-2;i++) {
    		if(h[i]+1==h[i+1]) answer++;
    	}
    	
    	//양옆이 높고, 가운데가 낮다.
    	for(int i=0;i<=N-3;i++) {
    		if(h[i]==h[i+2]&&h[i]==h[i+1]+1) answer++;
    	}
    	
    }
    
    //ㄴ 의 대칭
    public static void sequence6() {
    	//아래가 3칸 평평하다 
    	for(int i=0;i<=N-3;i++) {
    		if(h[i]==h[i+1]&&h[i+1]==h[i+2]) answer++;
    	}
    	
    	//아래가 2칸 평평하다 
    	for(int i=0;i<=N-2;i++) {
    		if(h[i]==h[i+1]) answer++;
    	}
    	
    	//왼쪽이 낮고, 중간 오른쪽이 높다
    	for(int i=0;i<=N-3;i++) {
    		if(h[i+1]==h[i+2]&&h[i+1]==h[i]+1) answer++;
    	}
    	
    	//왼쪽이 2높고, 오른쪽이 낮다
    	for(int i=0;i<=N-2;i++) {
    		if(h[i]==h[i+1]+2) answer++;
    	}
    	
    }
    
    // ㄴ 모양
    public static void sequence7() {
    	//아래가 3칸 평평하다 
    	for(int i=0;i<=N-3;i++) {
    		if(h[i]==h[i+1]&&h[i+1]==h[i+2]) answer++;
    	}
    	
    	//아래가 2칸 평평하다 
    	for(int i=0;i<=N-2;i++) {
    		if(h[i]==h[i+1]) answer++;
    	}
    	
    	//오른쪽이 낮고, 중간 왼쪽이 높다
    	for(int i=0;i<=N-3;i++) {
    		if(h[i]==h[i+1]&&h[i+2]+1==h[i]) answer++;
    	}
    	
    	//왼쪽이 2낮고, 오른쪽이 높다
    	for(int i=0;i<=N-2;i++) {
    		if(h[i]+2==h[i+1]) answer++;
    	}
    }
    

}




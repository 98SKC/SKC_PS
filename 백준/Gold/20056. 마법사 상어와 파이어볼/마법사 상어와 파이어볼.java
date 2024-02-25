import java.util.*;
import java.io.*;
 
 
public class Main {
	
	
	//파이어볼 정보 클래스
    static class fireBall{
        int r, c, m, s, d;
        public fireBall(int r, int c, int m, int s, int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};	//방향 r값 변경값
    static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};	//방향 c값 변경값
    static ArrayList<fireBall>[][] map;	//파이어볼 이동했을 때 정보
    static ArrayList<fireBall> fb = new ArrayList<>();	//모든 파이어볼 정보
	
	public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map[i][j] = new ArrayList<>();
        }
        //입력되는 파이어볼 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fb.add(new fireBall(r, c, m, s, d));
        }
        //K번 이동명령 진행
        for (int i = 0; i < K; i++) {
        	shotFireBall(N);
        	seperateFireBall(N);
        }
        int result = 0;
        for(fireBall sub : fb) result += sub.m;
       
        System.out.println(result);
        
    }
    
    //파이어볼을 발싸하는 메서드
    static void shotFireBall(int N) {
        for (fireBall sub : fb) {
            //r, c값 변경
            // +N을 하는 이유는 이동하였을 때 음수가 나올 수 있기 때문이라고 한다.
            int R = (sub.r + N + di[sub.d] * (sub.s%N)) % N;
            int C = (sub.c + N + dj[sub.d] * (sub.s%N)) % N;
            sub.r = R;
            sub.c = C;
            //이동한 파이어볼 저장
            map[sub.r][sub.c].add(sub);
        }
    }

    //파이어볼 분열 진행- 기존의 객체를 이용하여, 다른건 다 같고, 방향만 다른 4개의 파이어볼을 다른 객체로 다루는 코드를 사용함.
    // 합쳐지지 않은 파이어볼은 분열이 일어나지 않음!
    static void seperateFireBall(int N){
        for(int i = 0; i<N;i++){
            for(int j = 0; j<N;j++) {
            	
                //파이어볼 개수가 2개 미만일 때
                if(map[i][j].size() < 2){
                    map[i][j].clear();// map은 결국 임시 저장이였으므로 삭제.
                    continue;
                }
                
                //파이어볼 2개 이상일 때
                int mSum = 0, sSum = 0, oddCount = 0, evenCount = 0;
                int size = map[i][j].size();
                //분열 진행!
                for(fireBall cur : map[i][j]){
                    mSum += cur.m;	//질량 더하기
                    sSum += cur.s;	//속도 더하기
                    if(cur.d % 2 == 1)	//방향 홀수일 때
                        oddCount++;
                    else		//방향 짝수일 때
                        evenCount++;
                    fb.remove(cur);	//분열될 파이어볼 제거!
                }
                
                map[i][j].clear();
                mSum /= 5;	//분열될 질량 구하기
                if(mSum == 0) continue;	//분열될 질량이 0이면 소멸.
                sSum /= size;	//분열될 속도 구하기
                //모든 파이어볼 방향이 짝수이거나 홀수일 때
                if(oddCount == size || evenCount == size){
                    for(int a=0;a<8;a+=2)	//{0, 2, 4, 6} 방향 분열
                        fb.add(new fireBall(i,j,mSum, sSum, a));
                }else{
                    for(int a=1;a<8;a+=2)	//{1, 3, 5, 7} 방향 분열
                        fb.add(new fireBall(i,j,mSum, sSum, a));
                }
            }
        }
    }
    
}